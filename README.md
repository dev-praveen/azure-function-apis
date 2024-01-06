This projects uses spring-cloud-function-adapter-azure-web adapter to deploy the Spring Boot Web application as a Azure Function.

Usage
Build
./mvnw clean package

Run Locally
./mvnw azure-functions:run

Then use curl to interact with the rest application:

curl -X GET http://localhost:7072/api/AzureWebAdapter/v1/hello?name=john
will output result like Hello john 2024-01-06T19:26:23.406389200

Running on Azure
Make sure you are logged in your Azure account.

az login
and deploy

./mvnw azure-functions:deploy
