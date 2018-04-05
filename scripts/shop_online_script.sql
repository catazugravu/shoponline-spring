DROP DATABASE IF EXISTS `online_shop`;
CREATE DATABASE `online_shop`;
USE online_shop;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`password_hash` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NOT NULL,
	`created_date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `cart_items`;
CREATE TABLE `cart_items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cart_id` INT(11) NOT NULL,
	`product_id` INT(11) NOT NULL,
	`quantity` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`category_id` INT(11) NOT NULL,
	`name` varchar(50) NOT NULL,
	`price` DECIMAL NOT NULL,
	`stock` INT(11) NOT NULL,
	`description` varchar(50) NOT NULL,
	`image1_path` varchar(50) NOT NULL,
	`image2_path` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NOT NULL,
	`delivery_address` varchar(50) NOT NULL,
	`order_date` DATE NOT NULL,
	`order_status` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11) NOT NULL,
	`product_id` INT(11) NOT NULL,
	`quantity` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `cart` ADD CONSTRAINT `cart_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `cart_items` ADD CONSTRAINT `cart_items_fk0` FOREIGN KEY (`cart_id`) REFERENCES `cart`(`id`);

ALTER TABLE `cart_items` ADD CONSTRAINT `cart_items_fk1` FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);

ALTER TABLE `products` ADD CONSTRAINT `products_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `order_item` ADD CONSTRAINT `order_item_fk0` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);

ALTER TABLE `order_item` ADD CONSTRAINT `order_item_fk1` FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);

LOCK TABLES `users` WRITE;

INSERT INTO `users`(name, email, password_hash) 
VALUES ('ovidiu','ovidiu.cracea@iquestgroup.com','ovidiu.cracea'),

	('ioana','ioana.diaconu@iquestgroup.com','ioana.diaconu'),
	(
'daniel','ursu.daniel2202d@gmail.com','ursu.daniel'),
	(
'catalin','crisan.gheorghecatalin@gmail.com','catalin.crisan'),
	(
'colea','nicolaelungu8@gmail.com','colea.lungu');
	
UNLOCK TABLES;

LOCK TABLES `products` WRITE;

INSERT INTO `products` (category_id, name, price, stock, description, image1_path, image2_path) 
VALUES (1,'Samsung Galaxy S7',800 , 100 , '5.5"' , 'https://s7d2.scene7.com/is/image/SamsungUS/SMG930_gs7_102416?$product-details-jpg$' , 'https://s0emagst.akamaized.net/products/3093/3092917/images/res_ab4739016196fe30ef776c4fe1372fef_full.jpg'),
	(1,'iPhone 7',700 , 100 , '5.6"' ,'https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=png-alpha&qlt=95&.v=1472430205982' , 'https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/plus/iphone7-plus-rosegold-select-2016?wid=1200&hei=630&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=1472430147951'),
	(2,'HP Pavilion All In One PC - 27"',1500 , 50 , 'All-in-One' , 'http://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05184015.png' , 'https://images-na.ssl-images-amazon.com/images/I/81ZEo80zoZL._SL1500_.jpg'),
	(2,'Apple iMac 21.5"',2500 , 25 , 'All-in-One' ,'https://i.ebayimg.com/images/g/htcAAOSwBq1ZlI2C/s-l300.jpg' , 'https://www.encore-pc.co.uk/media/catalog/product/i/m/imac_a1311-1112.jpg');

UNLOCK TABLES;

LOCK TABLES `category` WRITE;

INSERT INTO `category`(name) 
VALUES ('phones'),
	('computers');	
UNLOCK TABLES;
