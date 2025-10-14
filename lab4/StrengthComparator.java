package lab4;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Beer> {

    public int compareStrength(Beer b1, Beer b2) {
        return Double.compare(b1.strength, b2.strength);
    }

    @Override
    public int compare(Beer o1, Beer o2) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compare'");
        return 0;
    }
    
}
