### Servicio Price-Service
Este servicio pretende ser usado para registrar y operar con la información de las emergencias permitiendo la creación, actualización y listado de emergencias de la plataforma

## Compilar el proyecto para un profile determinado
En el profile se definen los módulos a compilar: adaptadores de entrada y salida.

```
mvn clean install -Prest
```

## Expone el servicio REST.
```
mvn clean install
mvn -pl infrastructure\launcher\ spring-boot:run 
```

Se sube un postman con los ejemplos de consumo del endpoint.

