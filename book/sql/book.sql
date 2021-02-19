drop database if exists book;

create database book;

use book;

create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(20) not null unique,
	`password` varchar(32) not null,
	`email` varchar(200)
);

insert into t_user(`username`,`password`,`email`) values('admin','admin','admin@atguigu.com');

select * from t_user;



create table t_book(
	`id` int primary key auto_increment,
	`name` varchar(100),
	`price` decimal(11,2),
	`author` varchar(100),
	`sales` int,
	`stock` int,
	`img_path` varchar(200)
);



insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'Thinking in java' , 'Brian' , 80 , 9999 , 9 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'DataStructure' , 'Tom' , 78.5 , 6 , 13 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'How to cook' , 'Jerry' , 68, 99999 , 52 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'Cookies' , 'Thomas' , 16, 1000 , 50 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'C++ prime' , 'Mr john' , 45.5 , 14 , 95 , 'static/img/default.jpg');

insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`)
values(null , 'Hamburger' , 'Jack' , 9.9, 12 , 53 , 'static/img/default.jpg');





select id,name,author,price,sales,stock,img_path from t_book;



use book;

create table t_order(
	`order_id` varchar(50) primary key,
	`create_time` datetime,
	`price` decimal(11,2),
	`status` int,
	`user_id` int,
	foreign key(`user_id`) references t_user(`id`)
);

create table t_order_item(
	`id` int primary key auto_increment,
	`name` varchar(100),
	`count` int,
	`price` decimal(11,2),
	`total_price` decimal(11,2),
	`order_id` varchar(50),
	foreign key(`order_id`) references t_order(`order_id`)
);

