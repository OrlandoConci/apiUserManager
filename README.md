# Users Manager API

Gestión de usuarios y peticiones. 
La **API REST** Cuenta con validación de datos y utiliza memoria local.

## Tecnologías
- Java 17
- Gradle
- Spring Boot 3.2.2
## Dependencias
- Spring Data JPA
- H2 Database
- Spring Web

## Ejecución
1) git clone https://github.com/OrlandoConci/apiUserManager
2) Descargar IDLE
`IntelliJ IDEA`
Link:
```bash
https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC
```
- Una vez descargada la JDK 17, se ejecuta:
<img width="510" height="428" alt="Gradle" src="https://github.com/user-attachments/assets/17d44684-85f9-465c-91ce-fb379c8fc177" />


> Dirección de la app: `http://localhost:8080/h2-console`.

## Peticiones p/ Postman
- `GET` → http://localhost:8080/users
- `POST` → http://localhost:8080/users
`Body -> Raw`
```bash
{
    "name": "José",
    "lastName": "Fulano",
    "email": "josefulano@auj"

}
```
- `DELETE` → http://localhost:8080/users/n°

## Estructura principal y app en los archivos
<img width="436" height="522" alt="image" src="https://github.com/user-attachments/assets/7cb69a82-0450-4c05-adb7-65b278687acc" />
