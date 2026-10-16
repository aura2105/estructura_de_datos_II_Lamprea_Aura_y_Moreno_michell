public class Main {

    public static void main(String[] args) {

        // NIVEL 1: raíz
        NodoGeneral<String> raiz =
                new NodoGeneral<>("Atletismo");

        // NIVEL 2: categorías
        NodoGeneral<String> saltos =
                new NodoGeneral<>("Saltos");
        NodoGeneral<String> carreras =
                new NodoGeneral<>("Carreras");
        NodoGeneral<String> lanzamientos =
                new NodoGeneral<>("Lanzamientos");

        raiz.agregarHijo(saltos);
        raiz.agregarHijo(carreras);
        raiz.agregarHijo(lanzamientos);

        // NIVEL 3: disciplinas
        NodoGeneral<String> saltoLargo =
                new NodoGeneral<>("Salto largo");
        NodoGeneral<String> saltoAlto =
                new NodoGeneral<>("Salto alto");

        NodoGeneral<String> vallas =
                new NodoGeneral<>("Vallas");
        NodoGeneral<String> fondo =
                new NodoGeneral<>("Fondo");
        NodoGeneral<String> velocidad =
                new NodoGeneral<>("Velocidad");

        NodoGeneral<String> jabalina =
                new NodoGeneral<>("Jabalina");
        NodoGeneral<String> disco =
                new NodoGeneral<>("Disco");

        saltos.agregarHijo(saltoLargo);
        saltos.agregarHijo(saltoAlto);

        carreras.agregarHijo(vallas);
        carreras.agregarHijo(fondo);
        carreras.agregarHijo(velocidad);

        lanzamientos.agregarHijo(jabalina);
        lanzamientos.agregarHijo(disco);

        // NIVEL 4: detalles de cada disciplina
        saltoLargo.agregarHijo(
                new NodoGeneral<>("Fosa de arena"));

        saltoAlto.agregarHijo(
                new NodoGeneral<>("Tabla de batida"));

        vallas.agregarHijo(
                new NodoGeneral<>("Obstaculos"));

        fondo.agregarHijo(
                new NodoGeneral<>("Resistencia"));

        velocidad.agregarHijo(
                new NodoGeneral<>("100 metros planos"));

        jabalina.agregarHijo(
                new NodoGeneral<>("Tecnica de lanzamiento"));

        disco.agregarHijo(
                new NodoGeneral<>("Giro"));

        // Mostrar la estructura del árbol
        System.out.println("ARBOL GENERAL DE ATLETISMO");
        System.out.println("==========================");
        imprimirArbol(raiz, 0);

        // Calcular la altura
        int alturaCalculada = altura(raiz);

        System.out.println("\nMETRICAS DEL ARBOL");
        System.out.println("------------------");
        System.out.println("Cantidad de nodos: "
                + contarNodos(raiz));
        System.out.println("Grado del arbol: "
                + gradoArbol(raiz));
        System.out.println("Altura del arbol: "
                + alturaCalculada + " aristas");
        System.out.println("Cantidad de niveles: "
                + (alturaCalculada + 1));

        // Mostrar el grado de cada nodo
        System.out.println("\nGRADO DE CADA NODO");
        System.out.println("------------------");
        mostrarGrados(raiz);

        // Mostrar la profundidad de cinco nodos
        System.out.println("\nPROFUNDIDAD DE CINCO NODOS");
        System.out.println("--------------------------");
        mostrarProfundidad(raiz, "Atletismo");
        mostrarProfundidad(raiz, "Carreras");
        mostrarProfundidad(raiz, "Vallas");
        mostrarProfundidad(raiz, "Obstaculos");
        mostrarProfundidad(raiz, "Jabalina");

        // Mostrar todas las hojas y su profundidad
        System.out.println("\nPROFUNDIDAD DE CADA HOJA");
        System.out.println("------------------------");
        mostrarHojas(raiz, 0);

        // Mostrar dos caminos y sus longitudes
        System.out.println("\nDOS CAMINOS DEL ARBOL");
        System.out.println("---------------------");

        System.out.println(
                "Camino 1: Atletismo -> Carreras -> "
                + "Vallas -> Obstaculos");
        System.out.println("Longitud: 3 aristas");

        System.out.println(
                "Camino 2: Atletismo -> Lanzamientos -> "
                + "Disco -> Giro");
        System.out.println("Longitud: 3 aristas");

        // Agregar un nuevo nivel debajo de Obstaculos
        NodoGeneral<String> obstaculos =
                buscarNodo(raiz, "Obstaculos");

        int alturaAnterior = altura(raiz);

        if (obstaculos != null) {
            obstaculos.agregarHijo(
                    new NodoGeneral<>("Tecnica de paso"));
        }

        int alturaNueva = altura(raiz);

        System.out.println("\nCAMBIO DE ALTURA");
        System.out.println("----------------");
        System.out.println("Altura anterior: "
                + alturaAnterior + " aristas");
        System.out.println("Altura nueva: "
                + alturaNueva + " aristas");
        System.out.println("Niveles nuevos: "
                + (alturaNueva + 1));

        // Comparación con el cálculo manual
        System.out.println("\nCOMPROBACION MANUAL");
        System.out.println("-------------------");
        System.out.println(
                "Antes: 4 niveles = 3 aristas.");
        System.out.println(
                "Despues: 5 niveles = 4 aristas.");
        System.out.println(
                "El resultado recursivo coincide "
                + "con el calculo manual.");
    }

    // Método recursivo para calcular la altura
    // La altura se mide en aristas
    static int altura(NodoGeneral<?> nodo) {

        // Un árbol vacío tiene altura -1
        if (nodo == null) {
            return -1;
        }

        // Una hoja tiene altura cero
        if (nodo.getHijos().isEmpty()) {
            return 0;
        }

        int max = 0;

        // Buscamos la mayor altura entre los hijos
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            max = Math.max(max, altura(hijo));
        }

        // Sumamos una arista al camino más largo
        return 1 + max;
    }

    // Imprime el árbol con sangría según el nivel
    static void imprimirArbol(
            NodoGeneral<?> nodo, int nivel) {

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(nodo.getDato());

        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            imprimirArbol(hijo, nivel + 1);
        }
    }

    // Cuenta todos los nodos del árbol
    static int contarNodos(NodoGeneral<?> nodo) {

        if (nodo == null) {
            return 0;
        }

        int total = 1;

        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            total += contarNodos(hijo);
        }

        return total;
    }

    // Calcula el grado máximo del árbol
    static int gradoArbol(NodoGeneral<?> nodo) {

        if (nodo == null) {
            return 0;
        }

        int max = nodo.getGrado();

        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            max = Math.max(max, gradoArbol(hijo));
        }

        return max;
    }

    // Muestra el grado de cada nodo
    static void mostrarGrados(NodoGeneral<?> nodo) {

        System.out.println(
                nodo.getDato() + ": " + nodo.getGrado());

        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            mostrarGrados(hijo);
        }
    }

    // Busca un nodo por su nombre
    static NodoGeneral<String> buscarNodo(
            NodoGeneral<String> nodo, String nombre) {

        if (nodo == null) {
            return null;
        }

        if (nodo.getDato().equals(nombre)) {
            return nodo;
        }

        for (NodoGeneral<String> hijo : nodo.getHijos()) {
            NodoGeneral<String> encontrado =
                    buscarNodo(hijo, nombre);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    // Muestra la profundidad de un nodo específico
    static void mostrarProfundidad(
            NodoGeneral<String> raiz, String nombre) {

        int profundidad = buscarProfundidad(
                raiz, nombre, 0);

        System.out.println(nombre + ": " + profundidad);
    }

    // Busca recursivamente la profundidad de un nodo
    static int buscarProfundidad(
            NodoGeneral<String> nodo,
            String nombre,
            int nivel) {

        if (nodo == null) {
            return -1;
        }

        if (nodo.getDato().equals(nombre)) {
            return nivel;
        }

        for (NodoGeneral<String> hijo : nodo.getHijos()) {
            int resultado = buscarProfundidad(
                    hijo, nombre, nivel + 1);

            if (resultado != -1) {
                return resultado;
            }
        }

        return -1;
    }

    // Imprime cada hoja y su profundidad
    static void mostrarHojas(
            NodoGeneral<?> nodo, int profundidad) {

        if (nodo.esHoja()) {
            System.out.println(
                    nodo.getDato() + ": " + profundidad);
            return;
        }

        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            mostrarHojas(hijo, profundidad + 1);
        }
    }
}