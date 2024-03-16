import java.util.ArrayList;

public class Member {
    private String id,name,agegroup;
    private double fines;
    private ArrayList<String> borrowed;

    public Member(String id,String name, String agegroup){
        this.id = id;
        this.name = name;
        this.borrowed = new ArrayList<String>();
        this.fines = 0.00; // when someone joins library for the first time they should have no fine
        this.agegroup = agegroup;
    }
}
