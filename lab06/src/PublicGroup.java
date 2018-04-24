public final class PublicGroup extends Group {

    public PublicGroup() {
        super();
    }


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
