import tree.DataNode

fun main() {

    val root =
        DataNode(
            data = "Apfel",
            left = DataNode( data = "Birne", left = DataNode(data = "Mango"), right = DataNode(data = "Pflaume")),
            right = DataNode(data = "Kiwi")
        )

    root.traverseInOrder()

    println("InOrder:")
    root.traverseInOrder()

    println()

    println("PreOrder:")
    root.traversePreOrder()

    println()

    println("PostOrder:")
    root.traversePostOrder()

}