# Discografia API REST

API REST desarrollada con Java y Spring Boot para la gestión de artistas y discos

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB Atlas
- Gradle

## Base de datos

- Cluster: eva-u2-spring
- Base de datos: discografica-db

## Ejecución del proyecto

Dentro de Powershell o de la terminal de Visual Studio
ubicarse en la raíz del proyecto y ejecutar:

`
.\gradlew bootRun
`
 
La aplicación iniciará en el puerto 8080

## Importante

Este proyecto corresponde a una API REST desarrollada con Spring boot.

No posee interfaz gráfica ni página principal por lo que si accede a:

`text
http://localhost:8080/
`

Aparecerá el error 404 porque no existe una vista de inicio.

Las pruebas deben realizarse utilizando los endpoints de la API.


### Para probar la API utilizar los siguientes endpoints:

NOTA: En los endpoints que contienen `{id}`, este valor debe ser reemplazado por el identificador real que genera MongoDB.


## ARTISTAS

Para ver todos los artistas:
http://localhost:8080/api/artistas

Para obtener todos un artista por id:
http://localhost:8080/api/artista/{id}

Ejemplo:
http://localhost:8080/api/artista/6a92a894a78a666ad2255395


## DISCOS

Para ver todos los Discos:
http://localhost:8080/api/discos

Obtener discos de un artista:
http://localhost:8080/api/artista/{id}/discos

Ejemplo:
http://localhost:8080/api/artista/6a92a894a78a666ad2255395/discos


## NOTA

Los endpoints GET como los anteriores pueden probarse directamente desde el navegador, en cambio los endpoints POST, PUT y DELETE requieren una herramienta HTTP (Postman, PowerShell o similar)

Por ejemplo si quiero agregar un artista nuevo en la Base de datos desde Powershell debo ejecutar en Poweshell:

Invoke-RestMethod `
-Uri "http://localhost:8080/api/artista" `
-Method Post `
-ContentType "application/json" `
-Body '{
  "nombre":"Joss Stone",
  "estilos":["Soul","R&B","Pop"],
  "anioFundacion":2003,
  "estaActivo":true
}'


## Repositorio GitHub

https://github.com/marc7soto-web/discografia-apirest.git