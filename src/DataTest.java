import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @BeforeEach
    public void setUpLibrary() {
        Data.reset(); // Clear existing data
        Data.storeNewBook("The Blood of Olympus","Rick Riordan","Fantasy","Unavailable");
        Data.storeNewBook("Moby Dick","Herman Melville","Literary","Available");
        Data.storeNewBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        Data.storeNewBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        Data.storeNewBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Unavailable");
        Data.storeNewBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        Data.storeNewBook("Happy Place","Emily Henry","Romance","Unavailable");
        Data.storeNewBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        Data.storeNewBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Unavailable");
        Data.storeNewBook("Holly","Stephen King","Horror","Available");
        Data.storeNewBook("Poverty, by America","Matthew Desmond","Non-fiction","Unavailable");
        Data.storeNewBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
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
    }

    @Test
    void testGetAllBooks() {
        ArrayList<Object[]> allBooks = Data.getAllBooks();
        assertEquals(12, allBooks.size());
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
    void testGetAllBooks2(){

    }
    @Test
    void testGetAvailableBooks() {
    }

    @Test
    void testGetUnavailableBooks() {
    }

    @Test
    void getBooksByTitle() {
    }

    @Test
    void getBooksByAuthor() {
    }

    @Test
    void getBooksByGenre() {
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
    void testStoreNewMember() {
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