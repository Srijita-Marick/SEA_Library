package LibraryProjectPackage.objects;

import LibraryProjectPackage.util.MemberType;

public class ChildMember extends Member {

    private int booksRead;
    public ChildMember(int id, String name) {
        super(id, name, MemberType.CHILD);
        booksRead=0;
    }

    public void addToReadCount (){
        booksRead++;
    }
    public int getReadCount(){
        return booksRead;
    }

    @Override
    public String toString() {
        StringBuilder memString = new StringBuilder();
        memString.append("\n--------------------");
        memString.append("\nID: ").append(this.getID());
        memString.append("\nName: ").append(this.getName());
        memString.append("\nBooks Borrowed:");
        for (String book: LibraryProjectPackage.Data.getBorrowedBooks(this.getID())){
            memString.append("\n     ").append(book);
        }
        return memString.toString();
    }

}
