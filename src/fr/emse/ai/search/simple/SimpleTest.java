package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleTest {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        SimpleUndirectedGraphProblem p2 = new SimpleUndirectedGraphProblem();
        System.out.println("Solution to problem using depth first on a graph: ");
        /* tree */
        //System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
        //System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());
        /* graph */
        //System.out.println(new BreadthFirstGraphSearch().solve(p2).pathToString());
        System.out.println(new DepthFirstGraphSearch().solve(p2).pathToString());
    }
}
