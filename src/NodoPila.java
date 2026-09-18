/**
 * Nodo genérico usado para construir la pila manualmente mediante
 * una lista ligada (simplemente enlazada).
 *
 * @param <T> tipo de dato que almacena el nodo (en este proyecto, Pizza)
 */
public class NodoPila<T> {

    private T dato;
    private NodoPila<T> siguiente;

    public NodoPila(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoPila<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila<T> siguiente) {
        this.siguiente = siguiente;
    }
}
