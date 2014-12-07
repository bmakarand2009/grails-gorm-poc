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
    SELECT id ,version, guId, name, capacity
    FROM room_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);
    
*/
class RoomBase {

    
    static constraints = {
    	tenant (maxSize: 16, blank: false)
    	guId (maxSize:40, blank:false)
    }

    String name
    String tenant
    String guId
    Integer capacity

    static mapping = {
      guId column: 'guId'
    }
}
