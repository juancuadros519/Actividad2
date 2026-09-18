/**
 * GestionPedidos
 * --------------
 * Clase de control del sistema Pizza-Track. Coordina las dos pilas
 * manuales que gestionan el flujo de pedidos:
 *
 *   - pilaPrincipal (Undo): almacena los pedidos activos, conforme
 *     se van registrando (push en registrarPedido).
 *   - pilaSecundaria (Redo): almacena temporalmente los pedidos que
 *     han sido "deshechos", para poder recuperarlos de inmediato.
 */
public class GestionPedidos {

    private PilaManual<Pizza> pilaPrincipal;   // Undo
    private PilaManual<Pizza> pilaSecundaria;  // Redo

    public GestionPedidos() {
        this.pilaPrincipal = new PilaManual<>();
        this.pilaSecundaria = new PilaManual<>();
    }

    /**
     * 1. Registrar Pedido: agrega una pizza nueva a la pila principal.
     * Al registrar un nuevo pedido, se vacía la pila de "rehacer",
     * ya que la rama de pedidos deshechos deja de tener sentido
     * (comportamiento estándar de un sistema Undo/Redo).
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        pilaSecundaria = new PilaManual<>(); // se limpia el historial de "redo"
        System.out.println("Pedido registrado con éxito: " + pizza);
    }

    /**
     * 2. Deshacer (Undo): saca la última pizza de la pila principal
     * y la mueve a la pila secundaria.
     */
    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("No hay pedidos para deshacer.");
            return;
        }
        Pizza pizza = pilaPrincipal.pop();
        pilaSecundaria.push(pizza);
        System.out.println("Pedido deshecho: " + pizza);
    }

    /**
     * 3. Rehacer (Redo): saca la última pizza deshecha de la pila
     * secundaria y la devuelve a la pila principal (pedidos activos).
     */
    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println("No hay pedidos para rehacer.");
            return;
        }
        Pizza pizza = pilaSecundaria.pop();
        pilaPrincipal.push(pizza);
        System.out.println("Pedido rehecho: " + pizza);
    }

    /**
     * 4. Mostrar Pedido Actual: usa peek() para ver la pizza que
     * está en el tope de la pila principal (lista para producción),
     * sin retirarla.
     */
    public void mostrarPedidoActual() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("No hay pedidos activos en este momento.");
            return;
        }
        Pizza actual = pilaPrincipal.peek();
        System.out.println("Pedido actual (listo para producción): " + actual);
    }

    // Métodos auxiliares útiles para depurar o extender el sistema
    public boolean hayPedidosActivos() {
        return !pilaPrincipal.isEmpty();
    }

    public boolean hayPedidosParaRehacer() {
        return !pilaSecundaria.isEmpty();
    }
}
