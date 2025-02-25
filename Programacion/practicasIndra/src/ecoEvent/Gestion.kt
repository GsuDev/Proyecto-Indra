package ecoEvent

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Gestion {

    private var listaEventos = ArrayList<Evento>() //Lista de los eventos que existen
    private var listaUsuarios = ArrayList<Usuario>() //Lista de los usuarios existentes
    private var listaOrganizadores = ArrayList<Organizador>() //Lista de los organizadores existentes
    private var listaUbicaciones = ArrayList<Ubicacion>() //Lista de las ubicaciones existentes

    // HashMap de las inscripciones, donde la clave es el evento y el valor
    // es la lista de usuarios que se han inscrito
    private var inscripciones = HashMap<Evento, ArrayList<Usuario>>()

    /////////////////////////////////
    /////// GESTIÓN DE EVENTOS //////
    /////////////////////////////////

    //Metodo para crear evento
    fun crearEvento(){

        // Vamos pidiendo los atributos del evento

        // Nombre
        println("¿Como se llama el evento que quieres crear?")
        val nombreEvento = readln() //Nombre del objeto evento


        // Fecha
        println("¿Cuándo se va a realizar el evento (dd/mm/yyyy) ?")
        var fechaEvento = readln() //Fecha en la que se va a realizar el evento
        // Usamos una regex para comprobar el formato de la fecha (dd/mm/yyyy) y que ni los meses ni los días se pasen
        val formatoFechaRegex = """^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$""".toRegex()

        // Si el formato es incorrecto guarda la fecha de hoy y continua
        if (!fechaEvento.matches(formatoFechaRegex)){
            println("Formato de fecha incorrecto")
            println("Se tomará la fecha de hoy y podrá modificarse mas tarde")
            fechaEvento = "${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}/${Calendar.getInstance().get(Calendar.MONTH) + 1}/${Calendar.getInstance().get(
                Calendar.YEAR)}"
        }

        // Hora
        println("¿A que hora se realizará (hh:mm)?")
        var horaEvento = readln() //Hora del evento
        // Usamos una regex para comprobar el formato de la hora (HH:mm) y que ni las horas ni los minutos se pasen
        val formatoHoraRegex = """^([01][0-9]|2[0-3]):([0-5][0-9])$""".toRegex()

        // Si el formato es incorrecto guarda la hora actual y continúa
        if (!horaEvento.matches(formatoHoraRegex)) {
            println("Formato de hora incorrecto")
            println("Se tomará la hora actual y podrá modificarse más tarde")
            horaEvento = "${Calendar.getInstance().get(Calendar.HOUR_OF_DAY)}:${Calendar.getInstance().get(Calendar.MINUTE)}"
        }


        // Duración
        println("Dime cuantas horas dura el evento")
        val duracion = readln().toInt()

        println("Indique los detalles de la ubicación del evento")
        // Ubicación (llamamos a la función de crear ubicación)
        val ubicacionCreada = crearUbicacion() //Llamo a la función de crear la ubicación del evento

        // isOnline o presencial
        println("¿Se trata de un evento online? (Si / No)")
        val online = readln().lowercase()
        var isOnline = false

        if (online == "si") {
            isOnline = true //Caso de que sea online
        } //Cualquier otra cosa por defecto será PRESENCIAL


        //Crear organizador o elegir existente
        println("¿Quieres crear un organizador nuevo? (Si-No)")
        val crearOrganizador = readln().lowercase() // Preguntamos si queremos crear un organizador

        val organizadorEvento: Organizador

        if (crearOrganizador == "si") {
            organizadorEvento = crearOrganizador()
        } else {
            println("Dime el nombre del organizador ya existente")
            val nombreOrganizador = readln()
            val posicionNombre = listaOrganizadores.indexOfFirst { (it).getNombre() == nombreOrganizador }

            if (posicionNombre == -1) {
                println("No se ha encontrado, se creará uno nuevo")
                organizadorEvento = crearOrganizador() //Si el organizador no se encuentrea, crea uno.
            } else {
                //Caso de que si haya encontrado organizador
                organizadorEvento = listaOrganizadores[posicionNombre]
            }
        }

        //Categoria a la que pertenece el evento
        println("Dime a que categoria pertenece el evento (taller/conferencia/actividad ecologica)")
        var categoriaEvento = readln().lowercase()

        //Categorias disponibles
        val categoriasDisponibles = arrayListOf("taller", "conferencia", "actividad ecologica")

        //Compruebon si la categoria es valida, sino se atribuye conferencia
        if (categoriaEvento !in categoriasDisponibles) {
            println("La categoria ($categoriaEvento), no es una categoría válida. Por defecto se atribuirá (conferencia)")
            categoriaEvento = "conferencia" //Atribuyo conferencia por defecto
        }

        //Creacion del evento
        val eventoCreado =
            Evento(nombreEvento, fechaEvento, horaEvento, duracion, ubicacionCreada, isOnline, organizadorEvento, categoriaEvento)
        //Añado el evento creado a todos los eventos creados
        listaEventos.add(eventoCreado)
        println("Evento creado con exito")
    }


    //Metodo para borrar un evento
    fun borrarEvento() {

        //Nombre del evento a borrar
        println("Dime el nombre del evento que quieres borrar")
        val eventoEliminar = readln()

        //Busqueda del evento para realizar el borrado
        val buscado = listaEventos.firstOrNull { it.getNombre() == eventoEliminar }

        //Caso de que exista
        if (buscado != null) {
            println("Realizando borrado del evento $eventoEliminar")

            val posicionEliminar =
                listaEventos.indexOfFirst { it.getNombre() == eventoEliminar } //Guardo la posicion del evento que se quiere eliminar

            if (posicionEliminar != -1) {
                listaEventos.removeAt(posicionEliminar) //Elimino el evento
            } else {
                println("El evento no se ha encontrado en la lista")
            }

        } else {
            println("El evento no existe")
        }
    }

    // Borra un evento segun el organizador
    fun borrarEventoOrganizador() {
        println("Dime el nombre del organizador del cual quieres borrar su evento")
        val organizador = readln()
        // Encuentra la posicion del organizador
        val posicionOrganizador = listaOrganizadores.indexOfFirst { it.getNombre() == organizador }
        // Guarda el organizador de la lista de organizadores
        val organizadorBorrar = listaOrganizadores[posicionOrganizador]
        // Busca la posicion del evento de ese organizador
        val posicionEvento = listaEventos.indexOfFirst { it.getOrganizador() == organizadorBorrar }
        // Guarda el evento
        val eventoBorrar = listaEventos[posicionEvento]
        // Borra el evento
        listaEventos.remove(eventoBorrar)
    }

    //Modifica evento
    fun modifiicarEvento() {
        println("Dime el nombre del evento que quieres modificar")
        val nombreEvento = readln()

        val buscoEvento = listaEventos.indexOfFirst { nombreEvento == (it).getNombre() }

        if (buscoEvento == -1) {
            println("Ese evento no existe.")
        } else {
            val eventoModificar = listaEventos[buscoEvento] //Evento que se va a modificar

            println("1-Cambiar nombre 2-Fecha 3-Hora 4-Duracion 5-Ubicacion 6-Modalidad 7-Organizador 8-Categoria")
            val opcion = readln().toInt()

            when (opcion) {
                1 -> {
                    println("Dime el nombre nuevo para modificarlo")
                    val nuevoNombre = readln()
                    eventoModificar.setNombre(nuevoNombre) //Cambiar el nombre del evento
                }

                2 -> {
                    println("Dime la nueva fecha del evento (dd/mm/yyyy)")
                    val nuevaFecha = readln()

                    eventoModificar.setFecha(nuevaFecha) //Actualizo el evento con la nueva fecha
                }

                3 -> {

                    println("Dime la nueva hora del evento (hh:mm)")
                    val nuevaHora = readln()
                    eventoModificar.setHora(nuevaHora) //Actualizo la hora del evento
                }

                4 -> {
                    println("Dime la nueva duracion del evento en horas")
                    val nuevaDuracion = readln()
                    eventoModificar.setHora(nuevaDuracion) //Actualizo la duracion del evento
                }

                5 -> {
                    println("Dime la nueva ubicacion del evento completa")
                    val nuevaUbicacion = crearUbicacion() //Crea la nueva ubicacion del examen
                    eventoModificar.setUbicacion(nuevaUbicacion)
                }

                6 -> {
                    //Cambio de evento
                    println("¿Se trata de un evento online? (Si / No)")
                    val nuevaModalidad = readln().lowercase()

                    //Cualquier otra respuesta será presencial
                    var isOnline = (nuevaModalidad == "si")


                }

                7 -> {
                    println("1-Crea el nuevo organizador del evento. 2-Selecciona uno ya creado")
                    val opcionOrganizador = readln().toInt()

                    if (opcionOrganizador == 2) {
                        println("Dime el nombre del nuevo organizador, ya existente")
                        val nuevoOrganizadorNombre = readln()

                        //Extraigo la posicion del organizador
                        val nuevoOrganizador =
                            listaOrganizadores.indexOfFirst { nuevoOrganizadorNombre == (it).getNombre() }

                        //Control de errores en el cambio de organizador
                        if (nuevoOrganizador == -1) {
                            println("Organizador no válido, el cambio no se ha realizado")
                        } else {
                            //Cambio el organizador del evento
                            eventoModificar.setOrganizador(listaOrganizadores[nuevoOrganizador])
                        }

                    } else if (opcionOrganizador == 1) {

                        eventoModificar.setOrganizador(crearOrganizador()) //Creo un nuevo organizador y lo setteo en el evento
                    }

                }

                8 -> {
                    //Cambio de categoria
                    println("Dime la nueva categoria")
                    var nuevaCategoria = readln().lowercase()

                    //Categorias disponibles
                    val categoriasDisponibles = arrayListOf("taller", "conferencia", "actividad ecologica")

                    //Compruebon si la categoria es valida, sino se atribuye conferencia
                    if (nuevaCategoria !in categoriasDisponibles) {
                        println("La categoria ($nuevaCategoria), no es una categoria válida. Por defecto se atribuirá (conferencia)")
                        nuevaCategoria = "conferencia" //Atribuyo conferencia por defecto
                    }

                    //Cambio la categoria del evento
                    eventoModificar.setCategoria(nuevaCategoria) //Nueva categoria
                }
            }
        }
    }


    //Filtrar por categoria del evento
    fun filtrarEventoCategoria() {
        val eventosFiltrada = ArrayList<String>() //Lista de los eventos que coinciden con la categoria indicada

        println("Dime por qué categoría quieres filtrar ")
        val categoriaFiltrar = readln()

        //Recorro la lista de eventos buscando coincidencias por categoria
        for (evento in listaEventos) {

            if (evento.getNombre() == categoriaFiltrar) {
                eventosFiltrada.add(evento.getNombre()) //Guardo los nombres de los eventos de la categoria indicada
            }
        }
        //Devuelvo los eventos con coincidencia
        println("Los eventos de la categoria $categoriaFiltrar son ${eventosFiltrada.joinToString { it }}")
    }

    // Muestra el resumen de cada evento
    fun mostrarEventos() {
        println("Los eventos registrados hasta el momento son:")
        listaEventos.forEach { it.resumen() }
        println("Pulse cualquier tecla para continuar")
        readln()
    }

    // Muestra los eventos de un organizador
    fun mostrarEventosOrganizador() {
        println("Dime el nombre del organizador")
        val organizador = readln()
        val eventosOrganizador = listaEventos.filter { it.getOrganizador().getNombre() == organizador }
        println("Los eventos de $organizador son ${eventosOrganizador.joinToString { it.getNombre() }}")
        println("Pulse cualquier tecla para continuar")
        readln()
    }

    // Busca en la lista de usuarios apuntados a cada evento en la lista de inscripciones
    fun mostrarEventosUsuario(usuarioActual: Usuario) {
        // Inicializo una lista de eventos en los que el usuario está inscrito
        val eventosUsuario = ArrayList<Evento>()

        // Recorro el hashmap de inscripciones
        for (inscripcion in inscripciones) {
            // Guardo el evento que es la clave de cada entrada del hashmap
            val evento = inscripcion.key
            // Recorro la lista de usuarios (valor del hashmap) inscritos en el evento
            for (usuario in inscripcion.value) {
                // Compruebo si coincide el correo de cada usuario con el correo del usuario actual
                if (usuario.getCorreo() == usuarioActual.getCorreo()) {
                    eventosUsuario.add(evento)
                }
            }
        }
        // Si el usuario no se encuentra inscrito en ningun evento, imprimo un mensaje
        if (eventosUsuario.isEmpty()) {
            println("El usuario ${usuarioActual.getNombre()} no se encuentra inscrito en ningun evento")
        } else {
            // Imprimo la lista de eventos en los que el usuario se encuentra inscrito
            println("El usuario ${usuarioActual.getNombre()} se encuentra inscrito en los siguientes eventos:")
            eventosUsuario.joinToString { it.getNombre() }
        }
        println("Pulse cualquier tecla para continuar")
        readln()

    }

    // Mostrar los usuarios apuntados a un evento
    fun mostrarUsuariosEvento() {
        println("Dime el nombre del evento")
        val nombreEvento = readln().lowercase()
        // Guarda el evento que tiene ese nombre o null si no lo encuentra
        val evento = listaEventos.find { it.getNombre() == nombreEvento}
        // Si no lo encuentra sale de la función
        if (evento==null){
            println("No se ha encontrado el evento $nombreEvento")
            return
        }
        // Guarda la lista de usuarios apuntados a ese evento
        val usuariosEvento = inscripciones[evento]
        // Si la lista esta vacia sale de la función
        if (usuariosEvento.isNullOrEmpty()){
            println("No hay usuarios apuntados a $nombreEvento")
            return
        }
        println("Los usuarios apuntados a $nombreEvento son ${usuariosEvento.joinToString { it.getNombre() }}")
        println("Pulse cualquier tecla para continuar")
        readln()
    }

    fun existeEvento(nombreEvento: String): Evento? {
        val evento = listaEventos.find { it.getNombre() == nombreEvento }
        if (evento == null) {
            println("No se ha encontrado el evento $nombreEvento")
        }
        return evento
    }
    ///////////////////////////////////
    ////// FIN GESTIÓN DE EVENTOS /////
    ///////////////////////////////////


    ///////////////////////////////////
    ////// GESTIÓN DE UBICACIONES /////
    ///////////////////////////////////

    //Funcion para crear la ubicacion de un evento
    //Devuelve la ubicacion del evento que se está creando
    fun crearUbicacion(): Ubicacion {

        println("¿En qué país se va a realizar el evento?")
        val paisEvento = readln()

        println("Dime la ciudad en la que se celebrará el evento")
        val ciudadEvento = readln() //Ciudad en la que se realizará el evento

        println("Dime la localidad en la que se celebrará el evento")
        val localidadEvento = readln() //Localidad en la que se realizará el evento

        println("Dime el código postal en el que se realizará el evento")
        val cp = readln().toInt() //Cp del evento

        println("¿En qué calle se realizará el evento?")
        val calleEvento = readln() //Calle en la que se realiza el evento

        println("Dime el número de ( casa / piso / local ... )")
        val numeroEvento = readln().toInt() //Número

        println("Dime la letra, en caso de que la tenga")
        val letraEvento = readln() //En caso de no tener, se devolverá una cadena vacia


        val ubicacionCreada =
            Ubicacion(paisEvento, ciudadEvento, localidadEvento, cp, calleEvento, numeroEvento, letraEvento)

        listaUbicaciones.add(ubicacionCreada) //Añado la ubicacion creada a la lista de ubicaciones
        return ubicacionCreada

    }

    // Mostrar todas las ubicaciones
    fun mostrarUbicaciones() {
        println("Las ubicaciones registradas hasta el momento son:")
        listaUbicaciones.forEach { it.resumen() }
        println("Pulse cualquier tecla para continuar")
        readln()
    }
    ///////////////////////////////////////
    ////// FIN GESTIÓN DE UBICACIONES /////
    ///////////////////////////////////////

    ///////////////////////////////////////
    ////// GESTIÓN DE ORGANIZADORES ///////
    ///////////////////////////////////////


    //Metodo para crear un organizador
    fun crearOrganizador(): Organizador {

        println("Dime el nombre del organizador")
        val nombreOrganizador = readln()

        println("Dime el teléfono del organizador")
        val telfOrganizador = readln().toInt() //Tel. del organizador

        val orgaizadorCreado = Organizador(nombreOrganizador, telfOrganizador)


        //Añado el organizador a la lista de los organizadores
        listaOrganizadores.add(orgaizadorCreado)
        return orgaizadorCreado//Devuelvo el organizador creado
    }

    //Encontrar organizador por nombre
    fun encontrarOrganizadorNombre(nombre: String) {

        val encontrarOrganizador = listaOrganizadores.firstOrNull { (it).getNombre() == nombre }

        //Caso de que lo encuentre
        if (encontrarOrganizador != null) {
            println("El organizador $nombre se encuentra registrado")
        } else {
            //Caso de que no lo encuentre
            println("El organizador $nombre no se encuentra registrado")
        }
    }

    // Mostrar todos los organizadores
    fun mostrarOrganizadores() {
        println("Los organizadores registrados hasta el momento son:")
        println()
        listaOrganizadores.forEach { it.resumen(); println() }
        println("Pulse cualquier tecla para continuar")
        readln()
    }
    /////////////////////////////////////////
    ////// FIN GESTIÓN DE ORGANIZADORES /////
    /////////////////////////////////////////

    ////////////////////////////////
    ////// GESTIÓN DE USUARIOS /////
    ////////////////////////////////

    // Crea un usuario y lo añade a la lista de usuarios
    fun crearUsuario(): Usuario? {
        println("Dime el nombre del nuevo usuario")
        val nombre = readln()

        println("Dime el apellido del nuevo usuario")
        val apellido = readln()

        println("Dime el correo del nuevo usuario")
        val correo = readln()

        if ((listaUsuarios.find { it.getCorreo() == correo }) != null) {
            println("Ya existe un usuario con este correo")
            println("No se ha creado el usuario")
            return null
        }
        println("Dime la contraseña del nuevo usuario")
        val contrasena = readln()

        println("Dime el teléfono del nuevo usuario")
        val tlf = readln().toInt()

        val usuarioCreado = Usuario(nombre, apellido, correo, contrasena, tlf)
        listaUsuarios.add(usuarioCreado)

        println("Se ha creado el usuario ${usuarioCreado.getNombre()}")
        return usuarioCreado
    }

    // Borrar un usuario de la lista de usuarios y los eventos en los que estaba inscrito
    fun borrarUsuario(): Boolean {
        println("Dime el correo del usuario que quieres borrar")
        val correo = readln()
        println("Dime la contraseña del usuario que quieres borrar")
        val contrasena = readln()

        val usuarioBorrar = listaUsuarios.find { it.getCorreo() == correo && it.getContrasena() == contrasena }

        if (usuarioBorrar == null) {
            println("La contraseña es Incorrecta o el usuario no existe")
            println("No se ha borrado el usuario")
            return false
        }
        println("Desinscribiendo al usuario ${usuarioBorrar.getNombre()} de los eventos...")
        desinscribirUsuario(usuarioBorrar)
        listaUsuarios.remove(usuarioBorrar)
        println()
        println("Se ha borrado el usuario ${usuarioBorrar.getNombre()}")
        return true
    }

    // Cambiar la contraseña de un usuario devuelve booleano de estado
    fun cambiarContrasena(): Boolean {
        // Inicia la sesión del usuario por seguridad
        val usuario = inicioSesion()
        // Si el usuario es null es que ha fallado la autenticación
        if (usuario == null) {
            println("No se ha cambiado la contraseña")
            return false
        }
        println("Dime la nueva contraseña")
        val nuevaContrasena = readln()
        // Guardamos la nueva contraseña
        usuario.setContrasena(nuevaContrasena)
        println("Se ha cambiado la contraseña")
        return true
    }

    // Inicia la sesión del usuario y devuelve el usuario autenticado
    fun inicioSesion(): Usuario? {
        println("Dime tu correo")
        val correo = readln()
        println("Dime tu contraseña")
        val contrasena = readln()

        // Recorremos la lista de usuarios
        for (usuario in listaUsuarios) {
            // Comprobamos si el correo y la contraseña son correctos
            if (usuario.getCorreo() == correo && usuario.getContrasena() == contrasena) {
                println("Bienvenido ${usuario.getNombre()}")
                // Devolvemos el usuario
                return usuario
            }
        }
        println("El usuario no existe o la contraseña es incorrecta")
        // Al no encontrar el usuario o ser incorrecta la contraseña devolvemos null
        return null
    }

    // Muestra el resumen de cada usuario
    fun mostrarUsuarios() {
        println("Los usuarios registrados hasta ahora son:")
        println()
        listaUsuarios.forEach { it.resumen(); println() }
        println("Pulse cualquier tecla para continuar")
        readln()
    }

    // Inscribir un usuario en un evento
    fun inscribirUsuario(usuario: Usuario) {

        println("Dime el nombre del evento al que quieres inscribirte")
        val nombre = readln()
        val evento = listaEventos.find { it.getNombre() == nombre }

        if (evento == null) {
            println("El evento no existe")
        } else {
            inscripciones[evento]?.add(usuario)
            println("El usuario ${usuario.getNombre()} se ha inscritoen el evento ${evento.getNombre()}")
        }
    }

    // Borra un usuario de todos los eventos
    fun desinscribirUsuario(usuarioDes: Usuario) {
        // Inicializo una lista de eventos en los que el usuario está inscrito
        val eventosUsuario = ArrayList<Evento>()

        // Recorro el hashmap de inscripciones
        for (inscripcion in inscripciones) {
            // Guardo el evento que es la clave de cada entrada del hashmap
            val evento = inscripcion.key
            // Recorro la lista de usuarios (valor del hashmap) inscritos en el evento
            for (usuario in inscripcion.value) {
                // Compruebo si coincide el usuario con el usuario a desinscribir
                if (usuario == usuarioDes) {
                    inscripcion.value.remove(usuarioDes)
                    eventosUsuario.add(evento)
                }
            }
        }
        // Si el usuario no se encuentra inscrito en ningun evento, imprimo un mensaje
        if (eventosUsuario.isEmpty()) {
            println("El usuario ${usuarioDes.getNombre()} no estaba inscrito en ningun evento")
        } else {
            // Imprimo la lista de eventos en los que el usuario estaba inscrito
            println("El usuario ${usuarioDes.getNombre()} se desinscribió en los siguientes eventos:")
            eventosUsuario.joinToString { it.getNombre() }
        }
    }

    // Borra un usuario de un evento en concreto
    fun desinscribirUsuario(usuarioDes: Usuario, evento: Evento) {
        // Compruebo si el usuario está inscrito en el evento
        if (inscripciones[evento]?.contains(usuarioDes) == true) {
            inscripciones[evento]?.remove(usuarioDes)
        } else {
            // Si el usuario no se encuentra inscrito en el evento, imprimo un mensaje
            println("El usuario ${usuarioDes.getNombre()} no está inscrito en el evento ${evento.getNombre()}")
        }
    }

    ///////////////////////////////////
    ///// FIN GESTIÓN DE USUARIOS /////
    ///////////////////////////////////
}