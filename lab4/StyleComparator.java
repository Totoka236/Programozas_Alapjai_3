package lab4;

import java.util.Comparator;

public class StyleComparator implements Comparator<Beer> {

    public int compareStyle(Beer b1, Beer b2) {
        return b1.style.compareTo(b2.style);
    }

    @Override
    public int compare(Beer o1, Beer o2) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compare'");
        return 0;
    }
    
    
}
