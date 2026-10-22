
public class Main {

    public static ArbolBST crearArbol() {

        ArbolBST arbol = new ArbolBST();

        String[] letras = {
            "H", "D", "L", "B", "F", "J", "N",
            "A", "C", "E", "G", "I", "K", "M", "O"
        };

        for (String letra : letras) {
            arbol.insertar(letra);
        }

        return arbol;
    }

    public static void probar(
            String titulo, String letraEliminar) {

        ArbolBST arbol = crearArbol();

        System.out.println("\n=== " + titulo + " ===");

        System.out.println("ANTES de eliminar " + letraEliminar);
        arbol.imprimirArbol();

        arbol.eliminar(letraEliminar);

        System.out.println("\nDESPUES de eliminar " + letraEliminar);
        arbol.imprimirArbol();

        System.out.print("Orden alfabetico: ");
        arbol.imprimirEnOrden();

        System.out.println(
            "¿La letra sigue en el arbol? "
            + arbol.buscar(letraEliminar));
    }

    public static void main(String[] args) {

        // Caso 1: B es una hoja
        probar("CASO 1: NODO HOJA", "B");

        // Caso 2: D tendrá un solo hijo en este árbol
        ArbolBST arbolUnHijo = new ArbolBST();

        String[] datos = {"H", "D", "L", "F", "J"};

        for (String letra : datos) {
            arbolUnHijo.insertar(letra);
        }

        System.out.println("\n=== CASO 2: UN HIJO ===");
        System.out.println("ANTES:");
        arbolUnHijo.imprimirArbol();

        arbolUnHijo.eliminar("D");

        System.out.println("DESPUES de eliminar D:");
        arbolUnHijo.imprimirArbol();

        // Caso 3: H tiene dos hijos
        probar("CASO 3: DOS HIJOS", "H");

        // Eliminar la raíz
        probar("CASO 4: ELIMINAR LA RAIZ", "H");
    }
}
