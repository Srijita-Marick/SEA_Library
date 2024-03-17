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
     void storeDuplicatePhysicalBooks(){
        Data.reset(); // Clear existing data
        String title = "Atomic Habits";
        String author = "James Clear";
        String genre = "Non-fiction";
        String availabilityStatus = "Unavailable";
        Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        boolean success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);

        title = "Atomic Habits";
        author = "James Clear";
        genre = "Non-fiction";
        availabilityStatus = "Unavailable";
        success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
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
        Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        boolean success = Data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        assertEquals(0,Data.getAllBooks().size());

    }

    /**
     * Creating a temporary library to be used for testing
     */
    @BeforeEach
    void setUpLibrary() {
        Data.reset(); // Clear existing data
        Data.storeNewPhysicalBook("The Blood of Olympus","Rick Riordan","Fantasy","Available");
        Data.storeNewPhysicalBook("Moby Dick","Herman Melville","Literary","Available");
        Data.storeNewPhysicalBook("The Great Gatsby","F. Scott Fitzgerald","Literary","Available");
        Data.storeNewPhysicalBook("Weyward", "Emilia Hart", "Historical Fiction", "Available");
        Data.storeNewPhysicalBook("The Housemaid's Secret", "Freida McFadden", "Thriller", "Available");
        Data.storeNewPhysicalBook("To Kill a Mockingbird", "Harper Lee", "General Fiction", "Available");
        Data.storeNewPhysicalBook("Happy Place","Emily Henry","Romance","Available");
        Data.storeNewPhysicalBook("Hell Bent","Leigh Bardugo","Fantasy","Available");
        Data.storeNewPhysicalBook("In the Lives of Puppets","T.J. Klune","Science Fiction","Available");
        Data.storeNewPhysicalBook("Holly","Stephen King","Horror","Available");
        Data.storeNewPhysicalBook("Joyland","Stephen King","Thriller","Available");
        Data.storeNewPhysicalBook("Poverty, by America","Matthew Desmond","Non-fiction","Available");
        Data.storeNewPhysicalBook("Arsenic and Adobo","Mia P. Manansala","Mystery","Available");
        Data.storeNewPhysicalBook("Joyland","Emily Schultz","Literary","Available");
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
        ArrayList<Books> allBooks = Data.getAllBooks();
        assertEquals(14, allBooks.size());
    }

    @Test
    void testGetAllBooksAndReturnBookInfo(){
        ArrayList<Books> allBooks = Data.getAllBooks();
        Books fourthBook = allBooks.get(3);
        assertEquals("Weyward", fourthBook.getTitle());
        assertEquals("Emilia Hart", fourthBook.getAuthor());
        assertEquals("Historical Fiction", fourthBook.getGenre());
        assertEquals("Available", fourthBook.getAvailabilityStatus());
    }

    @Test
    void testGetAllBooksEmptyLibrary(){
        Data.reset(); // Clear existing data to simulate no books
        ArrayList<Books> allBooks = Data.getAllBooks();
        assertTrue(allBooks.isEmpty());
    }

    @Test
    void testGetAllBooksMatchDetails(){
        ArrayList<Books> allBooks = Data.getAllBooks();
        Books sixthBook = allBooks.get(5);
        assertEquals("To Kill a Mockingbird", sixthBook.getTitle());
        assertEquals("Harper Lee", sixthBook.getAuthor());
        assertEquals("General Fiction", sixthBook.getGenre());
        assertEquals("Available", sixthBook.getAvailabilityStatus());
        Books eighthBook = allBooks.get(7);
        assertEquals("Hell Bent", eighthBook.getTitle());
        assertEquals("Leigh Bardugo", eighthBook.getAuthor());
        assertEquals("Fantasy", eighthBook.getGenre());
        assertEquals("Available", eighthBook.getAvailabilityStatus());
    }

    /**
     * The following function is to test Data.getAvailableBooks
     */
    @Test
    void testGetAllAvailableBooks() {
        ArrayList<Books> allAvailableBooks = Data.getAvailableBooks();
        assertEquals(14, allAvailableBooks.size());

    }

    /**
     * The following function is to test Data.getUnavailableBooks
     */
    @Test
    void testGetUnavailableBooks() {
        Data.reset();
        ArrayList<Books> allUnavailableBooks = Data.getUnavailableBooks();
        assertEquals(0,allUnavailableBooks.size());
    }

    /**
     * The following five functions are to test Data.getBooksByTitle
     * Each checks a variation of title entries and whether they are
     * equivalent to the actual title that is present in the library
     */
    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksWithTitle = Data.getBooksByTitle("Joyland");
        assertEquals(2, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleReturnsCorrectBookInfo() {
        ArrayList<Books> booksWithTitle = Data.getBooksByTitle("The Blood of Olympus");
       Books firstBook = booksWithTitle.get(0);
        assertEquals("The Blood of Olympus", firstBook.getTitle());
        assertEquals("Rick Riordan", firstBook.getAuthor());
        assertEquals("Fantasy", firstBook.getGenre());
        assertEquals("Available", firstBook.getAvailabilityStatus());
    }

    @Test
    public void getBooksByTitleWhenTitleNotFound() {
        ArrayList<Books> booksWithTitle = Data.getBooksByTitle("American Gods");
        assertTrue(booksWithTitle.isEmpty());
    }

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksWithTitle = Data.getBooksByTitle("Poverty, by America");
        assertEquals(1, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleEmptyTitle(){
        ArrayList<Books> booksWithTitle = Data.getBooksByTitle(" ");
        assertTrue(booksWithTitle.isEmpty());
    }

    /**
     * The following five functions are to test Data.getBooksByAuthor
     * Each checks a variation of author name entries and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
    @Test
    void getBooksByAuthorReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksByAuthor = Data.getBooksByAuthor("Stephen King");
        assertEquals(2, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectBookInfo() {
        ArrayList<Books> booksByAuthor = Data.getBooksByAuthor("Emily Henry");
        Books book = booksByAuthor.get(0);
        assertEquals("Happy Place", book.getTitle());
        assertEquals("Emily Henry", book.getAuthor());
        assertEquals("Romance", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByAuthorWhenAuthorNotFound() {
        ArrayList<Books> booksByAuthor = Data.getBooksByAuthor("John Milton");
        assertTrue(booksByAuthor.isEmpty());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksByAuthor = Data.getBooksByAuthor("Freida McFadden");
        assertEquals(1, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorEmptyAuthor(){
        ArrayList<Books> booksByAuthor = Data.getBooksByAuthor(" ");
        assertTrue(booksByAuthor.isEmpty());
    }

    /**
     * The following five functions are to test Data.getBooksByGenre
     * Each checks a variation of genre types and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksByGenre = Data.getBooksByGenre("Fantasy");
        assertEquals(2, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreReturnsCorrectBookInfo() {
        ArrayList<Books> booksByGenre = Data.getBooksByGenre("Literary");
        Books book = booksByGenre.get(1);
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertEquals("Literary", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByGenreWhenNoBooksOfGenre() {
        ArrayList<Books> booksByGenre = Data.getBooksByGenre("Poetry");
        assertTrue(booksByGenre.isEmpty());
    }

    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksByGenre = Data.getBooksByGenre("Literary");
        assertEquals(3, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreWhenGenreNotValid() {
        ArrayList<Books> booksByInvalidGenre = Data.getBooksByGenre("Adventure");
        assertTrue(booksByInvalidGenre.isEmpty());
    }

    /**
     * The following two functions are to test Data.checkoutBook
     */
    @Test
    void checkoutBook() {
        ArrayList<Books> initialAvailableBooks = Data.getAvailableBooks();

        Data.checkoutBook(123, "The Blood of Olympus","Rick Riordan");
        assertFalse(Data.checkBookAvailable( "The Blood of Olympus","Rick Riordan"));

        ArrayList<Books> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void checkoutBookWhenBookDoesNotExist(){
        ArrayList<Books> initialAvailableBooks = Data.getAvailableBooks();
        Data.checkoutBook(103, "The Sea of Monsters","Rick Riordan");
        assertFalse(Data.checkBookAvailable( "The Sea of Monsters","Rick Riordan"));

        ArrayList<Books> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    /**
     * The following two functions are to test Data.returnBook
     */
    @Test
    void returnBook() {
        ArrayList<Books> initialAvailableBooks = Data.getAvailableBooks();

        Data.returnBook(124,"Weyward","Emilia Hart", 5);
        assertTrue(Data.checkBookAvailable("Weyward","Emilia Hart"));

        ArrayList<Books> updatedAvailableBooks = Data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void returnTwoBooks() {
        ArrayList<Books> initialAvailableBooks = Data.getAvailableBooks();

        Data.returnBook(125 ,"To Kill a Mockingbird", "Harper Lee", 7);
        assertTrue(Data.checkBookAvailable("To Kill a Mockingbird", "Harper Lee"));

        Data.returnBook(123,"Joyland","Stephen King",16);
        assertTrue(Data.checkBookAvailable("Joyland","Stephen King"));

        ArrayList<Books> updatedAvailableBooks = Data.getAvailableBooks();
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
    public void testStoreNewAdultMember() {
        assertTrue(Data.storeNewAdultMember(109, "Michael Brown"));
    }

    @Test
    public void testStoreNewAdultMemberAlreadyExists() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Jane Smith");
        Data.storeNewAdultMember(103, "Alice Johnson");
        assertFalse(Data.storeNewAdultMember(101, "John Doe"));
    }

    @Test
    public void testStoreNewAdultMemberAndCheckExistence() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Jane Smith");
        Data.storeNewAdultMember(103, "Alice Johnson");
        Data.storeNewAdultMember(104, "Michael Brown");
        assertTrue(Data.storeNewAdultMember(105, "Emily White"));
    }

    /**
     * Creating a temporary member list to be used for testing
     */
    @BeforeEach
    void setUpMemberData() {
        Data.storeNewAdultMember(101, "Arman Najari");
        Data.storeNewAdultMember(102, "Himanshu Ganga");
        Data.storeNewAdultMember(103, "The Webster");
        Data.storeNewAdultMember(104, "Alice Wonderland");
        Data.storeNewAdultMember(105, "Brad Pitt");
        Data.storeNewAdultMember(106, "Naruto Uzumaki");
        Data.storeNewAdultMember(107, "Jackie Chan");
        Data.storeNewAdultMember(108, "Michelle Yeoh");
    }
    /**
     * The following functions are to test checkExistMember
     */
    @Test
    public void testCheckExistAdultMemberWhenAdultMemberExists() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "Arman Najari");
        Data.storeNewAdultMember(102, "Himanshu Ganga");
        Data.storeNewAdultMember(103, "The Webster");
        assertTrue(Data.checkExistMember(101));
    }

    @Test
    public void testCheckExistAdultMemberWhenAdultMemberDoesNotExist() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "Arman Najari");
        Data.storeNewAdultMember(102, "Himanshu Ganga");
        Data.storeNewAdultMember(103, "The Webster");
        assertFalse(Data.checkExistMember(100));
    }

    /**
     * The following five functions are to test Data.removeMember
     * Each checks a different variation of true returns, false returns,
     * and checking to see if the member has actually been removed
     */
    @Test
    void testRemoveAdultMemberThatDoesntExist() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Jane Smith");
        Data.storeNewAdultMember(103, "Alice Johnson");

        assertFalse(Data.removeMember(100,"Anna"));
    }

    @Test
    void testRemoveAdultMemberThatDoesExist() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Jane Smith");
        Data.storeNewAdultMember(103, "Alice Johnson");

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
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Himanshu Ganga");
        Data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(Data.removeMember(102,"Anna"));
    }

    @Test
    void testRemoveAdultMemberWhenNameExistsButIdDoesNot() {
        Data.reset(); // Clear existing data
        Data.storeNewAdultMember(101, "John Doe");
        Data.storeNewAdultMember(102, "Himanshu Ganga");
        Data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(Data.removeMember(100,"Himanshu Ganga"));
    }

    /**
     * The following function is used to test Data.getAllMembers
     */
    @Test
    void getAllMembers() {
        Data.reset();
        Data.storeNewAdultMember(111, "Axelle Leung");
        Data.storeNewAdultMember(112, "Rachel Lam");
        Data.storeNewAdultMember(113, "Dhana Ramsamy");
        Data.storeNewAdultMember(114, "Emma Stone");
        Data.storeNewChildMember(115, "Elizabeth Roberts");
        Data.storeNewChildMember(116, "Rose Evans");
        Data.storeNewChildMember(117, "Jack Smith");
        Data.storeNewChildMember(118, "James Johnson");

        ArrayList<Member> allMembers = Data.getAllMembers();
        assertEquals(8, allMembers.size());
    }

    /**
     * The following three functions are used to test Data.getBorrowedBooks
     * Each checks a variation of books to be borrowed and whether the book
     * status has been updated accordingly
     */
    @Test
    void testGetBorrowedBooks() {
        Data.storeNewPhysicalBook("Nightcrawling", "Leila Mottley", "Literary", "Unavailable");
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
        ArrayList<Member> membersByName = Data.getMembersByName("Michelle Yeoh");
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
        ArrayList<Member> membersByName = Data.getMembersByName("The Webster");
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