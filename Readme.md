# Reconocimiento de Sospechosos

Este proyecto es una aplicación Spring Boot que permite el reconocimiento de sospechosos basado en su ADN.

## Tabla de Contenidos

- [Entidades](#entidades)
- [Repositorios](#repositorios)
- [Servicios](#servicios)
- [Controladores](#controladores)
- [Colecciones de Postman](#colecciones-de-postman)
- [Base de Datos](#base-de-datos)

## Entidades

### Persona

La entidad `Persona` representa a una persona en el sistema de reconocimiento de sospechosos. Cada persona tiene un nombre, apellido, dirección, email y un cromosoma que se utiliza para el reconocimiento.

## Repositorios

### PersonaRepository

`PersonaRepository` es una interfaz que extiende `JpaRepository`, proporcionando métodos CRUD para la entidad `Persona`.

## Servicios

### PersonaService

`PersonaService` es una interfaz que define los métodos que deben ser implementados por cualquier clase de servicio que maneje objetos `Persona`.

### PersonaServiceImp

`PersonaServiceImp` es una clase que implementa `PersonaService`, proporcionando la lógica de negocio para los objetos `Persona`.

## Controladores

### PersonaController

`PersonaController` es una clase que maneja las solicitudes HTTP relacionadas con los objetos `Persona`.

## Colecciones de Postman

El proyecto incluye una colección de Postman que contiene ejemplos de todas las solicitudes HTTP que se pueden hacer a la API.

La colección de Postman se encuentra en el archivo `reconocimiento_sospechosos.postman_collection.json` en la ruta `src/main/resources/postman`.

Para utilizar la colección, sigue estos pasos:

1. Abre Postman.
2. Haz clic en el botón "Import" en la parte superior izquierda.
3. Selecciona la opción "Upload Files".
4. Busca y selecciona el archivo `reconocimiento_sospechosos.postman_collection.json`.
5. Una vez importada, verás la colección en la barra lateral izquierda. Puedes expandirla para ver todas las solicitudes HTTP disponibles.

## Base de Datos

Se utiliza una base de datos H2 en memoria para almacenar los datos de las personas. Se proporciona un archivo `import.sql` para inicializar la base de datos con algunos datos de prueba.

## Cómo ejecutar el proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Navega hasta el directorio del proyecto.
3. Ejecuta el comando `mvn spring-boot:run`.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT.