import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        Group teste = new PublicGroup();
//        teste.dynamicTest();
//        ((PublicGroup) teste).dynamicTest();

        System.out.println("start main");

        Lift[] caronas = new Lift[2];
        caronas[0] = new PublicLift();
        caronas[1] = new PrivateLift();

        Group[] grupos = new Group[2];
        grupos[0] = new PublicGroup((PublicLift) caronas[0]);
        grupos[1] = new PrivateGroup((PrivateLift) caronas[1]);

        ((PublicLift) caronas[0]).addGroup((PublicGroup) grupos[0]);
        ((PrivateLift) caronas[1]).addGroup((PrivateGroup) grupos[1]);


        User u1 = new User("Deep Learning is overrated");
        Profile p1 = new Profile('M',"20/45/1944", "SP", "SP", "12345345", true, 4);
        Driver d1 = new Driver();

        u1.setProfile(p1);
        p1.setUser(u1);
        p1.setDriverProfile(d1);
        d1.setDriverProfile(p1);


        User u2 = new User("XGBoost rules");
        Profile p2 = new Profile('F',"45/56/1674", "Camp", "SP", "1784545", false, 2);
        Rider r2 = new Rider(true);

        u2.setProfile(p2);
        p2.setRiderProfile(r2);
        p2.setUser(u2);
        r2.setProfile(p2);


        User u3 = new User("Buzzword");
        Profile p3 = new Profile('M',"43/89/1944", "Jund", "SP", "0987654", false, 2);
        Driver d3 = new Driver();

        u3.setProfile(p3);
        p3.setDriverProfile(d3);
        p3.setUser(u3);
        d3.setDriverProfile(p3);


        User u4 = new User("Elixir");
        Profile p4 = new Profile('M',"78/43/7665", "Urr", "SP", "213568", true, 9);
        Rider r4 = new Rider(true);

        u4.setProfile(p4);
        p4.setUser(u4);
        p4.setRiderProfile(r4);
        r4.setProfile(p4);

//      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        ((PublicGroup) grupos[0]).addMember(u1);
        ((PublicGroup) grupos[0]).addMember(u2);
        ((PublicGroup) grupos[0]).addMember(u4);


        ArrayList<PaymentMethod> pay = new ArrayList<PaymentMethod>();
        pay.add(PaymentMethod.CASH);
        Lift l1 = d1.offerLift(4.5f, pay);
        caronas[0] = l1;
//        caronas[0].addPaymentMethod(PaymentMethod.CASH);
        if(caronas[0] == null) {
            System.out.println("Main, line 118, caronas[0] is null");
            return;
        }
        r2.askLift(caronas[0]);
        r4.askLift(caronas[0]);
        r2.giveLiftRating(caronas[0], 4.5f);
        r4.giveLiftRating(caronas[0], 4.5f);

        System.out.println(grupos[0]);


        ((PrivateGroup) grupos[1]).addMember(u3);
        ((PrivateGroup) grupos[1]).addMember(u2);
        ((PrivateGroup) grupos[1]).addMember(u4);

        Lift l2 = d3.offerLift(5.4f, new ArrayList<PaymentMethod>());
        caronas[1] = l2;
        caronas[1].addPaymentMethod(PaymentMethod.CREDITCARD);
        r2.askLift(caronas[1]);
        r4.askLift(caronas[1]);
        r2.giveLiftRating(caronas[1], 7.5f);
        r4.giveLiftRating(caronas[1], 7.5f);

        System.out.println(grupos[1]);
    }
}