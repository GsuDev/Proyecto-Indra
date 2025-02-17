package ecoEvent

class Organizador() {
    companion object {
        var cont = 1
    }
    private var id: Int = cont++
    private var razonSocial: String = ""
    private var tlf: Int? = null

    // Getters
    fun getId(): Int {
        return id
    }

    fun getRazonSocial(): String {
        return razonSocial
    }

    fun getTlf(): Int? {
        return tlf
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setRazonSocial(razonSocial: String) {
        this.razonSocial = razonSocial
    }

    fun setTlf(tlf: Int?) {
        this.tlf = tlf
    }
}

