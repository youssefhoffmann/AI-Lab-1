package fr.emse.ai.search.mAndCs;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class MAndCUndirectedGraphProblem implements Problem {
    MAndCState initialState = new MAndCState("(1,3,3) (0,0,0)");
    MAndCState finalState = new MAndCState("(0,0,0) (1,3,3)");

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
        String s = ((MAndCState) state).value;
        if (!isaDeadState(s)) {
            if (s.charAt(1) == '1') {
                switch (s.charAt(3)) {
                    case '0':
                        switch (s.charAt(5)) {
                            case '3':
                            case '2':
                                actions.add("[cc]>");
                            case '1':
                                actions.add("[_c]>");
                            default:
                                break;
                        }
                        break;
                    case '1':
                        switch (s.charAt(5)) {
                            case '3':
                            case '2':
                                actions.add("[cc]>");
                            case '1':
                                actions.add("[mc]>");
                                actions.add("[_c]>");
                            default:
                                actions.add("[m_]>");
                                break;
                        }
                        break;
                    default:
                        switch (s.charAt(5)) {
                            case '3':
                            case '2':
                                actions.add("[cc]>");
                            case '1':
                                actions.add("[mc]>");
                                actions.add("[_c]>");
                            default:
                                actions.add("[m_]>");
                                actions.add("[mm]>");
                                break;
                        }
                        break;
                }
            } else {
                switch (s.charAt(11)) {
                    case '0':
                        switch (s.charAt(13)) {
                            case '3':
                            case '2':
                                actions.add("[cc]<");
                            case '1':
                                actions.add("[_c]<");
                            default:
                                break;
                        }
                        break;
                    case '1':
                        switch (s.charAt(13)) {
                            case '3':
                            case '2':
                                actions.add("[cc]<");
                            case '1':
                                actions.add("[mc]<");
                                actions.add("[_c]<");
                            default:
                                actions.add("[m_]<");
                                break;
                        }
                        break;
                    default:
                        switch (s.charAt(13)) {
                            case '3':
                            case '2':
                                actions.add("[cc]<");
                            case '1':
                                actions.add("[mc]<");
                                actions.add("[_c]<");
                            default:
                                actions.add("[m_]<");
                                actions.add("[mm]<");
                                break;
                        }
                        break;
                }
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object anAction) {
        /* Example for action [m_]< and state (0,2,2) (1,1,1)
        mNum = 1 ; cNum = 0 ==> new state would be (1,3,2) (0,0,1) (undeadly)  */
        StringBuilder stateArr = new StringBuilder(((MAndCState) state).value);
        String action = anAction.toString();
        int mNum = 0;
        int cNum = 0;
        for (int i = 1; i < 3; i++) {
            if (action.charAt(i) == 'm') {
                mNum++;
            } else if (action.charAt(i) == 'c') {
                cNum++;
            }
        }
        if (action.charAt(4) == '>') {
            stateArr.setCharAt(9, '1');
            stateArr.setCharAt(1, '0');
            int mL = Character.getNumericValue(stateArr.charAt(3)) - mNum;
            int cL = Character.getNumericValue(stateArr.charAt(5)) - cNum;
            int mR = Character.getNumericValue(stateArr.charAt(11)) + mNum;
            int cR = Character.getNumericValue(stateArr.charAt(13)) + cNum;
            stateArr.setCharAt(3, (char) (mL + 48));
            stateArr.setCharAt(5, (char) (cL + 48));
            stateArr.setCharAt(11, (char) (mR + 48));
            stateArr.setCharAt(13, (char) (cR + 48));
        } else {
            stateArr.setCharAt(1, '1');
            stateArr.setCharAt(9, '0');
            int mL = Character.getNumericValue(stateArr.charAt(3)) + mNum;
            int cL = Character.getNumericValue(stateArr.charAt(5)) + cNum;
            int mR = Character.getNumericValue(stateArr.charAt(11)) - mNum;
            int cR = Character.getNumericValue(stateArr.charAt(13)) - cNum;
            stateArr.setCharAt(3, (char) (mL + 48));
            stateArr.setCharAt(5, (char) (cL + 48));
            stateArr.setCharAt(11, (char) (mR + 48));
            stateArr.setCharAt(13, (char) (cR + 48));
        }
        return new MAndCState(stateArr.toString());
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

    // useful to generate the next actions; check whether a state is terminal (i.e. (0,2,3) (1,1,0) means the game is over)
    public boolean isaDeadState(String state) {
        int mL = Character.getNumericValue(state.charAt(3));
        int mR = Character.getNumericValue(state.charAt(11));
        int cL = Character.getNumericValue(state.charAt(5));
        int cR = Character.getNumericValue(state.charAt(13));
        return ((cL > mL && mL > 0) ||
                (cR > mR && mR > 0));
    }
}
