package com.canary
/*
 DELIMITER //
CREATE TRIGGER product_base_before_trigger BEFORE INSERT ON product_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW product AS
    SELECT id ,version, guId, name, productType,productSubType,price
    FROM product_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);
    
*/
class ProductBase {


   
    static constraints = {
      tenant (maxSize: 16, blank: false)
      guId (maxSize:40, blank:false)
    }


    String name
    String guId
    String tenant
    
    String productType
    String productSubType
    BigDecimal price


	static mapping = {
      guId column: 'guId'
      productType column:'productType'
      productSubType column:'productSubType'
    }
}
