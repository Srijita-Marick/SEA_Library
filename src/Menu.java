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
//random comment
    private static String optMessage = """
            Menu Options
            """;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);
        for (int i = 0; i < options.size(); i++) {
            sb.append(String.format("\t%d.%s\n", i + 1, options.get(i)));
        }
        optMessage = sb.toString();
    }

    public static void menuLoop() {
        System.out.println(optMessage);
        String choice = scanner.nextLine();
        int option = Integer.parseInt(choice);
        option += -1;
        while (option != -1) {
            if (option > -1 && option < options.size()) {
                System.out.printf("Selected option %d.%s%n", option + 1, options.get(option));
                System.out.println("Press any key to continue...");
                scanner.nextLine();
            }
            switch (option + 1) {
                case 1 -> menuLibraryData();
                case 2 -> menuMemberData();
                default -> System.out.printf("Option %d not recognized!%n", option);
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
        do {
            String title = getTitle();
            String author = getAuthor();
            String genre = getGenre();
            String availabilityStatus = getAvailabilityStatus();
            //String dateDue = getDateDue();
            success = Data.storeNewBook(title, author, genre, availabilityStatus);
        } while (!success);
    }

    private static void menuEnterNewBook() {
        String title = null;
    }

//    private static String getDateDue() {
//        return null;
//    }

    private static String getAvailabilityStatus() {
        return "available";  // by default, new books should be available
    }

    private static String getGenre() {
        ArrayList<String> genres = new ArrayList<>(); //each genre option is a string in this list
            genres.add("Blank"); //this is a placeholder that is never displayed to user
            genres.add("Fantasy");
            genres.add("General Fiction");
            genres.add("Historical Fiction");
            genres.add("Horror");
            genres.add("Literary");
            genres.add("Mystery");
            genres.add("Non-fiction");
            genres.add("Poetry");
            genres.add("Romance");
            genres.add("Science Fiction");
            genres.add("Thriller");
        StringBuilder genreList = new StringBuilder(); // formatted list of the genres with instructions
        genreList.append("Select a Genre from the Following List:\n");
        for (int i = 1; i < genres.size(); i++) {
            genreList.append(String.format("\t%d.%s\n", i, genres.get(i)));
        }
        System.out.println(genreList);
        String choice = ""; // will be used to store user input for genre index
        boolean run = true; // tracks when the while loop should run or not
        while (run) {
            choice = scanner.nextLine(); // gets input from user
            int option = Integer.parseInt(choice); // converts into to an int
            if (option > 0 && option < genres.size()) { // checks if selection is valid
                System.out.printf("Selected genre %d.%s%n", option, genres.get(option));
                run = false; // stop while-loop to return value
            }
            else { // iterates through loop again if the selection was not valid
                System.out.printf("There is no genre %d! %n", option);
            }
        }
        return genres.get(Integer.parseInt(choice)); // returns the selected genre
    }

    private static String getAuthor() {
        System.out.println("Enter Author Name: ");
        String author;
        do {
            author = scanner.nextLine().trim();
        } while (author.isEmpty());
        return author;
    }

    private static String getTitle() {
        System.out.println("Enter Book Title: ");
        String title;
        do {
            title = scanner.nextLine().trim();
        } while (title.isEmpty());
        return title;
    }

    private static void menuMemberData() {
        
    }

    private static void menuEnterNewMember(){
        String name = null;
    }
}