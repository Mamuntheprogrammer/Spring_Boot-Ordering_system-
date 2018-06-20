CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` float DEFAULT NULL,
  `reduce_price` float DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkomdx99dhk2cveaxugl2lws2u` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


INSERT INTO category(id, name) VALUES(1, 'BURGER');
INSERT INTO category(id, name) VALUES(2, 'DESI');
INSERT INTO category(id, name) VALUES(3, 'CHINISE');
INSERT INTO category(id, name) VALUES(4, 'JAPANIS');
INSERT INTO category(id, name) VALUES(5, 'DRINKS');
INSERT INTO category(id, name) VALUES(6, 'ICE CREAM');
INSERT INTO category(id, name) VALUES(7, 'DESERT');
INSERT INTO category(id, name) VALUES(8, 'FRY ITEMS');
INSERT INTO category(id, name) VALUES(9, 'COFFE');
INSERT INTO category(id, name) VALUES(10, 'IDIAN');
INSERT INTO category(id, name) VALUES(11, 'FASR FOOD');

INSERT INTO food(id, name, image_path, price, reduce_price, category_id) VALUES(1, 'BURGER big','/images/109378844.jpg',120.00,-1, 1);
INSERT INTO food(id, name, image_path, price, reduce_price, category_id) VALUES(2, 'BURGER small','/images/109379298.jpg',80.00,-1, 1);
INSERT INTO food(id, name, image_path, price, reduce_price, category_id) VALUES(3, 'DESI small','/images/109379624.jpg',90.00,-1, 2);
INSERT INTO food(id, name, image_path, price, reduce_price, category_id) VALUES(4, 'DESI small','/images/109379671.jpg',60.00,-1, 2);


CREATE TABLE `final_project`.`order_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `table_no` VARCHAR(45) NOT NULL,
  `user_id` INT NULL DEFAULT NULL ,
  `order_total` FLOAT NOT NULL,
  `comment` VARCHAR(1024) NULL,
  PRIMARY KEY (`id`));

  
  CREATE TABLE `final_project`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` FLOAT NOT NULL,
  `order_id` INT NOT NULL,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `final_project`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `name1` VARCHAR(100) NULL,
  `quote` VARCHAR(255) NULL,
  `email` VARCHAR(100) NULL,
  `number` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `password1` VARCHAR(100) NULL,
  `dob` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

