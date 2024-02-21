import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> options = new ArrayList<>();
    static {
        options.add("Library Data");
        options.add("Member Data");
        options.add("Exit");
    }
    private static String optMessage = """
            Store and access groups for projects in CPSC 219 AND 233.
            \t Menu Options
            """;
    static{
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);
        for (int i = 0; i < options.size(); i++) {
            sb.append(String.format("\t%d.%s\n", i+1, options.get(i)));
        }
        optMessage = sb.toString();
    }
    public static void menuLoop() {
        System.out.println(optMessage);
        String choice = scanner.nextLine();
        int option = Integer.parseInt(choice);
        option += -1;
        while (option != -1){
            if (option > -1 && option < options.size()){
                System.out.printf("Selected option %d.%s%n", option + 1, options.get(option));
                System.out.println("Press any key to continue...");
                scanner.nextLine();
            }
            switch (option + 1){
                case 1 -> menuLibraryData();
                case 2 -> menuMemberData();
                default -> System.out.printf("Option %d not recognized!%n", option + 1);
            }
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            System.out.println(optMessage);
            choice = scanner.nextLine();
            option = Integer.parseInt(choice);
        }
    }

    private static void menuLibraryData() {
        boolean success;
        do{
            String title = getTitle();
            String author = getAuthor();
            String genre = getGenre();
            String availabilityStatus = getAvailabilityStatus();
            String dateDue = getDateDue();
            success = Data.storeNewBook(title, author, genre, availabilityStatus, dateDue);
        } while(!success);
    }

    private static String getDateDue() {
        return null;
    }

    private static String getAvailabilityStatus() {
        return null;
    }

    private static String getGenre() {
        return null;
    }

    private static String getAuthor() {
        return null;
    }

    private static String getTitle() {
        System.out.println("Enter Book Title: ");
        String title;
        do{
            title = scanner.nextLine().trim();
        } while (title.isEmpty());
        return title;
    }

    private static void menuMemberData() {
    }
}