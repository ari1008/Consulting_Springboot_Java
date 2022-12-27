# Consulting_Springboot_Java


Lien du notion https://www.notion.so/Architecture-Logiciel-1b4bfe611e194e37814539a1286b7cdd


La première route est pour créer des consultants.
POST : http://localhost:8080/api/consultants

Body 
```json
{
    "firstName": "ari",
    "lastName": "test",
    "modality": "Exemple",
    "startDate": "2022-04-23",
    "endDate": "2022-04-30",
    "tjm": 1200
}
```
Response :
```json
{
    "consultantId": "366ef9ee-3a7c-44f1-8f1b-0fadfb6e1dbe"
}
```
La deuxième route est pour modifier les consultants.
PUT : http://localhost:8080/api/consultants

Body
```json
{
    "id": "366ef9ee-3a7c-44f1-8f1b-0fadfb6e1dbe",
    "firstName": "nicolas",
    "lastName": "test",
    "modality": "changement",
    "startDate": "2022-04-23",
    "endDate": "2022-04-30",
    "tjm": 1200

}
```
Response : 
```json
{
    "id": "366ef9ee-3a7c-44f1-8f1b-0fadfb6e1dbe",
    "firstName": "nicolas",
    "lastName": "test",
    "modality": "changement",
    "startDate": "2022-04-23",
    "endDate": "2022-04-30",
    "tjm": 1200
}
```


La dernière route est pour chercher un consultant précisément :
Inspiration https://dzone.com/articles/advanced-search-amp-filtering-api-using-spring-dat
POST : http://localhost:8080/api/consultants 

Body 
```json
{
    "page": 1,
    "size": 20,
    "orders": "lastName|ASC",
    "filterAnd": "firstName|eq|nicolas",
    "filterOr": "lastName|eq|test"
}
```

Response:

```json

{
    "page": 1,
    "size": 20,
    "filterOr": "lastName|eq|test",
    "filterAnd": "firstName|eq|hello",
    "orders": "lastName|ASC",
    "consultants": [
        {
            "id": "366ef9ee-3a7c-44f1-8f1b-0fadfb6e1dbe",
            "firstName": "nicolas",
            "lastName": "test",
            "modality": "changement",
            "startDate": "2022-04-23",
            "endDate": "2022-04-30",
            "tjm": 1200
        }
    ]
}

```

