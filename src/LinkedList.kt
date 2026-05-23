// Wir brauchen das, damit wir einen Fehler werfen können, wenn jemand das erste Element will, aber die Liste leer ist.
import java.util.NoSuchElementException

class LinkedList<T : Comparable<T>> : Listlike<T> {

    // first zeigt immer auf das erste Element in der Liste.  Am Anfang ist die Liste leer, deswegen null.
    private var first: Node<T>? = null

    // Hier speichern wir, wie viele Elemente in der Liste sind. Am Anfang ist die Liste leer, also 0.
    private var listSize = 0

    // Diese Methode fügt ein neues Element ganz vorne in die Liste ein.
    override fun addFirst(data: T) {

        // Wir bauen eine neue Node mit dem Wert data.
        val newNode = Node(data)

        // Die neue Node soll auf das bisherige erste Element zeigen. Wenn vorher z.B. B vorne war, zeigt A jetzt auf B.
        newNode.next = first

        // Jetzt wird die neue Node das erste Element der Liste.
        first = newNode

        // Die Liste hat jetzt ein Element mehr.
        listSize++
    }

    // Diese Methode gibt das erste Element zurück.
    override fun getFirst(): T {

        // Wenn first null ist, dann ist die Liste leer.
        if (first == null) {

            // Dann werfen wir einen Fehler, weil es kein erstes Element gibt.
            throw NoSuchElementException()
        }

        // first!! bedeutet: Ich bin sicher, dass first nicht null ist. data gibt den gespeicherten Wert der ersten Node zurück.
        return first!!.data
    }

    // Diese Methode soll später ein Element hinten einfügen.
    override fun addLast(data: T) {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später das erste Element löschen und zurückgeben.
    override fun removeFirst(): T {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später die Anzahl der Elemente zurückgeben.
    override fun size(): Int {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später prüfen, ob ein bestimmtes Element in der Liste ist.
    override fun contains(data: T): Boolean {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später prüfen, ob die Liste leer ist.
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später ein Element an einer bestimmten Position zurückgeben.
    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später ein Element an einer bestimmten Position löschen.
    override fun removeAtIndex(index: Int): T {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später ein Element direkt sortiert einfügen.
    override fun addSorted(data: T) {
        TODO("Not yet implemented")
    }

    // Diese Methode soll später die Liste sortieren und eine neue sortierte Liste zurückgeben.
    override fun sort(): Listlike<T> {
        TODO("Not yet implemented")
    }
}