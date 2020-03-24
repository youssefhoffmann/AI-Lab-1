package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.Stack;

public class DepthFirstGraphSearch extends AbstractGraphSearch {

    public Collection<Node> initFrontier() {
        return new Stack<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}
