package com.canary

/*
DELIMITER //
CREATE TRIGGER note_base_before_trigger BEFORE INSERT ON note_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW note AS
    SELECT id ,version, note, client_id
    FROM note_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

Hibernate: insert into note (version, client_id, note) values (?, ?, ?)


*/

class NoteBase {

	static belongsTo = [client: ClientBase]
    static constraints = {
    	tenant (maxSize: 16, blank: false,nullable:true)
    }

    static mapping = {
	   note type: 'text'
	}
    String tenant
	String note
}
