package tree

interface Tree<T> {

    // Gibt zurück, wie viele echte Knoten im Baum sind.
    val size: Int

    // Prüft, ob ein bestimmtes Element im Baum vorkommt.
    fun contains(data: T, comparator: Comparator<T>): Boolean

    // Gibt den Baum in In-Order aus.
    fun traverseInOrder()

    // Gibt den Baum in Pre-Order aus.
    fun traversePreOrder()

    // Gibt den Baum in Post-Order aus.
    fun traversePostOrder()

    // Fügt ein Element sortiert in den Baum ein.
    fun addSorted(data: T, comparator: Comparator<T>): Tree<T>

    // Besucht jedes Element in In-Order und führt darauf eine Funktion aus.
    fun visit(visitorFunction: (T) -> Unit)
}