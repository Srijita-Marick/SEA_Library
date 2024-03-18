import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @Test
    void madAnnaDeleteLater() {
    }
}/*
    private Data data;
    @BeforeEach
    void Refresh(){
        data = new Data();
    }

    /**
     * The following five functions are to test data.storeNewBook
     * Each checks a different way in which we can save books to the Library
     * and checking to see if the book has been saved with the correct details
     */
    /*
    @Test
    void storeNewPhysicalBook() {
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook = data.getAllBooks().get(0);
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, newBook.getTitle());
        assertEquals(author, newBook.getAuthor());
        assertEquals(genre, newBook.getGenre());
        assertEquals(availabilityStatus,newBook.getAvailabilityStatus());
    }
    @Test
    void storeTwoPhysicalBooks() {
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook1 = data.getAllBooks().get(0);
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, newBook1.getTitle());
        assertEquals(author, newBook1.getAuthor());
        assertEquals(genre, newBook1.getGenre());
        assertEquals(availabilityStatus,newBook1.getAvailabilityStatus());

        title = "Pride and Prejudice";
        author = "Jane Austen";
        genre = "Romance";
        availabilityStatus = "Available";
        success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books newBook2 = data.getAllBooks().get(1);
        assertEquals(2, data.getAllBooks().size());
        assertEquals(title, newBook2.getTitle());
        assertEquals(author, newBook2.getAuthor());
        assertEquals(genre, newBook2.getGenre());
        assertEquals(availabilityStatus,newBook2.getAvailabilityStatus());
    }

    @Test
    void storeTwoPhysicalBooksSameAuthor() {
        String title = "Harry Potter and the Sorcerer's Stone";
        String author = "J.K. Rowling";
        String genre = "Fantasy";
        String availabilityStatus = "Available";
        assertEquals(0, data.getAllBooks().size());
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books book1  = data.getAllBooks().get(0);
        assertEquals(1, data.getAllBooks().size());
        assertEquals(title, book1.getTitle());
        assertEquals(author, book1.getAuthor());
        assertEquals(genre, book1.getGenre());
        assertEquals(availabilityStatus,book1.getAvailabilityStatus());

        title = "Harry Potter and the Chamber of Secrets";
        author = "J.K. Rowling";
        genre = "Fantasy";
        availabilityStatus = "Available";
        success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertTrue(success);

        Books book2 = data.getAllBooks().get(1);
        assertEquals(2, data.getAllBooks().size());
        assertEquals(title, book2.getTitle());
        assertEquals(author, book2.getAuthor());
        assertEquals(genre, book2.getGenre());
        assertEquals(availabilityStatus,book2.getAvailabilityStatus());
    }
    @Test
     void storeDuplicatePhysicalBooks(){
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
        assertEquals(1,data.getAllBooks().size());
    }

    @Test
     void storeEmptyTitle(){
        String title = "";
        String author = "Mary Shelley";
        String genre = "Horror";
        String availabilityStatus = "Unavailable";
        data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        boolean success = data.storeNewPhysicalBook(title, author, genre, availabilityStatus);
        assertFalse(success);
        assertEquals(0,data.getAllBooks().size());

    }

    /**
     * Creating a temporary library to be used for testing
     */
    /*
    @BeforeEach
    void setUpLibrary() {
        data.reset(); // Clear existing data
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
    }

    /**
     * The following five functions are to test data.checkExistBook
     * Each checks a variation of books, and whether the function returns t
     * rue or false according to the existence of the book in the setup Library
     */
    /*
    @Test
    void checkExistBook() {
        assertTrue(data.checkExistBook("The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @Test
    void checkBookDoesNotExist(){
        assertFalse(data.checkExistBook("The Catcher in the Rye", "J.D. Salinger"));
    }

    @Test
    void checkExistBookAuthorMismatch(){
        assertFalse(data.checkExistBook("Holly", "J.K. Rowling"));
    }

    @Test
    void checkExistBookEmptyTitleAndAuthor(){
        assertFalse(data.checkExistBook(" ", " "));
    }

    @Test
    void checkExistBookTitleWithNullAuthor(){
        assertFalse(data.checkExistBook("The Blood of Olympus", null));
    }

    /**
     * The following five functions are to test data.checkBookAvailable
     * Each checks a variation of availability statuses for a book in the setup
     * Library and checks whether the function returns true or false accordingly
     */
    /*
    @Test
    void checkBookAvailable() {
        assertTrue(data.checkBookAvailable("Hell Bent","Leigh Bardugo"));
    }

    @Test
    void checkBookUnavailable(){
        assertTrue(data.checkBookAvailable("In the Lives of Puppets","T.J. Klune"));
    }

    @Test
    void checkBookAvailableTitleWithNullAuthor(){
        assertFalse(data.checkBookAvailable("Joyland",null));
    }

    @Test
    void checkBookAvailableEmptyTitle(){
        assertFalse(data.checkBookAvailable(" ", "Emilia Hart"));
    }

    @Test
    void checkBookAvailableCaseSensitivity(){
        assertFalse(data.checkBookAvailable("TO KILL A MOCKINGBIRD", "HARPER LEE"));
    }

    /**
     * The following four functions are to test data.getAllBooks
     * Each checks a variation of books that have been stored in the main Library
     * and whether the values are equivalent to the expected ones
     */
    /*
    @Test
    void testGetAllBooks() {
        ArrayList<Books> allBooks = data.getAllBooks();
        assertEquals(14, allBooks.size());
    }

    @Test
    void testGetAllBooksAndReturnBookInfo(){
        ArrayList<Books> allBooks = data.getAllBooks();
        Books fourthBook = allBooks.get(3);
        assertEquals("Weyward", fourthBook.getTitle());
        assertEquals("Emilia Hart", fourthBook.getAuthor());
        assertEquals("Historical Fiction", fourthBook.getGenre());
        assertEquals("Available", fourthBook.getAvailabilityStatus());
    }

    @Test
    void testGetAllBooksEmptyLibrary(){
        data.reset(); // Clear existing data to simulate no books
        ArrayList<Books> allBooks = data.getAllBooks();
        assertTrue(allBooks.isEmpty());
    }

    @Test
    void testGetAllBooksMatchDetails(){
        ArrayList<Books> allBooks = data.getAllBooks();
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
     * The following function is to test data.getAvailableBooks
     */
    /*
    @Test
    void testGetAllAvailableBooks() {
        ArrayList<Books> allAvailableBooks = data.getAvailableBooks();
        assertEquals(14, allAvailableBooks.size());

    }

    /**
     * The following function is to test data.getUnavailableBooks
     */
    /*
    @Test
    void testGetUnavailableBooks() {
        data.reset();
        ArrayList<Books> allUnavailableBooks = data.getUnavailableBooks();
        assertEquals(0,allUnavailableBooks.size());
    }

    /**
     * The following five functions are to test data.getBooksByTitle
     * Each checks a variation of title entries and whether they are
     * equivalent to the actual title that is present in the library
     */
    /*
    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksWithTitle = data.getBooksByTitle("Joyland");
        assertEquals(2, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleReturnsCorrectBookInfo() {
        ArrayList<Books> booksWithTitle = data.getBooksByTitle("The Blood of Olympus");
       Books firstBook = booksWithTitle.get(0);
        assertEquals("The Blood of Olympus", firstBook.getTitle());
        assertEquals("Rick Riordan", firstBook.getAuthor());
        assertEquals("Fantasy", firstBook.getGenre());
        assertEquals("Available", firstBook.getAvailabilityStatus());
    }

    @Test
    public void getBooksByTitleWhenTitleNotFound() {
        ArrayList<Books> booksWithTitle = data.getBooksByTitle("American Gods");
        assertTrue(booksWithTitle.isEmpty());
    }

    @Test
    public void getBooksByTitleReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksWithTitle = data.getBooksByTitle("Poverty, by America");
        assertEquals(1, booksWithTitle.size());
    }

    @Test
    public void getBooksByTitleEmptyTitle(){
        ArrayList<Books> booksWithTitle = data.getBooksByTitle(" ");
        assertTrue(booksWithTitle.isEmpty());
    }

    /**
     * The following five functions are to test data.getBooksByAuthor
     * Each checks a variation of author name entries and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
    /*
    @Test
    void getBooksByAuthorReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksByAuthor = data.getBooksByAuthor("Stephen King");
        assertEquals(2, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectBookInfo() {
        ArrayList<Books> booksByAuthor = data.getBooksByAuthor("Emily Henry");
        Books book = booksByAuthor.get(0);
        assertEquals("Happy Place", book.getTitle());
        assertEquals("Emily Henry", book.getAuthor());
        assertEquals("Romance", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByAuthorWhenAuthorNotFound() {
        ArrayList<Books> booksByAuthor = data.getBooksByAuthor("John Milton");
        assertTrue(booksByAuthor.isEmpty());
    }

    @Test
    public void getBooksByAuthorReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksByAuthor = data.getBooksByAuthor("Freida McFadden");
        assertEquals(1, booksByAuthor.size());
    }

    @Test
    public void getBooksByAuthorEmptyAuthor(){
        ArrayList<Books> booksByAuthor = data.getBooksByAuthor(" ");
        assertTrue(booksByAuthor.isEmpty());
    }

    /**
     * The following five functions are to test data.getBooksByGenre
     * Each checks a variation of genre types and whether they are
     * equivalent to the details of the actual book that is present in the library
     */
    /*
    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks() {
        ArrayList<Books> booksByGenre = data.getBooksByGenre("Fantasy");
        assertEquals(2, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreReturnsCorrectBookInfo() {
        ArrayList<Books> booksByGenre = data.getBooksByGenre("Literary");
        Books book = booksByGenre.get(1);
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertEquals("Literary", book.getGenre());
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    public void getBooksByGenreWhenNoBooksOfGenre() {
        ArrayList<Books> booksByGenre = data.getBooksByGenre("Poetry");
        assertTrue(booksByGenre.isEmpty());
    }

    @Test
    public void getBooksByGenreReturnsCorrectNumberOfBooks1(){
        ArrayList<Books> booksByGenre = data.getBooksByGenre("Literary");
        assertEquals(3, booksByGenre.size());
    }

    @Test
    public void getBooksByGenreWhenGenreNotValid() {
        ArrayList<Books> booksByInvalidGenre = data.getBooksByGenre("Adventure");
        assertTrue(booksByInvalidGenre.isEmpty());
    }

    /**
     * The following two functions are to test data.checkoutBook
     */

    /*
    @Test
    void checkoutBook() {
        ArrayList<Books> initialAvailableBooks = data.getAvailableBooks();

        data.checkoutBook(123, "The Blood of Olympus","Rick Riordan");
        assertFalse(data.checkBookAvailable( "The Blood of Olympus","Rick Riordan"));

        ArrayList<Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void checkoutBookWhenBookDoesNotExist(){
        ArrayList<Books> initialAvailableBooks = data.getAvailableBooks();
        data.checkoutBook(103, "The Sea of Monsters","Rick Riordan");
        assertFalse(data.checkBookAvailable( "The Sea of Monsters","Rick Riordan"));

        ArrayList<Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    /**
     * The following two functions are to test data.returnBook
     */

    /*
    @Test
    void returnBook() {
        ArrayList<Books> initialAvailableBooks = data.getAvailableBooks();

        data.returnBook(124,"Weyward","Emilia Hart", 5);
        assertTrue(data.checkBookAvailable("Weyward","Emilia Hart"));

        ArrayList<Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    @Test
    void returnTwoBooks() {
        ArrayList<Books> initialAvailableBooks = data.getAvailableBooks();

        data.returnBook(125 ,"To Kill a Mockingbird", "Harper Lee", 7);
        assertTrue(data.checkBookAvailable("To Kill a Mockingbird", "Harper Lee"));

        data.returnBook(123,"Joyland","Stephen King",16);
        assertTrue(data.checkBookAvailable("Joyland","Stephen King"));

        ArrayList<Books> updatedAvailableBooks = data.getAvailableBooks();
        assertEquals(initialAvailableBooks.size() , updatedAvailableBooks.size());
    }

    /**
     * The following three functions are to test data.removeBook
     * Each checks a variation of books that can be removed from the Library
     */

    /*
    @Test
    void removeBook() {
        assertTrue(data.removeBook("Moby Dick","Herman Melville"));
    }

    @Test
    void removeTwoBooks() {
        assertTrue(data.removeBook("Arsenic and Adobo","Mia P. Manansala"));
        assertTrue(data.removeBook("Happy Place","Emily Henry"));
    }

    @Test
    void removeNonExistingBook() {
        assertFalse(data.removeBook("No Man is an Island","John Donne"));
    }

    /**
     * The following three functions are to test data.storeNewMember
     * Each checks a variation of member entries and whether it has been stored
     * properly in the Library's main member list
     */

    /*
    @Test
    public void testStoreNewAdultMember() {
        assertTrue(data.storeNewAdultMember(109, "Michael Brown"));
    }

    @Test
    public void testStoreNewAdultMemberAlreadyExists() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");
        assertFalse(data.storeNewAdultMember(101, "John Doe"));
    }

    @Test
    public void testStoreNewAdultMemberAndCheckExistence() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");
        data.storeNewAdultMember(104, "Michael Brown");
        assertTrue(data.storeNewAdultMember(105, "Emily White"));
    }

    /**
     * Creating a temporary member list to be used for testing
     */

    /*
    @BeforeEach
    void setUpMemberData() {
        data.storeNewAdultMember(101, "Arman Najari");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "The Webster");
        data.storeNewAdultMember(104, "Alice Wonderland");
        data.storeNewAdultMember(105, "Brad Pitt");
        data.storeNewAdultMember(106, "Naruto Uzumaki");
        data.storeNewAdultMember(107, "Jackie Chan");
        data.storeNewAdultMember(108, "Michelle Yeoh");
    }
    /**
     * The following functions are to test checkExistMember
     */
    /*
    @Test
    public void testCheckExistAdultMemberWhenAdultMemberExists() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "Arman Najari");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "The Webster");
        assertTrue(data.checkExistMember(101));
    }

    @Test
    public void testCheckExistAdultMemberWhenAdultMemberDoesNotExist() {
        data.reset(); // Clear existing data
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
    /*
    @Test
    void testRemoveAdultMemberThatDoesntExist() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");

        assertFalse(data.removeMember(100,"Anna"));
    }

    @Test
    void testRemoveAdultMemberThatDoesExist() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Jane Smith");
        data.storeNewAdultMember(103, "Alice Johnson");

        assertTrue(data.removeMember(101,"John Doe")&&!data.memberIDs.containsKey(101));
        //removeMember should return false, and 101 should no longer be part of memberIDS
    }

    @Test
    void testRemoveMemberWhenThereAreNoMembers() {
        data.reset(); // Clear existing data
        assertFalse(data.removeMember(100,"Anna"));
    }

    @Test
    void testRemoveMemberWhenIdExistsButNameDoesNot() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(data.removeMember(102,"Anna"));
    }

    @Test
    void testRemoveAdultMemberWhenNameExistsButIdDoesNot() {
        data.reset(); // Clear existing data
        data.storeNewAdultMember(101, "John Doe");
        data.storeNewAdultMember(102, "Himanshu Ganga");
        data.storeNewAdultMember(103, "Parker Gueth");

        assertFalse(data.removeMember(100,"Himanshu Ganga"));
    }

    /**
     * The following function is used to test data.getAllMembers
     */
    /*
    @Test
    void getAllMembers() {
        data.reset();
        data.storeNewAdultMember(111, "Axelle Leung");
        data.storeNewAdultMember(112, "Rachel Lam");
        data.storeNewAdultMember(113, "Dhana Ramsamy");
        data.storeNewAdultMember(114, "Emma Stone");
        data.storeNewChildMember(115, "Elizabeth Roberts");
        data.storeNewChildMember(116, "Rose Evans");
        data.storeNewChildMember(117, "Jack Smith");
        data.storeNewChildMember(118, "James Johnson");

        ArrayList<Member> allMembers = data.getAllMembers();
        assertEquals(8, allMembers.size());
    }

    /**
     * The following three functions are used to test data.getBorrowedBooks
     * Each checks a variation of books to be borrowed and whether the book
     * status has been updated accordingly
     */
    /*
    @Test
    void testGetBorrowedBooks() {
        data.storeNewPhysicalBook("Nightcrawling", "Leila Mottley", "Literary", "Unavailable");
        ArrayList<String> borrowedBooks = data.getBorrowedBooks(101);
        assertTrue(borrowedBooks.isEmpty());
        data.reset();
    }

    @Test
    public void testGetBorrowedBooksOneBook() {
        data.checkoutBook(103, "Holly", "Stephen King");
        ArrayList<String> borrowedBooks = data.getBorrowedBooks(103);
        assertEquals(1, borrowedBooks.size());
        assertTrue(borrowedBooks.contains("Holly by Stephen King"));
        data.reset(); //make sure nothing changes
    }

    @Test
    public void testGetBorrowedBooksNoBooksBorrowed() {
        ArrayList<String> borrowedBooks = data.getBorrowedBooks(101);
        assertTrue(borrowedBooks.isEmpty());
    }

    /**
     * The following four functions are to test data.getMembersByName
     * Each checks a different way in which we can get members by Name only
     */
    /*
    @Test
    void testGetMembersByName(){
        ArrayList<Member> membersByName = data.getMembersByName("Michelle Yeoh");
        assertEquals(1, membersByName.size());
    }

    @Test
    void testGetMembersByNameReturnMemberInfo(){
        ArrayList<Member> membersByName = data.getMembersByName("Alice Wonderland");
        assertEquals(1, membersByName.size());
        Member member = membersByName.get(0);
        assertEquals(104,member.getID());
        assertEquals("Alice Wonderland",member.getName());
    }

    @Test
    void testGetMembersByNameThreeMembers(){
        ArrayList<Member> membersByName = data.getMembersByName("The Webster");
        assertEquals(1, membersByName.size());
        ArrayList<Member> membersByName1 = data.getMembersByName("Himanshu Ganga");
        assertEquals(1, membersByName1.size());
        ArrayList<Member> membersByName2 = data.getMembersByName("Jackie Chan");
        assertEquals(1, membersByName2.size());
    }

    @Test
    void testGetMembersByNameNoName(){
        ArrayList<Member> membersByName = data.getMembersByName(" ");
        assertEquals(0, membersByName.size());
    }

    /**
     * The following three functions are to test data.getMembersById
     * Each checks a different way in which we can get members by Id only
     */
    /*
    @Test
    void testGetMembersById(){
        data.reset();
        ArrayList<Member> membersById = data.getMembersById(101);
        assertNull(membersById.get(0));
    }

    @Test
    void testGetMembersByIdReturnMemberInfo(){
        ArrayList<Member> members = data.getMembersById(105);
        assertEquals(1, members.size());
        Member member = members.get(0);
        assertEquals(105, member.getID());
        assertEquals("Brad Pitt", member.getName());
    }

    @Test
    void testGetMembersByIdTwoMembers(){
        ArrayList<Member> membersById = data.getMembersById(101);
        assertEquals(1, membersById.size());
        ArrayList<Member> membersById1 = data.getMembersById(103);
        assertEquals(1, membersById1.size());
    }

    /**
     * The following four functions are to test data.calculateFines
     * Each checks a different way in which we can correctly calculate fines for a given overdue period
     */
    /*
    @Test
    void testCalculateFines(){
        assertEquals(0.0, data.calculateFines(0));
    }

    @Test
    void testCalculateFinesOneDayOverdue() {
        assertEquals(0.05, data.calculateFines(1));
    }

    @Test
    void testCalculateFinesMultipleDaysOverdue() {
        assertEquals(1.0, data.calculateFines(20));
    }

    @Test
    void testCalculateFinesBigOverdue() {
        assertEquals(4.5, data.calculateFines(90));
    }

    /**
     * The following tests are for data.payFines
     * Each looks at a different ratio of payment to fines owed (>,=,<)
     */
    /*
    @Test
    void testPayFinesWhenPaymentGreaterThanFinesOwed() {
        data.checkoutBook(101,"Moby Dick","Herman Melville");
        data.returnBook(101,"Moby Dick","Herman Melville",90);
        assertFalse(data.payFines(101,4.6));
    }
    @Test
    void testPayFinesWhenPaymentIsLessThanFinesOwed() {
        AdultMember member = (AdultMember) data.members.get(0);
        member.setFines(10.00);
        assertTrue(data.payFines(101,5.00));
        assertEquals(5.00,member.getFines());
        data.reset();
    }
    @Test
    void testPayFinesWhenPaymentIsEqualToFinesOwed() {
        AdultMember member2 = (AdultMember) data.members.get(0);
        member2.setFines(5.00);
        assertTrue(data.payFines(101,5.00));
        assertEquals(0.00,member2.getFines());
        data.reset();

     */