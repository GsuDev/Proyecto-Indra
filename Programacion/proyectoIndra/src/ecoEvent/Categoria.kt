package ecoEvent

class Categoria() {

    companion object {
        var cont = 1
    }
    private var id: Int = cont++
    private var nombre: String = ""
    private var descripcion: String = ""

    // Getters
    fun getId(): Int {
        return id
    }

    fun getNombre(): String {
        return nombre
    }

    fun getDescripcion(): String {
        return descripcion
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setDescripcion(descripcion: String) {
        this.descripcion = descripcion
    }
}

