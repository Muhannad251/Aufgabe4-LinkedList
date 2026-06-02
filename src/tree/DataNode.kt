package tree

class DataNode<T>(
    val data: T,

    // linker Teilbaum, am Anfang leer
    var left: Tree<T> = EmptyTree(),

    // rechter Teilbaum, am Anfang leer
    var right: Tree<T> = EmptyTree()
) : Tree<T> {

    // aktueller Knoten + Größe links + Größe rechts
    override val size: Int
        get() = 1 + left.size + right.size

    // sucht sortiert: nur links ODER rechts
    override fun contains(data: T, comparator: Comparator<T>): Boolean {

        // vergleicht gesuchten Wert mit aktuellem Knoten
        val result = comparator.compare(data, this.data)

        // wenn beide gleich sind, haben wir es gefunden
        if (result == 0) {
            return true
        }

        // wenn gesuchter Wert kleiner ist, suchen wir nur links
        if (result < 0) {
            return left.contains(data, comparator)
        }

        // sonst suchen wir nur rechts
        return right.contains(data, comparator)
    }

    // links -> aktueller Knoten -> rechts
    override fun traverseInOrder() {
        left.traverseInOrder()
        println(data)
        right.traverseInOrder()
    }

    // aktueller Knoten -> links -> rechts
    override fun traversePreOrder() {
        println(data)
        left.traversePreOrder()
        right.traversePreOrder()
    }

    // links -> rechts -> aktueller Knoten
    override fun traversePostOrder() {
        left.traversePostOrder()
        right.traversePostOrder()
        println(data)
    }

    // fügt ein Element sortiert ein
    override fun addSorted(data: T, comparator: Comparator<T>): Tree<T> {

        // vergleicht neues Element mit aktuellem Knoten
        val result = comparator.compare(data, this.data)

        // kleiner -> nach links
        if (result < 0) {
            left = left.addSorted(data, comparator)
        }

        // größer oder gleich -> nach rechts
        else {
            right = right.addSorted(data, comparator)
        }

        // dieser Knoten bleibt bestehen
        return this
    }

    // besucht alle Elemente in In-Order
    override fun visit(visitorFunction: (T) -> Unit) {
        left.visit(visitorFunction)
        visitorFunction(data)
        right.visit(visitorFunction)
    }
}