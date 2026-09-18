/**
 * Clase Pizza
 * -----------
 * Representa el objeto que se moverá dentro de las pilas del sistema
 * Pizza-Track. Cada pizza tiene un nombre y un arreglo FIJO de 3
 * ingredientes (requisito obligatorio del taller).
 */
public class Pizza {

    // Tamaño fijo obligatorio para el arreglo de ingredientes
    public static final int NUMERO_INGREDIENTES = 3;

    private String nombre;
    private String[] ingredientes; // arreglo fijo de tamaño 3

    /**
     * Constructor de Pizza.
     *
     * @param nombre       nombre de la pizza
     * @param ingredientes arreglo de EXACTAMENTE 3 ingredientes
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = new String[NUMERO_INGREDIENTES];

        // Copiamos manualmente para garantizar que el arreglo interno
        // siempre tenga tamaño fijo 3, sin importar lo que llegue afuera.
        for (int i = 0; i < NUMERO_INGREDIENTES; i++) {
            if (ingredientes != null && i < ingredientes.length) {
                this.ingredientes[i] = ingredientes[i];
            } else {
                this.ingredientes[i] = "N/A";
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    /**
     * Representación en texto de la pizza, útil para mostrarla en consola.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ").append(nombre).append(" | Ingredientes: [");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
