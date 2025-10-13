package lab4;

import java.io.Serializable;

public class Beer implements Serializable {
    String name;
    String style;
    double strength;

    public Beer(String n, String s, double str) {
        name = n;
        style = s;
        strength = str;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public double getStrength() {
        return strength;
    }

    public String toString() {
        String out = new String(name+ " " + style + " " + strength);
        return out;
    }
}
