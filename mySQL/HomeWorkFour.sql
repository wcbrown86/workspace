# Question 1

CREATE VIEW PenguinBooks AS
SELECT BookCode, Title, Type, Price
FROM book
WHERE PublisherCode = "PE";

# Question 2


# Question 3

CREATE VIEW BookAuthor AS
SELECT BookCode, BookTitle, BookType, AuthorName, FirstName,LastName, SequenceNumber
FROM Inventory
GROUP BY BookCode;

# Question 4

#a
CREATE INDEX BookIndex1
ON Publisher (PublisherName);

#b
CREATE INDEX BookIndex2
ON Book (Type);

#c
CREATE INDEX BookIndex3
ON Book (BookCode, Type);

# Question 5

DROP INDEX BookIndex3
ON Book;

# Question 6

ALTER TABLE Book
ADD CHECK (Price > 90);

# Question 7

# Question 8

ALTER TABLE Book
ADD Classic CHAR(1);

# Question 9

UPDATE Book
SET Classic = 'Y'
WHERE Title = "The Grapes of Wrath";

# Question 10

ALTER TABLE Book
MODIFY COLUMN Title CHAR(60);

# Question 11

DROP TABLE Books;

# Question 12

DELIMITER $$
CREATE PROCEDURE Change_Price(BCode CHAR(4), Pprice DECIMAL(8,2), qual CHAR(8))BEGIN
UPDATE CopySET Price = Pprice 
WHERE BookCode = BCode and Quality = qual;
END &&
DELIMITER;

# Question 13

#a
DELIMITER $$
CREATE TRIGGER AddVal
AFTER INSERT ON Copy
FOR EACH ROW
BEGIN
UPDATE Branch
SET TotalValue = TotalValue + BookPrice
WHERE BookCode = New.BookCode
END && 
DELIMITER;

#b
DELIMITER $$
CREATE TRIGGER UpdVal
AFTER UPDATE ON Copy
FOR EACH ROW
BEGIN
UPDATE Branch
SET TotalOnHand = TotalOnHand + New.OnHand - Old.OnHand
WHERE BookCode = New.BookCode
END &&
DELIMITER;

#c
DELIMITER $$
CREATE TRIGGER DelVal
AFTER DELETE ON Copy
FOR EACH ROW
BEGIN
UPDATE Branch
SET TotalOnHand = TotalOnHand - Old.OnHand
WHERE BookCode = Old.BookCode
END &&
DELIMITER

