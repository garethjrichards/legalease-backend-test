# Legalease Backend Test

## Reference Documentation

### Build
- if you have docker installed `gradle bootBuildImage` will build an image for docker.
- alternatively you can run `gradle bootJar` to build a jar file

### Direct Run
- To run from gradle you can use `gradle bootRun` which should start the application directly

### Postman
- While the application is running you may import the postman collection in the root directory called `Legalease-test.postman_collection.json` to run tests in postman
