package com.canary

/*
DELIMITER //
CREATE TRIGGER address_base_before_trigger BEFORE INSERT ON address_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW address AS
    SELECT id ,version, street, state,city,zip
    FROM address_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into address (version, city, state, street, zip) values (?, ?, ?, ?, ?)

*/
class AddressBase {

    static constraints = {
    	    	tenant (maxSize: 16, blank: false,nullable:true)

    }
    String street
    String state
    String city
    Integer zip

    String tenant

   
}
