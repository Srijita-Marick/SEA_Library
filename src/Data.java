import java.lang.reflect.Array;
import java.util.ArrayList;

public class Data {
    private static final ArrayList<Object[]> books = new ArrayList<>();
    private static final ArrayList<Object[]> availableBooks = new ArrayList<>();
    private static final ArrayList<Object[]> unavailableBooks = new ArrayList<>();
    private static final ArrayList<String> titles = new ArrayList<>();

    private static final ArrayList<String> authors = new ArrayList<>();
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_AUTHOR = 1;
    public static final int INDEX_GENRE = 2;
    public static final int INDEX_STATUS = 3;
    //public static final int INDEX_DATEDUE = 4;
    public static final int INDEX_REMOVED = 4;
    public static boolean storeNewBook(String title, String author, String genre, String availabilityStatus) {
        if (!checkExistBook(title, author)) {
            Object[] book = new Object[6];
            book[INDEX_TITLE] = title;
            book[INDEX_AUTHOR] = author;
            book[INDEX_GENRE] = genre;
            book[INDEX_STATUS] = availabilityStatus;
            //book[INDEX_DATEDUE] = dateDue;
            book[INDEX_REMOVED] = false;
            books.add(book); //adding to list of all books
            availableBooks.add(book); //since all books are by default available when created
            titles.add(title);
            authors.add(author);
            System.out.println("Stored Yay!");
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkExistBook(String title , String author){
        return titles.contains(title) && authors.contains(author);
    }

    public static ArrayList <Object[]> getAllBooks(){
        return books;
    }
    public static ArrayList <Object[]> getAvailableBooks(){
        return availableBooks;
    }
    public static ArrayList<Object[]> getUnavailableBooks() {
        return unavailableBooks;
    }
    //  EVERYTHING BELOW HERE IS TO STORE MEMBER DATA

    static final ArrayList<Object[]> members = new ArrayList<>();
    static final ArrayList<Integer> memberIDs = new ArrayList<Integer>(); // all of the ids currently in use
    public static final int INDEX_ID = 0;
    public static final int INDEX_NAME = 1;
    public static final int INDEX_BORROWED = 2; // borrowed should be list of their borrowed books
    public static final int INDEX_FINES = 3;


    public static boolean storeNewMember(Integer id, String name, ArrayList<String> borrowed, Double fines) {
        if (!checkExistMember(id)) {
            Object[] member = new Object[6];
            member[INDEX_ID] = id;
            member[INDEX_NAME] = name;
            member[INDEX_BORROWED] = borrowed;
            member[INDEX_FINES] = fines;
            memberIDs.add(id);
            members.add(member); //adding to list of all members
            System.out.println("Stored Yay!");
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkExistMember(Integer id) {
        return memberIDs.contains(id);
    }

    public static boolean removeMember(Integer id, String name) {
        return false;
    }

    public static String[] getBorrowedBooks(Integer id){
        for (Object[] member: members){
            if (member[INDEX_ID]==id){
                return (String[]) member[INDEX_BORROWED];
            }
        }
        return new String[]{null};
    }
}
