package com.canary

/*
DELIMITER //
CREATE TRIGGER purchased_items_base_before_trigger BEFORE INSERT ON purchased_items_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW purchased_items AS
    SELECT id ,version,amount, itemPurchased,purchaseTime,client_id
    FROM purchased_items_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into note_base (version, note) values (?, ?)

*/

class PurchasedItemsBase {

    static constraints = {
            tenant (maxSize: 16, blank: false,nullable:true)
    }

	static belongsTo = [client: ClientBase]

    Integer purchaseTime
    InventoryBase itemPurchased
    BigDecimal amount
    String tenant


  	static mapping = {
      purchaseTime column: 'purchaseTime'
      itemPurchased column: 'itemPurchased'

    }
}
