DROP TABLE DebitCard IF EXISTS;

CREATE TABLE DebitCard(
cardno VARCHAR(200) NOT NULL, 
expirydate DATE NOT NULL,
customerName VARCHAR(200),
zip INTEGER, 
PRIMARY KEY(cardno)
);