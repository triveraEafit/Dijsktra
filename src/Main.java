import graph.G;

public class Main {
    public static void main(String[] args) {
        G g = new G();
        g.readGraph("graphNew.txt");

        System.out.println("Grafo de entrada:");
        g.printGraph();
        System.out.println();

        // Imprimir el camino más corto desde el nodo 1 a todos los demás nodos
        System.out.println("Camino más corto desde el nodo 1 a todos los demás nodos:");

        long ti= System.nanoTime();
        g.dijkstra(1);
        long tf=System.nanoTime();
        System.out.println("\nTiempo de ejecución (ns):"+(tf-ti)+ "\n");

        g.printVerticesWithPreviousNode();
        g.ShortestPath(1,5);
    }
}
