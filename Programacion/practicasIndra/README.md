## README.md

# EcoEvent - Gestión de Eventos Sostenibles

EcoEvent es una aplicación de gestión de eventos sostenibles desarrollada en Kotlin. Permite a los administradores y usuarios gestionar eventos, ubicaciones, organizadores y usuarios. A continuación, se presenta una descripción de la estructura del proyecto y un diagrama de clases que muestra cómo se organizan las diferentes clases y sus relaciones.

## Estructura del Proyecto

El proyecto está organizado en varias clases principales, cada una con responsabilidades específicas:

1. **Gestion.kt**: Clase principal que gestiona todas las operaciones relacionadas con eventos, usuarios, organizadores y ubicaciones. Contiene métodos para crear, modificar, eliminar y mostrar información sobre estos elementos.

2. **Evento.kt**: Representa un evento con atributos como nombre, fecha, hora, duración, ubicación, modalidad (online o presencial), organizador y categoría.

3. **Ubicacion.kt**: Representa la ubicación de un evento con atributos como país, ciudad, localidad, código postal, calle, número y letra.

4. **Organizador.kt**: Representa un organizador de eventos con atributos como nombre y teléfono.

5. **Usuario.kt**: Representa un usuario del sistema con atributos como nombre, apellido, correo, contraseña y teléfono.

6. **Main.kt**: Contiene la función principal (`main`) que inicia la aplicación y maneja los menús de administrador y usuario.

## Diagrama de Clases

A continuación, se presenta un diagrama de clases en forma de árbol que muestra las relaciones entre las clases principales:

```
EcoEvent
├── Gestion
│   ├── ArrayList<Evento>
│   ├── ArrayList<Usuario>
│   ├── ArrayList<Organizador>
│   ├── ArrayList<Ubicacion>
│   └── HashMap<Evento, ArrayList<Usuario>>
├── Evento
│   ├── String: nombre
│   ├── String: fecha
│   ├── String: hora
│   ├── Int: duracion
│   ├── Ubicacion: ubicacion
│   ├── Boolean: isOnline
│   ├── Organizador: organizador
│   └── String: categoria
├── Ubicacion
│   ├── String: pais
│   ├── String: ciudad
│   ├── String: localidad
│   ├── Int: cp
│   ├── String: calle
│   ├── Int: numero
│   └── String: letra
├── Organizador
│   ├── String: nombre
│   └── Int: tlf
└── Usuario
    ├── String: nombre
    ├── String: apellido
    ├── String: correo
    ├── String: contrasena
    └── Int: tlf
```

### Explicación del Diagrama

- **Gestion**: Es la clase central que contiene listas de eventos, usuarios, organizadores y ubicaciones. También gestiona las inscripciones de usuarios a eventos mediante un `HashMap` donde la clave es un evento y el valor es una lista de usuarios inscritos.

- **Evento**: Representa un evento con sus atributos básicos. Cada evento tiene una ubicación, un organizador y una categoría. La clase `Evento` también tiene métodos para modificar y mostrar sus atributos.

- **Ubicacion**: Representa la ubicación física de un evento. Contiene detalles como país, ciudad, calle, número, etc. Esta clase es utilizada por la clase `Evento` para definir dónde se llevará a cabo el evento.

- **Organizador**: Representa a la persona o entidad que organiza un evento. Contiene información básica como nombre y teléfono. Esta clase es utilizada por la clase `Evento` para definir quién organiza el evento.

- **Usuario**: Representa a un usuario del sistema. Contiene información personal como nombre, apellido, correo, contraseña y teléfono. Los usuarios pueden inscribirse en eventos y gestionar su participación.

## Funcionalidades Principales

### Administrador

- **Crear, modificar y eliminar eventos**: Los administradores pueden gestionar los eventos, incluyendo su creación, modificación y eliminación.
- **Filtrar eventos por categoría**: Los administradores pueden filtrar eventos según su categoría (taller, conferencia, actividad ecológica).
- **Gestionar organizadores y ubicaciones**: Los administradores pueden crear y mostrar organizadores y ubicaciones.
- **Mostrar usuarios**: Los administradores pueden ver la lista de usuarios registrados en el sistema.

### Usuario

- **Iniciar sesión y registrarse**: Los usuarios pueden iniciar sesión o registrarse en el sistema.
- **Inscribirse y desinscribirse de eventos**: Los usuarios pueden inscribirse en eventos y desinscribirse de ellos.
- **Ver eventos disponibles y sus inscripciones**: Los usuarios pueden ver todos los eventos disponibles y aquellos en los que están inscritos.
- **Gestionar su cuenta**: Los usuarios pueden cambiar su contraseña o eliminar su cuenta.

## Ejecución del Programa

El programa se ejecuta desde la función `main` en `Main.kt`. Al iniciar, el usuario puede elegir entre el modo de administrador o usuario. Dependiendo de la elección, se mostrarán diferentes menús con opciones para gestionar eventos, usuarios, organizadores y ubicaciones.

### Ejemplo de Uso

1. **Modo Administrador**:
    - Crear un nuevo evento.
    - Mostrar todos los eventos.
    - Filtrar eventos por categoría.
    - Gestionar organizadores y ubicaciones.

2. **Modo Usuario**:
    - Iniciar sesión o registrarse.
    - Inscribirse en un evento.
    - Ver eventos disponibles y aquellos en los que está inscrito.
    - Cambiar la contraseña o eliminar la cuenta.

## Conclusión

EcoEvent es una aplicación completa para la gestión de eventos sostenibles, diseñada para facilitar la organización y participación en eventos. La estructura del proyecto está bien organizada, con clases claramente definidas y responsabilidades separadas, lo que facilita la extensión y mantenimiento del código.