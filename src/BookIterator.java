import java.util.Iterator;

public class BookIterator implements Iterator<Contact> {

    private int index = -1;
    private final Book contacts;

    public BookIterator(Book contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean hasNext() {
        return index <contacts.getSize()-1;
    }

    @Override
    public Contact next() {
        return contacts.getContact(++index);
    }
}
