##Sistema de Calificaciones##

Este proyecto es una aplicación para la gestión de calificaciones en una universidad. Se compone de dos módulos principales:
- Backend: Un servicio REST desarrollado con Spring Boot que administra la lógica de negocio, la persistencia de datos (usando JPA) y la autenticación mediante JWT.
- Frontend: Una aplicación web también desarrollada con Spring Boot y Thymeleaf que consume el API REST del backend. Permite a los usuarios iniciar sesión, visualizar la lista de alumnos (y materias) y gestionar la sesión.

--------------------------------------------------------------

Índice
- Características
- Tecnologías Utilizadas
- Configuración
- Instrucciones de Ejecución
- Endpoints Principales
- Uso del Sistema
- Autor

-------------------------------------------------------------------

Características
- Gestión de alumnos y materias:

  - Crear, listar, obtener detalles y eliminar alumnos.
  - Cada alumno tiene un conjunto de materias asignadas.

- Autenticación y autorización mediante JWT:

  - Registro e inicio de sesión de usuarios.
  - Los endpoints protegidos requieren un token JWT válido que incluya el rol ROLE_CLIENT.

- Frontend con Thymeleaf y Bootstrap:

  - Formularios de login y registro.
  - Páginas con menú de navegación, listado de alumnos, materias y opción de logout.

- Comunicación entre Backend y Frontend:

  - El frontend consume los endpoints REST del backend para visualizar y gestionar la información.
 
-------------------------------------------------------------------------

Tecnologías Utilizadas
- Backend:

  - Java 17 (o superior)
  - Spring Boot
  - Spring Data JPA
  - Spring Security
  - JSON Web Tokens (JWT) (con la librería jjwt)
  - PostgreSQL
  - Lombok (opcional)
  - Logback / SLF4J para logging

- Frontend:

  - Java 17 (o superior)
  - Spring Boot
  - Spring Security
  - Thymeleaf
  - Bootstrap 4 (para estilos y componentes)
  - RestTemplate para consumo de APIs REST
  - Estructura del Proyecto

--------------------------------------------------------------------------------------

Configuración

Backend

1. Base de Datos:
  - Configura la conexión a PostgreSQL (o usa H2 para desarrollo) en el archivo application.properties o application.yml.
  - Ejemplo en application.yml:
```
spring:
  datasource:
    url: jdbc:postgresql://localhost/sistemadecalificaciones
    username: postgres
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
jwt:
  secret: "TuClaveSecretaMuyLargaParaJWT..."
  expiration: 3600000
```

2. Seguridad:
  - El backend tiene configurado Spring Security para proteger los endpoints, exceptuando /api/auth/** que son públicos.
  - El filtro JWT extrae y valida el token, permitiendo el acceso a endpoints protegidos solo si el token contiene el rol adecuado.

Frontend

1. Endpoints del Backend:
  - Las URLs para consumir el backend están configuradas en los servicios del frontend, por ejemplo:
    - Para alumnos: http://localhost:3000/api/alumnos
    - Para autenticación: http://localhost:3000/api/auth/signup y http://localhost:3000/api/auth/signin

2. Seguridad en el Frontend:
  - La configuración de Spring Security del frontend permite el acceso a las páginas de login y recursos estáticos.
  - El proceso de login se maneja en el AuthController y se guarda el token en sesión.

----------------------------------------------------------------------

Instrucciones de Ejecución

Backend

1. Compilar y Ejecutar:
```
cd sistemadecalificacionesapi
mvn clean install
mvn spring-boot:run
```

2. Verifica que la aplicación se inicie en el puerto configurado (por ejemplo, 3000).

3. Probar Endpoints:
  Usa Postman para probar:

  - Registro: POST http://localhost:3000/api/auth/signup
  - Login: POST http://localhost:3000/api/auth/signin
  - Listar alumnos: GET http://localhost:3000/api/alumnos (requiere token)

Frontend
1. Compilar y Ejecutar:
```
cd sistemacalificaciones-frontend
mvn clean install
mvn spring-boot:run
```

2. Acceder a la aplicación:
  - Abre en el navegador: http://localhost:8082/login
3. Flujo de Usuario:
  - Inicia sesión (o regístrate desde Postman).
  - Una vez autenticado, serás redirigido a la página Home, donde podrás navegar al listado de estudiantes y materias.
  - Para cerrar sesión, usa el botón "Cerrar Sesión" del menú.

---------------------------------------------------------------------

Endpoints Principales

Backend

- Autenticación:
  - POST /api/auth/signup – Registro de usuarios.
  - POST /api/auth/signin – Inicio de sesión y generación de token.
- Alumnos:
  - GET /api/alumnos – Listar todos los alumnos (protegido, requiere token con ROLE_CLIENT).
  - POST /api/alumnos – Crear alumno.
  - GET /api/alumnos/{id} – Obtener detalle de un alumno.
  - DELETE /api/alumnos/{id} – Eliminar un alumno.
- Materias: (similares endpoints para materias si se implementaron)

Frontend

- Vistas:
  - /login – Página de login.
  - /home – Página principal luego del login.
  - /estudiantes – Página que muestra el listado de estudiantes (consume el backend).
- Acciones:
  - /auth/logout – Acción para cerrar sesión.

----------------------------------------------------------------------------------

Uso del Sistema

1. Registro e Inicio de Sesión:

  - Los usuarios se registran desde Postman 
  - Inician sesión mediante el formulario en el frontend.
  - El token JWT se guarda en la sesión del navegador y se utiliza para autenticar las solicitudes a los endpoints protegidos del backend.

2. Visualización de Datos:

  - Una vez autenticado, el usuario puede acceder al listado de alumnos y materias, visualizando la información que proviene del backend a través de los servicios del frontend.

3. Cierre de Sesión:

  - El botón "Cerrar Sesión" invalida la sesión y redirige al usuario a la página de login.

------------------------------------------------------------------------------------------------

Autor

Nombre: Francisco Jeraldo
Correo: franciscojeraldof@gmail.com
