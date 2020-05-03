Download JAVA 14 Supported Intellij Idea from https://www.jetbrains.com/idea/download/

Set Project SDK to jdk 14


JAVA 14 feature Record type
A record is a data class that stores pure data. The idea behind introducing records is to quickly create simple and concise to avoid boiler plate code.

Few important things to note about Records:
•	A record can neither extend a class nor can it be extended by another class. It’s a final class.
•	Records cannot be abstract
•	Records cannot extend any other class and cannot define instance fields inside the body. Instance fields must be defined in the state description only
•	Declared fields are private and final
•	The body of a record allows static fields and methods


GET - http://localhost:9090/api/company -- get all companies

GET - http://localhost:9090/api/company/{companyId} -- getCompany by Id

GET - http://localhost:9090/api/company/companyName/{companyName} -- get by Company name

POST - http://localhost:9090/api/company -- addCompany
Request Body:
{ "id": 1, 
  "name": "Apple",
  "products": [{
		"code": "A-123",
		"name": "iPhone 11",
		"details": "Capacity1: 64GB, 128GB, 256GB; Dual 12MP Ultra Wide and Wide cameras; Operating System iOS 13",
		"price": 68300.00		
	  },
	  {
		"code": "A-456",
		"name": "iPhone 11 Pro",
		"details": "Capacity1: 64GB, 256GB, 512GB; Triple 12MP Ultra Wide, Wide and Telephoto cameras; Operating System iOS 13",
		"price": 106600.00
	  }  
  ],
  "contact": {
	"address": "Cupertino, CA 95014",
	"phone": "1-408-996-1010"
  }
} 

Request Body:
{ "id": 2, 
  "name": "Samsung",
  "products": [{
		"code": "S-012",
		"name": "Galaxy S10",
		"details": "Immersive viewing experience with our Dynamic AMOLED Infinity-O Display",
		"price":  57800.00
	  },
	  {
		"code": "S-456",
		"name": "Galaxy S10+",
		"details": "Immersive viewing experience with our Dynamic AMOLED Infinity-O Display",
		"price": 65200.00
	  }  
  ],
  "contact": {
	"address": "Seocho District, Seoul, South Korea",
	"phone": "+82-2-2053-3000"
  }
} 

PUT- http://localhost:9090/api/company --editCompany
Request Body
{ "id": 2, 
  "name": "Samsung",
  "products": [{
		"code": "S-768",
		"name": "Galaxy S10e",
		"details": "Immersive viewing experience with our Dynamic AMOLED Infinity-O Display",
		"price": 47300.00
	  } 
  ],
  "contact": {
	"address": "Seocho District, Seoul, South Korea",
	"phone": "+82-2-2053-3000"
  }
}  

PUT- http://localhost:9090/api/company/add/products/{companyId} --addCompanyProducts
[
  {
	"code": "S-768",
	"name": "Galaxy S10e",
	"details": "Immersive viewing experience with our Dynamic AMOLED Infinity-O Display",
	"price": 47300.00
  } 
]

PUT- http://localhost:9090/api/company/edit/products/{companyId} --editCompanyProduct 
Request Body:
{
 "code": "S-012",
 "name": "Galaxy S10",
 "details": "Charge your Galaxy Watch and Galaxy Buds cable free with Wireless Powershare"
}  

PUT- http://localhost:9090/api/company/contact/{companyId} --add or update company contact details
Request Body:
{
	"address": "Seocho District, Seoul, South Korea",
	"phone": "+82-2-2053-3001"
}

PUT- http://localhost:9090/api/company/edit/{companyId}/products/{productCode}/price/{priceIncreasedBy} --increment price by
companyId: 2
productCode: "S-456"
priceIncreasedBy: 5000.00

DEL- http://localhost:9090/api/company/companyName/{companyName} -- deleteCompanyByName

DEL- http://localhost:9090/api/company/{companyId} -- deleteCompanyById
