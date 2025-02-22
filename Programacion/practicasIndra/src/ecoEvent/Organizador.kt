package ecoEvent
class Organizador(
    private var nombre: String,
    private var tlf: Int
) {
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

    fun getTlf(): Int {
        return tlf
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setNombre(razonSocial: String) {
        this.nombre = razonSocial
    }

    fun setTlf(tlf: Int) {
        this.tlf = tlf
    }
    fun resumen() {
        println("Id: $id")
        println("Nombre: $nombre")
        println("Telefono: $tlf")
    }
}
