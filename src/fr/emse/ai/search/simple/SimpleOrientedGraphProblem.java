package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleOrientedGraphProblem implements Problem {

    SimpleState initialState = new SimpleState(SimpleState.A);
    SimpleState finalState = new SimpleState(SimpleState.H);

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
        String s = ((SimpleState) state).value;
        if (s.equals(SimpleState.A)) {
            actions.add("go to B");
            actions.add("go to C");
        } else if (s.equals(SimpleState.B)) {
            actions.add("go to D");
            actions.add("go to E");
        } else if (s.equals(SimpleState.C)) {
            actions.add("go to D");
        } else if (s.equals(SimpleState.D)) {
            actions.add("go to G");
        } else if (s.equals(SimpleState.E)) {
            actions.add("go to F");
        } else if (s.equals(SimpleState.F)) {
            actions.add("go to H");
        } else if (s.equals(SimpleState.G)) {
            actions.add("go to H");
        } else if (s.equals(SimpleState.H)) {
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to A")) return new SimpleState(SimpleState.A);
        if (action.equals("go to B")) return new SimpleState(SimpleState.B);
        if (action.equals("go to C")) return new SimpleState(SimpleState.C);
        if (action.equals("go to D")) return new SimpleState(SimpleState.D);
        if (action.equals("go to E")) return new SimpleState(SimpleState.E);
        if (action.equals("go to F")) return new SimpleState(SimpleState.F);
        if (action.equals("go to G")) return new SimpleState(SimpleState.G);
        if (action.equals("go to H")) return new SimpleState(SimpleState.H);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
