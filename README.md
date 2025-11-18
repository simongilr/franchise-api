Proyecto Franchise API

Este archivo README.txt describe cómo inicializar y probar el proyecto
franchise-api, incluyendo configuración, migraciones, conexión a base de
datos y uso de colecciones de Postman.

------------------------------------------------------------------------

1. Requisitos previos

-   Java 17
-   Maven 3.8+
-   MySQL en la nube (Clever Cloud)
-   Postman
-   Git

------------------------------------------------------------------------

2. Variables de entorno necesarias

Configurar el archivo application.properties o variables de entorno del
sistema:

    spring.datasource.url=jdbc:mysql://<HOST>:<PORT>/<DATABASE>?useSSL=true&requireSSL=true
    spring.datasource.username=<USER>
    spring.datasource.password=<PASSWORD>

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

Ejemplo con Clever Cloud:

    spring.datasource.url=jdbc:mysql://byxeougtidptsdriv6tg-mysql.services.clever-cloud.com:3306/byxeougtidptsdriv6tg?useSSL=true&requireSSL=true&verifyServerCertificate=false
    spring.datasource.username=ujejxdtr0plxqlvg
    spring.datasource.password=5Go9oqOXl5C9CZoyaTWu

------------------------------------------------------------------------

3. Cómo ejecutar el proyecto

3.1. Clonar el proyecto

    git clone <URL_DEL_REPOSITORIO>
    cd franchise-api

3.2. Compilar

    mvn clean install

3.3. Ejecutar

    mvn spring-boot:run

Si todo es correcto deberías ver:

    Tomcat started on port(s): 8080
    Started FranchiseApiApplication

------------------------------------------------------------------------

4. Probar el proyecto con Postman

Incluye la colección ubicada en:

   Franchise API.postman_collection.json

4.1. Importar

1.  Abrir Postman
2.  Click en Import
3.  Seleccionar el archivo JSON de la colección

4.2. Endpoints típicos incluidos

-   GET /api/franchises
-   POST /api/franchises
-   GET /api/franchises/{id}
-   PUT /api/franchises/{id}
-   DELETE /api/franchises/{id}

------------------------------------------------------------------------

5. Migraciones

El proyecto utiliza migraciones automáticas mediante Hibernate:

-   spring.jpa.hibernate.ddl-auto=update crea automáticamente las
    tablas.

Para producción se recomienda usar:

    validate

o migraciones con Liquibase/Flyway.

------------------------------------------------------------------------

6. Errores comunes

❌ Communications link failure

Solución: - Verificar host, puerto y credenciales - Probar conexión con:

    nc -vz HOST PORT

Debe mostrar: succeeded!

❌ SSL required

Asegurar que tu URL tenga:

    ?useSSL=true&requireSSL=true

------------------------------------------------------------------------

7. Estructura del proyecto

    src/
     ├── main/
     │   ├── java/com/example/franchiseapi
     │   │    ├── controller
     │   │    ├── service
     │   │    ├── repository
     │   │    └── model
     │   └── resources
     │        ├── application.properties
     │        └── data.sql
     └── test/

------------------------------------------------------------------------

8. Cómo cambiar la base de datos

Solo modifica los valores en application.properties.


------------------------------------------------------------------------

Fin del README.
