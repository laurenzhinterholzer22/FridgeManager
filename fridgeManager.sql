DROP TABLE IF EXISTS fridge CASCADE;
DROP TABLE IF EXISTS shopping_list CASCADE;
DROP TABLE IF EXISTS user_ CASCADE;
DROP TABLE IF EXISTS amount CASCADE;
DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE fridge (
id serial PRIMARY KEY,
name VARCHAR(255) NOT NULL);

CREATE TABLE shopping_list (
id serial PRIMARY KEY,
name VARCHAR(255) NOT NULL);

CREATE TABLE user_ (
id serial PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
birthday DATE NOT NULL,
gender VARCHAR(255) NOT NULL,
fridge INTEGER NOT NULL,
shopping_list INTEGER NOT NULL,
FOREIGN KEY (fridge) REFERENCES fridge(id) ON DELETE CASCADE,
FOREIGN KEY (shopping_list) REFERENCES shopping_list(id) ON DELETE CASCADE);

CREATE TABLE amount (
description VARCHAR(255) NOT NULL,
amount NUMERIC NOT NULL,
PRIMARY KEY (description, amount));


CREATE TABLE product (
ean VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
expiryDate TIMESTAMP,
amount_description VARCHAR(255) NOT NULL,
amount_amount NUMERIC NOT NULL,
fridge INTEGER NOT NULL,
shopping_list INTEGER NOT NULL,
FOREIGN KEY (amount_description,amount_amount) REFERENCES amount(description,amount),
FOREIGN KEY (fridge) REFERENCES fridge(id) ON DELETE CASCADE,
FOREIGN KEY (shopping_list) REFERENCES shopping_list(id) ON DELETE CASCADE,
PRIMARY KEY(ean,expiryDate,fridge,shopping_list));





