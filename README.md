## Objetivo

Simular el sistema de gestión de pedidos de una pizzería
que permita registrar pedidos, deshacerlos y rehacerlos, utilizando
**dos pilas manuales construidas desde cero con listas ligadas**
cumpliendo con los siguientes requisitos:

- Registrar Pedido (Escribir): captura el nombre y un arreglo fijo de
  3 ingredientes, y los apila en la Pila Principal.
- Deshacer (Undo): retira el último pedido de la Pila Principal y lo
  mueve a la Pila Secundaria.
- Rehacer (Redo): recupera el último pedido deshecho y lo devuelve a
  la Pila Principal (pedidos activos).

## Estructura del proyecto

```
Actividad2/
├── README.md
├── src/
│   ├── Pizza.java           # Modelo de datos (nombre + arreglo fijo de 3 ingredientes)
│   ├── NodoPila.java        # Nodo genérico de la lista ligada
│   ├── PilaManual.java      # Pila manual: push(), pop(), peek(), isEmpty()
│   ├── GestionPedidos.java  # Controla la Pila Principal (Undo) y Secundaria (Redo)
│   └── Main.java            # Menú interactivo en consola
```

## Instrucciones de ejecución

1. Ubicarse en la carpeta `src` del proyecto:
   ```bash
   cd Actividad2/src
   ```
2. Compilar todas las clases:
   ```bash
   javac *.java
   ```
3. Ejecutar el programa:
   ```bash
   java Main
   ```
4. Usar el menú interactivo:
   ```
   1. Registrar Pizza (Escribir)   -> pide nombre + 3 ingredientes, hace push() en la pila principal
   2. Deshacer (Undo)              -> pop() de la principal, push() a la secundaria
   3. Rehacer (Redo)               -> pop() de la secundaria, push() a la principal
   4. Mostrar Pedido Actual        -> peek() de la pila principal
   0. Salir
   ```

## Capturas de pantalla de la consola

**1. Registro de pedidos (push en la Pila Principal)**

https://drive.google.com/file/d/1q0SWTg-RtGOp_mwN7LeJpNoQEDdIt-q8/view?usp=drive_link

**2. Mostrar pedido actual (peek)**

https://drive.google.com/file/d/12usbRLf90b415HeMLUrrqisqAtfcOd1C/view?usp=drive_link

**3. Deshacer (pop de la Principal, push a la Secundaria)**

https://drive.google.com/file/d/1OnFOUvS3gLFEN-edjuhkdSlfPp-Oqcxc/view?usp=drive_link

**4. Rehacer (pop de la Secundaria, push a la Principal)**

https://drive.google.com/file/d/1AhXdmmGhT808CrDQlKs9u5ArtWBZTORE/view?usp=drive_link

**5. Salir **

https://drive.google.com/file/d/1okfUlBKri2A8M2K4laj94fhUwQbYKprP/view?usp=drive_link

## Enlace al video de sustentación

https://drive.google.com/file/d/1SCXU3EDbA3U9JqN5wCtpgpaXXkiCxkKP/view?usp=drive_link

## Notas de diseño

- **Pizza.java**: usa un arreglo `String[3]` fijo para los ingredientes,
  copiado internamente en el constructor para garantizar el tamaño exacto.
- **NodoPila.java** y **PilaManual.java**: implementan la pila con una
  lista ligada simple (cada nodo apunta al siguiente). El tope de la pila
  es siempre la cabeza de la lista, por lo que `push`, `pop` y `peek`
  son O(1).
- **GestionPedidos.java**: coordina dos instancias de `PilaManual<Pizza>`
  (principal y secundaria). Al registrar un nuevo pedido se limpia la
  pila secundaria, comportamiento estándar de un sistema Undo/Redo.
