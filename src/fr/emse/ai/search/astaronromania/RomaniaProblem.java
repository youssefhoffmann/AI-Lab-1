package fr.emse.ai.search.astaronromania;

import fr.emse.ai.search.astar.Astar;
import fr.emse.ai.search.astar.Edge;
import fr.emse.ai.search.astar.Node;

import java.util.List;

public class RomaniaProblem {
    public static void main(String[] args){

        //initialize the graph base on the Romania map
        Node n1 = new Node("Arad",366);
        Node n2 = new Node("Zerind",374);
        Node n3 = new Node("Oradea",380);
        Node n4 = new Node("Sibiu",253);
        Node n5 = new Node("Fagaras",178);
        Node n6 = new Node("Rimnicu Vilcea",193);
        Node n7 = new Node("Pitesti",98);
        Node n8 = new Node("Timisoara",329);
        Node n9 = new Node("Lugoj",244);
        Node n10 = new Node("Mehadia",241);
        Node n11 = new Node("Drobeta",242);
        Node n12 = new Node("Craiova",160);
        Node n13 = new Node("Bucharest",0);
        Node n14 = new Node("Giurgiu",77);

        //initialize the edges

        //Arad
        n1.adjacencies = new Edge[]{
                new Edge(n2,75),
                new Edge(n4,140),
                new Edge(n8,118)
        };

        //Zerind
        n2.adjacencies = new Edge[]{
                new Edge(n1,75),
                new Edge(n3,71)
        };


        //Oradea
        n3.adjacencies = new Edge[]{
                new Edge(n2,71),
                new Edge(n4,151)
        };

        //Sibiu
        n4.adjacencies = new Edge[]{
                new Edge(n1,140),
                new Edge(n5,99),
                new Edge(n3,151),
                new Edge(n6,80),
        };


        //Fagaras
        n5.adjacencies = new Edge[]{
                new Edge(n4,99),

                //178
                new Edge(n13,211)
        };

        //Rimnicu Vilcea
        n6.adjacencies = new Edge[]{
                new Edge(n4,80),
                new Edge(n7,97),
                new Edge(n12,146)
        };

        //Pitesti
        n7.adjacencies = new Edge[]{
                new Edge(n6,97),
                new Edge(n13,101),
                new Edge(n12,138)
        };

        //Timisoara
        n8.adjacencies = new Edge[]{
                new Edge(n1,118),
                new Edge(n9,111)
        };

        //Lugoj
        n9.adjacencies = new Edge[]{
                new Edge(n8,111),
                new Edge(n10,70)
        };

        //Mehadia
        n10.adjacencies = new Edge[]{
                new Edge(n9,70),
                new Edge(n11,75)
        };

        //Drobeta
        n11.adjacencies = new Edge[]{
                new Edge(n10,75),
                new Edge(n12,120)
        };

        //Craiova
        n12.adjacencies = new Edge[]{
                new Edge(n11,120),
                new Edge(n6,146),
                new Edge(n7,138)
        };

        //Bucharest
        n13.adjacencies = new Edge[]{
                new Edge(n7,101),
                new Edge(n14,90),
                new Edge(n5,211)
        };

        //Giurgiu
        n14.adjacencies = new Edge[]{
                new Edge(n13,90)
        };

        Astar.AstarSearch(n1,n13);

        List<Node> path = Astar.printPath(n13);

        System.out.println("Path: " + path);


    }
}
