# Foro Alura

_Foro Alura_ es una aplicación de foro desarrollada en Java utilizando Spring Boot. La aplicación permite a los usuarios crear y gestionar tópicos (temas de discusión) relacionados con diferentes cursos.

## Características

- Crear, actualizar, listar y eliminar tópicos.
- Gestión de autores.
- Soporte para diferentes cursos (Java, Python, JavaScript, CSS, HTML, Ruby).
- Seguridad implementada con Spring Security y JWT.
- Persistencia de datos utilizando JPA y Hibernate.
- Validación de datos con Jakarta Validation.
- Migraciones de base de datos con Flyway.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Instalación

1. Clona el repositorio del proyecto:

    ```bash
    git clone https://github.com/tu_usuario/foro_alura.git
    cd foro_alura
    ```

2. Configura la base de datos en PostgreSQL:

    ```sql
    CREATE DATABASE alura_foro;
    ```

3. Configura el archivo `application.properties` con los detalles de tu base de datos PostgreSQL:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:8080/foro_alura
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

4. Construye el proyecto con Maven:

    ```bash
    mvn clean install
    ```

## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando:

```bash
mvn spring-boot:run

####Endpoints
Tópicos
POST /topicos:![Captura de pantalla 2024-07-13 094713](https://github.com/user-attachments/assets/126d1759-07bc-4682-8904-fe900543e1e4)![Captura de pantalla 2024-07-13 095800](https://github.com/user-attachments/assets/384dd05f-0d0b-42c5-a5e6-fb8a242904aa)
![Captura de pantalla 2024-07-13 095744](https://github.com/user-attachments/assets/509f6036-9e5a-4384-acfc-a53363e95a3e)
![Captura de pantalla 2024-07-13 095721](https://github.com/user-attachments/assets/e7205b79-821d-4d03-a685-dbda9ae90acc)
![Captura de pantalla 2024-07-13 095706](https://github.com/user-attachments/assets/1d2806b6-5fae-4a30-a0ec-6592b9221271)
![Captura de pantalla 2024-07-13 095644](https://github.com/user-attachments/assets/b612b3da-3aa8-4260-878b-e4480712d472)
![Captura de pantalla 2024-07-13 095630](https://github.com/user-attachments/assets/2cc72642-208a-453d-a79b-4f3dc9ed23ad)
![Captura de pantalla 2024-07-13 095617](https://github.com/user-attachments/assets/88006f26-a769-4684-af85-0c377fc8fb00)
![Captura de pantalla 2024-07-13 095555](https://github.com/user-attachments/assets/a67b7445-e044-4fd0-9349-eca0fd3aa196)
![Captura de pantalla 2024-07-13 095544](https://github.com/user-attachments/assets/b8f6bcf4-5d2e-4139-9518-b22a1af733b5)
![Captura de pantalla 2024-07-13 095524](https://github.com/user-attachments/assets/b3af7ef5-49af-46b0-91d3-ad01891828f9)
![Captura de pantalla 2024-07-13 095500](https://github.com/user-attachments/assets/964ba334-2b90-4ce0-a7ad-1a7d31045305)
![Captura de pantalla 2024-07-13 095449](https://github.com/user-attachments/assets/b735ad40-40d7-4dea-806f-62d2ffc38922)
![Captura de pantalla 2024-07-13 095307](https://github.com/user-attachments/assets/eb1d8c39-e502-47b5-a9bb-e7284904872e)
![Captura de pantalla 2024-07-13 095036](https://github.com/user-attachments/assets/5585fb72-4567-41a1-bbc1-123811b5b870)
![Captura de pantalla 2024-07-13 094835](https://github.com/user-attachments/assets/fb493cbf-dea9-4f85-90dd-d7eb30122cca)
![Captura de pantalla 2024-07-13 094818](https://github.com/user-attachments/assets/195b53f7-1051-4e11-b885-da0b3c7e61dd)
![Captura de pantalla 2024-07-13 094744](https://github.com/user-attachments/assets/58867d62-6a21-4feb-91ef-75f6dc8c9132)
.
GET /topicos: Lista todos los tópicos.
POST /topicos: Crea un nuevo tópico.
PUT /topicos/{id}: Actualiza un tópico existente.
DELETE /topicos/{id}: Elimina un tópico por su ID.

# Ejemplo de JSON para crear un tópico

{
  "nombre": "Introducción a Java",
  "email": "usuario@example.com",
  "telefono": "12345678",
  "documento": "1234567",
  "titulo": "Persistencia de Datos con JPA y Hibernate",
  "mensaje": "Cómo utilizar JPA y Hibernate para la persistencia de datos en aplicaciones Java.",
  "status": "abierto",
  "curso": "Java"
}

####Lista de Errores
Error 404: No Encontrado

Descripción: Ocurre cuando una entidad solicitada no se encuentra en la base de datos.
Error 400: Argumento no válido

Descripción: Ocurre cuando los datos de la solicitud no son válidos, por ejemplo, cuando los campos requeridos no están presentes o no cumplen con las restricciones de validación.

# Este README proporciona una guía completa sobre el uso de dependencias y tecnologías, manejador de errores, y la autenticación con JWT en tu aplicación `foro_alura`. Ajusta y expande esta información según sea necesario para reflejar mejor las características y funcionalidades específicas de tu proyecto.

# adjunto imagenes donde se muestra el proyecto en funcion y el uso  de tecnologias y variables de entorno
