# How to run
## backend
```bash
./mvnw spring-boot:run 
```

## frontend
```bash
yarn install
ng serve --proxy-config proxy.config.json
```

## db in docker
```bash
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=somePassword -d postgres

```

# Documentation
Documentation is in swagger on adress http://localhost:8080/swagger-ui/
