package LibraryProjectPackage.objects;

import LibraryProjectPackage.util.MemberType;

import java.util.ArrayList;

public abstract class Member {
    private String name;
    private int id;
    private ArrayList<String> borrowed;
    private MemberType memberType;

    public Member(int id,String name,MemberType memberType){
        this.id = id;
        this.name = name;
        this.borrowed = new ArrayList<String>(); //when someone joins library for first time they don't have books yet
        this.memberType=memberType;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberType getMemberType() {
        return memberType;
    }


    public ArrayList<String> getBorrowed() {
        return borrowed;
    }

    @Override
    public abstract String toString() ;
        /*
        memString.append("\nID: ").append(member.getID());
            memString.append("\nName: ").append(member.getName());
            memString.append("\nBooks Borrowed:");
            for (String book: LibraryProjectPackage.Data.getBorrowedBooks(member.getID())){
                memString.append("\n     ").append(book);
            }
            String roundedFine = String.format("%.2f",(member.getFines()));
            memString.append("\nFines: ").append(roundedFine);
         */
    public void addBookToMember(String book){
        borrowed.add(book);
    }
    public void removeBookFromMember(String book){
        borrowed.remove(book);
    }
}
