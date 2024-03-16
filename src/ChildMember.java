public class ChildMember extends Member{

    public ChildMember(int id, String name) {
        super(id, name, MemberType.CHILD);
    }
    @Override
    public String toString() {
        return "Child Member{" +
                "id='" + this.getID() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", borrowed=" + this.getBorrowed() +
                '}';
    }

}
