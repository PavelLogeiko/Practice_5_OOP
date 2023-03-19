import java.util.Scanner;

public class Controller {
    public static void run(){
        Contact c1 = new Contact("Иванов", "Игорь","79111234567", 2,"Сантехник");
        Contact c2 = new Contact("Петров", "Сергей","79311234567", 1,"Адвокат");
        Contact c3 = new Contact("Павлова", "Ольга","79211234567", 2,"Менеджер ВТБ ипотека");
        Contact c4 = new Contact("Андреева", "Любовь","79901234567", 2,"Стоматолог сына");
        Contact c5 = new Contact("Степанова", "Оксана","79121234567",1,"Парикмахер");
        Book myBook = new Book();
        myBook.add(c1);
        myBook.add(c2);
        myBook.add(c3);
        myBook.add(c4);
        myBook.add(c5);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Add add = new Add(scanner);
        UserInterface userInterface = new UserInterface(scanner, menu, myBook, add);
        userInterface.start();
    }
}
