import java.util.ArrayList;

public abstract class Member {
    private String name;
    private int id;
    private double fines;
    private ArrayList<String> borrowed;
    private MemberType memberType;

    public Member(int id,String name,MemberType memberType){
        this.id = id;
        this.name = name;
        this.borrowed = new ArrayList<String>(); //when someone joins library for first time they don't have books yet
        this.fines = 0.00; // when someone joins library for the first time they should have no fine
        this.memberType=memberType;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setFines(double fines) {
        this.fines = fines;
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

    public double getFines() {
        return fines;
    }

    public ArrayList<String> getBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fines=" + fines +
                ", borrowed=" + borrowed +
                '}';
        /*
        memString.append("\nID: ").append(member.getID());
            memString.append("\nName: ").append(member.getName());
            memString.append("\nBooks Borrowed:");
            for (String book: Data.getBorrowedBooks(member.getID())){
                memString.append("\n     ").append(book);
            }
            String roundedFine = String.format("%.2f",(member.getFines()));
            memString.append("\nFines: ").append(roundedFine);
         */
    }
}
