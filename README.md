# handbook
REST API - handbook for cars, implementation on Spring

# Methods
  + ``` PUT /api/cars``` - add car in list
  + ``` GET /api/cars``` - show all car
  + ``` DELETE /api/cars/{id}``` - delete car from list

Request/response body cars dto in the JSON format:
```json
{
  "brand": "Lada",
  "model": "Granta",
  "release": "2019-05-20T00:00:00.000+0000"
}
```
