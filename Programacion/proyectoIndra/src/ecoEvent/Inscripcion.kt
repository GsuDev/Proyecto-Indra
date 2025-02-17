package ecoEvent

class Inscripcion() {

    private var idUsuario: Int = 0
    private var idEvento: Int = 0
    private var fechaInscripcion: String = ""

    // Getters
    fun getIdUsuario(): Int {
        return idUsuario
    }

    fun getIdEvento(): Int {
        return idEvento
    }

    fun getFechaInscripcion(): String {
        return fechaInscripcion
    }

    // Setters
    fun setIdUsuario(idUsuario: Int) {
        this.idUsuario = idUsuario
    }

    fun setIdEvento(idEvento: Int) {
        this.idEvento = idEvento
    }

    fun setFechaInscripcion(fechaInscripcion: String) {
        this.fechaInscripcion = fechaInscripcion
    }
}

