package clasificacionSupervisada

import data.Patron


interface Clasificador {

    fun entrenar(instancias: ArrayList<Patron>)
    fun clasificar(patron: Patron)
    fun clasificar(patrones: ArrayList<Patron>)

}