import data.*

fun main(args: Array<String>) {
    val p1 = Patron("", doubleArrayOf(2.0, 1.0, 4.5, 6.7))
    val p2 = Patron("", doubleArrayOf(3.0, 10.0, 4.5, 9.7))
    val p3 = Patron("", doubleArrayOf(11.0, 12.0, 4.5, 6.7))
    val p4 = Patron("", doubleArrayOf(5.0, 6.7, 1.5, 5.8))

    val pr = PatronRepresentativo("", doubleArrayOf(0.0, 0.0, 0.0, 0.0))
    pr.acumular(p1)
    pr.acumular(p2)
    pr.acumular(p3)
    pr.acumular(p4)
    pr.promediar()
    println()
}
