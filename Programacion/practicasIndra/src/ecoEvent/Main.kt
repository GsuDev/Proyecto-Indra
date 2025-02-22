package ecoEvent

import java.util.*

fun main() {

    val ecoEvent = Gestion() //Creamos un objeto de la clase Gestion
    var isUsuario: Boolean
    println("Bienvenido al programa de gestión de eventos sostenibles: EcoEvent")
    println()
    println("Cargando menú...")
    println()
    while (true) { //Bucle infinito para que el programa se mantenga en ejecución hasta que se cierre

        // Bucle de selección de rol
        while (true) {
            println("Desea usar el programa como administrador (A) o como usuario (U)?")
            val respuesta = readln().lowercase()
            when (respuesta) {
                "a" -> {
                    isUsuario = false
                    break
                }

                "u" -> {
                    isUsuario = true
                    break
                }

                else -> println("Respuesta no reconocida, inténtelo de nuevo")
            }
        }


        while (!isUsuario) { // Menu de opciones del Administrador
            println("Qué desea hacer?")
            println("1. Crear un nuevo evento")
            println("2. Borrar un evento")
            println("3. Modificar un evento")
            println("4. Filtrar eventos por categoría")
            println("5. Mostrar resumen de todos los eventos")
            println("6. Mostrar resumen de los eventos de un organizador")
            println("7. Mostrar ubicaciones")
            println("8. Mostrar organizadores")
            println("9. Mostrar usuarios")
            println("10. Crear organizador")
            println("11. Encontrar organizador por nombre")
            println("0. Salir del menú de Administrador")
            val respuesta = readln().toInt()
            when (respuesta) {
                1 -> ecoEvent.crearEvento()
                2 -> ecoEvent.borrarEvento()
                3 -> ecoEvent.modifiicarEvento()
                4 -> ecoEvent.filtrarEventoCategoria()
                5 -> ecoEvent.mostrarEventos()
                6 -> ecoEvent.mostrarEventosOrganizador()
                7 -> ecoEvent.mostrarUbicaciones()
                8 -> ecoEvent.mostrarOrganizadores()
                9 -> ecoEvent.mostrarUsuarios()
                10 -> ecoEvent.crearOrganizador()
                11 -> {
                    println("Introduzca el nombre del organizador:")
                    val nombreOrganizador = readln()
                    ecoEvent.encontrarOrganizadorNombre(nombreOrganizador)
                }

                0 -> {
                    println("Volviendo al menú principal...")
                    break
                }

                else -> println("Respuesta no reconocida, inténtelo de nuevo")
            }
        }

        var usuario: Usuario? = null
        var sesion = false

        while (isUsuario) { // Menu de opciones del Usuario


            while (!sesion || usuario == null) {
                println("Para acceder al menú de Usuario debes iniciar sesión (I) o registrarte (R)")
                val respuestaSesion = readln().lowercase()
                when (respuestaSesion) {
                    "i" -> {
                        usuario = ecoEvent.inicioSesion()
                        sesion = true
                    }

                    "r" -> {
                        usuario = ecoEvent.crearUsuario()
                        sesion = true

                    }

                    else -> {
                        println("Respuesta no reconocida, inténtelo de nuevo")
                    }
                }
            }
            while (sesion) {
                println("Que desea hacer?")
                println("1. Mostrar todos los eventos")
                println("2. Mostrar eventos a los que está inscrito")
                println("3. Inscribirse a un evento")
                println("4. Desinscribirse de un evento")
                println("5. Desinscribirse de todos los eventos")
                println("6. Opciones del usuario")
                println("7. Cerrar sesión")
                println("0. Salir del menú de Usuario")
                val respuesta = readln().toInt()
                when (respuesta) {
                    1 -> {
                        ecoEvent.mostrarEventos()
                    }

                    2 -> {
                        ecoEvent.mostrarEventosUsuario(usuario)
                    }

                    3 -> {
                        ecoEvent.inscribirUsuario(usuario)
                    }

                    4 -> {
                        println()
                        println("Dime el nombre del evento al que quieres desinscribirte")
                        val nombre = readln()
                        val evento = ecoEvent.existeEvento(nombre)
                        if (evento != null) ecoEvent.desinscribirUsuario(usuario, evento)
                    }

                    5 -> {
                        ecoEvent.desinscribirUsuario(usuario)
                    }
                    6 -> {
                        println("")
                        println("Que desea hacer?")
                        println("1. Cambiar contraseña")
                        println("2. Borrar usuario")
                        println("3. Salir")
                        val respuestaOp = readln().toInt()
                        when (respuestaOp) {
                            1 -> {
                                ecoEvent.cambiarContrasena()
                            }
                            2 -> {
                                ecoEvent.borrarUsuario()
                            }
                            3 -> {
                                println("Volviendo al menú de Usuario...")
                            }
                            else -> println("Respuesta no reconocida, volviendo al menú de Usuario...")
                        }
                    }
                    7 -> {
                        println("Cerrando la sesión del usuario: ${usuario.getNombre()}")
                        sesion = false
                    }

                    0 -> {
                        println("Volviendo al menú principal...")
                        sesion = false
                        isUsuario = false
                    }

                    else -> println("Respuesta no reconocida, inténtelo de nuevo")
                }
            }
        }
    }
}