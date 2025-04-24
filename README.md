# WebApiPolizas - Microservicio con Spring Boot + Java 17 + Azure SQL + JWT

Este proyecto es un microservicio REST construido con **Spring Boot 3.4.4** y **Java 17**, conectado a una base de datos **Azure SQL**, que implementa autenticación con **JWT (JSON Web Token)** y documentación automática con **Swagger/OpenAPI**.

---

## 🎓 Tecnologías usadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Security
- SQL Server (Azure SQL Database)
- JWT (JSON Web Tokens)
- Maven
- Swagger (springdoc-openapi)

---

## 🔧 Características

- CRUD completo de pólizas de seguros
- Validación de login con JWT
- Autenticación contra tabla `Usuarios` en Azure SQL
- Documentación Swagger en `/swagger-ui/index.html`
- Buenas prácticas con capas `controller`, `service`, `repository`
- Entidades anotadas con JPA

---

## 📂 Estructura del proyecto
```
src/
 ├── main/
 │   ├── java/com/webapipolizas/
 │   │   ├── controller/         # Controladores REST
 │   │   ├── service/            # Lógica de negocio
 │   │   ├── repository/         # Interfaces JpaRepository
 │   │   ├── model/              # Entidades JPA (Poliza, Usuario)
 │   │   ├── security/           # JWT config y filtros
 │   │   └── dto/                # Objetos de petición (LoginRequest)
 │   └── resources/
 │       ├── application.properties
 └── pom.xml
```

---

## ⚖️ Endpoints principales

### Autenticación
```http
POST /api/auth/login
{
  "login": "admin",
  "contrasena": "1234"
}
```
Devuelve un JWT si las credenciales existen en la tabla `Usuarios`.

### Pólizas
- `GET    /api/poliza/lista`      → Listar todas
- `POST   /api/poliza/guardar`    → Crear
- `PUT    /api/poliza/actualizar` → Editar
- `DELETE /api/poliza/eliminar/{numero}` → Eliminar
- `GET    /api/poliza/buscarPorCedula/{cedula}`

> Todos protegidos por JWT. El token debe enviarse en la cabecera:
```http
Authorization: Bearer {tu_token}
```

---

## 🚀 Ejecución local
1. Clona el proyecto
```bash
git clone https://github.com/CH88320B/devApiSpringBoot.git
```
2. Configura tu `application.properties` con tu instancia de Azure SQL:
```properties
spring.datasource.url=jdbc:sqlserver://xxx.database.windows.net:1433;databaseName=DBPolizas;
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```
3. Ejecuta
```bash
./mvnw spring-boot:run
```
4. Accede a:
- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- API Docs JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🏡 Despliegue sugerido
- Azure App Service (Java 17 + SQL Database)
- O también puede dockerizarse y desplegarse en ECS o Kubernetes

---

## 🚀 Próximos pasos sugeridos
- Agregar roles y permisos al usuario
- Cifrar contraseñas en base de datos con BCrypt
- Implementar tests (unitarios + integración)
- Agregar logging con Spring Boot Actuator
- Desplegar en AWS Lambda usando Spring Cloud Function (opcional avanzado)

---

## 👨‍💻 Autor
**Henderson J. Castañeda S.**  
Spring Boot Developer | Azure | AWS | .NET | Microservicios

[LinkedIn](https://www.linkedin.com/in/hendersonjcs) | [GitHub](https://github.com/CH88320B)

---

✨ Dale una estrella si este proyecto te fue últil!
