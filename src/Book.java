import java.util.*;

public class Book implements Iterable<Contact> {
    private final List<Contact> contacts;

    public Book() {
        this.contacts = new ArrayList<>();
    }

    public void add(Contact contact) {
        this.contacts.add(contact);
    }

    public int getSize() {
        return contacts.size();
    }

    public void showAll() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact getByLastName(String personLastName) { //поиск записи по Фамилии / Организации контакта (personLastName)
        System.out.println("\nСписок контактов по заданной Фамилия или наименованию Организации:");
        return contacts.stream()
                .filter(contact -> contact.getPersonLastName().equals(personLastName)) //применение метода equals
                .findFirst()
                .orElse(null);
    }
    public Contact getByNumber(String number) { //поиск записи по номеру телефона
        System.out.println("\nСписок контактов по заданному номеру телефона:");
        return contacts.stream()
                .filter(contact -> contact.getNumber().equals(number)) // применение метода equals
                .findFirst()
                .orElse(null);
    }
    public Contact getById(int id) {  //поиск записи по ID записи в справочнике
        return contacts.stream()
                .filter(contact -> contact.getId() == (id))
                .findFirst()
                .orElse(null);
    }

    public void totalSearch(String keyword) { // поиск записи по ключевому слову
        int res = 0;
        System.out.println("\nСписок контактов, содержащих ключевое слово: " + keyword);
        for (Contact contact : contacts) {
            String temp = contact.toString();
            if (temp.toLowerCase().contains(keyword.toLowerCase())) {
                res++;
                System.out.println(temp);
            }
        }
        if (res == 0) {
            String myRes = String.format("Совпадений со словом поиска: %s  - не найдено, попробуйте снова.", keyword);
            System.out.println(myRes);
        }
    }

    public void sort() {
        Collections.sort(contacts);
    }

    public void sortByPrior() {
        Comparator<Contact> priorComp = new ContactComparator();
        contacts.sort(priorComp);
    }

    @Override
    public Iterator<Contact> iterator() {
        return new BookIterator(this);
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }
}
