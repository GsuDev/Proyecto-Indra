package ecoEvent


class Usuario(
    private var nombre: String,
    private var ap1: String,
    private var ap2: String?,
    private var correo: String,
    private var contrasena: String,
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

    fun getAp1(): String {
        return ap1
    }

    fun getAp2(): String? {
        return ap2
    }

    fun getCorreo(): String {
        return correo
    }

    fun getContrasena(): String {
        return contrasena
    }

    fun getTlf(): Int? {
        return tlf
    }

    // Setters
    fun setId(id: Int) {
        this.id = id
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun setAp1(ap1: String) {
        this.ap1 = ap1
    }

    fun setAp2(ap2: String?) {
        this.ap2 = ap2
    }

    fun setCorreo(correo: String) {
        this.correo = correo
    }

    fun setContrasena(contrasena: String) {
        this.contrasena = contrasena
    }

    fun setTlf(tlf: Int?) {
        this.tlf = tlf
    }
}


