# master-portal

Proyecto modular basado en Maven, diseñado para facilitar el desarrollo de aplicaciones empresariales desacopladas y reutilizables. El enfoque principal es la separación en módulos independientes como `service`, `web`, `data`, entre otros, permitiendo su uso y despliegue de manera autónoma o conjunta. Actualmente, el sistema implementa un módulo de fichajes.

## Tecnologías principales

- **Java 21**
- **Spring Framework 6.x**
- **Jakarta EE 4.x**
- **PrimeFaces 14.0**
- **Maven (multi-módulo)**

## Estructura del proyecto

El proyecto sigue una arquitectura modular, donde cada módulo representa una capa o funcionalidad específica:

- `master-portal-parent` (parent POM)
    - `master-portal-service` (lógica de negocio)
    - `master-portal-web` (interfaz web)
    - `master-portal-data` (acceso a datos)
    - Otros módulos según necesidades futuras

Cada módulo es un subproyecto Maven con su propio `pom.xml`, gestionado por un `parent POM` en la raíz del repositorio[1][3][4].

## Instalación y ejecución

1. **Clona el repositorio:**
git clone https://github.com/tu-usuario/master-portal.git
cd master-portal

text

2. **Importa el proyecto en Eclipse:**
- Tener en cuenta que se necesita Eclipse Version: 2023-09 (4.29.0) debido al plugin Jboss tools 4.29. Por lo que sera necesario instalar un plugin que nos deje usar JAVA 21 en nuestro IDE
- Selecciona "Importar proyecto Maven existente" desde Eclipse.
- Elige la carpeta raíz del proyecto (`master-portal`).

3. **Construye todos los módulos:**
- Desde la terminal, ejecuta:
  ```
  mvn clean install
  ```
- Esto compilará y empaquetará todos los módulos del proyecto en el orden correcto[1][3][4].

4. **Despliegue y ejecución:**
- Cada módulo puede tener instrucciones específicas para su ejecución (por ejemplo, el módulo `web` puede desplegarse en un servidor de aplicaciones compatible con Jakarta EE).

## Estado actual

- Implementación inicial del sistema de fichajes.
- Arquitectura modular lista para extenderse con nuevos módulos y funcionalidades.

