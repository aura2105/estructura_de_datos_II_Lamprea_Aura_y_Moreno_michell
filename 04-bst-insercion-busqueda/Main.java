
public class Main {

    public static void main(String[] args) {

        // 15 letras insertadas en un orden que produce
        // un árbol balanceado
        String[] letrasMezcladas = {
            "H", "D", "L", "B", "F",
            "J", "N", "A", "C", "E",
            "G", "I", "K", "M", "O"
        };

        // Las mismas letras en orden alfabético
        String[] letrasOrdenadas = {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O"
        };

        ArbolBST arbolMezclado = new ArbolBST();
        ArbolBST arbolOrdenado = new ArbolBST();

        // Insertar las letras mezcladas
        for (String letra : letrasMezcladas) {
            arbolMezclado.insertar(letra);
        }

        // Insertar las letras ordenadas
        for (String letra : letrasOrdenadas) {
            arbolOrdenado.insertar(letra);
        }

        System.out.println("=== ARBOL MEZCLADO ===");
        System.out.println("Altura: " + arbolMezclado.altura());
        System.out.print("Letras: ");
        arbolMezclado.imprimirEnOrden();

        System.out.println("\n=== ARBOL ORDENADO ===");
        System.out.println("Altura: " + arbolOrdenado.altura());
        System.out.print("Letras: ");
        arbolOrdenado.imprimirEnOrden();

        // Cinco búsquedas
        String[] busquedas = {"H", "A", "M", "O", "Z"};

        System.out.println("\n=== BUSQUEDAS ===");

        for (String letra : busquedas) {

            boolean resultado1 = arbolMezclado.buscar(letra);
            int comparaciones1 = arbolMezclado.getComparaciones();

            boolean resultado2 = arbolOrdenado.buscar(letra);
            int comparaciones2 = arbolOrdenado.getComparaciones();

            System.out.println("\nLetra: " + letra);

            System.out.println(
                "Mezclado: " + resultado1 +
                " | Comparaciones: " + comparaciones1
            );

            System.out.println(
                "Ordenado: " + resultado2 +
                " | Comparaciones: " + comparaciones2
            );
        }
    }
}
