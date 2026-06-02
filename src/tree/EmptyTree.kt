package tree

class EmptyTree<T> : Tree<T> {

    // Leerer Baum hat 0 Knoten.
    override val size: Int = 0

    // Im leeren Baum kann nichts gefunden werden.
    override fun contains(data: T, comparator: Comparator<T>): Boolean {
        return false
    }

    // Leerer Baum gibt nichts aus.
    override fun traverseInOrder() {
    }

    // Leerer Baum gibt nichts aus.
    override fun traversePreOrder() {
    }

    // Leerer Baum gibt nichts aus.
    override fun traversePostOrder() {
    }

    // Wenn wir in einen leeren Baum einfügen, entsteht ein neuer DataNode.
    override fun addSorted(data: T, comparator: Comparator<T>): Tree<T> {
        return DataNode(data)
    }

    // Leerer Baum hat keine Elemente zum Besuchen.
    override fun visit(visitorFunction: (T) -> Unit) {
    }
}