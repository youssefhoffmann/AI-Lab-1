package fr.emse.ai.search.simple;

public class SimpleState {

    public final static String A = "A";
    public final static String B = "B";
    public final static String C = "C";
    public final static String D = "D";
    public final static String E = "E";
    public final static String F = "F";
    public final static String G = "G";
    public final static String H = "H";

    public String value;

    public SimpleState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof SimpleState) {
            return ((SimpleState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }

}
