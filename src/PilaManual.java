/**
 * PilaManual
 * ----------
 * Implementación de una pila (Stack) construida desde cero usando
 * una lista ligada de nodos (NodoPila). NO utiliza java.util.Stack
 * ni ninguna otra colección de la librería estándar de Java.
 *
 * El "tope" de la pila siempre es la cabeza (head) de la lista ligada,
 * de manera que push/pop/peek se ejecutan en O(1).
 *
 * @param <T> tipo de dato que almacena la pila (en este proyecto, Pizza)
 */
public class PilaManual<T> {

    private NodoPila<T> tope; // cabeza de la lista ligada / tope de la pila
    private int tamano;

    public PilaManual() {
        this.tope = null;
        this.tamano = 0;
    }

    /**
     * Inserta un elemento en el tope de la pila.
     */
    public void push(T elemento) {
        NodoPila<T> nuevoNodo = new NodoPila<>(elemento);
        nuevoNodo.setSiguiente(tope); // el nuevo nodo apunta al antiguo tope
        tope = nuevoNodo;             // el nuevo nodo pasa a ser el tope
        tamano++;
    }

    /**
     * Retira el elemento del tope y devuelve su contenido.
     * Si la pila está vacía, devuelve null.
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente(); // el tope pasa a ser el siguiente nodo
        tamano--;
        return dato;
    }

    /**
     * Devuelve el elemento del tope SIN retirarlo de la pila.
     * Si la pila está vacía, devuelve null.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.getDato();
    }

    /**
     * Indica si la pila se encuentra vacía.
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Cantidad de elementos actualmente en la pila.
     */
    public int size() {
        return tamano;
    }
}
