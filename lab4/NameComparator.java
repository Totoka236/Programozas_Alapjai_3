package lab4;

import java.util.Comparator;

public class NameComparator implements Comparator<Beer> {

    public int compareTo(Beer b1, Beer b2) {
        return b1.getName().compareTo(b2.getName());
    }

    @Override
    public int compare(Beer o1, Beer o2) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compare'");
        return 0;
    }
    
}
