package clasificacionSupervisada

import data.Herramientas.calcularDistanciaEuclidiana
import data.MatrizConfusion
import data.Patron
import data.PatronRepresentativo


/*
class MinimaDistancia {
    val representativos:ArrayList<Patron> = ArrayList<Patron>()

    fun entrenar(instancias: ArrayList<Patron>) {
        // generar los representativos
    }
}
*/
class MinimaDistancia : Clasificador {

    private val representativos: ArrayList<PatronRepresentativo>
    private var mc: MatrizConfusion?

    override fun entrenar(instancias: ArrayList<Patron>) {
        // agregamos el primer representativo
        representativos.add(PatronRepresentativo(instancias[0]!!))
        // recorrer todas las instancias
        for (x in 1..instancias.size) {
            val aux = instancias[x]
            // es verificar la existencia o no el representativo
            val pos = representativos.indexOf(aux)
            if (pos != -1) {

                // ACUMULAR AL REPRESENTATIVO QUE LE CORRESPONDA
                representativos[pos].acumular(aux!!)
            } else {
                // crear un nuevo patron representativo
                // agregamos el primer representativo
                representativos.add(PatronRepresentativo(aux!!))
            }
        }
        for (aux in representativos) {
            aux.actualizar()
        }
    }


    override fun clasificar(patron: Patron) {
        var iMenor = 0
        var dMenor = calcularDistanciaEuclidiana(patron, representativos[0])

        // en proceso iterativo calcular las distancias con respecto a los representativos
        var i = 1
        while (i < representativos.size) {
            val dN = calcularDistanciaEuclidiana(patron, representativos[i])
            if (dN < dMenor) {
                dMenor = dN
                iMenor = i
            }
            i += 1
        }
        patron.claseResultante = representativos[iMenor].clase
    }


    override fun clasificar(patrones: ArrayList<Patron>) {
        for (p in patrones) {
            clasificar(p)
        }
        mc = MatrizConfusion(patrones)
    }


    fun getMc(): MatrizConfusion? {
        return mc
    }


    init {
        representativos = ArrayList()
        mc = null
    }
}
