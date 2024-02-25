import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private static final ArrayList<Object[]> books = new ArrayList<>();
    private static final ArrayList<Object[]> availableBooks = new ArrayList<>();
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

    public static boolean storeNewMember(Integer id, String name, ArrayList<String> borrowed, String availabilityStatus) {
    }

    public static boolean removeMember(Integer id, String name, ArrayList<String> borrowed, Double fines) {
    }
}
