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
    SELECT id , guId, version, fName, lName,barcode, address_id,emergencyContact,emergencyContactPhone,is_teacher
    FROM client_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);
    
insert into client (barcode, emergencyContact,emergencyContactPhone, fName,lName,is_teacher) values ("dfkem3993", "medicla ", "2323232", "mark", "kopen",true);

insert into client (barcode, emergencyContact,emergencyContactPhone, fName,lName,is_teacher) values ("sdsds121", "medical center1 ", "23232232332", "john", "martin",true);
insert into client (barcode, emergencyContact,emergencyContactPhone, fName,lName,is_teacher) values ("sd12121", "spouseno ", "dfd22322", "rick", "hogan",true);

*/
class ClientBase {

   
    static constraints = {
      guId(maxSize:40, unique:true)
      tenant (maxSize: 16, blank: false,nullable:true)
      notes (nullable:true)
      classes(nullable:true)
      memberships(nullable:true)
      visits(nullable:true)
      purchasedItems(nullable:true)
      address(nullable:true)
      barcode(nullable:true)
      emergencyContact(nullable:true)
      emergencyContactPhone(nullable:true)
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
    //  id generator: 'assigned', type: 'string'
      guId column:'guId'
      fName column:'fName'
      lName column:'lName'
      emergencyContact column: 'emergencyContact'
      emergencyContactPhone column:'emergencyContactPhone'
    }

}
