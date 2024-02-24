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

    private static final ArrayList<String> options1 = new ArrayList<>();

    static {
        options1.add("Add Book");
        options1.add("Remove Book");
        options1.add("Checkout Books");
        options1.add("View All Books");
        options1.add("View Available Books");
        options1.add("View Unavailable Books");
        options1.add("Search");
        options1.add("Exit to Main Menu");
    }
    private static String optMessage1 = """
            Library Data Options
           """;

    static {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(optMessage1);
        for (int i = 0; i < options1.size(); i++) {
            sb1.append(String.format("\t%d.%s\n", i + 1, options1.get(i)));
        }
        optMessage1 = sb1.toString();
    }
    private static void menuLibraryData() {
        System.out.println(optMessage1);
        String libchoice = scanner.nextLine();
        int option1 = Integer.parseInt(libchoice);
        option1 +=-1;
        while (option1 != -1) {
            if (option1 > -1 && option1 < options1.size()) {
                System.out.printf("Selected option %d.%s%n", option1 + 1, options1.get(option1));
                System.out.println("Press any key to continue...");
                scanner.nextLine();
            }
            switch (option1 + 1) {
                case 1 -> menuEnterNewBook();
                case 2 -> menuRemoveBook();
                case 3 -> menuCheckoutBooks();
                case 4 -> menuViewAll();
                case 5 -> menuViewAvailable();
                case 6 -> menuViewUnavailable();
                case 7 -> menuSearch();
                default -> System.out.printf("Option %d not recognized!%n", option1);
            }
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            System.out.println(optMessage1);
            libchoice = scanner.nextLine();
            option1 = Integer.parseInt(libchoice);
        }
    }

    private static void menuSearch() {
    }

    private static void menuViewUnavailable() {
    }

    private static void menuViewAvailable() {
    }

    private static void menuViewAll() {
    }

    private static void menuCheckoutBooks() {
    }

    private static void menuRemoveBook() {
    }

    private static void menuEnterNewBook() {
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


    private static final ArrayList<String> options2 = new ArrayList<>();

    static {
        options2.add("Add Member");
        options2.add("Remove Member");
        options2.add("View All Members");
        options2.add("Remove Member");
        options2.add("Search Members");
    }
    private static String optMessage2 = """
 Member Data Options
 """;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(optMessage2);
        for (int i = 0; i < options2.size(); i++) {
            sb2.append(String.format("\t%d.%s\n", i + 1, options2.get(i)));
        }
        optMessage2 = sb2.toString();
    }
    private static void menuMemberData() {
        System.out.println(optMessage2);
        String memchoice = scanner.nextLine();
        int option2 = Integer.parseInt(memchoice);
        option2 +=-1;
        while (option2 != -1) {
            if (option2 > -1 && option2 < options2.size()) {
                System.out.printf("Selected option %d.%s%n", option2 + 1, options2.get(option2));
                System.out.println("Press any key to continue...");
                scanner.nextLine();
            }
            switch (option2 + 1) {
                case 1 -> menuAddMember();
                case 2 -> menuRemoveMember();
                case 3 -> menuSearchMembers();
                case 4 -> menuViewAllMembers();
                case 5 -> menuExitToMainMenu();
                default -> System.out.printf("Option %d not recognized!%n", option2);
            }
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            System.out.println(optMessage2);
            memchoice = scanner.nextLine();
            option2 = Integer.parseInt(memchoice);
        }
    }


    private static void menuAddMember(){}
    private static void menuRemoveMember(){}
    private static void menuViewAllMembers(){}
    private static void menuSearchMembers(){}
    private static void menuExitToMainMenu(){}

    private static String getNewMember() {
        System.out.println("Enter New Member Name: ");
        String member;
        do {
            member = scanner.nextLine().trim();
        } while (member.isEmpty());
        return member;
    }
    private static int getId() {
        String memberId;
        do {
            System.out.println("Enter Member Id: ");
            memberId = scanner.nextLine().trim();
        }while (memberId.isEmpty());
        return Integer.parseInt(memberId);
    }

}