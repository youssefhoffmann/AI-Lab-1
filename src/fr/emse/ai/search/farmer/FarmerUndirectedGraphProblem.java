package fr.emse.ai.search.farmer;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class FarmerUndirectedGraphProblem implements Problem {

    FarmerState initialState = new FarmerState("(FWGC, ____)");
    FarmerState finalState = new FarmerState("(____, FWGC)");

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        String s = ((FarmerState) state).value;
        if (!isaDeadState(s)) {
            if (s.charAt(1) == 'F') {
                actions.add("[F___]>");
                if ((s.charAt(2) == 'W')) {
                    actions.add("[FW__]>");
                }
                if ((s.charAt(3) == 'G')) {
                    actions.add("[F_G_]>");
                }
                if ((s.charAt(4) == 'C')) {
                    actions.add("[F__C]>");
                }
            } else {
                actions.add("[F___]<");
                if ((s.charAt(2) != 'W')) {
                    actions.add("[FW__]<");
                }
                if ((s.charAt(3) != 'G')) {
                    actions.add("[F_G_]<");
                }
                if ((s.charAt(4) != 'C')) {
                    actions.add("[F__C]<");
                }
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object anAction) {
        String action = anAction.toString();
        StringBuilder newState = new StringBuilder(state.toString());
        if (action.charAt(6) == '>') {
            newState.setCharAt(1, '_');
            newState.setCharAt(7, 'F');
            if (action.charAt(2) != '_') {
                newState.setCharAt(2, '_');
                newState.setCharAt(8, 'W');
            }
            if (action.charAt(3) != '_') {
                newState.setCharAt(3, '_');
                newState.setCharAt(9, 'G');
            }
            if (action.charAt(4) != '_') {
                newState.setCharAt(4, '_');
                newState.setCharAt(10, 'C');
            }
        } else {
            newState.setCharAt(7, '_');
            newState.setCharAt(1, 'F');
            if (action.charAt(2) != '_') {
                newState.setCharAt(8, '_');
                newState.setCharAt(2, 'W');
            }
            if (action.charAt(3) != '_') {
                newState.setCharAt(9, '_');
                newState.setCharAt(3, 'G');
            }
            if (action.charAt(4) != '_') {
                newState.setCharAt(10, '_');
                newState.setCharAt(4, 'C');
            }
        }
        return new FarmerState(newState.toString());
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
// useful to generate the next actions; check whether a state is terminal (i.e where G eats C or W eats G, game over)
    public boolean isaDeadState(Object state) {
        return (state.equals("(_WGC, F___)"))
                || (state.equals("(__GC, FW__)"))
                || (state.equals("(_WG_, F__C)"))
                || (state.equals("(FW__, __GC)"))
                || (state.equals("(F__C, _WG_)"));
    }

}