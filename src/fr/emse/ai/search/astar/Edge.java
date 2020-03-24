package fr.emse.ai.search.astar;

public class Edge {
    public final double cost;
    public final Node target;

    public Edge(Node target, double cost){
        this.target = target;
        this.cost = cost;
    }
}
