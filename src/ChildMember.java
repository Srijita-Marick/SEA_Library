public class ChildMember extends Member{

    public ChildMember(int id, String name) {
        super(id, name, MemberType.CHILD);
    }
    @Override
    public String toString() {
        return (this.getID() + "\t" +
                this.getName() + '\n' +
                "---------------" +
                "Books borrowed: \n" + this.getBorrowed() + "\n");
    }

}
