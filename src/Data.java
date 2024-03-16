import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    private static final ArrayList<Books> books = new ArrayList<>();
    private static final ArrayList<Books> availableBooks = new ArrayList<>();
    private static final ArrayList<Books> unAvailableBooks = new ArrayList<>();
    private static final ArrayList<String> titles = new ArrayList<>();
    private static final ArrayList<String> authors = new ArrayList<>();

    public static boolean storeNewBook(String title, String author, String genre, String availabilityStatus, String type) {
        if (title.isEmpty() || author.isEmpty()){
            System.out.println("Book cannot be stored.");
            return false;
        }

        if (!checkExistBook(title, author)) {
            Books book = new Books(title,author,genre,availabilityStatus,type);
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
        for(Books book : books){
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param title of book to check status of
     * @param author of book to check status of
     * @return whether the book is in the available books list
     */

    public static boolean checkBookAvailable(String title, String author){
        if (checkExistBook(title,author)) {
            for (Books book : availableBooks) {
                if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return list of all books in library
     */
    public static ArrayList <Books> getAllBooks(){
        return books;
    }

    /**
     * @return list of only the available books in library
     */
    public static ArrayList <Books> getAvailableBooks(){
        return availableBooks;
    }

    /**
     * @return list of only the unavailable books in library
     */
    public static ArrayList<Books> getUnavailableBooks() {
        return unAvailableBooks;
    }

    /**
     * @param title to search for
     * @return list of all books with that title
     */
    public static ArrayList<Books> getBooksByTitle(String title) {
        ArrayList<Books> booksWithTitle = new ArrayList<>();
        for (Books book: books){
            if (book.getTitle().equals(title)) {
                booksWithTitle.add(book);
            }
        }
        return booksWithTitle;
    }

    /**
     * @param author to search for
     * @return list of all books by that author
     */
    public static ArrayList<Books> getBooksByAuthor(String author) {
        ArrayList<Books> booksByAuthor = new ArrayList<>();
        for (Books book: books){
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    /**
     * @param genre to search for
     * @return list of all books in that genre
     */
    public static ArrayList<Books> getBooksByGenre(String genre) {
        ArrayList<Books> booksInGenre = new ArrayList<>();
        for (Books book: books){
            if (book.getGenre().equals(genre)) {
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
        for (Books book: books){ //goes through every book until it finds one matching title and author
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)){
                availableBooks.remove(book);
                book.setAvailabilityStatus("Unavailable");
                unAvailableBooks.add(book);
                for (Member member: members){ //goes through members until it finds one with ID
                    if (member.getID()==id){
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
        for (Books book: books){ //goes through every book until it finds one with title and author
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)){
                unAvailableBooks.remove(book);
                book.setAvailabilityStatus("Available");
                availableBooks.add(book);
                for (Member member: members){ //goes through members until it finds the one with ID
                    if (member.getID()==id){
                        ((ArrayList<String>)member[INDEX_BORROWED]).remove(title+" by "+author); //member no longer has book borrowed
                        member.setFines(member.getFines() + calculateFines(daysOverdue)); ; //adds fines
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
            for (Books book: books){
                if (book.getTitle().equals(title)&&book.getAuthor().equals(author)){
                    if (checkBookAvailable(title,author)){
                        availableBooks.remove(book);
                    }
                    else {
                        unAvailableBooks.remove(book);
                        for (Member member:members){ //should be removed from borrowed list of any member who has it
                            returnBook(member.getID(),title,author,0);
                        }
                    }
                    books.remove(book);
                    titles.remove(book.getTitle());
                    authors.remove(book.getAuthor());
                    return true; // book has successfully been removed
                }
            }
        }
        return false; //book did not exist, so it can't be removed
    }

    //  EVERYTHING BELOW HERE IS TO STORE MEMBER DATA

    static final ArrayList<Member> members = new ArrayList<>();
    static final HashMap<Integer,Member> memberIDs = new HashMap<>();


    /**
     * Adds new member to list of members and adds their ID to memberIDs
     * @param id of member to be added
     * @param name of member to be added
     * @return whether addition of member was successful (only unsuccessful when member with same ID already exists)
     */
    public static boolean storeNewMember(Integer id, String name,String agegroup) {
        if (!checkExistMember(id)){
            if (agegroup.equals("ADULT")) {
                AdultMember member = new AdultMember(id, name);
            }
            else if (agegroup.equals("CHILD")){
                ChildMember member = new ChildMember(id,name);
            }
            memberIDs.put(id,member);
            members.add(member); //adding to list of all members
            return true;
        } else {
            return false;
        }
    }
    public static boolean storeNewChildMember(Integer id, String name) {
        if (id==null||name.isEmpty()){
            System.out.println("Member cannot be stored.");
            return false;
        }

        if (!checkExistMember(id)) {
            Member member = new AdultMember(id, name);
            memberIDs.put(id, member);
            members.add(member); //adding to list of all members
            return true;
        } else {
            return false;
        }
    }
    public static boolean storeNewAdultMember(Integer id, String name) {
        if (id==null||name.isEmpty()){
            System.out.println("Member cannot be stored.");
            return false;
        }

        if (!checkExistMember(id)) {
            Member member = new ChildMember(id, name);
            memberIDs.put(id, member);
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
        return memberIDs.containsKey(id);
    }

    /**
     * Removes member from list of members and removes their ID from memberIDs
     * @param id of member to be removed
     * @param name of member to be removed
     * @return whether member was successfully removed
     */
    public static boolean removeMember(int id, String name) {
        if (checkExistMember(id)){
            for (Member member: members){

                if ((member.getID() == (id)) && member.getName().equals(name)){
                    members.remove(member);
                    memberIDs.remove(member.getID(),member);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return list of all members in library
     */
    public static ArrayList<Member> getAllMembers(){
        return members;
    }

    /**
     * @param name to search for
     * @return a list of members with that name
     */
    public static ArrayList<Member> getMembersByName(String name) {
        ArrayList<Member> membersWithName = new ArrayList<>();
        for (Member member: members){
            if (member.getName().equals(name)) {
                membersWithName.add(member);
            }
        }
        return membersWithName;
    }

    /**
     * @param id to find the corresponding member for
     * @return the member with that ID as a single element list (to make printing easy in Menu.java)
     */
    public static ArrayList<Member> getMembersById(int id) {
        ArrayList<Member> membersWithId = new ArrayList<>();
        for (Member member: members){
            if (member.getID()==id) {
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
        return memberIDs.get(id).getBorrowed();
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
        for (Member member:members){
            if (member.getID()==ID){
                if (member.getFines()>=payment){
                    member.setFines(member.getFines()-payment);
                    return true;
                }
            }
        }
        return false;
    }

}
