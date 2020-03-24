package fr.emse.ai.search.farmer;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class FarmerTest {
    public static void main(String[] args) {
        FarmerUndirectedGraphProblem fp = new FarmerUndirectedGraphProblem();
        System.out.println("Solving the problem using ...");
        System.out.println(new BreadthFirstGraphSearch().solve(fp).pathToString());

    }
}
