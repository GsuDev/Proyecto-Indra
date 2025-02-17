package ecoEvent

class Inscripcion() {
    private var usuario: Usuario
    private var evento: Evento
    private var fechaInscripcion: String


    // Getters
    fun getIdUsuario(): Int {
        return Usuario
    }

    fun getIdEvento(): Int {
        return Evento
    }

    fun getFechaInscripcion(): String {
        return fechaInscripcion
    }

    // Setters
    fun setIdUsuario(idUsuario: Int) {
        this.Usuario = Usuario
    }

    fun setIdEvento(idEvento: Int) {
        this.Evento = Evento
    }

    fun setFechaInscripcion(fechaInscripcion: String) {
        this.fechaInscripcion = fechaInscripcion
    }

    fun hacer() {
        println("Escriba el nombre del usuario: ")
        val nombre = readLine()
        println("Escriba el apellido del usuario: ")
        val ap1 = readLine()
        println("Escriba el segundo apellido del usuario: ")
        val ap2 = readLine()
        println("Escriba el correo del usuario: ")
        val correo = readLine()
        println("Escriba la contraseña del usuario: ")
        val contrasena = readLine()
        println("Escriba el teléfono del usuario: ")
        val tlf = readLine()
    }
}

