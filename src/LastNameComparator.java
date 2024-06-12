import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact> {


    public int compare(Contact o1, Contact o2) {
        return o1.getSurName().compareTo(o2.getSurName());
    }
}
