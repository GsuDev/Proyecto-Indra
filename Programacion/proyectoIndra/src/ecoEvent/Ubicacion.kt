package ecoEvent

class Ubicacion() {

    companion object {
        var cont = 1
    }
    private var id: Int = cont++
    private var pais: String? = null
    private var ciudad: String? = null
    private var localidad: String? = null
    private var cp: Int? = null
    private var calle: String? = null
    private var numero: Int? = null
    private var letra: String? = null

    // Getters
    fun getId(): Int {
        return id
    }

    fun getPais(): String? {
        return pais
    }

    fun getCiudad(): String? {
        return ciudad
    }

    fun getLocalidad(): String? {
        return localidad
    }

    fun getCp(): Int? {
        return cp
    }

    fun getCalle(): String? {
        return calle
    }

    fun getNumero(): Int? {
        return numero
    }

    fun getLetra(): String? {
        return letra
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setPais(pais: String?) {
        this.pais = pais
    }

    fun setCiudad(ciudad: String?) {
        this.ciudad = ciudad
    }

    fun setLocalidad(localidad: String?) {
        this.localidad = localidad
    }

    fun setCp(cp: Int?) {
        this.cp = cp
    }

    fun setCalle(calle: String?) {
        this.calle = calle
    }

    fun setNumero(numero: Int?) {
        this.numero = numero
    }

    fun setLetra(letra: String?) {
        this.letra = letra
    }
}

