public class PrivateGroup extends Group {

    public PrivateGroup() {
        super();
    }

    @Override
    public String toString() {
        return "PrivateGroup{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", members=" + getMembers() +
                '}';
    }
}
