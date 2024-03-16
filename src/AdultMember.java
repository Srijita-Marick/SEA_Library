public class AdultMember extends Member{
    private double fines;
    public AdultMember(int id, String name) {
        super(id, name,MemberType.ADULT);
        this.fines=0.00;
    }
    @Override
    public double getFines() {
        return fines;
    }
    @Override
    public void setFines(double fines) {
        this.fines = fines;
    }

    public String toString() {
        return "Adult Member{" +
                "id='" + this.getID() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", fines=" + this.getFines() +
                ", borrowed=" + this.getBorrowed() +
                '}';
    }
}