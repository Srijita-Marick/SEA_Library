import java.util.ArrayList;

public class Member {
    public static final int INDEX_ID = 0; // index for an integer ID
    public static final int INDEX_NAME = 1; // index for a name as a String
    public static final int INDEX_BORROWED = 2; // index for a list of a member's borrowed books
    public static final int INDEX_FINES = 3; // index for a double to track fines
    public static final int INDEX_AGEGROUP = 4; // index for a double to track fines
    private Object[] member = new Object[5];

    public Member(String id,String name, String agegroup){
        member[INDEX_ID] = id;
        member[INDEX_NAME] = name;
        member[INDEX_BORROWED] = new ArrayList<String>();
        member[INDEX_FINES] = 0.00; // when someone joins library for the first time they should have no fine
        member[INDEX_AGEGROUP] = agegroup;
    }
}
