import java.util.ArrayList;

/*

*/
public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();

        Profile p1 = new Profile('M', "23/02/1979", "Star", "SP", "33567896", true, 3);
        Profile p2 = new Profile('F', "24/32/1601", "EMPire", "NY", "12345678", false, 1);
        Profile p3 = new Profile('M', "21/45/4789", "Gondor", "MA", "78945612", false, 9);
        Profile p4 = new Profile('F', "12/45/6541", "Palo Alto", "CA", "16365498", false, 4);

        p1.setUser(u1);
        p2.setUser(u2);
        p3.setUser(u3);
        p4.setUser(u4);

        p1.setRating(4.5f);
        p2.setRating(4.5f);
        p3.setRating(4.5f);
        p4.setRating(4.5f);

        u1.setProfile(p1);
        u2.setProfile(p2);
        u3.setProfile(p3);
        u4.setProfile(p4);

        Driver d1 = new Driver();
        d1.setDriverProfile(p1);
        p1.setDriverProfile(d1);

        Rider r2 = new Rider(true);
        Rider r3 = new Rider(true);
        Rider r4 = new Rider(true);

        ArrayList<PaymentMethod> pay = new ArrayList<PaymentMethod>();
        pay.add(PaymentMethod.CASH);
        ArrayLift carona = d1.offerLift(1.4f, pay);
        carona.addRider(r2);
        carona.addRider(r3);
        carona.addRider(r4);

        System.out.println(carona.giveRiderRating(2, p1.getRating()));
        System.out.println(carona.giveRiderRating(3, p1.getRating()));
        System.out.println(carona.giveRiderRating(4, p1.getRating()));
        System.out.println(carona.giveRiderRating(35, p1.getRating()));

        System.out.println(carona.giveDriverRating(p2.getRating()));
        System.out.println(carona.giveDriverRating(p3.getRating()));
        System.out.println(carona.giveDriverRating(p4.getRating()));


        System.out.println(u1.print());
        System.out.println(u2.print());
        System.out.println(u3.print());
        System.out.println(u4.print());


    }
}
