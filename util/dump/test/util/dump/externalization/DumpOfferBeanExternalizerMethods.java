package util.dump.externalization;

import java.util.Random;

import util.dump.Externalizer;




public class DumpOfferBeanExternalizerMethods extends Externalizer implements Comparable<DumpOfferBeanExternalizerMethods> {

   private static final long   RANDOM_SEED = 123456;
   private static final Random RANDOM      = new Random(RANDOM_SEED);


   public static DumpOfferBeanExternalizerMethods createRandomBean() {
      DumpOfferBeanExternalizerMethods d = new DumpOfferBeanExternalizerMethods();
      d.code = randomString();
      d.codeType = RANDOM.nextInt();
      d.contentId = RANDOM.nextLong();
      d.created = RANDOM.nextInt();
      d.deeplink = randomString();
      d.deliveryCost = randomString();
      d.deliveryCostValue = RANDOM.nextDouble();
      d.deliveryTime = randomString();
      d.deliveryTimeColor = RANDOM.nextInt();
      d.description = randomString();
      d.hid = RANDOM.nextLong();
      d.imageSmall = randomString();
      d.imageView = randomString();
      d.isActive = RANDOM.nextInt() % 2 == 0 ? true : false;
      d.manufacturer = randomString();
      d.manufacturerPrdId = randomString();
      d.matchOwner = RANDOM.nextLong();
      d.matchProgram = RANDOM.nextLong();
      d.matchStamp = RANDOM.nextLong();
      d.matchType = RANDOM.nextLong();
      d.name = randomString();
      d.oldPrice = RANDOM.nextDouble();
      d.ownerId = RANDOM.nextLong();
      d.parentHid = RANDOM.nextLong();
      d.price = RANDOM.nextDouble();
      d.promoText = randomString();
      d.sourceGroup = randomString();
      d.sourceId = randomString();
      d.updated = RANDOM.nextLong();
      d.variant = RANDOM.nextLong();
      return d;
   }

   private static String randomString() {
      int length = RANDOM.nextInt(50);
      StringBuilder sb = new StringBuilder(length);
      for ( int i = 0; i < length; i++ ) {
         sb.append((char)(RANDOM.nextInt(64) + 32));
      }
      return sb.toString();
   }

   public long    contentId;
   public long    ownerId;
   public String  sourceId;
   public String  sourceGroup;

   public boolean isActive;

   public long    created;
   public long    updated;

   public long    hid;
   public long    parentHid;
   public long    variant;

   public long    matchOwner;
   public long    matchProgram;
   public long    matchType;
   public long    matchStamp;

   public String  name;
   public String  description;
   public String  manufacturer;
   public String  manufacturerPrdId;
   public String  promoText;

   public double  price;
   public Double  oldPrice;

   public String  code;
   public int     codeType;

   public String  deeplink;

   public String  deliveryTime;
   public int     deliveryTimeColor;
   public String  deliveryCost;
   public Double  deliveryCostValue;

   public String  imageView;
   public String  imageSmall;

   public DumpOfferBeanExternalizerMethods() {}


   public int compareTo( DumpOfferBeanExternalizerMethods o ) {
      return this.contentId < o.contentId ? -1 : (this.contentId == o.contentId ? 0 : 1);
   }


