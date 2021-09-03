package data


class MatrizConfusion(private val instancias: ArrayList<Patron>) {
    private var matriz: Array<DoubleArray>?
    private val clases: ArrayList<String>
    private fun inicializarMatriz() {
        for (p in instancias) {
            if (!clases.contains(p.clase)) {
                clases.add(p.clase)
            }
        }
        val m = clases.size
        matriz = Array(m) { DoubleArray(m + 1) }
        // recorremos las instancias nuevamente
        for (p in instancias) {
            val r = clases.indexOf(p.clase)
            val c = clases.indexOf(p.claseResultante)
            matriz!![r][c]++
        }
    }


    override fun toString(): String {
        var aux = ""
        for (r in matriz!!.indices) {
            aux += "|"
            for (c in matriz!!.indices) {
                aux += " " + matriz!![r][c] + ","
            }
            aux += "\n"
        }
        return aux
    }


    init {
        clases = ArrayList()
        matriz = null
        inicializarMatriz()
    }
}
