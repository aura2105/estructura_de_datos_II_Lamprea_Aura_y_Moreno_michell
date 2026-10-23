
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Crea la lista de productos de maquillaje.
        List<Producto> productos = crearProductos();

        // =====================================================
        // ESCENARIO 1: INSERCION ALEATORIA
        // =====================================================

        // Copia la lista original.
        List<Producto> aleatorios = new ArrayList<>(productos);

        // Mezcla los productos con una semilla fija.
        // Así el orden aleatorio se puede repetir.
        Collections.shuffle(aleatorios, new Random(42));

        // Crea un árbol para la inserción aleatoria.
        ArbolBSTCatalogo bstAleatorio = new ArbolBSTCatalogo();

        // Inserta cada producto en el árbol.
        for (Producto p : aleatorios) {
            bstAleatorio.insertar(p);
        }

        // =====================================================
        // ESCENARIO 2: INSERCION ORDENADA
        // =====================================================

        // Crea una copia para ordenar los productos.
        List<Producto> ordenados = new ArrayList<>(productos);

        // Ordena los productos de menor a mayor código.
        ordenados.sort(
                (a, b) -> Integer.compare(
                        a.getCodigo(), b.getCodigo()
                )
        );

        // Crea otro árbol para la inserción ordenada.
        ArbolBSTCatalogo bstOrdenado = new ArbolBSTCatalogo();

        // Inserta los productos ya ordenados.
        for (Producto p : ordenados) {
            bstOrdenado.insertar(p);
        }

        // =====================================================
        // MOSTRAR ORDEN DE INSERCION
        // =====================================================

        System.out.println("=== CATALOGO DE MAQUILLAJE ===");

        System.out.println("\nOrden ALEATORIO:");
        imprimirCodigos(aleatorios);

        System.out.println("\nOrden ASCENDENTE:");
        imprimirCodigos(ordenados);

        // =====================================================
        // MOSTRAR LOS ARBOLES
        // =====================================================

        System.out.println("\n=== BST ALEATORIO ===");
        bstAleatorio.imprimirArbol();
        System.out.println("Altura: " + bstAleatorio.altura());

        System.out.println("\n=== BST ORDENADO ===");
        bstOrdenado.imprimirArbol();
        System.out.println("Altura: " + bstOrdenado.altura());

        // =====================================================
        // BUSQUEDAS
        // =====================================================

        // Código existente: labial líquido.
        int existente = 650;

        // Código que no está en el catálogo.
        int inexistente = 700;

        System.out.println("\n=== BUSQUEDAS EN BST ALEATORIO ===");
        mostrarBusqueda(bstAleatorio, existente);
        mostrarBusqueda(bstAleatorio, inexistente);

        System.out.println("\n=== BUSQUEDAS EN BST ORDENADO ===");
        mostrarBusqueda(bstOrdenado, existente);
        mostrarBusqueda(bstOrdenado, inexistente);

        // =====================================================
        // COMPARACION FINAL
        // =====================================================

        System.out.println("\n=== COMPARACION FINAL ===");

        System.out.println(
                "Altura con datos aleatorios: "
                        + bstAleatorio.altura()
        );

        System.out.println(
                "Altura con datos ordenados: "
                        + bstOrdenado.altura()
        );

        System.out.println(
                "\nConclusion: el orden de insercion modifica "
                        + "la forma del BST. Insertar datos "
                        + "ordenados puede generar un arbol "
                        + "degenerado y aumentar su altura."
        );

        // =====================================================
        // CATALOGO ORDENADO POR CODIGO
        // =====================================================

        System.out.println("\n=== CATALOGO ORDENADO POR CODIGO ===");
        bstAleatorio.mostrarInorden();
    }

    // Imprime el resultado detallado de una búsqueda.
    private static void mostrarBusqueda(
            ArbolBSTCatalogo arbol, int codigo) {

        ResultadoBusqueda resultado =
                arbol.buscarConTraza(codigo);

        System.out.println("\nCódigo buscado: " + codigo);

        System.out.println(
                "Encontrado: " + resultado.encontrado()
        );

        System.out.println(
                "Comparaciones: " + resultado.getComparaciones()
        );

        System.out.println(
                "Camino: " + resultado.getCamino()
        );

        // Si existe, muestra toda la información del producto.
        if (resultado.encontrado()) {
            System.out.println(
                    "Producto: " + resultado.getProducto()
            );
        }
    }

    // Muestra los códigos en el orden de la lista recibida.
    private static void imprimirCodigos(
            List<Producto> productos) {

        for (Producto p : productos) {
            System.out.print(p.getCodigo() + " ");
        }

        System.out.println();
    }

    // Crea los 15 productos de maquillaje.
    private static List<Producto> crearProductos() {

        List<Producto> lista = new ArrayList<>();

        // Código, nombre, categoría y precio.
        lista.add(new Producto(50, "Brocha para polvo",
                "Herramientas", 25000));

        lista.add(new Producto(100, "Esponja de maquillaje",
                "Herramientas", 12000));

        lista.add(new Producto(150, "Polvo compacto",
                "Rostro", 35000));

        lista.add(new Producto(250, "Base líquida",
                "Rostro", 65000));

        lista.add(new Producto(300, "Corrector",
                "Rostro", 28000));

        lista.add(new Producto(350, "Rubor",
                "Rostro", 32000));

        lista.add(new Producto(400, "Iluminador",
                "Rostro", 40000));

        lista.add(new Producto(500, "Paleta de sombras",
                "Ojos", 75000));

        lista.add(new Producto(550, "Delineador",
                "Ojos", 22000));

        lista.add(new Producto(600, "Máscara de pestañas",
                "Ojos", 38000));

        lista.add(new Producto(650, "Labial líquido",
                "Labios", 30000));

        lista.add(new Producto(750, "Brillo labial",
                "Labios", 18000));

        lista.add(new Producto(800, "Perfilador de labios",
                "Labios", 15000));

        lista.add(new Producto(900, "Fijador de maquillaje",
                "Rostro", 45000));

        lista.add(new Producto(950, "Primer facial",
                "Rostro", 52000));

        return lista;
    }
}