   @Override
   public boolean equals( Object obj ) {
      if ( this == obj ) {
         return true;
      }
      if ( obj == null ) {
         return false;
      }
      if ( getClass() != obj.getClass() ) {
         return false;
      }
      DumpOfferBeanExternalizerMethods other = (DumpOfferBeanExternalizerMethods)obj;
      if ( code == null ) {
         if ( other.code != null ) {
            return false;
         }
      }
      else if ( !code.equals(other.code) ) {
         return false;
      }
      if ( codeType != other.codeType ) {
         return false;
      }
      if ( contentId != other.contentId ) {
         return false;
      }
      if ( created != other.created ) {
         return false;
      }
      if ( deeplink == null ) {
         if ( other.deeplink != null ) {
            return false;
         }
      }
      else if ( !deeplink.equals(other.deeplink) ) {
         return false;
      }
      if ( deliveryCost == null ) {
         if ( other.deliveryCost != null ) {
            return false;
         }
      }
      else if ( !deliveryCost.equals(other.deliveryCost) ) {
         return false;
      }
      if ( deliveryCostValue == null ) {
         if ( other.deliveryCostValue != null ) {
            return false;
         }
      }
      else if ( !deliveryCostValue.equals(other.deliveryCostValue) ) {
         return false;
      }
      if ( deliveryTime == null ) {
         if ( other.deliveryTime != null ) {
            return false;
         }
      }
      else if ( !deliveryTime.equals(other.deliveryTime) ) {
         return false;
      }
      if ( deliveryTimeColor != other.deliveryTimeColor ) {
         return false;
      }
      if ( description == null ) {
         if ( other.description != null ) {
            return false;
         }
      }
      else if ( !description.equals(other.description) ) {
         return false;
      }
      if ( hid != other.hid ) {
         return false;
      }
      if ( imageSmall == null ) {
         if ( other.imageSmall != null ) {
            return false;
         }
      }
      else if ( !imageSmall.equals(other.imageSmall) ) {
         return false;
      }
      if ( imageView == null ) {
         if ( other.imageView != null ) {
            return false;
         }
      }
      else if ( !imageView.equals(other.imageView) ) {
         return false;
      }
      if ( isActive != other.isActive ) {
         return false;
      }
      if ( manufacturer == null ) {
         if ( other.manufacturer != null ) {
            return false;
         }
      }
      else if ( !manufacturer.equals(other.manufacturer) ) {
         return false;
      }
      if ( manufacturerPrdId == null ) {
         if ( other.manufacturerPrdId != null ) {
            return false;
         }
      }
      else if ( !manufacturerPrdId.equals(other.manufacturerPrdId) ) {
         return false;
      }
      if ( matchOwner != other.matchOwner ) {
         return false;
      }
      if ( matchProgram != other.matchProgram ) {
         return false;
      }
      if ( matchStamp != other.matchStamp ) {
         return false;
      }
      if ( matchType != other.matchType ) {
         return false;
      }
      if ( name == null ) {
         if ( other.name != null ) {
            return false;
         }
      }
      else if ( !name.equals(other.name) ) {
         return false;
      }
      if ( oldPrice == null ) {
         if ( other.oldPrice != null ) {
            return false;
         }
      }
      else if ( !oldPrice.equals(other.oldPrice) ) {
         return false;
      }
      if ( ownerId != other.ownerId ) {
         return false;
      }
      if ( parentHid != other.parentHid ) {
         return false;
      }
      if ( Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price) ) {
         return false;
      }
      if ( promoText == null ) {
         if ( other.promoText != null ) {
            return false;
         }
      }
      else if ( !promoText.equals(other.promoText) ) {
         return false;
      }
      if ( sourceGroup == null ) {
         if ( other.sourceGroup != null ) {
            return false;
         }
      }
      else if ( !sourceGroup.equals(other.sourceGroup) ) {
         return false;
      }
      if ( sourceId == null ) {
         if ( other.sourceId != null ) {
            return false;
         }
      }
      else if ( !sourceId.equals(other.sourceId) ) {
         return false;
      }
      if ( updated != other.updated ) {
         return false;
      }
      if ( variant != other.variant ) {
         return false;
      }
      return true;
   }


   @externalize(1)
   public String getCode() {
      return code;
   }


   @externalize(2)
   public int getCodeType() {
      return codeType;
   }


   @externalize(3)
   public long getContentId() {
      return contentId;
   }


   @externalize(4)
   public long getCreated() {
      return created;
   }


   @externalize(5)
   public String getDeeplink() {
      return deeplink;
   }


   @externalize(6)
   public String getDeliveryCost() {
      return deliveryCost;
   }


   @externalize(7)
   public Double getDeliveryCostValue() {
      return deliveryCostValue;
   }


   @externalize(8)
   public String getDeliveryTime() {
      return deliveryTime;
   }


   @externalize(9)
   public int getDeliveryTimeColor() {
      return deliveryTimeColor;
   }


   @externalize(10)
   public String getDescription() {
      return description;
   }


   @externalize(11)
   public long getHid() {
      return hid;
   }


   @externalize(12)
   public String getImageSmall() {
      return imageSmall;
   }


   @externalize(13)
   public String getImageView() {
      return imageView;
   }


   @externalize(14)
   public String getManufacturer() {
      return manufacturer;
   }


   @externalize(15)
   public String getManufacturerPrdId() {
      return manufacturerPrdId;
   }


   @externalize(16)
   public long getMatchOwner() {
      return matchOwner;
   }


   @externalize(17)
   public long getMatchProgram() {
      return matchProgram;
   }


   @externalize(18)
   public long getMatchStamp() {
      return matchStamp;
   }


   @externalize(19)
   public long getMatchType() {
      return matchType;
   }


   @externalize(20)
   public String getName() {
      return name;
   }


   @externalize(21)
   public Double getOldPrice() {
      return oldPrice;
   }


   @externalize(22)
   public long getOwnerId() {
      return ownerId;
   }


   @externalize(23)
   public long getParentHid() {
      return parentHid;
   }


   @externalize(24)
   public double getPrice() {
      return price;
   }


   @externalize(25)
   public String getPromoText() {
      return promoText;
   }


   @externalize(26)
   public String getSourceGroup() {
      return sourceGroup;
   }


   @externalize(27)
   public String getSourceId() {
      return sourceId;
   }


   @externalize(28)
   public long getUpdated() {
      return updated;
   }


   @externalize(29)
   public long getVariant() {
      return variant;
   }


   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((code == null) ? 0 : code.hashCode());
      result = prime * result + codeType;
      result = prime * result + (int)(contentId ^ (contentId >>> 32));
      result = prime * result + (int)(created ^ (created >>> 32));
      result = prime * result + ((deeplink == null) ? 0 : deeplink.hashCode());
      result = prime * result + ((deliveryCost == null) ? 0 : deliveryCost.hashCode());
      result = prime * result + ((deliveryCostValue == null) ? 0 : deliveryCostValue.hashCode());
      result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
      result = prime * result + deliveryTimeColor;
      result = prime * result + ((description == null) ? 0 : description.hashCode());
      result = prime * result + (int)(hid ^ (hid >>> 32));
      result = prime * result + ((imageSmall == null) ? 0 : imageSmall.hashCode());
      result = prime * result + ((imageView == null) ? 0 : imageView.hashCode());
      result = prime * result + (isActive ? 1231 : 1237);
      result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
      result = prime * result + ((manufacturerPrdId == null) ? 0 : manufacturerPrdId.hashCode());
      result = prime * result + (int)(matchOwner ^ (matchOwner >>> 32));
      result = prime * result + (int)(matchProgram ^ (matchProgram >>> 32));
      result = prime * result + (int)(matchStamp ^ (matchStamp >>> 32));
      result = prime * result + (int)(matchType ^ (matchType >>> 32));
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((oldPrice == null) ? 0 : oldPrice.hashCode());
      result = prime * result + (int)(ownerId ^ (ownerId >>> 32));
      result = prime * result + (int)(parentHid ^ (parentHid >>> 32));
      long temp;
      temp = Double.doubleToLongBits(price);
      result = prime * result + (int)(temp ^ (temp >>> 32));
      result = prime * result + ((promoText == null) ? 0 : promoText.hashCode());
      result = prime * result + ((sourceGroup == null) ? 0 : sourceGroup.hashCode());
      result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
      result = prime * result + (int)(updated ^ (updated >>> 32));
      result = prime * result + (int)(variant ^ (variant >>> 32));
      return result;
   }

   @externalize(30)
   public boolean isActive() {
      return isActive;
   }


   public void setActive( boolean isActive ) {
      this.isActive = isActive;
   }


   public void setCode( String code ) {
      this.code = code;
   }


   public void setCodeType( int codeType ) {
      this.codeType = codeType;
   }


   public void setContentId( long contentId ) {
      this.contentId = contentId;
   }


   public void setCreated( long created ) {
      this.created = created;
   }


   public void setDeeplink( String deeplink ) {
      this.deeplink = deeplink;
   }


   public void setDeliveryCost( String deliveryCost ) {
      this.deliveryCost = deliveryCost;
   }


   public void setDeliveryCostValue( Double deliveryCostValue ) {
      this.deliveryCostValue = deliveryCostValue;
   }


   public void setDeliveryTime( String deliveryTime ) {
      this.deliveryTime = deliveryTime;
   }


   public void setDeliveryTimeColor( int deliveryTimeColor ) {
      this.deliveryTimeColor = deliveryTimeColor;
   }


   public void setDescription( String description ) {
      this.description = description;
   }


   public void setHid( long hid ) {
      this.hid = hid;
   }


   public void setImageSmall( String imageSmall ) {
      this.imageSmall = imageSmall;
   }


   public void setImageView( String imageView ) {
      this.imageView = imageView;
   }


   public void setManufacturer( String manufacturer ) {
      this.manufacturer = manufacturer;
   }


   public void setManufacturerPrdId( String manufacturerPrdId ) {
      this.manufacturerPrdId = manufacturerPrdId;
   }


   public void setMatchOwner( long matchOwner ) {
      this.matchOwner = matchOwner;
   }


   public void setMatchProgram( long matchProgram ) {
      this.matchProgram = matchProgram;
   }


   public void setMatchStamp( long matchStamp ) {
      this.matchStamp = matchStamp;
   }


   public void setMatchType( long matchType ) {
      this.matchType = matchType;
   }


   public void setName( String name ) {
      this.name = name;
   }


   public void setOldPrice( Double oldPrice ) {
      this.oldPrice = oldPrice;
   }


   public void setOwnerId( long ownerId ) {
      this.ownerId = ownerId;
   }


   public void setParentHid( long parentHid ) {
      this.parentHid = parentHid;
   }


   public void setPrice( double price ) {
      this.price = price;
   }


   public void setPromoText( String promoText ) {
      this.promoText = promoText;
   }

   public void setSourceGroup( String sourceGroup ) {
      this.sourceGroup = sourceGroup;
   }

   public void setSourceId( String sourceId ) {
      this.sourceId = sourceId;
   }

   public void setUpdated( long updated ) {
      this.updated = updated;
   }

   public void setVariant( long variant ) {
      this.variant = variant;
   }
}
