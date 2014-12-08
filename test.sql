DELIMITER //
CREATE TRIGGER address_base_before_trigger BEFORE INSERT ON address_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER 

CREATE VIEW address AS
    SELECT id ,version, street, state,city,zip
    FROM address_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);


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
    
  
DELIMITER //
CREATE TRIGGER client_base_before_trigger BEFORE INSERT ON client_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW client AS
    SELECT id ,version, guId, fName, lName,barcode, address_id,emergencyContact,emergencyContactPhone,is_teacher
    FROM client_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);
    
 DELIMITER //
CREATE TRIGGER inventory_base_before_trigger BEFORE INSERT ON inventory_base
 FOR EACH ROW begin
  SET new.guId = uuid();
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW inventory AS
    SELECT id ,version, guId, name, iType,iSubType,price
    FROM inventory_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);

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


DELIMITER //
CREATE TRIGGER purchased_items_base_before_trigger BEFORE INSERT ON purchased_items_base
 FOR EACH ROW begin
  SET new.tenant = SUBSTRING_INDEX(USER(), '@', 1);
end//
DELIMITER ;

CREATE VIEW purchased_items AS
    SELECT id ,version,amount, itemPurchased,purchaseTime,client_id
    FROM purchased_items_base
    WHERE tenant = SUBSTRING_INDEX(USER(), '@', 1);
    
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