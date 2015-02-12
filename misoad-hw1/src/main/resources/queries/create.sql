CREATE TABLE STORE (
  store_id INT(10) NOT NULL AUTO_INCREMENT,
  manager_id INT(10),
  address VARCHAR(50),
  last_update TIMESTAMP NOT NULL,
  PRIMARY KEY  (store_id)
  );

CREATE TABLE STAFF (
  staff_id INT(10) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  address VARCHAR(50),
  picture BLOB,
  email VARCHAR(50),
  store_id INT(10),
  active BOOLEAN DEFAULT false,
  username VARCHAR(16),
  password VARCHAR(40),
  last_update TIMESTAMP NOT NULL,
  PRIMARY KEY  (staff_id),
  FOREIGN KEY (store_id) REFERENCES STORE(store_id)
  );

ALTER TABLE STORE
  ADD FOREIGN KEY (manager_id) REFERENCES STAFF(staff_id);

CREATE TABLE RENTAL (
  rental_id INT(10) NOT NULL AUTO_INCREMENT,
  rental_date DATETIME NOT NULL ,
  inventory_id INT(10) NOT NULL ,
  customer_id INT(10) NOT NULL ,
  return_date DATETIME NOT NULL,
  staff_id INT(10) NOT NULL,
  last_update TIMESTAMP NOT NULL,
  PRIMARY KEY (rental_id),
  FOREIGN KEY (staff_id) REFERENCES STAFF(staff_id)
  );

CREATE TABLE PAYMENT (
  payment_id INT(10) NOT NULL AUTO_INCREMENT,
  customer_id INT(10),
  staff_id INT(10) NOT NULL,
  rental_id INT(10) NOT NULL,
  amount DECIMAL(5,2) NOT NULL,
  payment_date DATETIME NOT NULL,
  last_update TIMESTAMP NOT NULL,
  PRIMARY KEY (payment_id),
  FOREIGN KEY (staff_id) REFERENCES STAFF(staff_id),
  FOREIGN KEY (rental_id) REFERENCES RENTAL(rental_id)
  );
