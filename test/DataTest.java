import LibraryProjectPackage.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    /**
     * The following five functions are to test data.storeNewPhysicalBook
     * Each checks a different way in which we can save books to the Library
     * and checking to see if the book has been saved with the correct details
     */

    @Test
    void storeNewPhysicalBook() {
        Data d = new Data();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, d.getAllBooks().size());
        boolean success = d.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook = d.getAllBooks().getFirst();
        assertEquals(1, d.getAllBooks().size());
        assertEquals(title, newBook.getTitle());
        assertEquals(author, newBook.getAuthor());
        assertEquals(genre, newBook.getGenre());
        assertEquals(availabilityStatus, newBook.getAvailabilityStatus());
    }

    @Test
    void storeTwoPhysicalBooks() {
        Data data = new Data();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook1 = data.getAllBooks().getFirst();
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, newBook1.getTitle());
        assertEquals(author, newBook1.getAuthor());
        assertEquals(genre, newBook1.getGenre());
        assertEquals(availabilityStatus, newBook1.getAvailabilityStatus());

        title = "Pride and Prejudice";
        author = "Jane Austen";
        genre = "Romance";
        availabilityStatus = "Available";
        success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook2 = data.getAllBooks().get(1);
        assertEquals(2, data.getAllBooks().size());
        assertEquals(title, newBook2.getTitle());
        assertEquals(author, newBook2.getAuthor());
        assertEquals(genre, newBook2.getGenre());
        assertEquals(availabilityStatus, newBook2.getAvailabilityStatus());
    }

    @Test
    void storeTwoPhysicalBooksSameAuthor() {
        Data data = new Data();
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books book1 = data.getAllBooks().getFirst();
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, book1.getTitle());
        assertEquals(author, book1.getAuthor());
        assertEquals(genre, book1.getGenre());
        assertEquals(availabilityStatus, book1.getAvailabilityStatus());

        title = "Harry Potter and the Chamber of Secrets";
        author = "J.K. Rowling";
        genre = "Fantasy";
        availabilityStatus = "Available";
        success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books book2 = data.getAllBooks().get(1);
        assertEquals(2, data.getAllBooks().size());
        assertEquals(title, book2.getTitle());
        assertEquals(author, book2.getAuthor());
        assertEquals(genre, book2.getGenre());
        assertEquals(availabilityStatus, book2.getAvailabilityStatus());
    }

    @Test
    void storeDuplicatePhysicalBooks() {
        Data data = new Data();
        String title = "Atomic Habits";
        String author = "James Clear";
        String genre = "Non-fiction";
        String availabilityStatus = "Unavailable";
        data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);

        title = "Atomic Habits";
        author = "James Clear";
        genre = "Non-fiction";
        availabilityStatus = "Unavailable";
        success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        assertEquals(1, data.getAllBooks().size());
    }

    @Test
    void storeEmptyTitle() {
        Data data = new Data();
        String title = "";
        String author = "Mary Shelley";
        String genre = "Horror";
        String availabilityStatus = "Unavailable";
        data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        assertEquals(0, data.getAllBooks().size());

    }

    /**
     * The following two functions are to test data.storeNewAudioBook
     * Each checks a different way in which we can save books to the Library
     * and checking to see if the book has been saved with the correct details
     */
    @Test
    void storeNewAudioBook() {
        Data d = new Data();
        String title = "The Sun is Also a Star";
        String author = "Nicola Yoon";
        String narrator = "Raymond Lee";
        String genre = "Romance";
        String availabilityStatus = "Available";
        assertEquals(0, d.getAllBooks().size());
        boolean success = d.storeNewAudioBook(title, author, narrator, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook = d.getAllBooks().getFirst();
        assertEquals(1, d.getAllBooks().size());
        assertEquals(title, newBook.getTitle());
        assertEquals(author, newBook.getAuthor());
        assertEquals(genre, newBook.getGenre());
        assertEquals(availabilityStatus, newBook.getAvailabilityStatus());
    }

    @Test
    void storeTwoAudioBooks() {
        Data data = new Data();
        String title = "American Gods";
        String author = "Neil Gaiman";
        String narrator = "Ron McLarty";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewAudioBook(title, author, narrator, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook1 = data.getAllBooks().getFirst();
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, newBook1.getTitle());
        assertEquals(author, newBook1.getAuthor());
        assertEquals(genre, newBook1.getGenre());
        assertEquals(availabilityStatus, newBook1.getAvailabilityStatus());

        title = "Pride and Prejudice";
        author = "Jane Austen";
        narrator = "Elizabeth Klett";
        genre = "Romance";
        availabilityStatus = "Available";
        success = data.storeNewAudioBook(title, author, narrator, genre, availabilityStatus);
        assertTrue(success);

        LibraryProjectPackage.objects.Books newBook2 = data.getAllBooks().get(1);
        assertEquals(2, data.getAllBooks().size());
        assertEquals(title, newBook2.getTitle());
        assertEquals(author, newBook2.getAuthor());
        assertEquals(genre, newBook2.getGenre());
        assertEquals(availabilityStatus, newBook2.getAvailabilityStatus());
    }

    /**
     * The following five functions are to test data.checkExistBook
     * Each checks a variation of books, and whether the function returns t
     * rue or false according to the existence of the book in the setup Library
     */

    @Test
    void checkExistBook() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        assertTrue(data.checkExistBook("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @Test
    void checkBookDoesNotExist() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        assertFalse(data.checkExistBook("The Catcher in the Rye", "J.D. Salinger"));
    }

    @Test
    void checkExistBookAuthorMismatch() {
        Data data = new Data();
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        assertFalse(data.checkExistBook("Holly", "J.K. Rowling"));
    }

    @Test
    void checkExistBookEmptyTitleAndAuthor() {
        Data data = new Data();
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        assertFalse(data.checkExistBook(" ", " "));
    }

    @Test
    void checkExistBookTitleWithNullAuthor() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        assertFalse(data.checkExistBook("The Blood of Olympus", null));
    }

    /**
     * The following five functions are to test data.checkBookAvailable
     * Each checks a variation of availability statuses for a book in the setup
     * Library and checks whether the function returns true or false accordingly
     */

    @Test
    void checkBookAvailable() {
        Data data = new Data();
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        assertTrue(data.checkBookAvailable("Hell Bent", "Leigh Bardugo"));
    }

    @Test
    void checkBookUnavailable() {
        Data data = new Data();
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        assertTrue(data.checkBookAvailable("In the Lives of Puppets", "T.J. Klune"));
    }

    @Test
    void checkBookAvailableTitleWithNullAuthor() {
        Data data = new Data();
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        assertFalse(data.checkBookAvailable("Joyland", null));
    }

    @Test
    void checkBookAvailableEmptyTitle() {
        Data data = new Data();
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        assertFalse(data.checkBookAvailable(" ", "Emilia Hart"));
    }

    @Test
    void checkBookAvailableCaseSensitivity() {
        Data data = new Data();
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        assertFalse(data.checkBookAvailable("TO KILL A MOCKINGBIRD", "HARPER LEE"));
    }

    /**
     * The following four functions are to test data.getAllBooks
     * Each checks a variation of books that have been stored in the main Library
     * and whether the values are equivalent to the expected ones
     */

    @Test
    void testGetAllBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");
        ArrayList<LibraryProjectPackage.objects.Books> allBooks = data.getAllBooks();
        assertEquals(14, allBooks.size());
    }

    @Test
    void testGetAllBooksAndReturnBookInfo() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        ArrayList<LibraryProjectPackage.objects.Books> allBooks = data.getAllBooks();
        LibraryProjectPackage.objects.Books fourthBook = allBooks.get(3);
        assertEquals("Weyward", fourthBook.getTitle());
        assertEquals("Emilia Hart", fourthBook.getAuthor());
        assertEquals("Historical Fiction", fourthBook.getGenre());
        assertEquals("Available", fourthBook.getAvailabilityStatus());
    }

    @Test
    void testGetAllBooksEmptyLibrary() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Books> allBooks = data.getAllBooks();
        assertTrue(allBooks.isEmpty());
    }

    @Test
    void testGetAllBooksMatchDetails() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");


        ArrayList<LibraryProjectPackage.objects.Books> allBooks = data.getAllBooks();
        LibraryProjectPackage.objects.Books sixthBook = allBooks.get(5);
        assertEquals("To Kill a Mockingbird", sixthBook.getTitle());
        assertEquals("Harper Lee", sixthBook.getAuthor());
        assertEquals("General Fiction", sixthBook.getGenre());
        assertEquals("Available", sixthBook.getAvailabilityStatus());
        LibraryProjectPackage.objects.Books eighthBook = allBooks.get(7);
        assertEquals("Hell Bent", eighthBook.getTitle());
        assertEquals("Leigh Bardugo", eighthBook.getAuthor());
        assertEquals("Fantasy", eighthBook.getGenre());
        assertEquals("Available", eighthBook.getAvailabilityStatus());
    }

    /**
     * The following function is to test data.getAvailableBooks
     */

    @Test
    void testGetAllAvailableBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");
        ArrayList<LibraryProjectPackage.objects.Books> allAvailableBooks = data.getAvailableBooks();
        assertEquals(14, allAvailableBooks.size());

    }

    /**
     * The following function is to test data.getUnavailableBooks
     */

    @Test
    void testGetUnavailableBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");


        ArrayList<LibraryProjectPackage.objects.Books> allUnavailableBooks = data.getUnavailableBooks();
        assertEquals(0, allUnavailableBooks.size());
    }

    /**
     * The following five functions are to test data.getBooksByTitle
     * Each checks a variation of title entries and whether they are
     * equivalent to the actual title that is present in the library
     */

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");
        ArrayList<LibraryProjectPackage.objects.Books> booksWithTitle = data.getBooksByTitle("Joyland");
        assertEquals(2, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleReturnsCorrectBookInfo() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksWithTitle = data.getBooksByTitle("The Blood of Olympus");
        LibraryProjectPackage.objects.Books firstBook = booksWithTitle.getFirst();
        assertEquals("The Blood of Olympus", firstBook.getTitle());
        assertEquals("Rick Riordan", firstBook.getAuthor());
        assertEquals("Fantasy", firstBook.getGenre());
        assertEquals("Available", firstBook.getAvailabilityStatus());
    }

    @Test
    public void getBooksByTitleWhenTitleNotFound() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksWithTitle = data.getBooksByTitle("American Gods");
        assertTrue(booksWithTitle.isEmpty());
    }

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks1() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksWithTitle = data.getBooksByTitle("Poverty, by America");
        assertEquals(1, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleEmptyTitle() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksWithTitle = data.getBooksByTitle(" ");
        assertTrue(booksWithTitle.isEmpty());
    }

    /**
     * The following five functions are to test data.getBooksByAuthor
     * Each checks a variation of author name entries and whether they are
     * equivalent to the details of the actual book that is present in the library
     */

    @Test
    void getBooksByAuthorReturnsCorrectNumberOfBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        ArrayList<LibraryProjectPackage.objects.Books> booksByAuthor = data.getBooksByAuthor("Stephen King");

        assertEquals(2, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectBookInfo() {
        Data data = new Data();
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");


        ArrayList<LibraryProjectPackage.objects.Books> booksByAuthor = data.getBooksByAuthor("Emily Henry");
        LibraryProjectPackage.objects.Books book = booksByAuthor.getFirst();
        assertEquals("Happy Place", book.getTitle());
        assertEquals("Emily Henry", book.getAuthor());
        assertEquals("Romance", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByAuthorWhenAuthorNotFound() {
        Data data = new Data();
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        ArrayList<LibraryProjectPackage.objects.Books> booksByAuthor = data.getBooksByAuthor("John Milton");
        assertTrue(booksByAuthor.isEmpty());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectNumberOfBooks1() {
        Data data = new Data();
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksByAuthor = data.getBooksByAuthor("Freida McFadden");
        assertEquals(1, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorEmptyAuthor() {
        Data data = new Data();
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksByAuthor = data.getBooksByAuthor(" ");
        assertTrue(booksByAuthor.isEmpty());
    }

    /**
     * The following five functions are to test data.getBooksByGenre
     * Each checks a variation of genre types and whether they are
     * equivalent to the details of the actual book that is present in the library
     */

    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksByGenre = data.getBooksByGenre("Fantasy");
        assertEquals(2, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreReturnsCorrectBookInfo() {
        Data data = new Data();
        data.storeNewPhysicalBook("Gone with the Wind", "Margaret Mitchell", "Romance", "Available");

        ArrayList<LibraryProjectPackage.objects.Books> booksByGenre = data.getBooksByGenre("Romance");
        LibraryProjectPackage.objects.Books book = booksByGenre.getFirst();
        assertEquals("Gone with the Wind", book.getTitle());
        assertEquals("Margaret Mitchell", book.getAuthor());
        assertEquals("Romance", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByGenreWhenNoBooksOfGenre() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Books> booksByGenre = data.getBooksByGenre("Poetry");
        assertTrue(booksByGenre.isEmpty());
    }

    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks1() {
        Data data = new Data();
        data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        data.storeNewPhysicalBook("Pride and Prejudice","Jane Austen","Literary","Unavailable");
        ArrayList<LibraryProjectPackage.objects.Books> booksByGenre = data.getBooksByGenre("Literary");
        assertEquals(3, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreWhenGenreNotValid() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Books> booksByInvalidGenre = data.getBooksByGenre("Adventure");
        assertTrue(booksByInvalidGenre.isEmpty());
    }

    /**
     * The following two functions are to test data.checkoutBook
     */


    @Test
    void checkoutBook() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Books> initialAvailableBooks = data.getAvailableBooks();

        data.checkoutBook(123, "The Blood of Olympus", "Rick Riordan");
        assertFalse(data.checkBookAvailable("The Blood of Olympus", "Rick Riordan"));

        ArrayList<LibraryProjectPackage.objects.Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size(), updatedAvailableBooks.size());
    }

    @Test
    void checkoutBookWhenBookDoesNotExist() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Books> initialAvailableBooks = data.getAvailableBooks();
        data.checkoutBook(103, "The Sea of Monsters", "Rick Riordan");
        assertFalse(data.checkBookAvailable("The Sea of Monsters", "Rick Riordan"));

        ArrayList<LibraryProjectPackage.objects.Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size(), updatedAvailableBooks.size());
    }

    /**
     * The following two functions are to test data.returnBook
     */


    @Test
    void returnBook() {
        Data data = new Data();
        data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");

        ArrayList<LibraryProjectPackage.objects.Books> initialAvailableBooks = data.getAvailableBooks();

        data.returnBook(124, "Weyward", "Emilia Hart", 5);
        assertTrue(data.checkBookAvailable("Weyward", "Emilia Hart"));

        ArrayList<LibraryProjectPackage.objects.Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size(), updatedAvailableBooks.size());
    }

    @Test
    void returnTwoBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");

        ArrayList<LibraryProjectPackage.objects.Books> initialAvailableBooks = data.getAvailableBooks();

        data.returnBook(125, "To Kill a Mockingbird", "Harper Lee", 7);
        assertTrue(data.checkBookAvailable("To Kill a Mockingbird", "Harper Lee"));

        data.returnBook(123, "Joyland", "Stephen King", 16);
        assertTrue(data.checkBookAvailable("Joyland", "Stephen King"));

        ArrayList<LibraryProjectPackage.objects.Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size(), updatedAvailableBooks.size());
    }

    /**
     * The following three functions are to test data.removeBook
     * Each checks a variation of books that can be removed from the Library
     */


    @Test
    void removeBook() {
        Data data = new Data();
        data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");

        assertTrue(data.removeBook("Moby Dick", "Herman Melville"));
    }

    @Test
    void removeTwoBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");

        assertTrue(data.removeBook("Arsenic and Adobo", "Mia P. Manansala"));
        assertTrue(data.removeBook("Happy Place", "Emily Henry"));
    }

    @Test
    void removeNonExistingBook() {
        Data data = new Data();
        assertFalse(data.removeBook("No Man is an Island", "John Donne"));
    }

    /**
     * The following three functions are to test data.storeNewMember
     * Each checks a variation of member entries and whether it has been stored
     * properly in the Library's main member list
     */


    @Test
    public void testStoreNewAdultMember() {
        Data data = new Data();
        assertTrue(data.storeNewAdultMember(109, "Michael Brown"));
    }

    @Test
    public void testStoreNewAdultMemberAlreadyExists() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");
        assertFalse(data.storeNewAdultMember(101, "John Doe"));
    }

    @Test
    public void testStoreNewAdultMemberAndCheckExistence() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");
        data.storeNewAdultMember(104, "Michael Brown");
        assertTrue(data.storeNewAdultMember(105, "Emily White"));
    }

    /**
     * Creating a temporary member list to be used for testing
     */


    @BeforeEach
    void setUpMemberData() {
    }

    /**
     * The following functions are to test checkExistMember
     */

    @Test
    public void testCheckExistAdultMemberWhenAdultMemberExists() {
        Data data = new Data();
        data.storeNewAdultMember(101, "Arman Najari");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "The Webster");
        assertTrue(data.checkExistMember(101));
    }

    @Test
    public void testCheckExistAdultMemberWhenAdultMemberDoesNotExist() {
        Data data = new Data();
        data.storeNewAdultMember(101, "Arman Najari");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "The Webster");
        assertFalse(data.checkExistMember(100));
    }

    /**
     * The following five functions are to test data.removeMember
     * Each checks a different variation of true returns, false returns,
     * and checking to see if the member has actually been removed
     */

    @Test
    void testRemoveAdultMemberThatDoesntExist() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");

        assertFalse(data.removeMember(100, "Anna"));
    }

    @Test
    void testRemoveAdultMemberThatDoesExist() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");

        assertFalse(data.removeMember(101, "John Doe") && data.getMembersById(101).isEmpty());
        //removeMember should return false, and 101 should no longer be part of memberIDS
    }

    @Test
    void testRemoveMemberWhenThereAreNoMembers() {
        Data data = new Data();
        assertFalse(data.removeMember(100, "Anna"));
    }

    @Test
    void testRemoveMemberWhenIdExistsButNameDoesNot() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(data.removeMember(102, "Anna"));
    }

    @Test
    void testRemoveAdultMemberWhenNameExistsButIdDoesNot() {
        Data data = new Data();
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(data.removeMember(100, "Himanshu Ganga"));
    }

    /**
     * The following function is used to test data.getAllMembers
     */

    @Test
    void getAllMembers() {
        Data data = new Data();
        data.storeNewAdultMember(111, "Axelle Leung");
        data.storeNewAdultMember(112, "Rachel Lam");
        data.storeNewAdultMember(113, "Dhana Ramsamy");
        data.storeNewAdultMember(114, "Emma Stone");
        data.storeNewChildMember(115, "Elizabeth Roberts");
        data.storeNewChildMember(116, "Rose Evans");
        data.storeNewChildMember(117, "Jack Smith");
        data.storeNewChildMember(118, "James Johnson");

        ArrayList<LibraryProjectPackage.objects.Member> allMembers = data.getAllMembers();
        assertEquals(8, allMembers.size());
    }

    /**
     * The following three functions are used to test data.getBorrowedBooks
     * Each checks a variation of books to be borrowed and whether the book
     * status has been updated accordingly
     */

    @Test
    void testGetBorrowedBooks() {
        Data data = new Data();
        data.storeNewPhysicalBook("Nightcrawling", "Leila Mottley", "Literary", "Unavailable");
        data.storeNewAdultMember(101, "John Doe");

        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(101);
        assertTrue(borrowedBooks.isEmpty());
    }

    @Test
    public void testGetBorrowedBooksOneBook() {
        Data data = new Data();
        data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        data.storeNewChildMember(156, "Peter Robin");
        data.checkoutBook(156,  "In the Lives of Puppets", "T.J. Klune");

        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(156);

        assertEquals(1, borrowedBooks.size());
        assertTrue(borrowedBooks.contains("In the Lives of Puppets by T.J. Klune"));
    }

    @Test
    public void testGetBorrowedBooksNoBooksBorrowed() {
        Data data = new Data();
        data.storeNewAdultMember(123, "Jonathan Mayor");
        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(123);
        assertTrue(borrowedBooks.isEmpty());
    }

    /**
     * The following four functions are to test data.getMembersByName
     * Each checks a different way in which we can get members by Name only
     */

    @Test
    void testGetMembersByName() {
        Data data = new Data();
        data.storeNewAdultMember(128, "Michelle Yeoh");

        ArrayList<LibraryProjectPackage.objects.Member> membersByName = data.getMembersByName("Michelle Yeoh");
        assertEquals(1, membersByName.size());
    }

    @Test
    void testGetMembersByNameReturnMemberInfo() {
        Data data = new Data();
        data.storeNewChildMember(127, "Alice Wonderland");
        ArrayList<LibraryProjectPackage.objects.Member> membersByName = data.getMembersByName("Alice Wonderland");
        assertEquals(1, membersByName.size());
        LibraryProjectPackage.objects.Member member = membersByName.getFirst();
        assertEquals(127, member.getID());
        assertEquals("Alice Wonderland", member.getName());
    }

    @Test
    void testGetMembersByNameThreeMembers() {
        Data data = new Data();
        data.storeNewAdultMember(122, "Olivia Bells");
        data.storeNewAdultMember(123, "Sarah Li");
        data.storeNewAdultMember(124, "Steve Rodge");

        ArrayList<LibraryProjectPackage.objects.Member> membersByName = data.getMembersByName("Olivia Bells");
        assertEquals(1, membersByName.size());
        ArrayList<LibraryProjectPackage.objects.Member> membersByName1 = data.getMembersByName("Sarah Li");
        assertEquals(1, membersByName1.size());
        ArrayList<LibraryProjectPackage.objects.Member> membersByName2 = data.getMembersByName("Steve Rodge");
        assertEquals(1, membersByName2.size());
    }

    @Test
    void testGetMembersByNameNoName() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Member> membersByName = data.getMembersByName(" ");
        assertEquals(0, membersByName.size());
    }

    /**
     * The following three functions are to test data.getMembersById
     * Each checks a different way in which we can get members by Id only
     */

    @Test
    void testGetMembersById() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Member> membersById = data.getMembersById(178);
        assertNull(membersById.getFirst());
    }

    @Test
    void testGetMembersByIdReturnMemberInfo() {
        Data data = new Data();
        data.storeNewAdultMember(165, "Kai Hit");
        ArrayList<LibraryProjectPackage.objects.Member> members = data.getMembersById(165);
        assertEquals(1, members.size());
        LibraryProjectPackage.objects.Member member = members.getFirst();
        assertEquals(165, member.getID());
        assertEquals("Kai Hit", member.getName());
    }

    @Test
    void testGetMembersByIdTwoMembers() {
        Data data = new Data();
        ArrayList<LibraryProjectPackage.objects.Member> membersById = data.getMembersById(101);
        assertEquals(1, membersById.size());
        ArrayList<LibraryProjectPackage.objects.Member> membersById1 = data.getMembersById(103);
        assertEquals(1, membersById1.size());
    }

    /**
     * The following four functions are to test data.calculateFines
     * Each checks a different way in which we can correctly calculate fines for a given overdue period
     */

    @Test
    void testCalculateFines() {
        Data data = new Data();
        assertEquals(0.0, data.calculateFines(0));
    }

    @Test
    void testCalculateFinesOneDayOverdue() {
        Data data = new Data();
        assertEquals(0.05, data.calculateFines(1));
    }

    @Test
    void testCalculateFinesMultipleDaysOverdue() {
        Data data = new Data();
        assertEquals(1.0, data.calculateFines(20));
    }

    @Test
    void testCalculateFinesBigOverdue() {
        Data data = new Data();
        assertEquals(4.5, data.calculateFines(90));
    }

    /**
     * The following tests are for data.payFines
     * Each looks at a different ratio of payment to fines owed (>,=,<)
     */

    @Test
    void testPayFinesWhenPaymentGreaterThanFinesOwed() {
        Data data = new Data();
        data.checkoutBook(101, "Moby Dick", "Herman Melville");
        data.returnBook(101, "Moby Dick", "Herman Melville", 90);
        assertFalse(data.payFines(101, 4.6));
    }

    @Test
    void testPayFinesWhenPaymentIsLessThanFinesOwed() {
        Data data = new Data();
        data.storeNewAdultMember(125, "Ellie Rick");
        LibraryProjectPackage.objects.AdultMember member = (LibraryProjectPackage.objects.AdultMember) data.getAllMembers().getFirst();
        member.setFines(10.00);
        assertTrue(data.payFines(125, 5.00));
        assertEquals(5.00, member.getFines());
    }

    @Test
    void testPayFinesWhenPaymentIsEqualToFinesOwed() {
        Data data = new Data();
        data.storeNewAdultMember(126, "Adi Mustafa");
        LibraryProjectPackage.objects.AdultMember member2 = (LibraryProjectPackage.objects.AdultMember) data.getAllMembers().getFirst();
        member2.setFines(5.00);
        assertTrue(data.payFines(126, 5.00));
        assertEquals(0.00, member2.getFines());

    }
}