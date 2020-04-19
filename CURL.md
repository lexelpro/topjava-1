Meals Requests
===============================

### Get Meal
`curl -v http://localhost:8080/topjava/rest/meals/100002`

### Get All Meals
`curl -v http://localhost:8080/topjava/rest/meals/`

### Create Meal POST
```curl -X POST localhost:8080/topjava/rest/meals -H 'Content-type:application/json' -d '{"id": null,"dateTime":"2020-04-19T18:25:39.905333","description":"test meal","calories":2000}'```

### Update Meal PUT
`curl -X PUT localhost:8080/topjava/rest/meals/100002 -H 'Content-type:application/json' -d '{"id": 100002, "dateTime": "2020-04-19T18:25:39.905345", "description": "dinner", "calories":200}'`

### Delete Meal DELETE

```curl -X DELETE localhost:8080/topjava/rest/meals/100002```
