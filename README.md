# LibraryManagementSystem

الشعبة: 5 

الأعضاء : 1- عمار خالد الحتيرشي (ليدر)
2- أحمد سعد الحارثي
3-أصيل خالد الجفري
4- محمد أسعد قاسم
5- عبد الوهاب شالواله
6- محمد وجدي خياط

The project is an application to buy books online
•	Book has title, author, type and price.
•	There are three types of books:
1.	Paper book:
-	It has a number of pages and number of copies.
-	This book can be bought(if there is more copies). 
-	Its price equals the original price.
2.	PDF book:
-	It has a number of pages and size in MB(this is a derived attribute, each page =1kB).
-	This book can be bought.
-	Its price equals size * price.
3.	Audio book:
-	It has a narrator and length (another class has hours and minutes).
-	This book can be bought.
-	Its price equals (hours+(minutes/60))*price.
•	Each audio book has an attribute called AudioLength:
-	It has hours and minute to show the length of the audio.
•	Customer has first name, last name, address, myBooks (books that he bought them), balance to pay for books and password is needed when login.
•	When he login to the application, his balance is 0, he can add balance to his account.
•	He can buy any book and pay its price.
Finally in the driver class there is an arrayList of customers and books.
We can add a new customer or new book.
Delete a customer or book.
Login as a customer, the system takes name and password, search for the name and check the password.
Customers can search for books , and buy them.
customer can show books from a specific type and choose its form (PDF for PDF book, Paper for paper book and Audio for audio book).
And he can see his books.

Amounts and Sellings operations will be saves in a file to read it each time and keep the real amount of each book depending on selling operation.
