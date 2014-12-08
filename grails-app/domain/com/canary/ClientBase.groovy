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

insert into client_base (version, address_id, barcode, emergencyContact,
 emergencyContactPhone, fName, guId, is_teacher, lName, tenant) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

*/
class ClientBase {

   
    static constraints = {
      tenant (maxSize: 16, blank: false,nullable:true)
      guId (maxSize:40, blank:false,nullable:true)
      notes (nullable:true)
      classes(nullable:true)
      memberships(nullable:true)
      visits(nullable:true)
      purchasedItems(nullable:true)
      address(nullable:true)
    }

    static hasMany =[notes:NoteBase,classes:ClassBase,memberships:MembershipBase,visits:VisitBase,purchasedItems:PurchasedItemsBase]
    static belongsTo = ClassBase
    String guId
    String tenant
    String fName
    String lName
    String barcode
    AddressBase address
    Boolean isTeacher

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
