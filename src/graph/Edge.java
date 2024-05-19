package graph;

class Edge {
    public int v;      // destination vertex
    public int w;      // weight
    public Edge next;  // next edge in the list

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
