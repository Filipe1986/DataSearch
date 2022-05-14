# Search Challange

## Description

Create a API REST that looks for users by name and username from a key word. 
Use the [database.csv](database.csv) that contains the database. It contains IDs, names e usernames.

###### ExemplE
| ID                                   | Name              | Username             |
|--------------------------------------|-------------------|----------------------|
| 065d8403-8a8f-484d-b602-9138ff7dedcf | Wadson marcia     | wadson.marcia        |
| 5761be9e-3e27-4be8-87bc-5455db08408  | Kylton Saura      | kylton.saura         |
| ef735189-105d-4784-8e2d-c8abb07e72d3 | Edmundo Cassemiro | edmundo.cassemiro    |
| aaa40f4e-da26-42ee-b707-cb81e00610d5 | Raimundira M      | raimundiram          |
| 51ba0961-8d5b-47be-bcb4-54633a567a99 | Pricila Kilder    | pricilakilderitaliani|


It alsos gives you 2 lists of users tha should be used to prioritise the query results.
The list 1 has priority over the list 2, that has priority over the others.

The results must by paginated by 15 registers.

#### GET `/search?query={term}`

Return all the users as `.json` respecting the relevancy rules


Exemple: 

`$ curl http://localhost:8080/search?query=dragon`

Return:
```json
    {
        "from": 0,
        "size": 2,
        "data": [
            {
                "id": "aaaaaaaa-bbbb-cccc-dddd-111111111111",
                "name": "Dragon Ball",
                "username": "dragon.ball"
            },
            {
                "id": "xxxxxxxx-yyyy-cccc-aaaa-zzzzzzzzzzzz",
                "name": "Super Dragon",
                "username": "super.dragon"
            }
        ]
    }

```

## Premisses

### Scale 

* 100 k requests per minute
* ~10 milions searchable itens  

##

* Use README.md ;
* Clean and organized code;
* Design parterns;
* Run with **docker**;
* Unit test.


### Extras
* Auth
* Integration test
* Relevance Search
