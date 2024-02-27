import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public static void reset(){   // Reset any existing data to ensure a clean state before test runs
        books.clear();
        availableBooks.clear();
        unAvailableBooks.clear();
        titles.clear();
        authors.clear();

    }
    private static final ArrayList<Object[]> books = new ArrayList<>();
    private static final ArrayList<Object[]> availableBooks = new ArrayList<>();
    private static final ArrayList<Object[]> unAvailableBooks = new ArrayList<>();
    private static final ArrayList<String> titles = new ArrayList<>();

    private static final ArrayList<String> authors = new ArrayList<>();
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_AUTHOR = 1;
    public static final int INDEX_GENRE = 2;
    public static final int INDEX_STATUS = 3;
    public static final int INDEX_REMOVED = 4;
    public static boolean storeNewBook(String title, String author, String genre, String availabilityStatus) {
        if (title.isEmpty() || author.isEmpty()){
            System.out.println("Book cannot be stored.");
            return false;
        }

        if (!checkExistBook(title, author)) {
            Object[] book = new Object[5];
            book[INDEX_TITLE] = title;
            book[INDEX_AUTHOR] = author;
            book[INDEX_GENRE] = genre;
            book[INDEX_STATUS] = availabilityStatus;
            book[INDEX_REMOVED] = false;
            books.add(book); //adding to list of all books
            availableBooks.add(book); //since all books are by default available when created
            titles.add(title);
            authors.add(author);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkExistBook(String title , String author){
        return titles.contains(title) && authors.contains(author);
    }

    public static boolean checkBookAvailable(String title, String author){
        if (checkExistBook(title,author)) {
            for (Object[] book : availableBooks) {
                if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList <Object[]> getAllBooks(){
        return books;
    }
    public static ArrayList <Object[]> getAvailableBooks(){
        return availableBooks;
    }
    public static ArrayList<Object[]> getUnavailableBooks() {
        return unAvailableBooks;
    }
    public static ArrayList<Object[]> getBooksByTitle(String title) {
        ArrayList<Object[]> booksWithTitle = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_TITLE].equals(title)) {
                booksWithTitle.add(book);
            }
        }
        return booksWithTitle;
    }
    public static ArrayList<Object[]> getBooksByAuthor(String author) {
        ArrayList<Object[]> booksByAuthor = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_AUTHOR].equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
    public static ArrayList<Object[]> getBooksByGenre(String genre) {
        ArrayList<Object[]> booksInGenre = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_GENRE].equals(genre)) {
                booksInGenre.add(book);
            }
        }
        return booksInGenre;
    }

    public static void checkoutBook(Integer id, String title, String author){
        for (Object[] book: books){
            if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)){
                availableBooks.remove(book);
                book[INDEX_STATUS]= "Unavailable";
                unAvailableBooks.add(book);
                for (Object[] member: members){
                    if (member[INDEX_ID]==id){
                        ((ArrayList<String>)member[INDEX_BORROWED]).add(title+" by "+author);
                    }
                }
            }
        }
    }

    public static void returnBook(Integer id, String title, String author, int daysOverdue) {
        for (Object[] book: books){
            if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)){
                unAvailableBooks.remove(book);
                book[INDEX_STATUS]= "Available";
                availableBooks.add(book);
                for (Object[] member: members){
                    if (member[INDEX_ID]==id){
                        ((ArrayList<String>)member[INDEX_BORROWED]).remove(title+" by "+author);
                        member[INDEX_FINES] = (double)member[INDEX_FINES] + calculateFines(daysOverdue);
                    }
                }
            }
        }
    }
    public static boolean removeBook(String title, String author) {
        if (checkExistBook(title,author)){
            for (Object[] book: books){
                if (book[INDEX_TITLE].equals(title)&&book[INDEX_AUTHOR].equals(author)){
                    books.remove(book);
                    titles.remove((String)book[INDEX_TITLE]);
                    authors.remove((String)book[INDEX_AUTHOR]);
                    if (checkBookAvailable(title,author)){
                        availableBooks.remove(book);
                    }
                    else {
                        unAvailableBooks.remove(book);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //  EVERYTHING BELOW HERE IS TO STORE MEMBER DATA

    static final ArrayList<Object[]> members = new ArrayList<>();
    static final ArrayList<Integer> memberIDs = new ArrayList<Integer>(); // all the ids currently in use
    public static final int INDEX_ID = 0;
    public static final int INDEX_NAME = 1;
    public static final int INDEX_BORROWED = 2; // borrowed should be list of their borrowed books
    public static final int INDEX_FINES = 3;


    public static boolean storeNewMember(Integer id, String name) {
        if (!checkExistMember(id)) {
            Object[] member = new Object[4];
            member[INDEX_ID] = id;
            member[INDEX_NAME] = name;
            member[INDEX_BORROWED] = new ArrayList<String>();
            member[INDEX_FINES] = 0.00; // when someone joins library for the first time they should have no fine
            memberIDs.add(id);
            members.add(member); //adding to list of all members
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkExistMember(Integer id) {
        return memberIDs.contains(id);
    }

    public static boolean removeMember(Integer id, String name) {
        if (checkExistMember(id)){
            for (Object[] member: members){
                if (member[INDEX_ID]==(id)&&member[INDEX_NAME].equals(name)){
                    members.remove(member);
                    memberIDs.remove(member[INDEX_ID]);
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<Object[]> getAllMembers(){
        return members;
    }

    public static ArrayList<Object[]> getMembersByName(String name) {
        ArrayList<Object[]> membersWithName = new ArrayList<>();
        for (Object[] member: members){
            if (member[INDEX_NAME].equals(name)) {
                membersWithName.add(member);
            }
        }
        return membersWithName;
    }
    public static ArrayList<Object[]> getMembersById(int id) {
        ArrayList<Object[]> membersWithId = new ArrayList<>();
        for (Object[] member: members){
            if (member[INDEX_ID].equals(id)) {
                membersWithId.add(member);
            }
        }
        return membersWithId;
    }
    public static ArrayList<String> getBorrowedBooks(Integer id){
        for (Object[] member: members){
            if (member[INDEX_ID]==id){
                return (ArrayList<String>) member[INDEX_BORROWED];
            }
        }
        return new ArrayList<String>();
    }

    /**
     * @param daysOverDue is the number of days the user had the book past the due date
     * @return the fines accrued from being overdue
     */
    private static double calculateFines(int daysOverDue){
        return ((double)daysOverDue)*0.05; //five cents are added to fines per day overdue
    }

}
