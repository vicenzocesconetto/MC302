public final class PublicGroup extends Group {

//    private int staticTest = 69;

    public PublicGroup() {
        super();
    }

//    @Override
//    public int getStaticTest() {
//        return this.staticTest;
//    }

    @Override
    public String toString() {
        return "PublicGroup{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", members=" + getMembers() +
                '}';
    }
}
