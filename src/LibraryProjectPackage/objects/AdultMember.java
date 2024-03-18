package LibraryProjectPackage.objects;

import LibraryProjectPackage.util.MemberType;

public class AdultMember extends Member {
    private double fines;
    public AdultMember(int id, String name) {
        super(id, name, MemberType.ADULT);
        this.fines=0.00;
    }
    public double getFines() {
        return fines;
    }
    public void setFines(double fines) {
        this.fines = fines;
    }

    public String toString() {
        return (this.getID() + "\t" +
                this.getName() + '\t' +
                "Fines: " + this.getFines() + "\n" +
                "---------------" +
                "LibraryProjectPackage.objects.Books borrowed: \n" + this.getBorrowed() + "\n");
    }
}