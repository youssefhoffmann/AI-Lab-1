package fr.emse.ai.search.cans;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class CansUndirectedGraphProblem implements Problem {
    CansState initialState = new CansState("(14,1)");
    CansState finalState = new CansState("(10,5)");

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
        boolean d = isaDeadState((CansState) state);
        if (!d) {
            String[] volsArray = ((CansState) state).value.split(",");
            int aVol = Integer.parseInt(volsArray[0].substring(1));
            int bVol = Integer.parseInt(volsArray[1].substring(0, volsArray[1].length() - 1));
            if (aVol > 0) {
                actions.add("A into the river");
                if (bVol < CansState.bCap) {
                    actions.add("A into B");
                }
            }
            if (bVol > 0) {
                actions.add("B into the river");
                if (aVol < CansState.aCap) {
                    actions.add("B into A");
                }
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object anAction) {
        String action = anAction.toString();
        String[] volsArray = ((CansState) state).value.split(",");
        int aVol = Integer.parseInt(volsArray[0].substring(1));
        int bVol = Integer.parseInt(volsArray[1].substring(0, volsArray[1].length() - 1));
        switch (action.charAt(0)) {
            case 'A':
                if (action.charAt(7) == 'B') {
                    int aIntoBVol = Math.min(Math.max(CansState.bCap - bVol, 0), aVol);
                    aVol -= aIntoBVol;
                    bVol = Math.min(CansState.bCap, bVol + aIntoBVol);
                } else {
                    aVol = 0;
                }
                break;
            case 'B':
                if (action.charAt(7) == 'A') {
                    int bIntoAVol = Math.min(Math.max(CansState.aCap - aVol, 0), bVol);
                    bVol -= bIntoAVol;
                    aVol = Math.min(CansState.aCap, aVol + bIntoAVol);
                } else {
                    bVol = 0;
                }
                break;
        }
        return new CansState("(" + aVol + "," + bVol + ")");
    }


    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

    public boolean isaDeadState(CansState state) {
        // Ex. 0 + 5 = 5L at minimum should be available in a + b to reach final state
        String[] volsArray = ((CansState) state).value.split(",");
        String[] volsArrayFinal = finalState.value.split(",");
        int finalStateVol = Integer.parseInt(volsArrayFinal[0].substring(1)) + Integer.parseInt(volsArrayFinal[1].substring(0, volsArrayFinal[1].length() - 1));
        int stateVol = Integer.parseInt(volsArray[0].substring(1)) + Integer.parseInt(volsArray[1].substring(0, volsArray[1].length() - 1));//
        return (stateVol < finalStateVol);
    }
}
