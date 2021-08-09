create table products
(
    id         bigserial primary key,
    title      varchar(128),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp


);
insert into products(title, price)
values ('Product_1', 10),
       ('Product_2', 20),
       ('Product_3', 30),
       ('Product_4', 40),
       ('Product_5', 50),
       ('Product_6', 60),
       ('Product_7', 70),
       ('Product_8', 80),
       ('Product_9', 90),
       ('Product_10', 100),
       ('Product_11', 110),
       ('Product_12', 120),
       ('Product_13', 130),
       ('Product_14', 140),
       ('Product_15', 150),
       ('Product_16', 160),
       ('Product_17', 170),
       ('Product_18', 180),
       ('Product_19', 190),
       ('Product_20', 200),
       ('Product_21', 210)
;