import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @org.junit.jupiter.api.Test
    void testStoreNewBook() {
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
    void testStoreTwoBooks() {
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

    @Test
    void checkExistBook() {
        Data.reset();
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String genre = "Literary";
        String availabilityStatus = "Available";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        title = "Moby Dick";
        author = "Herman Melville";
        genre = "Literary";
        availabilityStatus = "Available";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        assertTrue(Data.checkExistBook("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @Test
    void checkBookDoesNotExist(){
        Data.reset();
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String genre = "General Fiction";
        String availabilityStatus = "Available";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        title = "1984";
        author = "George Orwell";
        genre = "Science Fiction";
        availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        assertFalse(Data.checkExistBook("The Catcher in the Rye", "J.D. Salinger"));
    }

    @Test
    void checkExistBookAuthorMismatch(){
        Data.reset();
        String title = "The Da Vinci Code";
        String author = "Dan Brown";
        String genre = "Mystery";
        String availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        title = "The Hobbit";
        author = "J.R.R. Tolkien";
        genre = "Fantasy";
        availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        title = "Dracula";
        author = "Bram Stoker";
        genre = "Horror";
        availabilityStatus = "Available";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        assertFalse(Data.checkExistBook("Dracula", "J.K. Rowling"));
    }

    @Test
    void checkExistBookEmptyTitleAndAuthor(){
        Data.reset();
        String title = "The Girl with the Dragon Tattoo";
        String author = "Stieg Larsson";
        String genre = "Mystery";
        String availabilityStatus = "Available";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        title = "The Help";
        author = "Kathryn Stockett";
        genre = "Historical Fiction";
        availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        assertFalse(Data.checkExistBook(" ", " "));
    }
    @Test
    void checkBookAvailable() {
    }

    @Test
    void testGetAllBooks() {
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