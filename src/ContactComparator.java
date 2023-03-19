import java.util.Comparator;

public class ContactComparator implements Comparator <Contact> {

    @Override
    public int compare(Contact o1, Contact o2) {
        return o2.getPriorCode()- o1.getPriorCode();
    }
}