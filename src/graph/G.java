package graph;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class G {
    // Set of vertices
    Vertex[] V;
    // Adjacency list
    Edge[] adj;

    MinPriorityQueue pq;

    public void addEdge(int u, int v, int w) {
        Edge e = new Edge(v, w);
        e.next = adj[u];
        adj[u] = e;
    }

    public void initializeSingleSource(int s) {
        for (int i = 1; i < V.length; i++) {
            V[i] = new Vertex(i, Integer.MAX_VALUE, -1);
        }
        V[s].distance = 0;
    }


    public void dijkstra(int s) {
        pq = new MinPriorityQueue(V.length);
        initializeSingleSource(s);

        for (int i = 1; i < V.length; i++) {
            pq.minHeapInsert(V[i]);
        }

        while (!pq.isEmpty()) {
            Vertex u = pq.extractMin();
            Edge e = adj[u.number];
            while (e != null) {
                relax(u.number, e.v, e.w);
                e = e.next;
            }
        }
    }

     public List<Integer> getShortestPath(int source, int destination) {
        List<Integer> shortestPath = new ArrayList<>();
        if (V[destination].distance == Integer.MAX_VALUE) {
            return shortestPath; // No hay camino desde el origen al destino
        }

        Stack<Integer> pathStack = new Stack<>();
        int currentVertex = destination;
        while (currentVertex != -1) {
            pathStack.push(currentVertex);
            currentVertex = V[currentVertex].pi;
        }

        while (!pathStack.isEmpty()) {
            shortestPath.add(pathStack.pop());
        }

        return shortestPath;
    }

    public void relax(int u, int v, int w) {
        if (V[v].distance > V[u].distance + w) {
            V[v].distance = V[u].distance + w;
            V[v].pi = u;
            pq.minHeapDecreaseKey(V[v].positionInMinHeap, V[v].distance);
        }
    }


    public void readGraph(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int n = sc.nextInt();
            int m = sc.nextInt();

            this.V = new Vertex[n + 1];
            this.adj = new Edge[n + 1];

            // Inicializar la lista de adyacencia para cada vértice
            for (int i = 1; i <= n; i++) {
                this.adj[i] = null;
            }

            // Leer y agregar cada arista del archivo al grafo
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();

                // Agregar la arista desde u hasta v con peso w
                addEdge(u, v, w);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void printVerticesWithPreviousNode() {
        for (int i = 1; i < V.length; i++) {
            if (V[i].pi == -1) {
                System.out.println("v: "+V[i].number + "| d: " + V[i].distance + "| pi: " + null);
            } else {
                System.out.println("v: "+V[i].number + "| d: " + V[i].distance + "| pi: " + V[i].pi);
            }
        }
    }

    public void printGraph()
    {
        for(int i=1; i<adj.length; i++)
        {
            Edge head= adj[i];
            System.out.print(i+":");
            while(head!=null)
            {
                System.out.print(" ->"+"| v:"+head.v+ " _ w:"+ head.w+ "|");
                head= head.next;
            }
            System.out.println("");
        }
    }
}
