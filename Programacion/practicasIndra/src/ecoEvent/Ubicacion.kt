package ecoEvent
class Ubicacion(
    private var pais: String,
    private var ciudad: String,
    private var localidad: String,
    private var cp: Int,
    private var calle: String,
    private var numero: Int,
    private var letra: String
) {

    companion object {
        var cont = 1
    }
    private var id: Int = cont++


    // Getters
    fun getId(): Int {
        return id
    }

    fun getPais(): String {
        return pais
    }

    fun getCiudad(): String {
        return ciudad
    }

    fun getLocalidad(): String {
        return localidad
    }

    fun getCp(): Int {
        return cp
    }

    fun getCalle(): String {
        return calle
    }

    fun getNumero(): Int {
        return numero
    }

    fun getLetra(): String {
        return letra
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setPais(pais: String) {
        this.pais = pais
    }

    fun setCiudad(ciudad: String) {
        this.ciudad = ciudad
    }

    fun setLocalidad(localidad: String) {
        this.localidad = localidad
    }

    fun setCp(cp: Int) {
        this.cp = cp
    }

    fun setCalle(calle: String) {
        this.calle = calle
    }

    fun setNumero(numero: Int) {
        this.numero = numero
    }

    fun setLetra(letra: String) {
        this.letra = letra
    }

    fun resumen(){
        println("ID: $id")
        println("Pais: $pais")
        println("Ciudad: $ciudad")
        println("Localidad: $localidad")
        println("Cp: $cp")
        println("Calle: $calle")
        println("Numero: $numero")
        println("Letra: ${if (letra == "") "No tiene" else letra}")
    }
}