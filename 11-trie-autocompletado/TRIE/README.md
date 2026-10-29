
# Trie: Mini motor de autocompletado en Java

## 1. Objetivo

Implementar una estructura de datos Trie desde cero para insertar
palabras, buscar términos, comprobar prefijos y sugerir palabras
automáticamente.

## 2. Tecnologías utilizadas

- Java
- HashMap
- ArrayList
- Scanner
- Visual Studio Code

## 3. Estructura del proyecto

- `NodoTrie.java`: representa los nodos del árbol.
- `Trie.java`: contiene las operaciones de inserción, búsqueda,
  verificación de prefijos y autocompletado.
- `Main.java`: carga el diccionario, ejecuta pruebas y muestra
  el menú interactivo.

## 4. Funcionamiento

Cada nodo contiene un mapa de caracteres a nodos hijos y una
marca llamada `finPalabra`, que indica el final de una palabra.

Las palabras comparten los nodos correspondientes a sus prefijos.
Por ejemplo, las palabras "casa", "casado" y "casamiento"
comparten parte de su recorrido inicial.

### Operaciones

- `insertar(String)`: agrega una palabra al Trie.
- `buscar(String)`: comprueba si existe una palabra completa.
- `empiezaCon(String)`: verifica si existe el prefijo.
- `sugerir(String)`: devuelve hasta cinco palabras que comienzan
  con el prefijo indicado.
- `contarPalabras()`: cuenta las palabras almacenadas.

## 5. Cómo ejecutar

1. Abrir la carpeta del proyecto en Visual Studio Code.
2. Verificar que Java esté instalado.
3. Abrir la terminal en la carpeta del proyecto.
4. Compilar los archivos:

   javac NodoTrie.java Trie.java Main.java

5. Ejecutar el programa:

   java Main

## 6. Pruebas realizadas

Se cargan 40 palabras y se prueban cinco prefijos:

- `ar`: arbol, arboles, arco, archivo, arena.
- `ca`: camino, casa, casado, cascada, casamiento.
- `com`: compilar, complejo, completo, computadora,
  computacion.
- `da`: database, dato, datos.
- `dis`: diseno, dinero, diccionario.

Las sugerencias se limitan a cinco resultados y se ordenan
alfabéticamente.

## 7. Análisis de complejidad

Sea L la longitud de la palabra o del prefijo.

- Inserción: O(L) en promedio.
- Búsqueda: O(L) en promedio.
- Comprobación de prefijo: O(L) en promedio.
- Sugerencias: depende de los nodos visitados y del tamaño de
  las palabras encontradas. No se recorre necesariamente todo
  el diccionario.
- Espacio: proporcional al número total de nodos y transiciones
  almacenados en el Trie.

Las operaciones sobre HashMap se consideran O(1) en promedio
por carácter.

## 8. Comparación con una lista de 1000 palabras

En una lista sin ordenar, buscar una palabra requiere revisar
hasta 1000 elementos en el peor caso. Si cada palabra tiene
longitud promedio L, el costo puede aproximarse a O(1000 * L).

En un Trie, buscar una palabra de longitud L requiere recorrer
sus caracteres, con costo promedio O(L). Para autocompletar,
se localiza primero el nodo del prefijo y se recorren sus
descendientes para generar las sugerencias.

## 9. Conclusión

El Trie permite almacenar palabras compartiendo prefijos y
realizar búsquedas eficientes según la longitud de la cadena.
Es una estructura apropiada para diccionarios, motores de
autocompletado y búsquedas por prefijo.
