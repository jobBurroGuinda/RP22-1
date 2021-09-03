package data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.*
import javax.swing.JFileChooser
import javax.swing.JOptionPane


object Herramientas {
    var instancias: ArrayList<Patron>? = null
    fun leerDatos() {
        instancias = ArrayList()
        var texto: String?
        var aux: String?
        val lista: LinkedList<String?> = LinkedList<String?>()
        try {
            //llamamos el metodo que permite cargar la ventana
            val file = JFileChooser()
            file.currentDirectory = File("./")
            file.showOpenDialog(file)
            //abrimos el archivo seleccionado
            val abre = file.selectedFile

            //recorremos el archivo y lo leemos
            if (abre != null) {
                val archivos = FileReader(abre)
                val lee = BufferedReader(archivos)
                while (lee.readLine().also { aux = it } != null) {
                    texto = aux
                    lista.add(texto)
                }
                lee.close()
                //System.out.println(lista.size());
                val lista2 = ArrayList<String>()
                var clase = ""
                for (i in lista.indices) {
                    val st = StringTokenizer(lista[i], ",")
                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken())
                    }
                    val vector = DoubleArray(lista2.size - 1)
                    for (x in 0 until lista2.size - 1) {
                        vector[x] = lista2[x].toDouble()
                    }
                    clase = lista2[lista2.size - 1]
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias!!.add(Patron(vector, clase))
                    // patrones.add();
                    lista2.clear()
                }
            }
        } catch (ex: IOException) {
            JOptionPane.showMessageDialog(
                null, """
     $ex
     No se ha encontrado el archivo
     """.trimIndent(),
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE
            )
        }
    }


    fun leerDatos(config: IntArray) {
        instancias = ArrayList()
        var texto: String?
        var aux: String?
        val lista: LinkedList<String?> = LinkedList<String?>()
        try {
            //llamamos el metodo que permite cargar la ventana
            val file = JFileChooser()
            file.showOpenDialog(file)
            //abrimos el archivo seleccionado
            val abre = file.selectedFile

            //recorremos el archivo y lo leemos
            if (abre != null) {
                val archivos = FileReader(abre)
                val lee = BufferedReader(archivos)
                while (lee.readLine().also { aux = it } != null) {
                    texto = aux
                    lista.add(texto)
                }
                lee.close()
                //System.out.println(lista.size());
                val lista2 = ArrayList<String>()
                var clase = ""
                for (i in lista.indices) {
                    val st = StringTokenizer(lista[i], ",")
                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken())
                    }
                    val vector = DoubleArray(obtenerDimension(config))
                    var j = 0
                    for (x in config.indices) {
                        if (config[x] == 1) {
                            vector[j] = lista2[x].toDouble()
                            j++
                        }
                    }
                    clase = lista2[lista2.size - 1]
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias!!.add(Patron(vector, clase))
                    // patrones.add();
                    lista2.clear()
                }
            }
        } catch (ex: IOException) {
            JOptionPane.showMessageDialog(
                null, """
     $ex
     No se ha encontrado el archivo
     """.trimIndent(),
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE
            )
        }
    }


    fun calcularDistanciaEuclidiana(a: Patron, b: Patron): Double {
        var aux = 0.0
        for (x in 0 until a.vector.size) {
            aux += Math.pow(a.vector[x] - b.vector[x], 2.0)
        }
        return Math.sqrt(aux)
    }


    private fun obtenerDimension(config: IntArray): Int {
        var c = 0
        for (x in config.indices) {
            if (config[x] == 1) {
                c++
            }
        }
        return c
    }
}
