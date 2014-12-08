package com.canary
/*
 DELIMITER //
CREATE TRIGGER inventory_base_before_trigger BEFORE INSERT ON inventory_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW inventory AS
    SELECT id ,version, guId, name, productType,productSubType,price
    FROM inventory_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);


insert into inventory_base (version, guId, iSubType, iType, name, price, tenant) values (?, ?, ?, ?, ?, ?, ?)
    
*/
class InventoryBase {


   
    static constraints = {
      tenant (maxSize: 16, blank: false,nullable:true)
      guId (maxSize:40, blank:false,nullable:true)
    }


    String name
    String guId
    String tenant
    
    String iType
    String iSubType
    BigDecimal price


	static mapping = {
      guId column: 'guId'
      iType column:'iType'
      iSubType column:'iSubType'

    }
}
