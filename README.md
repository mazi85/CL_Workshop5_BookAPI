# CL_Workshop5_BookAPI
WEB technologies - Spring, MVC, Jackson Json, REST API 

API Web aplication for manage books. In this version books are implement temporary in app code during app is running.  Main target in this case is create API, "convert" obeject Book to Json and vice versa. API give you too possibility to delete or update Book. In next step books source will be change for real DB. 

API Methods

|Metoda HTTP 	|ADRES 	|FUNCTION|
|---|---|---|
GET 	|/books 	|Return list of all books 
POST 	|/books 	|Create new book.
GET 	|/books/{id} 	|Return one book with included in request id
PUT 	|/books 	|Update information in book
DELETE 	|/books/{id} 	|Delete book with id included in request
