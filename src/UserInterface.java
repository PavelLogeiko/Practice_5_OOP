import java.util.Scanner;
public class UserInterface {

    private final Scanner scanner;
    private final Menu menu;
    private final Book book;
    private final Add add;
    protected static String csvPath = "/Users/logeyko/IdeaProjects/Practice_5_OOP/src/Book.csv";

// путь где расположены файлы, в которые выполняется запись /Users/logeyko/IdeaProjects/Practice_5_OOP/src

    public UserInterface(Scanner scanner, Menu menu, Book book, Add add) {
        this.scanner = scanner;
        this.menu = menu;
        this.book = book;
        this.add = add;
    }

    public void start() {

        while (true) {
            switch (menu.selectFunction()) {
                case "1": // показать все контакты
                    System.out.println("\nСписок всех контактов:");
                    book.sort();
                    book.showAll();
                    System.out.println("");
                    break;
                case "2": // найти контакт по Фамилии или Организации
                    System.out.print("Введите Фамилию или наименование Организации контакта: ");
                    System.out.println(book.getByLastName(scanner.nextLine()));
                    System.out.println("");
                    break;
                case "3": // найти контакт по номеру телефона
                    System.out.print("Введите номер телефона контакта, в формате 79111234567: ");
                    System.out.println(book.getByNumber(scanner.nextLine()));
                    System.out.println("");
                    break;
                case "4": // найти контакт по ключевому слову (например родство, профессия и пр.)
                    System.out.print("\nВведите ключевое слово для поиска контакта (например родство, профессия и пр.): ");
                    book.totalSearch(scanner.nextLine());
                    System.out.println("");
                    break;
                case "5": // отсортировать контакты по приоритету (избранное)
                    System.out.println("\nОтсортированный список контактов по приоритетам - сначала избранные, потом обычные:");
                    book.sortByPrior();
                    book.showAll();
                    System.out.println("");
                    break;
                case "6": // выполнить запись контактов в файл
                    saveFile();
                    break;
                case "7": // добавить новый контакт в справочник
                    book.add(add.makeNewContact());
                    break;
                case "8": // изменить существующий контакт
                    System.out.println("Введите номер (ID) записи в справочнике, которую необходимо изменить: ");
                    changeContact(book.getById((scanner.nextInt())));

                case "0": // выход
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
            }
        }
    }

    public void saveFile() {
        BookIterator bookIterator = new BookIterator(book);
        while (true) {
            switch (menu.selectSaveType()) {
                case "1" -> // запись контактов справочника в файл формата CSV
                {
                    while (bookIterator.hasNext()) {
                        SaveModel<Contact> saved = new SaveModel<>(bookIterator.next());
                        saved.setFormat(new CsvWriter());
                        saved.setPath(csvPath);
                        saved.save();
                    }
                    System.out.println("\nКонтакты справочника сохранены в файл формата <CSV>.\n");
                }
                case "2" -> //меню
                        start();
                case "0" -> // выход
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }

    public void changeContact(Contact changing) {
        while (true) {
            switch (menu.selectContactChange()) {
                case "1" -> { // изменяем Фамилию или наименование Организации контакта
                    System.out.println("Введите новую Фамилию или наименование Организации контакта: ");
                    changing.setPersonLastName(scanner.nextLine());
                }
                case "2" -> { // изменяем Имя контакта
                    System.out.println("Введите новое Имя контакта: ");
                    changing.setPersonFirstName(scanner.nextLine());
                }
                case "3" -> { // изменяем номер телефона
                    System.out.print("Введите новый номер телефона: ");
                    changing.setNumber(scanner.nextLine());
                }
                case "4" -> { // изменяем приоритет (обычный / избранный)
                    System.out.print("Введите новый приоритет контакта: 1 - обычный, 2 - избранный: ");
                    changing.setPriority(scanner.nextInt());
                }
                case "5" -> { // изменяем комментарий (доп информацию) контакта
                    System.out.print("Введите новый комментарий к записи контакта (родство, профессия, место работы и пр.): ");
                    changing.setComment(scanner.nextLine());
                }
                case "6" -> // возврат в основное меню
                        start();
                case "0" -> // выход (завершение программы)
                        System.exit(0);
                default -> {
                    System.out.println("Неверный ввод пункта меню, повторите ввод.\n");
                }
            }
        }
    }
}