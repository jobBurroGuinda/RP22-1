package data
/*
class PatronRepresentativo(clase: String, vector:DoubleArray) : Patron(clase, vector) {
    var cantidad:Int = 0

    fun acumular(aux:Patron){
        // proceso iterativo en el que acumulamos la información
        for (i in 0..super.vector.size-1){
            super.vector[i] += aux.vector[i]
        }
        cantidad++
    }

    fun promediar(){
        for (i in 0..super.vector.size-1) {
            super.vector[i] /= cantidad.toDouble()
        }
    }
}
*/

class PatronRepresentativo : Patron {
    /**
     * @return the contador
     */
    var contador: Int
        private set

    constructor(a: Patron, nombre: String?) : super(a.vector, nombre!!) {
        contador = 0
        acumular(a)
    }

    constructor(a: Patron) : super(a.vector.size-1) {
        super.clase = a.clase
        contador = 0
        acumular(a)
    }

    fun acumular(a: Patron) {
        for (x in 0..a.vector.size-1) {
            super.vector[x] += a.vector[x]
        }
        contador++
    }

    fun actualizar() {
        for (x in 0..super.vector.size-1) {
            super.vector[x] /= contador.toDouble()
        }
        contador = 0
    }

    override fun equals(obj: Any?): Boolean {
        return super.equals(obj) //To change body of generated methods, choose Tools | Templates.
    }

    override fun toString(): String {
        var aux = ""
        for (x in 0..vector.size-1) aux += "[" + vector[x] + "]"
        return aux //To change body of generated methods, choose Tools | Templates.
    }

    fun contar() {
        contador++
    }
}


