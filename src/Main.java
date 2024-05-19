import graph.G;

import java.util.List;
import java.util.Scanner;

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

        // Pedir al usuario los nodos de origen y destino
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen: ");
        int source = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino: ");
        int destination = scanner.nextInt();

        // Imprimir el camino más corto entre los nodos de origen y destino
        List<Integer> shortestPath = g.getShortestPath(source, destination);
        if (!shortestPath.isEmpty()) {
            System.out.println("Camino más corto desde el nodo " + source + " al nodo " + destination + ":");
            for (int i = 0; i < shortestPath.size(); i++) {
                System.out.print(shortestPath.get(i));
                if (i < shortestPath.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No hay camino desde el origen al destino.");
        }

        scanner.close();
    }
}
