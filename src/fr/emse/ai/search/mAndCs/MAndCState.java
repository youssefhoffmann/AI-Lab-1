package fr.emse.ai.search.mAndCs;

import java.util.Arrays;

public class MAndCState {
    public String value;

    public MAndCState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof MAndCState) {
            return ((MAndCState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }


}
