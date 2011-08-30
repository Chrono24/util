package util.dump.stream;

import java.io.BufferedOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;


/**
 * The SingleTypeObjectStreamProvider uses very performant implementations for ObjectInput and ObjectOutput.<br><br>
 * 
 * The drawbacks are:<br>
 *  - only {@link Externalizable} instances may be used<br>
 *  - the {@link Externalizable}s may not use readObject() during readExternal() or writeObject(o) during writeExternal()<br><br>
 *  - if you put an instance twice into the dump, you will have two instances after deserialization in memory<br><br>
 * 
 * This ObjectStreamProvider can compress the streams using java.util.zip.Deflater. Use the appropriate constructor with values between 1 and 9.
 * Using values higher than 6 degrades performance too much to be of use. Using 1 is often the most sensible approach. Use compression only if you have 
 * limitted storage space on your server, an IO bottleneck on your server, or if you access the dumps via network and have a network bottleneck. 
 * 
 * @see JavaObjectStreamProvider 
 * @see ExternalizableObjectStreamProvider
 */
public class SingleTypeObjectStreamProvider<E extends Externalizable> implements ObjectStreamProvider {


   private final Class _class;
   private final int   _compression;

   public SingleTypeObjectStreamProvider( Class c ) {
      _class = c;
      _compression = 0;
   }

   /**
    * @param compression if set to a value > 0 the input and output streams are wrapped with GZip compression
    * @see java.util.zip.Deflater
    */
   public SingleTypeObjectStreamProvider( Class c, int compression ) {
      _class = c;
      _compression = compression;
   }

   public ObjectInput createObjectInput( InputStream in ) throws IOException {
      if ( _compression > 0 ) {
         in = new GZIPInputStream(in);
      }
      return new SingleTypeObjectInputStream<E>(in, _class);
   }

   public ObjectOutput createObjectOutput( OutputStream out ) throws IOException {
      if ( _compression > 0 ) {
         out = new BufferedOutputStream(new ConfigurableGZIPOutputStream(out, _compression));
      }
      return new SingleTypeObjectOutputStream<E>(out, _class);
   }
}
