# API REST - Centro Deportivo 🏋️‍♂️

Este proyecto es una API RESTful desarrollada con Spring Boot para la gestión integral de un Centro Deportivo. Cumple con todos los requisitos de la API 1 (Principal) solicitados en el Trabajo Práctico.

## 🚀 Tecnologías Utilizadas

* **Java 17**
* **Spring Boot** (Web, Data JPA, Validation)
* **Spring Security & JWT** (Autenticación y protección de rutas)
* **MySQL** (Base de datos relacional)
* **MapStruct** (Mapeo automático entre Entidades y DTOs)
* **Lombok** (Reducción de código repetitivo)
* **JUnit 5 & Mockito** (Testing unitario)

## 🏗️ Arquitectura y Componentes

El proyecto sigue una arquitectura multicapa estándar:
* **Controllers:** Manejo de peticiones HTTP (Uso de Body, Path Variables y Query Params).
* **Services:** Lógica de negocio aislada.
* **Repositories:** Comunicación con BD y queries personalizadas.
* **DTOs:** Validaciones implementadas (`@NotBlank`, `@Email`, etc.) para asegurar la integridad de los datos.

## 🗄️ Base de Datos y Relaciones

Entidades mapeadas con JPA incluyendo relaciones complejas:
* `ManyToOne`: Usuarios asociados a un Plan.
* `ManyToMany`: Usuarios inscriptos en múltiples Clases.

## 🔐 Seguridad (JWT)

* Endpoint público de login (`/api/auth/login`) para generar tokens JWT.
* Endpoints protegidos (`/api/usuarios/**`) que requieren validación mediante `Bearer Token` en el header de autorización.
* Filtro personalizado (`JwtRequestFilter`) para la gestión del ciclo de vida del token.

## 🧪 Testing

* Implementación de pruebas unitarias para aislar la lógica de negocio.
* Uso de **Mockito** (`@Mock`, `@InjectMocks`) para simular la capa de datos (Repository y Mapper) y testear el `UsuarioService` con éxito.