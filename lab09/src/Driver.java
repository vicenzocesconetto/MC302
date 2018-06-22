import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Driver implements Savable{
    private int habilitationTime;
    private String favoriteMusicGenre;
    private String licensePlate;
    private final String driverLicense;
    private String vehicleBrand;
    private String vehicleModel;
    private ArrayList<LiftDriver> lifts;
    private int seatsAvailable;
    private static int numberOfRiders;
    private Profile driverProfile;


    public Driver() {
        driverLicense = "2018";
        lifts = new ArrayList<LiftDriver>();
    }

    public PublicLift offerPublicLift(float price, ArrayList<PaymentMethod> acceptedPaymentMethods) {
        LiftDriver liftDriver = new LiftDriver(this); // instantiating association class LiftDriver and make it see the driver
        PublicLift lift = new PublicLift(liftDriver); // instantiate a Lift and make it see the LiftDriver
        liftDriver.setLift(lift); // make the LiftDriver see the Lift
        lifts.add(liftDriver); // add the LiftDriver to the relationship array
        lift.setPrice(price); // set the lift's price
        lift.setAcceptedPaymentMethods(acceptedPaymentMethods); // set the PaymentMethods
        return lift;
    }

    public PrivateLift offerPrivateLift(float price, ArrayList<PaymentMethod> acceptedPaymentMethods) {
        LiftDriver liftDriver = new LiftDriver(this); // instantiating association class LiftDriver and make it see the driver
        PrivateLift lift = new PrivateLift(liftDriver); // instantiate a Lift and make it see the LiftDriver
        liftDriver.setLift(lift); // make the LiftDriver see the Lift
        lifts.add(liftDriver); // add the LiftDriver to the relationship array
        lift.setPrice(price); // set the lift's price
        lift.setAcceptedPaymentMethods(acceptedPaymentMethods); // set the PaymentMethods
        return lift;
    }

    public void addLift(LiftDriver l) {
        lifts.add(l);
    }

    public void addLift(Lift lift) {
        LiftDriver liftDriver = new LiftDriver(lift, this);
        lift.setDriver(liftDriver);
        lifts.add(liftDriver);
    }

    public int getHabilitationTime() {
        return habilitationTime;
    }

    public void setHabilitationTime(int habilitationTime) {
        this.habilitationTime = habilitationTime;
    }

    public String getFavoriteMusicGenre() {
        return favoriteMusicGenre;
    }

    public void setFavoriteMusicGenre(String favoriteMusicGenre) {
        this.favoriteMusicGenre = favoriteMusicGenre;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

//    public void setDriverLicense(String driverLicense) {
//        this.driverLicense = driverLicense;
//    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public static int getNumberOfRiders() {
        return numberOfRiders;
    }

    public static void setNumberOfRiders(int numberOfRiders) {
        Driver.numberOfRiders = numberOfRiders;
    }

    public Profile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(Profile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public ArrayList<LiftDriver> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<LiftDriver> lifts) {
        this.lifts = lifts;
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

            outputFile.write(Integer.toString(habilitationTime));
            outputFile.newLine();

            if(favoriteMusicGenre != null)
                outputFile.write(favoriteMusicGenre);
            else
                outputFile.write("null");

            outputFile.newLine();

            if(licensePlate != null)
                outputFile.write(licensePlate);
            else
                outputFile.write("null");

            outputFile.newLine();

            if(driverLicense != null)
                outputFile.write(driverLicense);
            else
                outputFile.write("null");

            outputFile.newLine();

            if(vehicleBrand != null)
                outputFile.write(vehicleBrand);
            else
                outputFile.write("null");

            outputFile.newLine();

            if(vehicleModel != null)
                outputFile.write(vehicleBrand);
            else
                outputFile.write("null");

            outputFile.newLine();

            outputFile.write(Integer.toString(seatsAvailable));
            outputFile.newLine();

            if(driverProfile != null) {
                driverProfile.saveToFile();
                outputFile.write(driverProfile.originalToString());
            } else
                outputFile.write("null");

            outputFile.newLine();

            outputFile.flush(); // flushing it before closing, just to be safe.

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
                System.out.println("This is a glitch in the Matrix: Driver.saveToFile()");
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "habilitationTime=" + habilitationTime +
                ", favoriteMusicGenre='" + favoriteMusicGenre + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", seatsAvailable=" + seatsAvailable +
                ", driverProfile=" + driverProfile +
                '}';
    }

    @Override
    public String originalToString() {
        return super.toString();
    }
}