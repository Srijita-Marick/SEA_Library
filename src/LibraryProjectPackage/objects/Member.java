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

    public void addBookToMember(String book){
        borrowed.add(book);
        if (this instanceof ChildMember childMember){
            childMember.addToReadCount();
        }
    }
    public void removeBookFromMember(String book){
        borrowed.remove(book);
    }
}
