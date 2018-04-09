class Rider {
    private String creditCard;
    private boolean payWithCash;
    private static int numberOfDrivers;
    private Profile profile;

    public Rider() {}

    public Rider(String creditCard) {
        this.creditCard = creditCard;
    }

    public Rider(boolean payWithCash) {
        this.payWithCash = payWithCash;
    }



    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isPayWithCash() {
        return payWithCash;
    }

    public void setPayWithCash(boolean paysWithCash) {
        this.payWithCash = paysWithCash;
    }

    public static int getNumberOfDrivers() {
        return numberOfDrivers;
    }

    public static void setNumberOfDrivers(int numberOfDrivers) {
        Rider.numberOfDrivers = numberOfDrivers;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "creditCard='" + creditCard + '\'' +
                ", payWithCash=" + payWithCash +
                ", profile=" + profile +
                '}';
    }
}