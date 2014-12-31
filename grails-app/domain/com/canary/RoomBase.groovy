package com.canary

/*
 DELIMITER //
CREATE TRIGGER room_base_before_trigger BEFORE INSERT ON room_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW room AS
    SELECT id ,guId, version, name, capacity
    FROM room_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into room ( name,capacity) values ("yosemit", 75);
insert into room ( name,capacity) values ("tahoe", 100);
insert into room ( name,capacity) values ("goldengate", 24);



*/
class RoomBase {

    
    static constraints = {
      guId(maxSize:40, unique:true)
    	tenant (maxSize: 16, blank: false,nullable:true)
    }

    String guId
    String name
    String tenant
    Integer capacity

    static mapping = {
      guId column:'guId'
      //id generator: 'assigned', type: 'string'
    }
}
