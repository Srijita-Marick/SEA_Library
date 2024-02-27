import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public static void reset(){   // Reset any existing data to ensure a clean state before test runs
        books.clear();
        availableBooks.clear();
        unAvailableBooks.clear();
        titles.clear();
        authors.clear();
        memberIDs.clear();
        members.clear();
    }
    private static final ArrayList<Object[]> books = new ArrayList<>();
    private static final ArrayList<Object[]> availableBooks = new ArrayList<>();
    private static final ArrayList<Object[]> unAvailableBooks = new ArrayList<>();
    private static final ArrayList<String> titles = new ArrayList<>();

    private static final ArrayList<String> authors = new ArrayList<>();
    public static final int INDEX_TITLE = 0;
    public static final int INDEX_AUTHOR = 1;
    public static final int INDEX_GENRE = 2;
    public static final int INDEX_STATUS = 3;
    public static final int INDEX_REMOVED = 4;
    public static boolean storeNewBook(String title, String author, String genre, String availabilityStatus) {
        if (title.isEmpty() || author.isEmpty()){
            System.out.println("Book cannot be stored.");
            return false;
        }

        if (!checkExistBook(title, author)) {
            Object[] book = new Object[5];
            book[INDEX_TITLE] = title;
            book[INDEX_AUTHOR] = author;
            book[INDEX_GENRE] = genre;
            book[INDEX_STATUS] = availabilityStatus;
            book[INDEX_REMOVED] = false;
            books.add(book); //adding to list of all books
            availableBooks.add(book); //since all books are by default available when created
            titles.add(title);
            authors.add(author);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a book exists or not
     * @param title of the book to be checked
     * @param author of the book to be checked
     * @return whether the library has a book with that title and author
     */
    public static boolean checkExistBook(String title , String author){
        return titles.contains(title) && authors.contains(author);
    }

    /**
     * @param title of book to check status of
     * @param author of book to check status of
     * @return whether the book is in the available books list
     */

    public static boolean checkBookAvailable(String title, String author){
        if (checkExistBook(title,author)) {
            for (Object[] book : availableBooks) {
                if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return list of all books in library
     */
    public static ArrayList <Object[]> getAllBooks(){
        return books;
    }

    /**
     * @return list of only the available books in library
     */
    public static ArrayList <Object[]> getAvailableBooks(){
        return availableBooks;
    }

    /**
     * @return list of only the unavailable books in library
     */
    public static ArrayList<Object[]> getUnavailableBooks() {
        return unAvailableBooks;
    }

    /**
     * @param title to search for
     * @return list of all books with that title
     */
    public static ArrayList<Object[]> getBooksByTitle(String title) {
        ArrayList<Object[]> booksWithTitle = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_TITLE].equals(title)) {
                booksWithTitle.add(book);
            }
        }
        return booksWithTitle;
    }

    /**
     * @param author to search for
     * @return list of all books by that author
     */
    public static ArrayList<Object[]> getBooksByAuthor(String author) {
        ArrayList<Object[]> booksByAuthor = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_AUTHOR].equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    /**
     * @param genre to search for
     * @return list of all books in that genre
     */
    public static ArrayList<Object[]> getBooksByGenre(String genre) {
        ArrayList<Object[]> booksInGenre = new ArrayList<>();
        for (Object[] book: books){
            if (book[INDEX_GENRE].equals(genre)) {
                booksInGenre.add(book);
            }
        }
        return booksInGenre;
    }

    /**
     * Changes the status of a book from available to unavailable
     * Removes it from availableBooks and adds it to unAvailableBooks
     * Adds the books as a String to the member's borrowed books list
     * @param id of member who is checking the book out
     * @param title of the book they are checking out
     * @param author of the book they are checking out
     */
    public static void checkoutBook(Integer id, String title, String author){
        for (Object[] book: books){ //goes through every book until it finds one matching title and author
            if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)){
                availableBooks.remove(book);
                book[INDEX_STATUS]= "Unavailable";
                unAvailableBooks.add(book);
                for (Object[] member: members){ //goes through members until it finds one with ID
                    if (member[INDEX_ID]==id){
                        //saves to member's borrowed books list as a String
                        ((ArrayList<String>)member[INDEX_BORROWED]).add(title+" by "+author);
                    }
                }
            }
        }
    }

    /**
     * Changes status of book from unavailable to available
     * Removes book from unAvailableBooks and adds it availableBooks
     * Removes the corresponding String from the member's borrowed books list
     * Adds fines to the member's pre-existing fines
     * @param id of member returning book
     * @param title of book being returned
     * @param author of book being returned
     * @param daysOverdue is the days that the member kept the book past its due date
     */
    public static void returnBook(Integer id, String title, String author, int daysOverdue) {
        for (Object[] book: books){ //goes through every book until it finds one with title and author
            if (book[INDEX_TITLE].equals(title) && book[INDEX_AUTHOR].equals(author)){
                unAvailableBooks.remove(book);
                book[INDEX_STATUS]= "Available";
                availableBooks.add(book);
                for (Object[] member: members){ //goes through members until it finds the one with ID
                    if (member[INDEX_ID]==id){
                        ((ArrayList<String>)member[INDEX_BORROWED]).remove(title+" by "+author); //member no longer has book borrowed
                        member[INDEX_FINES] = (double)member[INDEX_FINES] + calculateFines(daysOverdue); //adds fines
                    }
                }
            }
        }
    }

    /**
     * Removes book from every list of books it is a part of, including books,titles,availableBooks,unAvailableBooks
     * If book is checked out by someone, removes it from their borrowed books list without any fines
     * @param title of book to be removed from library
     * @param author of book to be removed from library
     * @return whether deletion was successful
     */
    public static boolean removeBook(String title, String author) {
        if (checkExistBook(title,author)){ //can only remove a book that exists
            for (Object[] book: books){
                if (book[INDEX_TITLE].equals(title)&&book[INDEX_AUTHOR].equals(author)){
                    if (checkBookAvailable(title,author)){
                        availableBooks.remove(book);
                    }
                    else {
                        unAvailableBooks.remove(book);
                        for (Object[] member:members){ //should be removed from borrowed list of any member who has it
                            returnBook((Integer)member[INDEX_ID],title,author,0);
                        }
                    }
                    books.remove(book);
                    titles.remove((String)book[INDEX_TITLE]);
                    authors.remove((String)book[INDEX_AUTHOR]);
                    return true; // book has successfully been removed
                }
            }
        }
        return false; //book did not exist, so it can't be removed
    }

    //  EVERYTHING BELOW HERE IS TO STORE MEMBER DATA

    static final ArrayList<Object[]> members = new ArrayList<>();
    static final ArrayList<Integer> memberIDs = new ArrayList<Integer>(); // all the ids currently in use
    public static final int INDEX_ID = 0; // index for an integer ID
    public static final int INDEX_NAME = 1; // index for a name as a String
    public static final int INDEX_BORROWED = 2; // index for a list of a member's borrowed books
    public static final int INDEX_FINES = 3; // index for a double to track fines


    /**
     * Adds new member to list of members and adds their ID to memberIDs
     * @param id of member to be added
     * @param name of member to be added
     * @return whether addition of member was successful (only unsuccessful when member with same ID already exists)
     */
    public static boolean storeNewMember(Integer id, String name) {
        if (!checkExistMember(id)) {
            Object[] member = new Object[4];
            member[INDEX_ID] = id;
            member[INDEX_NAME] = name;
            member[INDEX_BORROWED] = new ArrayList<String>();
            member[INDEX_FINES] = 0.00; // when someone joins library for the first time they should have no fine
            memberIDs.add(id);
            members.add(member); //adding to list of all members
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param id of member to check
     * @return if ID already exists in list of memberIDs
     */
    public static boolean checkExistMember(Integer id) {
        return memberIDs.contains(id);
    }

    /**
     * Removes member from list of members and removes their ID from memberIDs
     * @param id of member to be removed
     * @param name of member to be removed
     * @return whether member was successfully removed
     */
    public static boolean removeMember(Integer id, String name) {
        if (checkExistMember(id)){
            for (Object[] member: members){
                if (member[INDEX_ID]==(id)&&member[INDEX_NAME].equals(name)){
                    members.remove(member);
                    memberIDs.remove(member[INDEX_ID]);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return list of all members in library
     */
    public static ArrayList<Object[]> getAllMembers(){
        return members;
    }

    /**
     * @param name to search for
     * @return a list of members with that name
     */
    public static ArrayList<Object[]> getMembersByName(String name) {
        ArrayList<Object[]> membersWithName = new ArrayList<>();
        for (Object[] member: members){
            if (member[INDEX_NAME].equals(name)) {
                membersWithName.add(member);
            }
        }
        return membersWithName;
    }

    /**
     * @param id to find the corresponding member for
     * @return the member with that ID as a single element list (to make printing easy in Menu.java)
     */
    public static ArrayList<Object[]> getMembersById(int id) {
        ArrayList<Object[]> membersWithId = new ArrayList<>();
        for (Object[] member: members){
            if (member[INDEX_ID].equals(id)) {
                membersWithId.add(member);
            }
        }
        return membersWithId;
    }

    /**
     * @param id of member to get books for
     * @return list of Strings representing books the member has checked out
     */
    public static ArrayList<String> getBorrowedBooks(Integer id){
        for (Object[] member: members){
            if (member[INDEX_ID]==id){
                return (ArrayList<String>) member[INDEX_BORROWED];
            }
        }
        return new ArrayList<String>();
    }

    /**
     * @param daysOverDue is the number of days the user had the book past the due date
     * @return the fines accrued from being overdue
     */
    public static double calculateFines(int daysOverDue){
        return ((double)daysOverDue)*0.05; //five cents are added to fines per day overdue
    }

    /**
     * Updates a members fines when they pay them
     * @param ID of member paying fines
     * @param payment is the amount the member is paying
     * @return whether it is a valid payment or not
     */
    public static boolean payFines(Integer ID, Double payment){
        for (Object[] member:members){
            if ((member[INDEX_ID])==ID){
                if ((Double)member[INDEX_FINES]>=payment){
                    member[INDEX_FINES]=(Double)member[INDEX_FINES]-payment;
                    return true;
                }
            }
        }
        return false;
    }

}
