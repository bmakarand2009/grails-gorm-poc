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
    SELECT id ,guId, version, classSize,startTime,endTime,name,`teacher_id`,room_id
    FROM class_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);



insert into class_base (version, classSize, endTime, name, room_id, startTime, teacher_id, tenant) values (?, ?, ?, ?, ?, ?, ?, ?, ?)

insert into class_base (classSize, endTime, name, startTime) values (75, 1413611143, "test123",1413611143)
insert into class (classSize, endTime, name, startTime,teacher_id,room_id) values (75, 1413611143, "trialclass2",1413611143,"033bc81a-867e-11e4-bbf0-0a2a84bf4f80","a4903585-867e-11e4-bbf0-0a2a84bf4f80")


*/

class ClassBase {

    static constraints = {
      guId(maxSize:40, unique:true)
    	tenant (maxSize: 16, blank: false,nullable:true)
      students(nullable:true)
      room(nullable:true)
      classSize(nullable:true)
      teacher(nullable:true)
    }

    static hasMany =[students:ClientBase]


    String guId
    String name
    String tenant
    Integer startTime
    Integer endTime
    Integer classSize
    ClientBase teacher
    RoomBase room


    static mapping = {
      //id generator: 'assigned', type: 'string'
      guId column:'guId'
      startTime column:'startTime'
      endTime column:'endTime'
      classSize column:'classSize'
      students lazy:false
      room fetch: 'join'

    }

}
