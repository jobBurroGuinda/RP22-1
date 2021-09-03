package data
/*
open class Patronn(clase:String, vector:DoubleArray) {
    var clase = clase
    val claseResultante = ""
    var vector : DoubleArray = vector.clone()

    var javaPrueba = ClaseJava()
}
*/

open class Patron {

    var vector: DoubleArray
    var clase: String
    /**
     * @return the claseResultante
     */
    /**
     * @param claseResultante the claseResultante to set
     */
    var claseResultante: String


    constructor(n: Int) {
        vector = DoubleArray(n)
        clase = "Desconocida"
        claseResultante = "Desconocida"
    }


    constructor(vector: DoubleArray, clase: String) {
        this.vector = vector
        this.clase = clase
        claseResultante = "Desconocida"
    }


    constructor(aux: Patron) {
        clase = aux.clase
        vector = aux.vector.clone()
        claseResultante = "Desconocida"
    }


    override fun equals(obj: Any?): Boolean {
        val aux = obj as Patron?
        for (x in vector.indices) {
            if (vector[x] != aux!!.vector[x]) {
                return false
            }
        }
        return true
    }
}


