# CL_Workshop5_6_BookAPI
WEB technologies - Spring, MVC, Jackson Json, REST API 

API Web aplication for manage books. Books are stored in two ways:
1. As Mock - implement temporary in app code during app is running
2. In DB MySQL - achive saved books - this service by default is injected in code

Main target in this case is create API, "convert" object Book to Json and vice versa. API give you too possibility to delete or update Book.
Additionally I added simple JSP views for "admin" who can directly manage books.

API Methods

|Metoda HTTP 	|ADRES 	|FUNCTION|
|---|---|---|
GET 	|/books 	|Return list of all books 
POST 	|/books 	|Create new book.
GET 	|/books/{id} 	|Return one book with included in request id
PUT 	|/books 	|Update information in book
DELETE 	|/books/{id} 	|Delete book with id included in request
