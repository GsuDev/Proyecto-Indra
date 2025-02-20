package ecoEvent
class Evento(
    private var nombre: String,
    private var fecha: String,
    private var hora: String,
    private var duracion: Int,
    private var ubicacion: Ubicacion,
    private var isOnline: Boolean,
    private var organizador: Organizador,
    private var categoria: String,
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

    fun getIsOnline(): Boolean {
        return isOnline
    }

    fun getOrganizador(): Organizador {
        return organizador
    }

    fun getCategoria(): String {
        return categoria
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

    fun setUbicacion(ubicacion: Ubicacion) {
        this.ubicacion = ubicacion
    }

    fun setEstado(estado: Boolean) {
        this.estado = estado

    }

    fun setIsOnline(modalidad: Boolean) {
        this.isOnline = modalidad
    }

    fun setOrganizador(organizador: Organizador) {
        this.organizador = organizador
    }

    fun setCategoria(categoria: String) {
        this.categoria = categoria
    }

    fun resumen() {
        println("Id: $id")
        println("Nombre: $nombre")
        println("Fecha: $fecha")
        println("Hora: $hora")
        println("Duracion: $duracion")
        println("Ubicacion: $ubicacion")
        println("Estado: $estado")
        println("Online: $isOnline")
        println("Organizador: $organizador")
        println("Categoria: $categoria")
    }

}