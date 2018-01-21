DROP DATABASE IF EXISTS `online_shop`;
CREATE DATABASE `online_shop`;
USE online_shop;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password_hash` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `delivery_address` varchar(45) NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_users_orders_idx` (`user_id`),
  CONSTRAINT `FK_users_orders` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `stock` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `image1_path` varchar(300) NOT NULL,
  `image2_path` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_category_products_idx` (`category_id`),
  CONSTRAINT `FK_category_products` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_cart_idx` (`order_id`),
  constraint `FK_orders_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `cart_products`;
CREATE TABLE `cart_products` (
  `product_id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  KEY `FK_cartProducts_cart_idx` (`cart_id`),
  KEY `FK_cartProducts_products` (`product_id`),
  CONSTRAINT `FK_cartProducts_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FK_cartProducts_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` int(11) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  `status_description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `status_history`;
CREATE TABLE `status_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_statusHistory_idx` (`order_id`),
  KEY `FK_orderStatus_statusHistory_idx` (`status_id`),
  CONSTRAINT `FK_orderStatus_statusHistory` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`id`),
  CONSTRAINT `FK_orders_statusHistory` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'ovidiu','ovidiu.cracea@iquestgroup.com','ovidiu.cracea'),
						   (2,'ioana','ioana.diaconu@iquestgroup.com','ioana.diaconu'),
                           (3,'daniel','ursu.daniel2202d@gmail.com','ursu.daniel'),
                           (4,'catalin','crisan.gheorghecatalin@gmail.com','catalin.crisan'),
                           (5,'colea','nicolaelungu8@gmail.com','colea.lungu');
UNLOCK TABLES;


LOCK TABLES `category` WRITE;
INSERT INTO `category` VALUES (1,'phones'),
							  (2,'computers');
UNLOCK TABLES;


LOCK TABLES `products` WRITE;
INSERT INTO `products` VALUES (1,1,'samsung galaxy s7','800' , '100' , '5.5"' , 'https://s7d2.scene7.com/is/image/SamsungUS/SMG930_gs7_102416?$product-details-jpg$' , 'https://s0emagst.akamaized.net/products/3093/3092917/images/res_ab4739016196fe30ef776c4fe1372fef_full.jpg'),
							  (2,1,'ihpone 7','700' , '100' , '5.6"' ,'https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=png-alpha&qlt=95&.v=1472430205982' , 'https://store.storeimages.cdn-apple.com/4974/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/plus/iphone7-plus-rosegold-select-2016?wid=1200&hei=630&fmt=jpeg&qlt=95&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=1472430147951'),
                              (3,2,'HP Pavilion All In One PC - 27"','1500' , '50' , 'All-in-One' , 'http://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05184015.png' , 'https://images-na.ssl-images-amazon.com/images/I/81ZEo80zoZL._SL1500_.jpg'),
                              (4,2,'Apple iMac 21.5"','2500' , '25' , 'All-in-One' ,'https://i.ebayimg.com/images/g/htcAAOSwBq1ZlI2C/s-l300.jpg' , 'https://www.encore-pc.co.uk/media/catalog/product/i/m/imac_a1311-1112.jpg');
UNLOCK TABLES;