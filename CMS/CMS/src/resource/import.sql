CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `image_path` varchar(50) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` text,
  `stock_number` varchar(20) NOT NULL,
  `availablilty` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`)
);

insert into product (
   product_id
  ,name
  ,image_path
  ,price
  ,description
  ,stock_number
  ,availablilty
) VALUES (
   1
  ,'Wooden Chair'
  ,'E:\\images\\chair.png'
  ,45
  ,'Beautiful wooden chair'
  ,'CHR1011'
  ,'Yes'
);

insert into product (
   product_id
  ,name
  ,image_path
  ,price
  ,description
  ,stock_number
  ,availablilty
) VALUES (
   2
  ,'Sofa'
  ,'E:\\images\\sofa.png'
  ,45
  ,'Leather covered sofa'
  ,'SOF4153'
  ,'Yes'
);

insert into product (
   product_id
  ,name
  ,image_path
  ,price
  ,description
  ,stock_number
  ,availablilty
) VALUES (
   3
  ,'Maplewood Table'
  ,'E:\\images\\table.png'
  ,45
  ,'Polished maplewood table'
  ,'TBL9015'
  ,'No'
);