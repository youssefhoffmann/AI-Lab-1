package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.Stack;

public class DepthFirstTreeSearch extends AbstractTreeSearch {

    public Collection<Node> initFrontier() {
        return new Stack<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}
