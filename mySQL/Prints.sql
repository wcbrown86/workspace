CREATE DATABASE PRINTS;

USE PRINTS;

CREATE TABLE Customer
(customer_id CHAR(4) PRIMARY KEY,
customer_name CHAR(30),
customer_add CHAR(30),
customer_city CHAR(15),
customer_sate CHAR(2),
customer_zip CHAR(5),
customer_phone CHAR(12)
);

CREATE TABLE Items
(item_id CHAR(3) PRIMARY KEY,
title CHAR(30),
artist CHAR(30),
unit_price DEC(4,2),
on_hand CHAR(4)
);

CREATE TABLE Orders
( order_id CHAR(3) PRIMARY KEY,
customer_id CHAR(4),
order_date CHAR(10),
ship_date CHAR(10)
);

CREATE TABLE Orderline
(order_id CHAR(4),
item_id CHAR(3),
order_qty CHAR(4),
PRIMARY KEY (order_id, item_id) );

INSERT INTO Customer
VALUES('1000','Cora Blanca','1555 Seminole Ct.','Charlotte','NC','28210','704/552.1810');
INSERT INTO customer
VALUES('1100','Yash Reed','878 Madison Ave.','Greensboro','NC','27407','336/316-5434');
INSERT INTO customer
VALUES('1200','John Mills','4200 Olive Ave.','Columbia','SC','29206','803/432.6225');
INSERT INTO customer
VALUES('1300','David Cox','608 Old Post Rd.','Decatur','GA','30030','404/243.7379');
INSERT INTO customer
VALUES('1400','Tina Evans','235 Easton Ave','Jacksonville','FL','32221','904/992-7234');
INSERT INTO customer
VALUES('1500','Will Allem','2508 W. Shaw Rd', 'Raleigh', 'NC', '27542', '919/809.2545');
INSERT INTO customer
VALUES('1600', 'James Boyd','200 Pembury Ln.', 'Columbia', 'SC', '29206', '803/432-7600');
INSERT INTO customer
VALUES('1700', 'Will Parsons', '4990 S. Pine St.', 'Raleigh', 'NC', '27545', '919/355.0034');
INSERT INTO customer
VALUES('1800', 'Walkter Kelly', '1200 Little St', 'Columbia', 'SC', '29206', '803/432-1987');
INSERT INTO customer
VALUES('1900', 'Ann Damian', '7822 N. Ridge Rd.', 'Jacksonville', 'FL', '32216', '904/725-4672');
INSERT INTO customer
VALUES('2000', 'Grace Hull', '4090 Caldweld St.', 'Charlotte', 'NC', '28205', '704/365-7655');
INSERT INTO customer
VALUES('2100', 'Jane Brown', '3320 W. Main St.', 'Charlotte', 'NC', '28210', '704/372-9000');
INSERT INTO customer
VALUES('2200', 'Betty Draper', '1600 Sardis Rd', 'Sarasota', 'FL', '32441', '918/941-9121');


INSERT INTO Items
Values('100', 'Under the Sun', 'Donald Arley', 46.80, '340');
INSERT INTO Items
Values('200', 'Dark Lady', 'Keith Morris', 120.99, '250');
INSERT INTO Items
Values('300', 'Happy Days', 'Andrea Reid', 78.00, '210');
INSERT INTO Items
Values('350', 'Top of the Mountain', 'Janice Jones', 110.00, '290');
INSERT INTO Items
Values('400', 'Streets from Old', 'Sharon Brune', 123.00, '320');
INSERT INTO Items
Values('450', 'The Hunt', 'Walkter Alford', 39.99, '390');
INSERT INTO Items
Values('600', 'Rainbow Row', 'Judy Ford', 46.00, '350');
INSERT INTO Items
Values('700', 'Skies Above', 'Alexander Wilson', 98.00, '275');
INSERT INTO Items
Values('800', 'The Seas and Moon', 'Susan Beeler', 67.81, '235');
INSERT INTO Items
Values('850', 'Greek Isles', 'Benjamin Cudle', 76.00, '300');

INSERT INTO Orders
VALUES('1', '1200', '2013-10-23', '2013-10-28');
INSERT INTO Orders
VALUES('2', '1500', '2013-10-30', '2013-11-03');
INSERT INTO Orders
VALUES('3', '1500', '2013-11-09', '2013-11-14');
INSERT INTO Orders
VALUES('4', '2100', '2013-11-15', '2013-11-20');
INSERT INTO Orders
VALUES('5', '1600', '2013-11-15', '2013-11-20');
INSERT INTO Orders
VALUES('6', '1900', '2013-12-15', '2013-12-19');
INSERT INTO Orders
VALUES('7', '2200', '2013-12-18', '2013-12-22');
INSERT INTO Orders
VALUES('8', '1600', '2013-12-20', '2013-12-22');
INSERT INTO Orders
VALUES('9', '1000', '2014-01-18', '2014-01-23');
INSERT INTO Orders
VALUES('10', '2200', '2014-01-31', '2014-02-04');
INSERT INTO Orders
VALUES('11', '1500', '2014-02-01', '2014-02-06'); 
INSERT INTO Orders
VALUES('12', '1400', '2014-02-27', '2014-03-02');
INSERT INTO Orders
VALUES('13', '1100', '2014-03-10', '2014-03-15');
INSERT INTO Orders
VALUES('14', '1400', '2014-03-14', '2014-03-19');

INSERT INTO Orderline
VALUES('1', '800','2');
INSERT INTO Orderline
VALUES('1', '600', '1');
INSERT INTO Orderline
VALUES('2', '700', '3');
INSERT INTO Orderline
VALUES('2', '300', '2');
INSERT INTO Orderline
VALUES('3', '850', '1');
INSERT INTO Orderline
VALUES(INSERT INTO Orderline
VALUES('4', '200', '4');
INSERT INTO Orderline
VALUES('4', '100', '1');
INSERT INTO Orderline
VALUES('4', '850', '1');
INSERT INTO Orderline
VALUES('5', '450', '1');
INSERT INTO Orderline
VALUES('6', '800', '2');
INSERT INTO Orderline
VALUES('7', '300', '2');
INSERT INTO Orderline
VALUES('7', '600', '2')
INSERT INTO Orderline
VALUES('8', '100', '1')
INSERT INTO Orderline
VALUES('9', '100', '3')
INSERT INTO Orderline
VALUES('10', '450', '6');
INSERT INTO Orderline
VALUES('10', '600', '8');
INSERT INTO Orderline
VALUES('10', '200', '4');
INSERT INTO Orderline
VALUES('11', '700', '2');
INSERT INTO Orderline
VALUES('12', '300', '3');
INSERT INTO Orderline
VALUES('12', '700', '4');
INSERT INTO Orderline
VALUES('13', '200', '2');
INSERT INTO Orderline
VALUES('13', '600', '10');
INSERT INTO Orderline
VALUES('13', '450', '4');
INSERT INTO Orderline
VALUES('14', '700', '8');
INSERT INTO Orderline
VALUES('14', '200', '6');
INSERT INTO Orderline
VALUES('14', '800', '4');
INSERT INTO Orderline
VALUES('14', '450', '2');

