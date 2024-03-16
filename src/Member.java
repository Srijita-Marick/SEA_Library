import java.util.ArrayList;

public class Member {
    private String id,name,agegroup;
    private double fines;
    private ArrayList<String> borrowed;

    public Member(String id,String name, String agegroup){
        this.id = id;
        this.name = name;
        this.borrowed = new ArrayList<String>(); //when someone joins library for first time they don't have books yet
        this.fines = 0.00; // when someone joins library for the first time they should have no fine
        this.agegroup = agegroup;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setFines(double fines) {
        this.fines = fines;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAgegroup() {
        return agegroup;
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
                ", agegroup='" + agegroup + '\'' +
                ", fines=" + fines +
                ", borrowed=" + borrowed +
                '}';
    }
}
