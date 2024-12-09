# Open API Übungsprojekt der Lehrlingsakademie

Run tests in `ShipControllerTest`

## Implement OpenAPI

### Version 1.0.0

`/src/main/resource/openapi`

#### Enhance the API

Extend the ship
- ship name. A string
- size. An Integer, must be greater than 0, but lower or equal than 1000.
- captain email. A string following an email pattern.
- cargo. An array of cargo

Define the cargo:
- cargo type. An enum with the following allowed values: 'Medicine', 'Plants', 'Food', 'Tools'
- size. An integer. Allowed values are onl 1, 2 or 4

#### Add some 400 and 500 exception

#### Write some more endpoints

- A get on '/ship' to return a list of ships
- A delete for a specific id

- Write tests for all

### Write a new version of the api

- Create a new file - Use Semantic Versioning
- Add a nickname to the ship as an optional string

Analyse the file with `oasdiff diff <filename_old> <filename_new>`

### Write another new version of the api

- Create a new file - Use Semantic Versioning
- Extend the get for the list to have a required query parameter of type string that's called search.

Analyse the file with `oasdiff diff <filename_old> <filename_new>`
Perform a check for breaking changes `oasdiff breaking <filename_old> <filename_new>`
