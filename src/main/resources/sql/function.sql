DELIMITER $$
 
CREATE FUNCTION  fnc_hierarchi() RETURNS INT
 
NOT DETERMINISTIC
 
READS SQL DATA
 
BEGIN
 
    DECLARE v_id INT;
    DECLARE v_parent INT;    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET @id = NULL;
 
    SET v_parent = @id;
    SET v_id = -1;
 
    IF @id IS NULL THEN
        RETURN NULL;
    END IF;
 
    LOOP
    
    SELECT MIN(id)
      INTO @id 
      FROM category
     WHERE parrent_id = v_parent
       AND id > v_id;
 
    IF (@id IS NOT NULL) OR (v_parent = @start_with) THEN
       SET @level = @level + 1;
    RETURN @id;
    END IF;
    
    SET @level := @level - 1;
 
    SELECT id, parrent_id
      INTO v_id , v_parent 
        FROM category
       WHERE id = v_parent;
   
    END LOOP;
 
END
 
$$
 
DELIMITER ;