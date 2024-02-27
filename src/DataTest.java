import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @org.junit.jupiter.api.Test
    void storeNewBook() {
        Data.reset();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, Data.getAllBooks().get(0)[0]);
        assertEquals(author, Data.getAllBooks().get(0)[1]);
        assertEquals(genre, Data.getAllBooks().get(0)[2]);
        assertEquals(availabilityStatus, Data.getAllBooks().get(0)[3]);
        assertTrue(success, "Add was successful");
    }
    @org.junit.jupiter.api.Test
    void storeTwoBooks() {
        Data.reset();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertTrue(success);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, Data.getAllBooks().get(0)[0]);
        assertEquals(author, Data.getAllBooks().get(0)[1]);
        assertEquals(genre, Data.getAllBooks().get(0)[2]);
        assertEquals(availabilityStatus, Data.getAllBooks().get(0)[3]);
        assertTrue(success, "Add was successful");
        title = "Pride and Prejudice";
        author = "Jane Austen";
        genre = "Romance";
        availabilityStatus = "Available";
        success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertTrue(success);
        assertEquals(2, Data.getAllBooks().size());
        assertEquals(title, Data.getAllBooks().get(1)[0]);
        assertEquals(author, Data.getAllBooks().get(1)[1]);
        assertEquals(genre, Data.getAllBooks().get(1)[2]);
        assertEquals(availabilityStatus, Data.getAllBooks().get(1)[3]);
    }
    @org.junit.jupiter.api.Test
    void storeTwoBooksSameAuthor() {
        Data.reset();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertTrue(success);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, Data.getAllBooks().get(0)[0]);
        assertEquals(author, Data.getAllBooks().get(0)[1]);
        assertEquals(genre, Data.getAllBooks().get(0)[2]);
        assertEquals(availabilityStatus, Data.getAllBooks().get(0)[3]);
        assertTrue(success, "Add was successful");
        title = "Harry Potter and the Chamber of Secrets";
        author = "J.K. Rowling";
        genre = "Fantasy";
        availabilityStatus = "Available";
        success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertTrue(success);
        assertEquals(2, Data.getAllBooks().size());
        assertEquals(title, Data.getAllBooks().get(1)[0]);
        assertEquals(author, Data.getAllBooks().get(1)[1]);
        assertEquals(genre, Data.getAllBooks().get(1)[2]);
        assertEquals(availabilityStatus, Data.getAllBooks().get(1)[3]);
        
        for (Object[] book : Data.getAllBooks()){
            assertEquals(author, book[1]);
        }
    }
    @org.junit.jupiter.api.Test
     void storeDuplicateBooks(){
        Data.reset();
        String title = "Atomic Habits";
        String author = "James Clear";
        String genre = "Non-fiction";
        String availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        title = "Atomic Habits";
        author = "James Clear";
        genre = "Non-fiction";
        availabilityStatus = "Unavailable";
        success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertEquals(1,Data.getAllBooks().size());
        assertFalse(success);
    }
    @org.junit.jupiter.api.Test
     void storeEmptyTitle(){
        Data.reset();
        String title = "";
        String author = "Mary Shelley";
        String genre = "Horror";
        String availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertEquals(0,Data.getAllBooks().size());
        assertFalse(success);
    }

    @BeforeEach
    void setUpLibrary() {
        Data.reset(); // Clear existing data
        Data.storeNewBook("The Blood of Olympus","Rick Riordan","Fantasy","Unavailable");
        Data.storeNewBook("Moby Dick","Herman Melville","Literary","Unavailable");
        Data.storeNewBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        Data.storeNewBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        Data.storeNewBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Unavailable");
        Data.storeNewBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        Data.storeNewBook("Happy Place","Emily Henry","Romance","Unavailable");
        Data.storeNewBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        Data.storeNewBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Unavailable");
        Data.storeNewBook("Holly","Stephen King","Horror","Available");
        Data.storeNewBook("Joyland","Stephen King","Thriller","Unavailable");
        Data.storeNewBook("Poverty, by America","Matthew Desmond","Non-fiction","Unavailable");
        Data.storeNewBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        Data.storeNewBook("Joyland","Emily Schultz","Literary","Available");
    }
    @Test
    void checkExistBook() {
        assertTrue(Data.checkExistBook("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @Test
    void checkBookDoesNotExist(){
        assertFalse(Data.checkExistBook("The Catcher in the Rye", "J.D. Salinger"));
    }

    @Test
    void checkExistBookAuthorMismatch(){
        assertFalse(Data.checkExistBook("Holly", "J.K. Rowling"));
    }

    @Test
    void checkExistBookEmptyTitleAndAuthor(){
        assertFalse(Data.checkExistBook(" ", " "));
    }

    @Test
    void checkExistBookTitleWithNullAuthor(){
        assertFalse(Data.checkExistBook("The Blood of Olympus", null));
    }
    @Test
    void checkBookAvailable() {
        assertTrue(Data.checkBookAvailable("Hell Bent","Leigh Bardugo"));
    }

    @Test
    void checkBookUnavailable(){
        assertTrue(Data.checkBookAvailable("In the Lives of Puppets","T.J. Klune"));
    }

    @Test
    void checkBookAvailableTitleWithNullAuthor(){
        assertFalse(Data.checkBookAvailable("Joyland",null));
    }

    @Test
    void checkBookAvailableEmptyTitle(){
        assertFalse(Data.checkBookAvailable(" ", "Emilia Hart"));
    }

    @Test
    void checkBookAvailableCaseSensitivity(){
        assertFalse(Data.checkBookAvailable("TO KILL A MOCKINGBIRD", "HARPER LEE"));
    }

    @Test
    void testGetAllBooks() {
        ArrayList<Object[]> allBooks = Data.getAllBooks();
        assertEquals(14, allBooks.size());
    }

    @Test
    void testGetAllBooksAndReturnBookInfo(){
        ArrayList<Object[]> allBooks = Data.getAllBooks();
        Object[] fourthBook = allBooks.get(3);
        assertEquals("Weyward", fourthBook[Data.INDEX_TITLE]);
        assertEquals("Emilia Hart", fourthBook[Data.INDEX_AUTHOR]);
        assertEquals("Historical Fiction", fourthBook[Data.INDEX_GENRE]);
        assertEquals("Available", fourthBook[Data.INDEX_STATUS]);
    }

    @Test
    void testGetAllBooksEmptyLibrary(){
        Data.reset(); // Clear existing data to simulate no books
        ArrayList<Object[]> allBooks = Data.getAllBooks();
        assertTrue(allBooks.isEmpty());
    }

    @Test
    void testGetAllBooksMatchDetails(){
        ArrayList<Object[]> allBooks = Data.getAllBooks();
        Object[] sixthBook = allBooks.get(5);
        assertEquals("To Kill a Mockingbird", sixthBook[Data.INDEX_TITLE]);
        assertEquals("Harper Lee", sixthBook[Data.INDEX_AUTHOR]);
        assertEquals("General Fiction", sixthBook[Data.INDEX_GENRE]);
        assertEquals("Available", sixthBook[Data.INDEX_STATUS]);
        Object[] eighthBook = allBooks.get(7);
        assertEquals("Hell Bent", eighthBook[Data.INDEX_TITLE]);
        assertEquals("Leigh Bardugo", eighthBook[Data.INDEX_AUTHOR]);
        assertEquals("Fantasy", eighthBook[Data.INDEX_GENRE]);
        assertEquals("Available", eighthBook[Data.INDEX_STATUS]);
    }

    @Test
    void testGetAvailableBooks() {
    }

    @Test
    void testGetUnavailableBooks() {
    }

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks() {
        ArrayList<Object[]> booksWithTitle = Data.getBooksByTitle("Joyland");
        assertEquals(2, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleReturnsCorrectBookInfo() {
        ArrayList<Object[]> booksWithTitle = Data.getBooksByTitle("The Blood of Olympus");
        Object[] firstBook = booksWithTitle.get(0);
        assertEquals("The Blood of Olympus", firstBook[Data.INDEX_TITLE]);
        assertEquals("Rick Riordan", firstBook[Data.INDEX_AUTHOR]);
        assertEquals("Fantasy", firstBook[Data.INDEX_GENRE]);
        assertEquals("Unavailable", firstBook[Data.INDEX_STATUS]);
    }

    @Test
    public void getBooksByTitleWhenTitleNotFound() {
        ArrayList<Object[]> booksWithTitle = Data.getBooksByTitle("American Gods");
        assertTrue(booksWithTitle.isEmpty());
    }

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks1(){
        ArrayList<Object[]> booksWithTitle = Data.getBooksByTitle("Poverty, by America");
        assertEquals(1, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleEmptyTitle(){
        ArrayList<Object[]> booksWithTitle = Data.getBooksByTitle(" ");
        assertTrue(booksWithTitle.isEmpty());
    }

    @Test
    void getBooksByAuthorReturnsCorrectNumberOfBooks() {
        ArrayList<Object[]> booksByAuthor = Data.getBooksByAuthor("Stephen King");
        assertEquals(2, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectBookInfo() {
        ArrayList<Object[]> booksByAuthor = Data.getBooksByAuthor("Emily Henry");
        Object[] book = booksByAuthor.get(0);
        assertEquals("Happy Place", book[Data.INDEX_TITLE]);
        assertEquals("Emily Henry", book[Data.INDEX_AUTHOR]);
        assertEquals("Romance", book[Data.INDEX_GENRE]);
        assertEquals("Unavailable", book[Data.INDEX_STATUS]);
    }

    @Test
    public void getBooksByAuthorWhenAuthorNotFound() {
        ArrayList<Object[]> booksByAuthor = Data.getBooksByAuthor("John Milton");
        assertTrue(booksByAuthor.isEmpty());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectNumberOfBooks1(){
        ArrayList<Object[]> booksByAuthor = Data.getBooksByAuthor("Freida McFadden");
        assertEquals(1, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorEmptyAuthor(){
        ArrayList<Object[]> booksByAuthor = Data.getBooksByAuthor(" ");
        assertTrue(booksByAuthor.isEmpty());
    }
    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks() {
        ArrayList<Object[]> booksByGenre = Data.getBooksByGenre("Fantasy");
        assertEquals(2, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreReturnsCorrectBookInfo() {
        ArrayList<Object[]> booksByGenre = Data.getBooksByGenre("Literary");
        Object[] book = booksByGenre.get(1);
        assertEquals("The Great Gatsby", book[Data.INDEX_TITLE]);
        assertEquals("F. Scott Fitzgerald", book[Data.INDEX_AUTHOR]);
        assertEquals("Literary", book[Data.INDEX_GENRE]);
        assertEquals("Available", book[Data.INDEX_STATUS]);
    }

    @Test
    public void getBooksByGenreWhenNoBooksOfGenre() {
        ArrayList<Object[]> booksByGenre = Data.getBooksByGenre("Poetry");
        assertTrue(booksByGenre.isEmpty());
    }

    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks1(){
        ArrayList<Object[]> booksByGenre = Data.getBooksByGenre("Literary");
        assertEquals(3, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreWhenGenreNotValid() {
        ArrayList<Object[]> booksByInvalidGenre = Data.getBooksByGenre("Adventure");
        assertTrue(booksByInvalidGenre.isEmpty());
    }
    @Test
    void checkoutBook() {
    }

    @Test
    void returnBook() {
    }

    @Test
    void removeBook() {
    }

    @Test
    public void testStoreNewMember() {
        assertTrue(Data.storeNewMember(104, "Michael Brown", new ArrayList<>()));
    }

    @Test
    public void testStoreNewMemberAlreadyExists() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe", new ArrayList<>());
        Data.storeNewMember(102, "Jane Smith", new ArrayList<>());
        Data.storeNewMember(103, "Alice Johnson", new ArrayList<>());
        assertFalse(Data.storeNewMember(101, "John Doe", new ArrayList<>()));
    }

    @Test
    public void testStoreNewMemberAndCheckExistence() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe", new ArrayList<>());
        Data.storeNewMember(102, "Jane Smith", new ArrayList<>());
        Data.storeNewMember(103, "Alice Johnson", new ArrayList<>());
        Data.storeNewMember(104, "Michael Brown", new ArrayList<>());
        assertTrue(Data.storeNewMember(105, "Emily White", new ArrayList<>()));
    }

    @Test
    void checkExistMember() {
    }

    @Test
    void testRemoveMember() {
    }

    @Test
    void getAllMembers() {
    }

    @Test
    void testGetBorrowedBooks() {
    }
}