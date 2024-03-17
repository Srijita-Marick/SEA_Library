import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    /**
     * The following five functions are to test Data.storeNewBook
     * Each checks a different way in which we can save books to the Library
     * and checking to see if the book has been saved with the correct details
     */
    @Test
    void storeNewPhysicalBook() {
        Data.reset(); // Clear existing data
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook = Data.getAllBooks().get(0);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, newBook.getTitle());
        assertEquals(author, newBook.getAuthor());
        assertEquals(genre, newBook.getGenre());
        assertEquals(availabilityStatus,newBook.getAvailabilityStatus());
    }
    @Test
    void storeTwoPhysicalBooks() {
        Data.reset(); // Clear existing data
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook1 = Data.getAllBooks().get(0);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, newBook1.getTitle());
        assertEquals(author, newBook1.getAuthor());
        assertEquals(genre, newBook1.getGenre());
        assertEquals(availabilityStatus,newBook1.getAvailabilityStatus());

        title = "Pride and Prejudice";
        author = "Jane Austen";
        genre = "Romance";
        availabilityStatus = "Available";
        success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook2 = Data.getAllBooks().get(1);
        assertEquals(2, Data.getAllBooks().size());
        assertEquals(title, newBook2.getTitle());
        assertEquals(author, newBook2.getAuthor());
        assertEquals(genre, newBook2.getGenre());
        assertEquals(availabilityStatus,newBook2.getAvailabilityStatus());
    }

    @Test
    void storeTwoPhysicalBooksSameAuthor() {
        Data.reset(); // Clear existing data
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, Data.getAllBooks().size());
        boolean success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books book1  = Data.getAllBooks().get(0);
        assertEquals(1, Data.getAllBooks().size());
        assertEquals(title, book1.getTitle());
        assertEquals(author, book1.getAuthor());
        assertEquals(genre, book1.getGenre());
        assertEquals(availabilityStatus,book1.getAvailabilityStatus());

        title = "Harry Potter and the Chamber of Secrets";
        author = "J.K. Rowling";
        genre = "Fantasy";
        availabilityStatus = "Available";
        success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books book2 = Data.getAllBooks().get(1);
        assertEquals(2, Data.getAllBooks().size());
        assertEquals(title, book2.getTitle());
        assertEquals(author, book2.getAuthor());
        assertEquals(genre, book2.getGenre());
        assertEquals(availabilityStatus,book2.getAvailabilityStatus());
    }
    @Test
     void storeDuplicateBooks(){
        Data.reset(); // Clear existing data
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
        assertFalse(success);
        assertEquals(1,Data.getAllBooks().size());
    }

    @Test
     void storeEmptyTitle(){
        Data.reset(); // Clear existing data
        String title = "";
        String author = "Mary Shelley";
        String genre = "Horror";
        String availabilityStatus = "Unavailable";
        Data.storeNewBook(title, author, genre, availabilityStatus);
        boolean success = Data.storeNewBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        assertEquals(0,Data.getAllBooks().size());

    }

    /**
     * Creating a temporary library to be used for testing
     */
    @BeforeEach
    void setUpLibrary() {
        Data.reset(); // Clear existing data
        Data.storeNewBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        Data.storeNewBook("Moby Dick","Herman Melville","Literary","Available");
        Data.storeNewBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        Data.storeNewBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        Data.storeNewBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        Data.storeNewBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        Data.storeNewBook("Happy Place","Emily Henry","Romance","Available");
        Data.storeNewBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        Data.storeNewBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        Data.storeNewBook("Holly","Stephen King","Horror","Available");
        Data.storeNewBook("Joyland","Stephen King","Thriller","Available");
        Data.storeNewBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        Data.storeNewBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        Data.storeNewBook("Joyland","Emily Schultz","Literary","Available");
    }

    /**
     * The following five functions are to test Data.checkExistBook
     * Each checks a variation of books, and whether the function returns t
     * rue or false according to the existence of the book in the setup Library
     */
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

    /**
     * The following five functions are to test Data.checkBookAvailable
     * Each checks a variation of availability statuses for a book in the setup
     * Library and checks whether the function returns true or false accordingly
     */
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

    /**
     * The following four functions are to test Data.getAllBooks
     * Each checks a variation of books that have been stored in the main Library
     * and whether the values are equivalent to the expected ones
     */
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

    /**
     * The following function is to test Data.getAvailableBooks
     */
    @Test
    void testGetAllAvailableBooks() {
        ArrayList<Object[]> allAvailableBooks = Data.getAvailableBooks();
        assertEquals(14, allAvailableBooks.size());

    }

    /**
     * The following function is to test Data.getUnavailableBooks
     */
    @Test
    void testGetUnavailableBooks() {
        Data.reset();
        ArrayList<Object[]> allUnavailableBooks = Data.getUnavailableBooks();
        assertEquals(0,allUnavailableBooks.size());
    }

    /**
     * The following five functions are to test Data.getBooksByTitle
     * Each checks a variation of title entries and whether they are
     * equivalent to the actual title that is present in the library
     */
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
        assertEquals("Available", firstBook[Data.INDEX_STATUS]);
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

    /**
     * The following five functions are to test Data.getBooksByAuthor
     * Each checks a variation of author name entries and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
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
        assertEquals("Available", book[Data.INDEX_STATUS]);
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

    /**
     * The following five functions are to test Data.getBooksByGenre
     * Each checks a variation of genre types and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
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

    /**
     * The following two functions are to test Data.checkoutBook
     */
    @Test
    void checkoutBook() {
        ArrayList<Object[]> initialAvailableBooks = Data.getAvailableBooks();

        Data.checkoutBook(123, "The Blood of Olympus","Rick Riordan");
        assertFalse(Data.checkBookAvailable( "The Blood of Olympus","Rick Riordan"));

        ArrayList<Object[]> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void checkoutBookWhenBookDoesNotExist(){
        ArrayList<Object[]> initialAvailableBooks = Data.getAvailableBooks();
        Data.checkoutBook(103, "The Sea of Monsters","Rick Riordan");
        assertFalse(Data.checkBookAvailable( "The Sea of Monsters","Rick Riordan"));

        ArrayList<Object[]> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    /**
     * The following two functions are to test Data.returnBook
     */
    @Test
    void returnBook() {
        ArrayList<Object[]> initialAvailableBooks = Data.getAvailableBooks();

        Data.returnBook(124,"Weyward","Emilia Hart", 5);
        assertTrue(Data.checkBookAvailable("Weyward","Emilia Hart"));

        ArrayList<Object[]> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void returnTwoBooks() {
        ArrayList<Object[]> initialAvailableBooks = Data.getAvailableBooks();

        Data.returnBook(125 ,"To Kill a Mockingbird", "Harper Lee", 7);
        assertTrue(Data.checkBookAvailable("To Kill a Mockingbird", "Harper Lee"));

        Data.returnBook(123,"Joyland","Stephen King",16);
        assertTrue(Data.checkBookAvailable("Joyland","Stephen King"));

        ArrayList<Object[]> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    /**
     * The following three functions are to test Data.removeBook
     * Each checks a variation of books that can be removed from the Library
     */
    @Test
    void removeBook() {
        assertTrue(Data.removeBook("Moby Dick","Herman Melville"));
    }

    @Test
    void removeTwoBooks() {
        assertTrue(Data.removeBook("Arsenic and Adobo","Mia P. Manansala"));
        assertTrue(Data.removeBook("Happy Place","Emily Henry"));
    }

    @Test
    void removeNonExistingBook() {
        assertFalse(Data.removeBook("No Man is an Island","John Donne"));
    }

    /**
     * The following three functions are to test Data.storeNewMember
     * Each checks a variation of member entries and whether it has been stored
     * properly in the Library's main member list
     */
    @Test
    public void testStoreNewMember() {
        assertTrue(Data.storeNewMember(109, "Michael Brown"));
    }

    @Test
    public void testStoreNewMemberAlreadyExists() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Jane Smith");
        Data.storeNewMember(103, "Alice Johnson");
        assertFalse(Data.storeNewMember(101, "John Doe"));
    }

    @Test
    public void testStoreNewMemberAndCheckExistence() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Jane Smith");
        Data.storeNewMember(103, "Alice Johnson");
        Data.storeNewMember(104, "Michael Brown");
        assertTrue(Data.storeNewMember(105, "Emily White"));
    }

    /**
     * Creating a temporary member list to be used for testing
     */
    @BeforeEach
    void setUpMemberData() {
        Data.storeNewMember(101, "Arman Najari");
        Data.storeNewMember(102, "Himanshu Ganga");
        Data.storeNewMember(103, "The Webster");
        Data.storeNewMember(104, "Alice Wonderland");
        Data.storeNewMember(105, "Brad Pitt");
        Data.storeNewMember(106, "Naruto Uzumaki");
        Data.storeNewMember(107, "Jackie Chan");
        Data.storeNewMember(108, "Michelle Yeoh");
    }
    /**
     * The following functions are to test checkExistMember
     */
    @Test
    public void testCheckExistMemberWhenMemberExists() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "Arman Najari");
        Data.storeNewMember(102, "Himanshu Ganga");
        Data.storeNewMember(103, "The Webster");
        assertTrue(Data.checkExistMember(101));
    }

    @Test
    public void testCheckExistMemberWhenMemberDoesNotExist() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "Arman Najari");
        Data.storeNewMember(102, "Himanshu Ganga");
        Data.storeNewMember(103, "The Webster");
        assertFalse(Data.checkExistMember(100));
    }

    /**
     * The following five functions are to test Data.removeMember
     * Each checks a different variation of true returns, false returns,
     * and checking to see if the member has actually been removed
     */
    @Test
    void testRemoveMemberThatDoesntExist() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Jane Smith");
        Data.storeNewMember(103, "Alice Johnson");

        assertFalse(Data.removeMember(100,"Anna"));
    }

    @Test
    void testRemoveMemberThatDoesExist() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Jane Smith");
        Data.storeNewMember(103, "Alice Johnson");

        assertTrue(Data.removeMember(101,"John Doe")&&!Data.memberIDs.containsKey(101));
        //removeMember should return false, and 101 should no longer be part of memberIDS
    }

    @Test
    void testRemoveMemberWhenThereAreNoMembers() {
        Data.reset(); // Clear existing data
        assertFalse(Data.removeMember(100,"Anna"));
    }

    @Test
    void testRemoveMemberWhenIdExistsButNameDoesNot() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Himanshu Ganga");
        Data.storeNewMember(103, "Parker Gueth");

        assertFalse(Data.removeMember(102,"Anna"));
    }

    @Test
    void testRemoveMemberWhenNameExistsButIdDoesNot() {
        Data.reset(); // Clear existing data
        Data.storeNewMember(101, "John Doe");
        Data.storeNewMember(102, "Himanshu Ganga");
        Data.storeNewMember(103, "Parker Gueth");

        assertFalse(Data.removeMember(100,"Himanshu Ganga"));
    }

    /**
     * The following function is used to test Data.getAllMembers
     */
    @Test
    void getAllMembers() {
        Data.reset();
        Data.storeNewMember(111, "Axelle Leung");
        Data.storeNewMember(112, "Rachel Lam");
        Data.storeNewMember(113, "Dhana Ramsamy");
        Data.storeNewMember(114, "Emma Stone");

        ArrayList<Object[]> allMembers = Data.getAllMembers();
        assertEquals(4, allMembers.size());
    }

    /**
     * The following three functions are used to test Data.getBorrowedBooks
     * Each checks a variation of books to be borrowed and whether the book
     * status has been updated accordingly
     */
    @Test
    void testGetBorrowedBooks() {
        Data.storeNewBook("Nightcrawling", "Leila Mottley", "Literary", "Unavailable");
        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(1);
        assertTrue(borrowedBooks.isEmpty());
        Data.reset();
    }

    @Test
    public void testGetBorrowedBooksOneBook() {
        Data.checkoutBook(103, "Holly", "Stephen King");
        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(103);
        assertEquals(1, borrowedBooks.size());
        assertTrue(borrowedBooks.contains("Holly by Stephen King"));
        Data.reset(); //make sure nothing changes
    }

    @Test
    public void testGetBorrowedBooksNoBooksBorrowed() {
        ArrayList<String> borrowedBooks = Data.getBorrowedBooks(101);
        assertTrue(borrowedBooks.isEmpty());
    }

    /**
     * The following four functions are to test Data.getMembersByName
     * Each checks a different way in which we can get members by Name only
     */
    @Test
    void testGetMembersByName(){
        ArrayList<Object[]> membersByName = Data.getMembersByName("Michelle Yeoh");
        assertEquals(1, membersByName.size());
    }

    @Test
    void testGetMembersByNameReturnMemberInfo(){
        ArrayList<Object[]> membersByName = Data.getMembersByName("Alice Wonderland");
        assertEquals(1, membersByName.size());
        Object[] member = membersByName.get(0);
        assertEquals(104,member[Data.INDEX_ID]);
        assertEquals("Alice Wonderland",member[Data.INDEX_NAME]);
    }

    @Test
    void testGetMembersByNameThreeMembers(){
        ArrayList<Object[]> membersByName = Data.getMembersByName("The Webster");
        assertEquals(1, membersByName.size());
        ArrayList<Object[]> membersByName1 = Data.getMembersByName("Himanshu Ganga");
        assertEquals(1, membersByName1.size());
        ArrayList<Object[]> membersByName2 = Data.getMembersByName("Jackie Chan");
        assertEquals(1, membersByName2.size());
    }

    @Test
    void testGetMembersByNameNoName(){
        ArrayList<Object[]> membersByName = Data.getMembersByName(" ");
        assertEquals(0, membersByName.size());
    }

    /**
     * The following three functions are to test Data.getMembersById
     * Each checks a different way in which we can get members by Id only
     */
    @Test
    void testGetMembersById(){
        Data.reset();
        ArrayList<Object[]> membersById = Data.getMembersById(101);
        assertEquals(0, membersById.size());
    }

    @Test
    void testGetMembersByIdReturnMemberInfo(){
        ArrayList<Object[]> members = Data.getMembersById(105);
        assertEquals(1, members.size());
        Object[] member = members.get(0);
        assertEquals(105, member[Data.INDEX_ID]);
        assertEquals("Brad Pitt", member[Data.INDEX_NAME]);
    }

    @Test
    void testGetMembersByIdTwoMembers(){
        ArrayList<Object[]> membersById = Data.getMembersById(101);
        assertEquals(1, membersById.size());
        ArrayList<Object[]> membersById1 = Data.getMembersById(103);
        assertEquals(1, membersById1.size());
    }

    /**
     * The following four functions are to test Data.calculateFines
     * Each checks a different way in which we can correctly calculate fines for a given overdue period
     */
    @Test
    void testCalculateFines(){
        assertEquals(0.0, Data.calculateFines(0));
    }

    @Test
    void testCalculateFinesOneDayOverdue() {
        assertEquals(0.05, Data.calculateFines(1));
    }

    @Test
    void testCalculateFinesMultipleDaysOverdue() {
        assertEquals(1.0, Data.calculateFines(20));
    }

    @Test
    void testCalculateFinesBigOverdue() {
        assertEquals(4.5, Data.calculateFines(90));
    }

    /**
     * The following tests are for Data.payFines
     * Each looks at a different ratio of payment to fines owed (>,=,<)
     */
    @Test
    void testPayFinesWhenPaymentGreaterThanFinesOwed() {
        Data.checkoutBook(101,"Moby Dick","Herman Melville");
        Data.returnBook(101,"Moby Dick","Herman Melville",90);
        assertFalse(Data.payFines(101,4.6));
    }
    @Test
    void testPayFinesWhenPaymentIsLessThanFinesOwed() {
        Data.members.get(0)[Data.INDEX_FINES] = 10.00;
        assertTrue(Data.payFines(101,5.00));
        assertEquals(5.00,Data.members.get(0)[Data.INDEX_FINES]);
        Data.reset();
    }
    @Test
    void testPayFinesWhenPaymentIsEqualToFinesOwed() {
        Data.members.get(0)[Data.INDEX_FINES] = 5.00;
        assertTrue(Data.payFines(101,5.00));
        assertEquals(0.00,Data.members.get(0)[Data.INDEX_FINES]);
        Data.reset();
    }
}