package fr.emse.ai.search;

import fr.emse.ai.search.cans.CansState;

import java.util.Arrays;

public class trash {
    public static void main(String[] args) {
        //1 2 3 4  7 8 9 10

        int[][] chatta = {{6,5},{2,5}};
        chatta[1][1] = 5;
        String[] stuff = "(99212,85932)".split(",");
        int aVol = Integer.parseInt(stuff[0].substring(1));
        int bVol = Integer.parseInt(stuff[1].substring(0,stuff[1].length()-1));
        System.out.println(new trash().isaDeadState(new CansState("(12,0)")));

    }
    public boolean isaDeadState(CansState state) {
        // Ex. 0 + 5 = 5L at minimum should be available in a + b to reach final state
        String[] volsArray = ((CansState) state).value.split(",");
        String[] volsArrayFinal = "(0,5)".split(",");
        int finalStateVol = Integer.parseInt(volsArrayFinal[0].substring(1)) + Integer.parseInt(volsArrayFinal[1].substring(0, volsArrayFinal[1].length() - 1));
        int stateVol = Integer.parseInt(volsArray[0].substring(1)) + Integer.parseInt(volsArray[1].substring(0, volsArray[1].length() - 1));//
        return (stateVol > finalStateVol);
    }
}
