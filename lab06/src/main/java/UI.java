import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class UI {
    private final Scanner scan = new Scanner(System.in);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Proxy proxy;

    UI(Proxy proxy) {
        this.proxy = proxy;
    }

    public void run() {
        System.out.println("PERSON DATABASE");
        System.out.println("press number to perfom action...");
        while(true){
            System.out.println("1 - Ask for person coordinates");
            System.out.println("2 - Add new person");
            System.out.println("3 - Show whole database");
            String option = scan.nextLine();
            switch (option){
                case "1":
                    askForPersonCoordinates();
                    break;
                case "2":
                    addNewPerson();
                    break;
                case "3":
                    showWholeDatabase();
                    break;
                default:
                    System.out.println("ERROR: Invalid option.");
                    break;
            }
        }
    }

    public void askForPersonCoordinates() {
        System.out.println("Insert full name");
        String fullName = scan.nextLine();
        try {
            Coordinates coords = proxy.getCoordinatesFor(fullName);
            System.out.printf("(%s,%s)%n",coords.getX(), coords.getY());
        }catch (IllegalArgumentException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    public void addNewPerson() {
        System.out.println("Insert full name");
        String fullName = scan.nextLine();
        System.out.println("Insert x coord");
        String x = scan.nextLine();
        System.out.println("Insert y coord");
        String y = scan.nextLine();

        try {
            proxy.insertNewPerson(fullName, x, y);
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    public void showWholeDatabase() {
        System.out.println(gson.toJson(proxy.getFactory()));
    }
}
