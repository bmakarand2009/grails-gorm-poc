package com.canary

/*
DELIMITER //
CREATE TRIGGER class_base_before_trigger BEFORE INSERT ON class_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

  
CREATE VIEW class AS
    SELECT id ,version, guId, classSize,startTime,endTime,name,`teacher_id`,room_id
    FROM class_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);



insert into class_base (version, classSize, endTime, guId, name, room_id, startTime, teacher_id, tenant) values (?, ?, ?, ?, ?, ?, ?, ?, ?)

databaseName = fitnessStudio
userName = fuser1

*/

class ClassBase {

    static constraints = {
    	tenant (maxSize: 16, blank: false,nullable:true)
    	guId (maxSize:40, blank:false,nullable:true)
      students(nullable:true)
      room(nullable:true)
    }

    static hasMany =[students:ClientBase]


    String name
    String guId
    String tenant
    Integer startTime
    Integer endTime
    Integer classSize
    ClientBase teacher
    RoomBase room


    static mapping = {
      guId column: 'guId'
      startTime column:'startTime'
      endTime column:'endTime'
      classSize column:'classSize'
    }

}
