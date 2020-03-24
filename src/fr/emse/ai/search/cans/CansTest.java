package fr.emse.ai.search.cans;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class CansTest {
    public static void main(String[] args) {
        CansUndirectedGraphProblem fp = new CansUndirectedGraphProblem();
        System.out.println("Solving the problem using ...");
        System.out.println(new DepthFirstGraphSearch().solve(fp).pathToString());

    }
}
