import java.util.ArrayList;

public class Data {
    private static final ArrayList<Object[]> books = new ArrayList<>();
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_AUTHOR = 1;
    public static final int INDEX_GENRE = 2;
    public static final int INDEX_STATUS = 3;
    //public static final int INDEX_DATEDUE = 4;
    public static final int INDEX_REMOVED = 4;
    public static boolean storeNewBook(String title, String author, String genre, String availabilityStatus) {
        Object[] book = new Object[6];
        book[INDEX_TITLE] = title;
        book[INDEX_AUTHOR] = author;
        book[INDEX_GENRE] = genre;
        book[INDEX_STATUS] = availabilityStatus;
        //book[INDEX_DATEDUE] = dateDue;
        book[INDEX_REMOVED] = false;
        books.add(book);
        System.out.println("Stored Yay!");
        return true;
    }
}
