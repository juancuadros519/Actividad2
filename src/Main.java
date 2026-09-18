import java.util.Scanner;

/**
 * Main
 * ----
 * Punto de entrada de la aplicación Pizza-Track. Presenta el menú
 * interactivo en consola descrito en el enunciado del taller.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();

        int opcion = -1;

        System.out.println("=========================================");
        System.out.println("   BIENVENIDO A PIZZA-TRACK");
        System.out.println("=========================================");

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarPizza(sc, gestion);
                    break;
                case 2:
                    gestion.deshacer();
                    break;
                case 3:
                    gestion.rehacer();
                    break;
                case 4:
                    gestion.mostrarPedidoActual();
                    break;
                case 0:
                    System.out.println("Saliendo de Pizza-Track. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println(); // línea en blanco para separar iteraciones
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1. Registrar Pizza (Escribir)");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar Pedido Actual");
        System.out.println("0. Salir");
        System.out.println("-----------------------------------------");
    }

    /**
     * Solicita al usuario el nombre de la pizza y sus 3 ingredientes,
     * crea el objeto Pizza y lo registra en la gestión de pedidos.
     */
    private static void registrarPizza(Scanner sc, GestionPedidos gestion) {
        System.out.print("Ingrese el nombre de la pizza: ");
        String nombre = sc.nextLine();

        String[] ingredientes = new String[Pizza.NUMERO_INGREDIENTES];
        for (int i = 0; i < Pizza.NUMERO_INGREDIENTES; i++) {
            System.out.print("Ingrese el ingrediente " + (i + 1) + ": ");
            ingredientes[i] = sc.nextLine();
        }

        Pizza pizza = new Pizza(nombre, ingredientes);
        gestion.registrarPedido(pizza);
    }

    /**
     * Lee un número entero de forma segura, validando que el usuario
     * no ingrese texto no numérico.
     */
    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un número válido.");
            sc.next(); // descarta la entrada inválida
            System.out.print(mensaje);
        }
        int valor = sc.nextInt();
        sc.nextLine(); // consumir el salto de línea pendiente
        return valor;
    }
}
