package fr.emse.ai.search.astar;

public class Node {
    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String value, double h_scores){
        this.value = value;
        this.h_scores = h_scores;
    }

    public String toString(){
        return value;
    }
}
