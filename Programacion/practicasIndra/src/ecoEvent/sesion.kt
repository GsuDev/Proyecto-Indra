package ecoEvent

class sesion(
    private var usuario: Usuario
) {




    fun inicioSesion() {
        println("Escribe el nombre de usuario")
        val nombre = readln()
        println("Escribe la contraseña")
        val contrasena = readln()
    }
}