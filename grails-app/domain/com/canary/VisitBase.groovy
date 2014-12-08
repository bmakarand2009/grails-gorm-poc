package com.canary
/*
DELIMITER //
CREATE TRIGGER visit_base_before_trigger BEFORE INSERT ON visit_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW visit AS
    SELECT id ,version, client_id, membership_id,teacher_id,visitTime
    FROM visit_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into visit_base (version, client_id, membership_id,teacher_id,visitTime) values (?, ?,?,?,?)

*/
class VisitBase {

	static belongsTo = [client: ClientBase]
    static constraints = {
    	tenant (maxSize: 16, blank: false,nullable:true)
    }

    Integer visitTime
    ClassBase teacher
    MembershipBase membership
    String tenant

    static mapping = {
      visitTime column: 'visitTime'

    }
}
