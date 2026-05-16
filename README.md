# API REST - Centro Deportivo 🏋️‍♂️

Este proyecto es una API RESTful desarrollada con Spring Boot para la gestión integral de un Centro Deportivo. Permite administrar usuarios, clases, planes de suscripción y sus respectivas relaciones.

## 🚀 Tecnologías Utilizadas

* **Java 17**
* **Spring Boot** (Web, Data JPA)
* **MySQL** (Base de datos relacional)
* **MapStruct** (Mapeo automático entre Entidades y DTOs)
* **Lombok** (Reducción de código repetitivo)
* **Maven** (Gestor de dependencias)

## 🏗️ Arquitectura

El proyecto sigue una arquitectura multicapa estándar de la industria:
1. **Controladores (`controller`):** Manejan las peticiones HTTP y exponen los endpoints.
2. **Servicios (`service`):** Contienen toda la lógica de negocio.
3. **Repositorios (`repository`):** Gestionan la comunicación directa con la base de datos mediante Spring Data JPA.
4. **DTOs y Mappers:** Se utiliza MapStruct para aislar el modelo de dominio (Entidades) de los datos expuestos hacia el exterior (DTOs), garantizando mayor seguridad.

## 🛠️ Estado Actual

* Entidad `Usuario` configurada con sus relaciones (`ManyToOne` con Plan, `ManyToMany` con Clases).
* Endpoint `POST /api/usuarios` funcional y testeado (devuelve `201 Created`).
* *Nota: El módulo de Spring Security se encuentra temporalmente deshabilitado para facilitar la etapa actual de desarrollo y pruebas de los endpoints principales.*