package fr.emse.ai.search.cans;

public class CansState {
    public String value;

    public static final int aCap = 15;
    public static final int bCap = 2;

    public CansState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof CansState) {
            return ((CansState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
