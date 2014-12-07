package com.canary

/*
CREATE TABLE class_base (
    itemId int(11) unsigned PRIMARY KEY AUTO_INCREMENT,
    guId char(40) NOT NULL,
    tenant VARCHAR(16) NOT NULL,
    className VARCHAR(255) NOT NULL,
    startTime INTEGER UNSIGNED,
    endTime INTEGER UNSIGNED,
    teacher VARCHAR(255),
    roomName VARCHAR(255),
    UNIQUE (guId)
)DEFAULT CHARSET=latin1;

DELIMITER //
CREATE TRIGGER class_base_before_trigger BEFORE INSERT ON class_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW class AS
    SELECT itemId,guId, className,startTime,endTime,teacher,roomName
    FROM class_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into class(className) values('bikram yoga class second');

databaseName = fitnessStudio
userName = fuser1

*/

class ClassBase {

    static constraints = {
    	tenant (maxSize: 16, blank: false)
    	guId (maxSize:40, blank:false)
    }

    static hasMany =[students:ClientBase]


    String name
    String guId
    String tenant
    Integer startTime
    Integer endTime
    Integer classSize
    ClientBase teacher


    static mapping = {
      guId column: 'guId'
      startTime column:'startTime'
      endTime column:'endTime'
      classSize column:'classSize'
    }

}
