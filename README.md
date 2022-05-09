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

As listas podem ser encontradas na raiz deste repositório ([lista_relevancia_1.txt](lista_relevancia_1.txt) e [lista_relevancia_2.txt](lista_relevancia_2.txt)).
The results must by paginated by 15 registers.

### Interface REST

Siga o formato abaixo para definir o endpoint.

#### GET `/search?query={term}`

Return all the users as `.json` que combinam com o termo pesquisado, de acordo com a regra de relevância das listas informada anteriormente.

| Parameter  | Description                 |
|------------|-----------------------------|
| query      | Termo procurado.                                                                                                 |
| from       | Posição da página. 0 é a primeira, 1 é a segunda e assim por diante.  Caso não informado, o valor default será 0.|
| size       | Number of  returned itens. default value is 15                               |


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

## O que será avaliado e valorizamos

* Use README.md ;
* Clean and organized code;
* Design parterns;
* Run with **docker**;
* Unit test.


### Extras
* Auth;
* integration test;
* Usar alguma solução open-source que facilite a pesquisa por relevância;
