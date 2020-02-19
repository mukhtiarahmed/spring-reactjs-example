#  Spring Security Oauth2 Mongodb Docker,React JS Example

## Prerequisites:
* Docker
* JDK 1.8 
* Maven 3.*

## Install and run the project 
1. download/clone the project 
2. Run following command from the project root folder and create the docker image for back end api service. 
  * `cd oauth-mongodb/ && mvn clean package && sudo docker build -t oauth-mongodb .`
3. Run following command from the project root folder and create the docker image for front end. 
  * `cd react-example && sudo docker build -t react-example .`
4. Run the docker-compose using the following command   
  * `docker-compose up -d`     
  

 
  