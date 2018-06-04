import java.util.ArrayList;

class Driver {
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
    }

    public PublicLift offerPublicLift(float price, ArrayList<PaymentMethod> acceptedPaymentMethods) {
        LiftDriver liftDriver = new LiftDriver(this); // instancia a classe associativa CaronaCaronante
        PublicLift lift = new PublicLift(liftDriver); // instancia a classe Carona
        liftDriver.setLift(lift); // da a carona para a CaronaCaronante
        lift.setPrice(price); // da o preco para a carona
        lifts.add(liftDriver); // adiciona a classe associativa ao array
        lift.setAcceptedPaymentMethods(acceptedPaymentMethods); // da as formas de pagamento
        return lift;
    }

    public PrivateLift offerPrivateLift(float price, ArrayList<PaymentMethod> acceptedPaymentMethods) {
        LiftDriver liftDriver = new LiftDriver(this); // instancia a classe associativa CaronaCaronante
        PrivateLift lift = new PrivateLift(liftDriver); // instancia a classe Carona
        liftDriver.setLift(lift); // da a carona para a CaronaCaronante
        lift.setPrice(price); // da o preco para a carona
        lifts.add(liftDriver); // adiciona a classe associativa ao array
        lift.setAcceptedPaymentMethods(acceptedPaymentMethods); // da as formas de pagamento
        return lift;
    }

    public void addLift(LiftDriver l) {
        lifts.add(l);
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
}