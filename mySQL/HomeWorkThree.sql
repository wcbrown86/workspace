# Home work three by William Brown, 800816688

# Queston One
select publisherName
from Publisher
where publisherName != "New York";

# Question two
select Title
from book b, Publisher p
where (p.PublisherCode = b.PublisherCode) and (p.publisherName = "Penguin USA");

# Question Three
select Title
from book
where book.Type = "MYS";

# Question Four
select Title
from book
where book.Type = "SCI" and Paperback = 'Y';

# Question Five
select Title
from book
where book.Type = "PSY" or PublisherCode = "JP";

# Question Six
select title
from book
where type = "CMP" or type = "HIS" or type = "SCI";

# Question Seven
select count(*) 
from book
where PublisherCode = "ST" or PublisherCode = "VB";

# Question Eight
select title
from book b, wrote w, author a
where (b.bookcode = w.bookcode) and (a.authorNum = w.authorNum) and (a.authorFirst = "Dick") 
and (a.authorLast = "Francis");

# Question Nine
select title 
from book b, wrote w, author a
where (b.bookcode = w.bookcode) and (a.authorNum = w.authorNum) and (a.authorFirst = "John") 
and (a.authorLast = "Steinbeck") and (b.type = "FIC");

# Question Ten
select title
from wrote w, book b
where (b.bookCode = w.bookCode) and (sequence > 1);

# Question Eleven
select count(*)
from copy
where (price > 20) and (price < 25);

# Question Twelve
select BranchNum, CopyNum, quality, Price
from copy c, book b
where (b.bookCode = c.bookCode) and (b.title = "The Stranger"); 

# Question Thrithteen
 select BranchName, CopyNum, quality, Price
from copy c, book b, branch 
where (c.branchNum = branch.branchNum) and (b.bookCode = c.bookCode) 
and (b.title = "Electric Light");

# Question Fourteen
select title, price, quality
from book b, copy c
where (b.bookCode = c.bookCode) and (c.price > 25);

# Question Fithteen
select title, authorFirst, authorLast
from branch bb, book b, copy c, author a, wrote w
where (bb.branchNum = c.branchNum) and (c.bookCode = b.bookCode) and (b.bookCode = w.bookCode)
and (w.authorNum = a.authorNum) and (quality = "Excellent") and (bb.branchName = "Henry on the Hill")
order by b.title and w.sequence;

# Question Sixteen
select b.bookCode, b.title, branchNum, CopyNum, quality, c.price
into FictionCopies
from book b, copy c
where b.bookCode = c.bookCode and type = "FIC";

# Question Seventeen
select BookCode, Title, Price*1.1 AS InreasedPrice
from FictionCopies;

# Question Eighteen 
update FictionCopies
set price = 14.50
where price = 14.00;

# Question Nineteen
delete 
from FictionCopies
where quality = "Poor";
