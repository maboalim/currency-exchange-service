# currency-exchange-service

This is a test project as simple service called by other services in microservices project
This project call external API to get the currency exchange rate
Inside this project, there is a usage for rest template (old way) and another usage for feign client
In case of rest template, this project retrieve the URL from spring cloud configuration server called spring-cloud-config-server
This service register itself on eureka naming server since the annotation @EnableDiscoveryClient is used but it is not using other microservices registered inside eureka naming server

# Port
This service use port 8000 as defined in application.properties file

# Example URLs
http://localhost:8080/currency-exchange/from/eur/to/usd

# External API information
External API URL which is used for testing
https://api.exchangeratesapi.io/latest?base=EUR&symbols=USD
Sample responses:
{"rates":{"USD":1.1856},"base":"EUR","date":"2020-10-23"}

{"rates":{"CAD":1.5563,"HKD":9.1885,"ISK":164.9,"PHP":57.388,"DKK":7.4407,"HUF":364.17,"CZK":27.222,"AUD":1.6578,"RON":4.874,"SEK":10.3618,"IDR":17410.24,"INR":87.3245,"BRL":6.6052,"RUB":90.6421,"HRK":7.5778,"JPY":124.17,"THB":37.056,"CHF":1.0715,"SGD":1.6089,"PLN":4.5823,"BGN":1.9558,"TRY":9.4418,"CNY":7.9157,"NOK":10.9178,"NZD":1.7703,"ZAR":19.1905,"USD":1.1856,"MXN":24.753,"ILS":4.0032,"GBP":0.90675,"KRW":1338.52,"MYR":4.9291},"base":"EUR","date":"2020-10-23"}

# Environment information
Java 8
IDE Eclipse
maven 3.6.3