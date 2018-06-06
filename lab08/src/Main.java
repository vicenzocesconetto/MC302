import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User u0 = new User();
        Profile p0 = new Profile('F', "12/54/987", "Palo Alto", "CA", "7563243", false, 3);
        Driver d0 = new Driver();
        Rider r0 = new Rider();
        u0.setProfile(p0);
        p0.setUser(u0);
        p0.setDriverProfile(d0);
        p0.setRiderProfile(r0);
        d0.setDriverProfile(p0);
        r0.setProfile(p0);

        User u1 = new User();
        Profile p1 = new Profile('M', "332/3443/10034", "Mountain View", "CA", "7654321", false, 5);
        Driver d1 = new Driver();
        Rider r1 = new Rider();
        u1.setProfile(p1);
        p1.setUser(u1);
        p1.setDriverProfile(d1);
        p1.setRiderProfile(r1);
        d1.setDriverProfile(p1);
        r1.setProfile(p1);

        User u2 = new User();
        Profile p2 = new Profile('F', "20/05/1967", "Menlo Park", "CA", "7654321", false, 5);
        Driver d2 = new Driver();
        Rider r2 = new Rider();
        u2.setProfile(p2);
        p2.setUser(u2);
        p2.setDriverProfile(d2);
        p2.setRiderProfile(r2);
        d2.setDriverProfile(p2);
        r2.setProfile(p2);

        User u3 = new User();
        Profile p3 = new Profile('F', "43/89/3445", "San Bruno", "CA", "1385125", false, 1);
        Driver d3 = new Driver();
        Rider r3 = new Rider();
        u3.setProfile(p3);
        p3.setUser(u3);
        p3.setDriverProfile(d3);
        p3.setRiderProfile(r3);
        d3.setDriverProfile(p3);
        r3.setProfile(p3);

        User u4 = new User();
        Profile p4 = new Profile('M', "65/54/455656", "San Francisco", "CA", "2685477", false, 2);
        Driver d4 = new Driver();
        Rider r4 = new Rider();
        u4.setProfile(p4);
        p4.setUser(u4);
        p4.setDriverProfile(d4);
        p4.setRiderProfile(r4);
        d4.setDriverProfile(p4);
        r4.setProfile(p4);

        PublicGroup gpu = new PublicGroup();
        PrivateGroup ec017 = new PrivateGroup(u0);

        System.out.println(ec017);

        try {
            u0.addUserToPrivateGroup(u1, ec017);
        } catch (SystemLiftException e) {
            e.printStackTrace();
            System.out.println("User not added:\n" + u1);
        }

        try {
            u0.addUserToPrivateGroup(u2, ec017);
        } catch (SystemLiftException e) {
            e.printStackTrace();
            System.out.println("User not added:\n" + u2);
        }

        System.out.println(ec017);

        try {
            u2.addUserToPrivateGroup(u4, ec017);
        } catch (SystemLiftException e) {
            e.printStackTrace();
            System.out.println("User not added:\n" + u4);
        }

        System.out.println(ec017);

        u2.addPublicGroup(gpu);
        u3.addPublicGroup(gpu);
        u4.addPublicGroup(gpu);


        ArrayList<PaymentMethod> now = new ArrayList<PaymentMethod>();
        now.add(PaymentMethod.CASH);
        u3.getProfile().getDriverProfile().offerPublicLift(12.03f, now).addGroup(gpu);

        u0.removeGroup(gpu); /*"Garanta que o método removerGrupo só remova o usuário do grupo caso ele não seja o dono (no caso de ser um grupo privado)."
        entao quer dizer que dono de grupo privado nao pode sair, mas o dono do grupo publico pode*/
//        O diagrama UML diz que removeGroup eh para ser void
        System.out.println(gpu);

        PrivateLift l = u4.getProfile().getDriverProfile().offerPrivateLift(7.8f, now);
        l.addGroup(ec017);

        l = u2.getProfile().getDriverProfile().offerPrivateLift(7.8f, now);
        l.addGroup(ec017);

        System.out.println(u0.getProfile().getRiderProfile().askLift(l)); // deve retornar true
        System.out.println(u1.getProfile().getRiderProfile().askLift(l)); // deve retornar true
        System.out.println(u3.getProfile().getRiderProfile().askLift(l)); // deve retornar false

        /*12*/ ArrayList<Profile> list = new ArrayList<Profile>();
        list.add(u0.getProfile());
        list.add(u1.getProfile());
        list.add(u2.getProfile());


        l.rateDriver(u0.getId(), 4.4f);
        l.rateDriver(u1.getId(), 4.6f);

        l.rateRiders(4.5f);

        System.out.println(u0.getProfile().getRating());
        System.out.println(u1.getProfile().getRating());
        System.out.println(u2.getProfile().getRating());

        list.sort(Profile::compareTo);

        System.out.println(list.toString()); // ver se esta mesmo ordenado


        System.out.println(u0);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);

        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println(d0);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);


        System.out.println(r0);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        System.out.println(gpu);
        System.out.println(ec017);
        System.out.println(l);


// 16. Salve todos os dados no(s) arquivo(s) apropriado(s).








    }
}