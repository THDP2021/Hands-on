create table users (
id int(6) auto_increment,
name varchar(30) not null,
primary key (id)
);

create table providers (
id int(6) auto_increment,
name varchar(30) not null,
primary key (id)
);

create table products (
id int(6) auto_increment,
provider_id int(6) not null,
user_id int(6) not null,
name varchar(30) not null,
price float not null,
amount int(6) not null,
primary key (id),
CONSTRAINT fk_provider_product FOREIGN KEY(provider_id) REFERENCES providers(id),
CONSTRAINT fk_user_product FOREIGN KEY(user_id) REFERENCES users(id)
);

INSERT INTO users (name) VALUES ('Emilio');
INSERT INTO users (name) VALUES ('Abraham');
INSERT INTO users (name) VALUES ('Saul');

INSERT INTO providers (name) VALUE ('Wallmart');
INSERT INTO providers (name) VALUE ('Staples');
INSERT INTO providers (name) VALUE ('Kroger');
INSERT INTO providers (name) VALUE ('Target');

INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Fruits', 1.15, 15);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Beef', 3.55, 20);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Milk', 2.25, 20);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Bread', 3.75, 40);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Soda', 1.75, 30);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Instant Soup', 1.50, 70);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Veggtables', 2.15, 50);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Chocolate', 2.65, 30);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Cookies', 2.99, 10);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (1,1,'Lays', 2.55, 25);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Wood plates', 7.55, 50);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Package of paper', 6.99, 100);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Box of Staples', 5.00, 25);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Box of pens', 6.99, 25);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Box of pencils', 5.99, 25);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'USB', 12.50, 100);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Box of screws', 4.50, 15);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Office Chair', 59.99, 5);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Trash bin', 9.99, 35);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (2,2,'Tape', 8.75, 125);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Bleach', 5.00, 32);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Liquid Soap', 6.99, 22);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Detergent', 2.50, 16);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Window Cleaner', 3.25,27);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Broom', 3.50, 54);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Mop', 4.50, 45);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Box of Trash bags', 2.99, 12);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Dishwasher', 184.99, 11);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Laundry Machine', 299.00, 16);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (3,3,'Hoover', 124.99, 7);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Headphones', 24.99, 10);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'TV', 599.99, 5);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Smart Watch', 199.99, 9);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Camera', 324.99, 5);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Videogame Console', 299.99, 12);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'PC', 449.99, 4);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Laptop', 445.99, 3);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Projector', 199.99, 2);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Stereo', 129.50, 8);
INSERT INTO products (provider_id, user_id, name, price, amount) VALUES (4,3,'Smart Phone', 299.99, 12);