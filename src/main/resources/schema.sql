drop table item if exists;
create table item (item_id int generated by default as identity (start with 1) PRIMARY KEY, item_name varchar(50),
                        item_type varchar(10) not null, quantity integer, item_price double);

                        
drop table user if exists;
create table user (user_id int generated by default as identity (start with 1) PRIMARY KEY, user_name varchar(50),
                        email varchar(50) not null, mobile_number BIGINT not null );
                        
                        
drop table cart if exists;
create table cart (cart_id integer generated by default as identity (start with 1), user_id integer,item_id integer);

drop table coupon if exists;
create table coupon (coupon_id integer generated by default as identity (start with 1), coupon_name varchar(50),discount double)


--drop table cart_items if exists;
--create table cart_items (cart_id integer not null, item_id integer not null, primary key (cart_id, item_id))

