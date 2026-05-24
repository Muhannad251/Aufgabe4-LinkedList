 interface Listlike <T : Comparable<T>> {
    /**
     * Fügt das angegebene Element am Anfang der Liste hinzu.
     *
     * @param data das hinzuzufügende Element
     */
    fun addFirst(data: T)   // O(1)

    /**
     * Gibt das erste Element aus der Liste zurück.
     *
     * @return das erste Element aus der Liste
     * @throws NoSuchElementException wenn die Liste leer ist
     */
    fun getFirst(): T // O(1)

    /**
     * Fügt das angegebene Element am Ende der Liste hinzu.
     *
     * @param data das hinzuzufügende Element
     */
    fun addLast(data: T) // O(n)

    /**
     * Entfernt das erste Element aus der Liste und gibt dieses zurück.
     *
     * @return das erste Element aus der Liste
     * @throws NoSuchElementException wenn die Liste leer ist
     */
    fun removeFirst(): T  // O(1)

    /**
     * Gibt die Anzahl der Elemente in der Liste zurück.
     *
     * @return die Anzahl der Elemente in der Liste
     */
    fun size(): Int // O(1)

    /**
     * Prüft, ob die Liste das angegebene Element enthält.
     *
     * @param data Element, dessen Vorhandensein in der Liste geprüft werden soll
     * @return true, wenn die Liste das angegebene Element enthält
     */
    fun contains(data: T): Boolean  // O(n)

    /**
     * Prüft, ob die Liste keine Elemente enthält.
     *
     * @return true, wenn die Liste keine Elemente enthält
     */
    fun isEmpty(): Boolean   //O(1)

    /**
     * Gibt das Element an der angegebenen Position in der Liste zurück. Der Index fängt bei 0 an.
     *
     * @param index Index des zurückzugebenden Elements.
     * @return das Element an der angegebenen Position in der Liste
     * @throws IndexOutOfBoundsException wenn der Index außerhalb des gültigen Bereichs liegt (index < 0 || index >= size())
     */
    fun get(index: Int): T // O(n)

    /**
     * Entfernt das Element an der angegebenen Position und gibt dieses zurück.
     *
     * @param index Index des zu entfernenden Elements
     * @return das entfernte Element
     * @throws IndexOutOfBoundsException wenn der Index außerhalb des gültigen Bereichs liegt (index < 0 || index >= size())
     */
    fun removeAtIndex(index: Int): T  // O(n)

    fun addSorted(data: T) // O(n)

    fun sort(): Listlike<T> // O(n^2).  O(n) * O(n) = O(n^2) (Für jedes Element wird möglicherweise die Liste erneut durchsucht.)

     fun any(condition: (T) -> Boolean): Boolean

     fun all(condition: (T) -> Boolean): Boolean

     fun find(condition: (T) -> Boolean): T?

     fun forEach(action: (T) -> Unit)


}




// O(n) Heißt: je größer die Liste, desto länger dauert es.
// O(1) bedeutet konstante Laufzeit. Die Methode braucht immer ungefähr gleich lange, egal wie viele Elemente in der Liste sind.