package ecoEvent

class Evento(
            private var nombre: String,
            private var fecha: String,
            private var hora: String,
            private var duracion: Int,
            private var ubicacion: Ubicacion,
            private var modalidad: String,
            private var organizador: Organizador,
            private var categoria: Categoria,
            private var tipo: String
) {
    private var estado: Boolean = true
    companion object {
        var cont = 1
    }
    private var id: Int = cont++


    // Getters
    fun getId(): Int {
        return id
    }

    fun getNombre(): String {
        return nombre
    }

    fun getFecha(): String {
        return fecha
    }

    fun getHora(): String {
        return hora
    }

    fun getDuracion(): Int {
        return duracion
    }

    fun getUbicacion(): Ubicacion {
        return ubicacion
    }

    fun getEstado(): Boolean {
        return estado
    }

    fun getModalidad(): String {
        return modalidad
    }

    fun getOrganizador(): Organizador {
        return organizador
    }

    fun getCategoria(): Categoria {
        return categoria
    }

    fun getTipo(): String {
        return tipo
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setFecha(fecha: String) {
        this.fecha = fecha
    }

    fun setHora(hora: String) {
        this.hora = hora
    }

    fun setDuracion(duracion: Int) {
        this.duracion = duracion
    }
    // TODO Asignar Ubicacion
    fun setUbicacion(ubicacion: Ubicacion) {
        this.ubicacion = Ubicacion()
    }

    fun setEstado(estado: Boolean) {
        this.estado = estado
    }

    fun setModalidad(modalidad: String) {
        this.modalidad = modalidad
    }
    // TODO Asignar Organizador
    fun setOrganizador(organizador: String) {
        this.organizador = Organizador()
    }
    // TODO Asignar Categoria
    fun setCategoria(categoria: String) {
        this.categoria = Categoria()
    }

    fun setTipo(tipo: String) {
        this.tipo = tipo
    }
}


