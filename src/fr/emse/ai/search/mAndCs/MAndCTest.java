package fr.emse.ai.search.mAndCs;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class MAndCTest {
    public static void main(String[] args) {
        MAndCUndirectedGraphProblem fp = new MAndCUndirectedGraphProblem();
        System.out.println("Solving the problem using ...");
        System.out.println(new BreadthFirstGraphSearch().solve(fp).pathToString());

    }
}
