package com.canary

/*

DELIMITER //
CREATE TRIGGER client_base_before_trigger BEFORE INSERT ON client_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

  
CREATE VIEW client AS
    SELECT id ,version, guId, fName, lName,barcode, address_id,emergencyContact,emergencyContactPhone
    FROM client_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

*/
class ClientBase {

   
    static constraints = {
      tenant (maxSize: 16, blank: false)
      guId (maxSize:40, blank:false)
    }

    static hasMany =[notes:Note,classes:ClassBase,memberships:Membership,visits:Visit,purchasedItems:PurchasedItems]
    static belongsTo = ClassBase
    String guId
    String tenant
    String fName
    String lName
    String barcode
    Address address

    String emergencyContact
    String emergencyContactPhone

    static mapping = {
      guId column: 'guId'
      fName column:'fName'
      lName column:'lName'
      emergencyContact column: 'emergencyContact'
      emergencyContactPhone column:'emergencyContactPhone'
    }

}
