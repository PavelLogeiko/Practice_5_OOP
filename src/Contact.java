
// основной класс - Контакт

public class Contact implements Comparable<Contact> { // было Task

    private String personLastName; // переменная для Фамилии / наименовании Организации контакта

    private String personFirstName; // переменная для Имени контакта
    private String number; // было endOfTask
    private String comment; // было author

//    private final String addTime;
//    private final String addDate;
//
    private int priority; // переменная для маркера избранного контакта

    private final int id;
    private static int count;

    static {
        count = 0;
    }

// конструктор задач

    public Contact(String personLastName, String personFirstName, String number, int priority, String comment) {
        this.personLastName = personLastName;
        this.personFirstName = personFirstName;
        this.number = number;
        this.priority = priority;
        this.comment = comment;
        this.id = ++count;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getPriority() { //возвращает приоритет контакта в зависимости от номера
        return switch (priority) {
            case 1 -> "Обычный контакт";
            case 2 -> "Избранный контакт";
            default -> "Не установлен";
        };
    }

    public int getPriorCode() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "№(ID) " + getId() +
                "  Фамилия / Наименование: " + getPersonLastName() +
                "  Имя: " + getPersonFirstName() +
                ", Телефон: " + getNumber() +
                ", Приоритет: " + getPriority() +
                ", Комментарий: " + getComment();
    }

    @Override
    public int compareTo(Contact o) {
        int compareId
                = o.getId();
        return this.id - compareId;
    }
}