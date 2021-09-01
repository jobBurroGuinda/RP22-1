package data

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

