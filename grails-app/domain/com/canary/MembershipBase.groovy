package com.canary

/*
DELIMITER //
CREATE TRIGGER membership_base_before_trigger BEFORE INSERT ON membership_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW membership AS
    SELECT id ,version, client_id,name,credits,expDate
    FROM membership_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

insert into membership_base (version, name, credits, expDate) values (?, ?, ?, ?)

*/

class MembershipBase {

    static constraints = {
    	tenant (maxSize: 16, blank: false,nullable:true)

    }

    String name
    String credits
    Integer expDate
    String tenant

    static belongsTo=[client:ClientBase]
    static mapping = {
      expDate column: 'expDate'
    }


}
