package util.dump.stream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import util.dump.stream.ExternalizableObjectStreamProvider.InstanceType;
import util.io.IOUtils;


public class ExternalizableObjectOutputStream extends DataOutputStream implements ObjectOutput {

   public static byte[] writeSingleInstance( Externalizable e ) {
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();

      ExternalizableObjectOutputStream out = null;
      try {
         out = new ExternalizableObjectOutputStream(bytes);
         out.writeObject(e);
      }
      catch ( IOException argh ) {
         throw new RuntimeException(argh);
      }
      finally {
         IOUtils.close(out);
      }

      return bytes.toByteArray();
   }


   private ObjectOutputStream    _objectOutputStream;

   private boolean               _resetPending               = false;
   private Compression       _compressionType            = Compression.None;
   private ByteArrayOutputStream _compressionByteBuffer      = null;
   private OutputStream          _originalOut                = null;
   private ObjectOutputStream    _originalObjectOutputStream = null;


   public ExternalizableObjectOutputStream( OutputStream out ) throws IOException {
      super(out);
      _objectOutputStream = new NoHeaderObjectOutputStream(out);
   }

   public ExternalizableObjectOutputStream( OutputStream out, Compression compressionType ) throws IOException {
      this(out);
      _compressionType = compressionType;
      _compressionByteBuffer = new ByteArrayOutputStream();
   }

   @Override
   public void close() throws IOException {
      super.close();
      _objectOutputStream.close();
   }

   @Override
   public void flush() throws IOException {
      super.flush();
      _objectOutputStream.flush();
   }

   public void reset() {
      _resetPending = true;
   }

   public void writeObject( Object obj ) throws IOException {

      writeBoolean(obj != null);
      if ( obj != null ) {
         boolean restore = false;
         if ( _compressionType != Compression.None && _originalOut == null ) {
            restore = true;
            _originalOut = out;
            _compressionByteBuffer.reset();
            out = _compressionByteBuffer;
            _originalObjectOutputStream = _objectOutputStream;
            _objectOutputStream = new NoHeaderObjectOutputStream(out);
         }

         if ( obj instanceof Externalizable ) {
            writeByte(InstanceType.Externalizable.getId());
            writeUTF(obj.getClass().getName());
            ((Externalizable)obj).writeExternal(this);
         } else if ( obj instanceof String ) {
            writeByte(InstanceType.String.getId());
            writeUTF((String)obj);
         } else if ( obj instanceof Date ) {
            writeByte(InstanceType.Date.getId());
            writeLong(((Date)obj).getTime());
         } else if ( obj instanceof UUID ) {
            writeByte(InstanceType.UUID.getId());
            writeLong(((UUID)obj).getMostSignificantBits());
            writeLong(((UUID)obj).getLeastSignificantBits());
         } else if ( obj instanceof Integer ) {
            writeByte(InstanceType.Integer.getId());
            writeInt((Integer)obj);
         } else if ( obj instanceof Double ) {
            writeByte(InstanceType.Double.getId());
            writeDouble((Double)obj);
         } else if ( obj instanceof Float ) {
            writeByte(InstanceType.Float.getId());
            writeFloat((Float)obj);
         } else if ( obj instanceof Long ) {
            writeByte(InstanceType.Long.getId());
            writeLong((Long)obj);
         } else {
            writeByte(InstanceType.Object.getId());
            if ( _resetPending ) {
               _objectOutputStream.reset();
               _resetPending = false;
            }
            _objectOutputStream.writeObject(obj);
         }

         if ( restore ) {
            byte[] bytes = _compressionByteBuffer.toByteArray();
            byte[] compressedBytes = _compressionType.compress(bytes);
            out = _originalOut;

            if ( compressedBytes.length + 6 < bytes.length ) {
               out.write(1);
               if ( compressedBytes.length >= 65535 ) {
                  out.write(0xff);
                  out.write(0xff);
                  out.write((compressedBytes.length >>> 24) & 0xFF);
                  out.write((compressedBytes.length >>> 16) & 0xFF);
               }
               out.write((compressedBytes.length >>> 8) & 0xFF);
               out.write((compressedBytes.length >>> 0) & 0xFF);

               out.write(compressedBytes);
            } else {
               out.write(0);
               out.write(bytes);
            }
            _originalOut = null;
            _objectOutputStream = _originalObjectOutputStream;
            _originalObjectOutputStream = null;
         }
      }
   }


   private final class NoHeaderObjectOutputStream extends ObjectOutputStream {

      private NoHeaderObjectOutputStream( OutputStream out ) throws IOException {
         super(out);
      }

      @Override
      protected void writeStreamHeader() throws IOException {
         // do nothing
      }
   }
}
