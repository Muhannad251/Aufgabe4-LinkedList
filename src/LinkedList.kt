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
        // Neue Node erstellen
        val newNode = Node(data)

        // Wenn die Liste leer ist
        if (first == null) {
            first = newNode
        } else {

            // Wir starten vorne in der Liste
            var current = first

            // Wir laufen bis zum letzten Element
            while (current!!.next != null) {
                current = current.next
            }

            // Neue Node hinten anhängen
            current.next = newNode
        }

        // Größe der Liste erhöhen
        listSize++
    }

    // Diese Methode soll das erste Element löschen und zurückgeben.
    override fun removeFirst(): T {
        // Prüft ob die Liste leer ist
        if (first == null) {
            throw NoSuchElementException()
        }

        // Speichert den Wert vom ersten Element
        val removedData = first!!.data

        // Das zweite Element wird jetzt das erste
        first = first!!.next

        // Ein Element weniger in der Liste
        listSize--

        // Gibt den gelöschten Wert zurück
        return removedData
    }

    // Diese Methode soll die Anzahl der Elemente zurückgeben.
    override fun size(): Int {
        return listSize
    }

    // Diese Methode soll  prüfen, ob ein bestimmtes Element in der Liste ist.
    override fun contains(data: T): Boolean {
        // Wir starten beim ersten Element
        var current = first

        // Solange noch Elemente existieren
        while (current != null) {

            // Prüft ob der Wert gefunden wurde
            if (current.data == data) {
                return true
            }

            // Geht zum nächsten Element
            current = current.next
        }

        // Wenn nichts gefunden wurde
        return false
    }

    // Diese Methode soll prüfen, ob die Liste leer ist.
    override fun isEmpty(): Boolean {
       return listSize == 0 // Wenn listSize gleich 0 ist → Liste leer → true  ,Wenn nicht → false
    }

    // Diese Methode soll ein Element an einer bestimmten Position zurückgeben.
    override fun get(index: Int): T {
        if (index < 0 || index >= listSize) { // prüft, ob der Index ungültig ist.
            throw IndexOutOfBoundsException()
        }

        var current = first // wir starten vorne bei der Liste.
        var counter = 0

        while (counter < index) { // wir laufen so lange weiter, bis wir bei der gewünschten Position sind.
            current = current!!.next
            counter++
        }

        return current!!.data // gibt den Wert an dieser Position zurück.
    }

    // Diese Methode soll ein Element an einer bestimmten Position löschen.
    override fun removeAtIndex(index: Int): T {
        // Prüft ob der Index gültig ist
        if (index < 0 || index >= listSize) {
            throw IndexOutOfBoundsException()
        }

        // Wenn erstes Element gelöscht werden soll
        if (index == 0) {
            return removeFirst()
        }

        // Wir starten vorne
        var current = first

        // Wir laufen bis zum Element VOR dem Ziel
        for (i in 0 until index - 1) {
            current = current!!.next
        }

        // Speichert die Node die gelöscht werden soll
        val removedNode = current!!.next

        // Überspringt die gelöschte Node
        current.next = removedNode!!.next

        // Größe reduzieren
        listSize--

        // Gibt den gelöschten Wert zurück
        return removedNode.data
    }

    // Diese Methode soll ein Element direkt sortiert einfügen.
    override fun addSorted(data: T) {
        // Neue Node erstellen
        val newNode = Node(data)

        // Wenn Liste leer ist
        if (first == null) {
            first = newNode
        }

        // Wenn das neue Element kleiner als das erste ist
        else if (data < first!!.data) {

            // Neue Node zeigt auf erstes Element
            newNode.next = first

            // Neue Node wird erstes Element
            first = newNode
        }

        else {

            // Wir starten vorne
            var current = first

            // Sucht richtige Position
            while (
                current!!.next != null &&
                current.next!!.data < data
            ) {
                current = current.next
            }

            // Neue Node dazwischen einfügen
            newNode.next = current.next
            current.next = newNode
        }

        // Größe erhöhen
        listSize++
    }

    // Diese Methode soll später die Liste sortieren und eine neue sortierte Liste zurückgeben.
    override fun sort(): Listlike<T> {
        // Neue leere Liste
        val sortedList = LinkedList<T>()

        // Startet beim ersten Element
        var current = first

        // Läuft durch die ganze Liste
        while (current != null) {

            // Fügt jedes Element sortiert ein
            sortedList.addSorted(current.data)

            // Geht weiter zum nächsten Element
            current = current.next
        }

        // Gibt die sortierte Liste zurück
        return sortedList
    }

    // O(n)
// Prüft, ob mindestens ein Element die Bedingung erfüllt.
    override fun any(condition: (T) -> Boolean): Boolean {

        // Wir starten beim ersten Element der Liste.
        var current = first

        // Solange current nicht null ist, gibt es noch ein Element.
        while (current != null) {

            // Hier wird die Bedingung auf das aktuelle Element angewendet.
            // Beispiel: condition("Klaus") prüft dann z.B. startsWith("K").
            if (condition(current.data)) {

                // Wenn ein Element passt, können wir direkt true zurückgeben.
                return true
            }

            // Wir gehen zum nächsten Element in der Liste.
            current = current.next
        }

        // Wenn kein Element gepasst hat, geben wir false zurück.
        return false
    }


    // O(n)
// Prüft, ob alle Elemente die Bedingung erfüllen.
    override fun all(condition: (T) -> Boolean): Boolean {

        // Wir starten beim ersten Element der Liste.
        var current = first

        // Solange current nicht null ist, laufen wir durch die Liste.
        while (current != null) {

            // Wenn ein Element die Bedingung NICHT erfüllt...
            if (!condition(current.data)) {

                // ...dann können wir direkt false zurückgeben.
                return false
            }

            // Wir gehen zum nächsten Element.
            current = current.next
        }

        // Wenn kein Element falsch war, erfüllen alle die Bedingung.
        return true
    }

    // O(n)
// Sucht das erste Element, das die Bedingung erfüllt.
    override fun find(condition: (T) -> Boolean): T? {

        // Wir starten vorne in der Liste.
        var current = first

        // Wir laufen durch die ganze Liste.
        while (current != null) {

            // Prüft die Bedingung.
            if (condition(current.data)) {

                // Gibt das erste passende Element zurück.
                return current.data
            }

            // Geht zum nächsten Element.
            current = current.next
        }

        // Wenn nichts gefunden wurde.
        return null
    }


    // O(n)
// Führt eine Aktion für jedes Element aus.
    override fun forEach(action: (T) -> Unit) {

        // Wir starten vorne.
        var current = first

        // Läuft durch die Liste.
        while (current != null) {

            // Führt die Aktion aus.
            action(current.data)

            // Geht weiter.
            current = current.next
        }
    }



}