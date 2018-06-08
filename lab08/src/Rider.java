import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Rider implements Savable{

    private String creditCard;
    private boolean payWithCash;
    private static int numberOfDrivers;
    private ArrayList<LiftRider> lifts;
    private Profile profile;

    public Rider() {
        lifts = new ArrayList<LiftRider>();
    }

    public Rider(String creditCard) {
        this();
        this.creditCard = creditCard;
    }

    public Rider(boolean payWithCash) {
        this();
        this.payWithCash = payWithCash;
    }

    public boolean askLift(Lift lift) {
        return lift.addRider(this);
    }

//    public boolean rateLift(Lift lift, float rating) {
//        for (LiftRider i: lifts) {
//            if(i.getLift().equals(lift)) {
//                i.setRating(rating);
//                return true;
//            }
//        }
//        return false;
//    }

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

    public ArrayList<LiftRider> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<LiftRider> lifts) {
        this.lifts = lifts;
    }

    public boolean addLiftRider(LiftRider lr) {
        return lifts.add(lr);
    }

    @Override
    public boolean saveToFile() {
        if(!(new File("Objects/").exists()))
            new File("Objects/").mkdir();

        if((new File("Objects/" + originalToString()).exists()))
            return false;

        BufferedWriter outputFile = null;

        try {
            outputFile = new BufferedWriter(new FileWriter("Objects/" + originalToString()));

            if(creditCard != null)
                outputFile.write(creditCard);
            else
                outputFile.write("null");

            outputFile.newLine();

            outputFile.write(payWithCash? "true" : "false");
            outputFile.newLine();

            outputFile.write(Integer.toString(numberOfDrivers));
            outputFile.newLine();

            if(profile != null) {
                profile.saveToFile();
                outputFile.write(profile.originalToString() + "|");
            } else
                outputFile.write("null");

            outputFile.newLine();


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save " + originalToString());
            return false;

        } finally {

            try {
                if (outputFile != null)
                    outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Glitch in the Matrix: Rider.saveToFile()");
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "creditCard='" + creditCard + '\'' +
                ", payWithCash=" + payWithCash +
                ", lifts=" + lifts +
                ", profile=" + profile +
                '}';
    }

    @Override
    public String originalToString() {
        return super.toString();
    }
}