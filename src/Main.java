import graph.G;

public class Main {
    public static void main(String[] args) {
        G g = new G();
        g.readGraph("graph1.txt");

        System.out.println("Grafo de entrada:");
        g.printGraph();
        System.out.println();

        // Imprimir el camino más corto desde el nodo 1 a todos los demás nodos
        System.out.println("Camino más corto desde el nodo 1 a todos los demás nodos:");
        g.dijkstra(1);
        g.printVerticesWithPreviousNode();
    }
}
