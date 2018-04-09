class Rider {
    private String creditCard;
    private boolean payWithCash;
    private static int numberOfDrivers;

    public Rider() {
    }

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

    @Override
    public String toString() {
        return "Rider{" +
                "creditCard='" + creditCard + '\'' +
                ", paysWithCash=" + payWithCash +
                '}';
    }
}