public class Books {
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_AUTHOR = 1;
    public static final int INDEX_GENRE = 2;
    public static final int INDEX_STATUS = 3;
    public static final int INDEX_TYPE = 4;
    public static final int INDEX_REMOVED = 5;
    private Object[] book;
    public Books(String title, String author, String genre, String availabilityStatus, String type){
        book = new Object[5];
        book[INDEX_TITLE] = title;
        book[INDEX_AUTHOR] = author;
        book[INDEX_GENRE] = genre;
        book[INDEX_STATUS] = availabilityStatus;
        book[INDEX_TYPE] = type;
        book[INDEX_REMOVED] = false;
    }
}