
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Diccionario inicial de 40 palabras.
        List<String> diccionario = Arrays.asList(
            "arbol", "arboles", "arco", "archivo", "arena",
            "avion", "aviso", "auto", "aula", "aumentar",
            "casa", "casado", "casamiento", "casco", "cascada",
            "carta", "carton", "carro", "cartera", "camino",
            "computadora", "computacion", "compilar",
            "complejo", "completo", "comida", "comer",
            "codigo", "colegio", "colombia",
            "dato", "datos", "database", "dedo", "deporte",
            "desarrollo", "diccionario", "dinero",
            "diseno", "documento"
        );

        for (String palabra : diccionario) {
            trie.insertar(palabra);
        }

        Scanner teclado = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("   TRIE - AUTOCOMPLETADO EN JAVA");
        System.out.println("==================================");
        System.out.println("Palabras cargadas: " + trie.contarPalabras());

        // Pruebas obligatorias con cinco prefijos.
        System.out.println("\n--- PRUEBAS DE CINCO PREFIJOS ---");

        String[] prefijos = {"ar", "ca", "com", "da", "dis"};

        for (String prefijo : prefijos) {
            System.out.println(
                prefijo + " -> " + trie.sugerir(prefijo)
            );
        }

        // Pruebas de búsqueda.
        System.out.println("\n--- PRUEBAS DE BUSQUEDA ---");
        System.out.println("¿Existe 'computadora'? "
                + trie.buscar("computadora"));
        System.out.println("¿Existe 'computar'? "
                + trie.buscar("computar"));
        System.out.println("¿Existe prefijo 'comp'? "
                + trie.empiezaCon("comp"));
        System.out.println("¿Existe prefijo 'xyz'? "
                + trie.empiezaCon("xyz"));

        // Menú interactivo.
        int opcion;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Insertar palabra");
            System.out.println("2. Buscar palabra");
            System.out.println("3. Comprobar prefijo");
            System.out.println("4. Obtener sugerencias");
            System.out.println("5. Mostrar cantidad de palabras");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.print("Ingrese un numero valido: ");
                teclado.next();
            }

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Palabra para insertar: ");
                    String nueva = teclado.nextLine().trim();

                    if (nueva.isEmpty()) {
                        System.out.println("La palabra no puede estar vacia.");
                    } else if (trie.buscar(nueva)) {
                        System.out.println("La palabra ya existe.");
                    } else {
                        trie.insertar(nueva);
                        System.out.println("Palabra insertada correctamente.");
                    }
                    break;

                case 2:
                    System.out.print("Palabra para buscar: ");
                    String busqueda = teclado.nextLine();

                    if (trie.buscar(busqueda)) {
                        System.out.println("La palabra SI existe.");
                    } else {
                        System.out.println("La palabra NO existe.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese un prefijo: ");
                    String prefijo = teclado.nextLine();

                    if (trie.empiezaCon(prefijo)) {
                        System.out.println("El prefijo existe.");
                    } else {
                        System.out.println("No existe ese prefijo.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese un prefijo: ");
                    String consulta = teclado.nextLine();

                    List<String> sugerencias = trie.sugerir(consulta);

                    if (sugerencias.isEmpty()) {
                        System.out.println("No hay sugerencias.");
                    } else {
                        System.out.println("Sugerencias: " + sugerencias);
                    }
                    break;

                case 5:
                    System.out.println(
                        "Total de palabras: " + trie.contarPalabras()
                    );
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
