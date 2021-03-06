class Driver {
    private int habilitationTime;
    private String favoriteMusicGenre;
    private String licensePlate;
    private String driverLicense;
    private String vehicleBrand;
    private String vehicleModel;
    private int seatsAvailable;
    private static int numberOfRiders;

    public Driver() {

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

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

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
                '}';
    }
}