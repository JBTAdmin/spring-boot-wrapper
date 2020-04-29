GET - http://localhost:9090/api/company -- get all companies

GET - http://localhost:9090/api/company/{companyId} -- getCompany by Id

GET - http://localhost:9090/api/company/companyName/{companyName} -- get by Company name

POST - http://localhost:9090/api/company -- addCompany
Request Body:
{ "id": 1, 
  "name": "Apple",
  "products": [{
		"code": "A-123",
		"name": "Iphone 7",
		"details": "Price: 649.00 USD & FREE shipping"
	  },
	  {
		"code": "A-456",
		"name": "IPadPro",
		"details": "Price: 417.67 USD & FREE shipping"
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
		"name": "GalaxyJ7",
		"details": "Price: 219.00 USD & FREE shipping"
	  },
	  {
		"code": "S-456",
		"name": "GalaxyTabA",
		"details": "Price: 299.99 USD & FREE shipping"
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
		"name": "S10",
		"details": "Price: 899.99 USD & FREE shipping"
	  } 
  ],
  "contact": {
	"address": "Seocho District, Seoul, South Korea",
	"phone": "+82-2-2053-3000"
  }
}  

PUT- http://localhost:9090/api/company/add/products/{companyId} --addCompanyProducts

PUT- http://localhost:9090/api/company/edit/products/{companyId} --editCompanyProduct 
Request Body:
{
 "code": "S-012",
 "name": "GalaxyJ7",
 "details": "Price: 219.00 USD & FREE shipping"
}  

PUT- http://localhost:9090/api/company/contact/{companyId} --add or update company contact details
Request Body:
{
	"address": "Seocho District, Seoul, South Korea",
	"phone": "+82-2-2053-3001"
}

DEL- http://localhost:9090/api/company/companyName/{companyName} -- deleteCompanyByName

DEL- http://localhost:9090/api/company/{companyId} -- deleteCompanyById
