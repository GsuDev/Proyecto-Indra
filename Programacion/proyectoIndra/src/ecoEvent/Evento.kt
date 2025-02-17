package ecoEvent

class Evento() {
    companion object {
        var cont = 1
    }
    private var id: Int = cont++
    private var nombre: String = ""
    private var fecha: String = ""
    private var hora: String = ""
    private var duracion: Int = 0
    private var ubicacion: Ubicacion = Ubicacion()
    private var estado: Boolean = true
    private var modalidad: String = ""
    private var organizador: Organizador = Organizador()
    private var categoria: Categoria = Categoria()
    private var tipo: String = "C"

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
    fun setUbicacion(ubicacion: String) {
    }

    fun setEstado(estado: Boolean) {
        this.estado = estado
    }

    fun setModalidad(modalidad: String) {
        this.modalidad = modalidad
    }
    // TODO Asignar Organizador
    fun setOrganizador(organizador: String) {
    }
    // TODO Asignar Categoria
    fun setCategoria(categoria: String) {
    }

    fun setTipo(tipo: String) {
        this.tipo = tipo
    }
}


