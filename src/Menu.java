/**
 * CPSC 233 W24 Group Project
 * Library Management System
 * @author Anna Littkemann, Emily Ng Kwong Sang, Srijita Marick
 * @email anna.littkemann@ucalgary.ca, emily.ngkwongsang@ucalgary.ca,
 * srijita.marick@ucalgary.ca
 * @UCID 30212220, 30230290, 30230880
 * @date Feb 21-27 2024 (DEMO 1)
 * @tutorial T03 Tue  3:00PM -  4:50PM
 * Used "Group Project Part 1 Long Example" by Jonathan Hudson as code source
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> options = new ArrayList<>();

    static {
        options.add("Blank"); //placeholder for indexing purposes that is never seen by user
        options.add("Library Data");
        options.add("Member Data");
        options.add("Exit");
    }
    private static String optMessage = """
            -------------WELCOME TO LIBRARY-------------
            """;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(optMessage);
        for (int i = 1; i < options.size(); i++) {
            sb.append(String.format("\t%d.%s\n", i, options.get(i)));
        }
        optMessage = sb.toString();
    }

    /**
     * Used to prompt the user to input a non-empty String and trim any leading or trailing whitespace
     * @return non-empty String obtained from user input
     */
    private static String getOption(){
        String option;
        do {
            option = scanner.nextLine().trim();
        }while(option.isEmpty());
        return option;
    }

    /**
     * Used in Main.java to run the main program
     */
    public static void menuLoop() {
        int option = 0;
        boolean run = true; // Flag to control the loop
        while (run) {
            System.out.println(optMessage);
            String choice = getOption();
            if (!choice.isEmpty() && !choice.equals("0")) {
                option = Integer.parseInt(choice); // Convert user's choice to an integer
            }
            if (option > 0 && option < options.size()) {
                System.out.printf("Selected option %d.%s%n", option, options.get(option));
                switch (option) {
                    case 1 -> menuLibraryData();
                    case 2 -> menuMemberData();
                    case 3 -> run = false; // Exit the loop if user chooses to quit
                    default -> System.out.printf("Option %d not recognized!%n", option);
                }
            } else {
                System.out.printf("Option %d not recognized!%n", option);
            }
        }
        System.out.println("Exiting program...");
    }


    private static final ArrayList<String> options1 = new ArrayList<>();

    static {
        options1.add("Blank"); //placeholder for indexing purposes that is never seen by user
        options1.add("Add Book");
        options1.add("Remove Book");
        options1.add("Checkout Books");
        options1.add("Return Books");
        options1.add("View All Books");
        options1.add("View Available Books");
        options1.add("View Unavailable Books");
        options1.add("Search");
        options1.add("Exit to Main Menu");
    }
    private static String optMessage1 = """
            -------------LIBRARY DATA-------------
           """;

    static {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(optMessage1);
        for (int i = 1; i < options1.size(); i++) {
            sb1.append(String.format("\t%d.%s\n", i, options1.get(i)));
        }
        optMessage1 = sb1.toString();
    }

    /**
     * Used in menuLoop as a sub-menu to access Library resources
     */
    private static void menuLibraryData() {
        int option1 = 0;
        boolean run = true;
        while (run) {
            System.out.println(optMessage1);
            String libchoice = scanner.nextLine();
            if (!libchoice.isEmpty() && !libchoice.equals("0")) {
                option1 = Integer.parseInt(libchoice);
            }
            if (option1 > 0 && option1 < options1.size()) {
                System.out.printf("Selected option %d.%s%n", option1, options1.get(option1));
                switch (option1) {
                    case 1 -> menuEnterNewBook();
                    case 2 -> menuRemoveBook();
                    case 3 -> menuCheckoutBooks();
                    case 4 -> menuReturnBooks();
                    case 5 -> menuViewAllBooks();
                    case 6 -> menuViewAvailable();
                    case 7 -> menuViewUnavailable();
                    case 8 -> menuSearchBooks();
                    case 9 -> run = false;
                    default -> System.out.printf("Option %d not recognized!%n", option1);
                }
            } else{
                System.out.printf("Option %d not recognized!%n", option1);
            }
        }
    }
    /**
     * sends user to their desired type of search
     */
    private static void menuSearchBooks() {
        ArrayList<String> searchOptions = new ArrayList<>(); //each search option is a string in this list
        searchOptions.add("Blank"); //this is a placeholder that is never displayed to user
        searchOptions.add("Title");
        searchOptions.add("Author");
        searchOptions.add("Genre");
        StringBuilder searchString = new StringBuilder(); // formatted list of the search options with instruction
        searchString.append("How would you like to search for books?\n");
        for (int i = 1; i < searchOptions.size(); i++) {
            searchString.append(String.format("\t%d.%s\n", i, searchOptions.get(i)));
        }
        System.out.println(searchString);
        String choice = ""; // will be used to store user input for genre index
        boolean run = true; // tracks when the while loop should run or not
        while (run) {
            choice = scanner.nextLine(); // gets input from user
            int option = Integer.parseInt(choice); // converts into to an int
            if (option > 0 && option < searchOptions.size()) { // checks if selection is valid
                System.out.printf("Searching by %d.%s%n", option, searchOptions.get(option));
                run = false; // stop while-loop
            }
            switch(option){
                case 1 -> searchByTitle();//title
                case 2 -> searchByAuthor();//author
                case 3 -> searchByGenre();//genre
                default -> System.out.printf("Option %d not recognized!%n", option);
            }
        }
    }
    /**
     * Prints all books with selected title using menuViewAnyBookList
     */
    private static void searchByTitle(){
        String title = getTitle();
        String viewBooksMessage = """
             All books with that title:""";
        ArrayList<Books> bookList = Data.getBooksByTitle(title);
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }
    /**
     * Prints all books by selected author using menuViewAnyBookList
     */
    private static void searchByAuthor(){
        String author = getAuthor();
        String viewBooksMessage = """
             All books by that author:""";
        ArrayList<Books> bookList = Data.getBooksByAuthor(author);
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }

    /**
     * Prints all books in selected genre using menuViewAnyBookList
     */
    private static void searchByGenre(){
        String genre = getGenre();
        String viewBooksMessage = """
             All books in that genre:""";
        ArrayList<Books> bookList = Data.getBooksByGenre(genre);
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }

    /**
     * Prints all unavailable books in library using menuViewAnyBookList
     */
    private static void menuViewUnavailable() {
        String viewBooksMessage = """
            Unavailable Books:""";
        ArrayList<Books> bookList = Data.getUnavailableBooks();
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }

    /**
     * Prints all available books in library using menuViewAnyBookList
     */
    private static void menuViewAvailable() {
        String viewBooksMessage = """
            Available Books:""";
        ArrayList<Books> bookList = Data.getAvailableBooks();
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }

    /**
     * Prints all book in library using menuViewAnyBookList
     */
    private static void menuViewAllBooks() {
        String viewBooksMessage= """
            ALl library Books:""";
        ArrayList<Books> bookList = Data.getAllBooks();
        System.out.println(viewAnyBookList(viewBooksMessage, bookList));
    }


    /**
     * called on by menuViewAllBooks, menuViewAvailableBooks, etc.
     * Any time a list of books is required, it returns the desired type of list
     * @param viewBooksMessage is the instructions messages
     * @param listOfBooks is the list of books being displayed
     * @return String containing all the required books
     */
    private static String viewAnyBookList(String viewBooksMessage, ArrayList<Books> listOfBooks){
        StringBuilder booksString = new StringBuilder();
        booksString.append(viewBooksMessage);
        for (Books book :listOfBooks){
            booksString.append(book.toString());
        }
        return (booksString.toString());
    }

    /**
     * Used in menuLibraryData to check out books
     */
    private static void menuCheckoutBooks() {
        int id = getId();
        while (!Data.checkExistMember(id)){
            System.out.println("Member does not exist. Please try again.\n");
            id = getId();
        }
        String title = getTitle();
        String author = getAuthor();
        while (!Data.checkExistBook(title,author)){
            System.out.printf("The library does not own %s by %s. Please try again.\n",title,author);
            title = getTitle();
            author = getAuthor();
        }
        if (Data.checkBookAvailable(title,author)){
            Data.checkoutBook(id, title, author);
        }
        else {
            System.out.printf("%s by %s is currently checked out by another user.\n" ,title,author);
        }

    }

    /**
     * Used in menuLibraryData to return books
     */
    private static void menuReturnBooks(){
        int id = getId();
        while (!Data.checkExistMember(id)){  //makes sure that this id corresponds to an existing member
            System.out.println("Member does not exist. Please try again.\n");
            id = getId();
        }
        String title = getTitle();
        String author = getAuthor();
        if (!Data.checkExistBook(title,author)){ //if the books isn't in the system, no action is taken
            System.out.printf("The library does not own %s by %s. Please try again.\n",title,author);
        }
        else if (Data.checkBookAvailable(title,author)){ //if the book has already been returned, no action is taken
            System.out.printf("%s by %s is not currently checked out by anyone. That is not our book.\n",title,author);
        }
        else { //if the book both exists and is not checked out, then it is returned to the library
            int daysOverdue = getDaysOverdue();
            System.out.printf("%s by %s has been returned to the library.\n",title,author);
            Data.returnBook(id,title,author,daysOverdue);
        }
    }

    /**
     * Used in menuLibraryData to remove books
     */
    private static void menuRemoveBook() {
        boolean success;
        do {
            String title = getTitle();
            String author = getAuthor();
            success = Data.removeBook(title, author);
            if (!success){
                System.out.printf("%s by %s does not exist in library. Please try again.\n",title,author);
            }
            else {
                System.out.printf("\n%s by %s was deleted from the library!\n",title,author);
            }
        } while (!success);
    }

    /**
     * Used in menuLibraryData to add books to the Library's main dataset
     */
    private static void menuEnterNewBook() {
        boolean success;
        do {
            String title = getTitle();
            String author = getAuthor();
            String genre = getGenre();
            String availabilityStatus = getAvailabilityStatus();
            String type = "PHYSICAL";
            success = Data.storeNewBook(title, author, genre, availabilityStatus, type);
            if (!success){
                System.out.println("Book already exists in library. Try again.");
            }
        } while (!success);
        System.out.println("Stored a new book!");
    }

    private static String getAvailabilityStatus() {
        return "Available";  // by default, new books should be available
    }

    /** Called on by menuReturnBooks
     * Used to get the number of days a book is overdue from user input
     * @return integer value of days obtained from user input
     */
    public static int getDaysOverdue(){
        System.out.println("How many days overdue is the book? ");
        String days;
        do {
            days = scanner.nextLine().trim();
        } while (days.isEmpty()||days.contains("-")||days.contains(".")); //continues while selections are invalid
        return Integer.parseInt(days);
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

    /**
     * Used in menuCheckoutBooks, menuReturnBooks, etc.
     * @return the name of the book
     */
    private static String getTitle() {
        System.out.println("Enter Book Title: ");
        String title;
        do {
            title = scanner.nextLine().trim();
        } while (title.isEmpty());
        return title;
    }

    //BELOW THIS POINT IS MEMBER MENU

    private static final ArrayList<String> options2 = new ArrayList<>();

    static {
        options2.add("Blank"); //placeholder for indexing purposes that is never seen by user
        options2.add("Add Member");
        options2.add("Remove Member");
        options2.add("View All Members");
        options2.add("Search Members");
        options2.add("Pay fines");
        options2.add("Exit to Main Menu");
    }
    private static String optMessage2 = """
    -------------MEMBER DATA-------------
    """;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(optMessage2);
        for (int i = 1; i < options2.size(); i++) {
            sb2.append(String.format("\t%d.%s\n", i, options2.get(i)));
        }
        optMessage2 = sb2.toString();
    }

    private static void menuMemberData() {
        int option2 = 0;
        boolean run = true;
        while (run) {
            System.out.println(optMessage2);
            String memchoice = scanner.nextLine();
            if(!memchoice.isEmpty() && !memchoice.equals("0")){
                option2 = Integer.parseInt(memchoice);
            }
            if (option2 > 0 && option2 < options2.size()) {
                System.out.printf("Selected option %d.%s%n", option2, options2.get(option2));
                switch (option2) {
                    case 1 -> menuAddMember();
                    case 2 -> menuRemoveMember();
                    case 3 -> menuViewAllMembers();
                    case 4 -> menuSearchMembers();
                    case 5 -> menuPayFines();
                    case 6 -> run = false;
                    default -> System.out.printf("Option %d not recognized!%n\n", option2);
                }
            } else {
                System.out.printf("Option %d not recognized!%n\n", option2);
            }
        }
    }

    /**
     * Used in menuMemberData to add a new member to the Library's member list
     */
    private static void menuAddMember(){
        boolean success;
        Integer ID = getId();
        String name = getMember();
        success = Data.storeNewMember(ID, name);
        if (!success){
            System.out.println("You cannot have two members with the same information.\n");
        }
        else{
            System.out.println("Stored a new member!\n");
        }
    }

    /**
     * Used in menuMemberData to remove a member from the member list
     */
    private static void menuRemoveMember(){
        boolean success;
        do {
            Integer ID = getId();
            String name = getMember();
            success = Data.removeMember(ID, name);
            if (!success){
                System.out.println("Member does not exist in Membership List. Please try again.\n");
            }
        } while (!success);
        System.out.println("Deleted a new member!\n");
    }
    /**
     * Used in menuMemberData to print the entire list of library members
     */
    private static void menuViewAllMembers(){
        ArrayList<Member> members = Data.getAllMembers();
        StringBuilder memString = new StringBuilder();
        String memMessage = """
            All Library Members:""";
        memString.append(memMessage);
        for (Member member: members){
            memString.append(member.toString());
        }
        System.out.println(memString);
    }

    /**
     * Used in menuMemberData to search for a member in the member list
     */
    private static void menuSearchMembers() {
        ArrayList<String> searchOptions = new ArrayList<>(); //each search option is a string in this list
        searchOptions.add("Blank"); //this is a placeholder that is never displayed to user
        searchOptions.add("Member Name");
        searchOptions.add("Member ID");
        StringBuilder searchString = new StringBuilder(); // formatted list of the search options with instruction
        searchString.append("How would you like to search for members?\n");
        for (int i = 1; i < searchOptions.size(); i++) {
            searchString.append(String.format("\t%d.%s\n", i, searchOptions.get(i)));
        }
        System.out.println(searchString);
        String choice; // will be used to store user input
        boolean run = true; // tracks when the while loop should run or not
        while (run) {
            choice = scanner.nextLine(); // gets input from user
            int option = Integer.parseInt(choice); // converts into to an int
            if (option > 0 && option < searchOptions.size()) { // checks if selection is valid
                System.out.printf("Searching by %d.%s%n", option, searchOptions.get(option));
                run = false; // stop while-loop
            }
            switch(option){
                case 1 -> searchByName();//member name
                case 2 -> searchById();//member id
                default -> System.out.printf("Option %d not recognized!%n", option);
            }
        }
    }

    /**
     * Used in menuSearchMembers to look for a member by name only
     */
    private static void searchByName() {
        String name = getMember();
        String viewMembersMessage = """
                All members with that name:""";
        ArrayList<Member> memberList = Data.getMembersByName(name);
        System.out.println(viewAnyMemberList(viewMembersMessage, memberList));
    }

    /**
     * Used in menuSearchMembers to look for a member by ID only
     */
    private static void searchById(){
        int id = getId();
        String viewMembersMessage = """
             Member with given ID:""";
        ArrayList<Member> memberList = Data.getMembersById(id);
        System.out.println(viewAnyMemberList(viewMembersMessage, memberList));
    }

    /**
     * called on by searchByName and searchById
     * @param viewMembersMessage is the instructions message
     * @param listOfMembers is the list of members being displayed
     * @return String containing all the required members
     */
    private static String viewAnyMemberList(String viewMembersMessage, ArrayList<Member> listOfMembers) {
        StringBuilder membersString = new StringBuilder();
        membersString.append(viewMembersMessage);
        for (Member member :listOfMembers){
            membersString.append(member.toString());
        }
        return (membersString.toString());
    }

    /**
     * Passes information to Data.payFines so that a member's fines can be updated when they pay it
     * Prints member's information before and after they pay the fine
     */
    private static void menuPayFines(){
        int ID = getId();
        String viewMembersMessage = """
             Member's Information:""";
        System.out.println(viewAnyMemberList(viewMembersMessage,Data.getMembersById(ID)));

        String input; //temporarily saving payment amount as a string for looping purposes
        do {
            System.out.println("\nEnter amount to be paid: ");
            input = scanner.nextLine().trim();
        }while (input.isEmpty()||!input.contains(".")||input.contains("-")||input.contains("$"));
        input = String.format("%.2f",Double.parseDouble(input));
        Double payment = Double.parseDouble(input);
        if(Data.payFines(ID,payment)){ //calls of Data.payFines, which updates the fine info as long as it's valid
            System.out.println("Payment successful!\n");
            viewMembersMessage = """
             Member's Updated Information:""";
            System.out.println(viewAnyMemberList(viewMembersMessage,Data.getMembersById(ID)));
        }
        else{
            System.out.println("Invalid payment. You cannot pay more than the amount owed.\n");
        }
    }


    /** called by menuAddMember, menuRemoveMember, searchByName
     * Used to get the member name
     * @return member name obtained from user input
     */
    private static String getMember() {
        System.out.println("Enter Member Name: ");
        String member;
        do {
            member = scanner.nextLine().trim();
        } while (member.isEmpty());
        return member;
    }

    /** called by menuCheckoutBooks, menuReturnBooks, menuAddMember, menuRemoveMember, searchById
     * Used to get the member Id
     * @return return Integer value of member ID obtained from user input
     */
    private static int getId() {
        String memberId;
        do {
            System.out.println("Enter Member ID (integer value): ");
            memberId = scanner.nextLine().trim();
        }while (memberId.isEmpty());
        return Integer.parseInt(memberId);
    }

}