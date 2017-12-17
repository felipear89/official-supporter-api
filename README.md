# Official Supporter Service

## Description
A web application to bind official supporter and campaigns

## Endpoints
| Path                                    | Description                                |
|-----------------------------------------|--------------------------------------------|
| POST /officialSupporters                | Insert officialSupporter                   |
| PUT /officialSupporters/{id}            | Update officialSupporter                   |
| GET /officialSupporters                 | List officialSupporters                    |
| POST /officialSupporters/{id}/associate | Associate officialSupporters and campaign  |
| GET /officialSupporters/{id}/associate  | Get officialSupporters associations        |

## How to run
You need to start our dependencies before run integration tests or start the application.

Notice that this docker-compose contain the campaign micro service. So you don't need to have the api running locally

Run the below command
```
docker-compose up -d
```
Let's run!
```
mvn spring-boot:run
```

## Examples
### Insert
```
curl -X POST \
  http://localhost:8080/officialSupporters \
  -H 'content-type: application/json' \
  -d '{
	"name": "Foo Bar",
	"email": "foobar@fakeemail.com",
	"birthday": "1964-01-01",
	"teamId": "chapeco"
}'
```
### Associate

```
curl -X POST http://localhost:8080/officialSupporters/{id}/associate
```

### Get associations
```
curl -X GET http://localhost:8080/officialSupporters/{id}/associate
```
### Get all supporters
```
curl -X GET http://localhost:8080/officialSupporters
 ```
 
