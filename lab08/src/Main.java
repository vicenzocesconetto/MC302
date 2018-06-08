/*

PARTE I

1. É possível uma interface herdar de uma classe abstrata? É possível uma classe abstrata implementar
uma interface?

Uma interface soh pode herdar de uma interface. Sim.


2. Quais as principais diferenças entre classes abstratas e interfaces?

Classes abstratas podem ter metodos nao abstratos, interfaces nao. Todos os membros na interface eh publico, enquanto que
na classe abstrata podem haver membros privados.


3. O que acontece se uma classe implementar 2 interfaces diferentes, mas que tem um método com o
mesmo nome e assinatura?

Implementando esse tal metodo, tudo fica certo e sao implementadas duas interfaces ao mesmo tempo.


4. No caso geral, não é possível implementar métodos em interfaces. Mas a partir do Java 8, é possível
um de dois modificadores aos métodos de uma interface para que seja possível implementá-los.
Quais são esses modificadores?

static e default


PARTE II

1. Qual a diferença na leitura através de um objeto BufferedInputStream para um InputStream
(incluindo suas subclasses)?

InputStream eh uma classe abstrata com o read() feito para ler um byte por vez de um aquivo. Assim, InputStream
estabelece um protocolo comum entre as herdeiras.

O BufferedInputStream eh concreto entao voce pode fazer uma instancia dele. O metodo read() do BufferedInputStream tambem
retorna um byte por vez, mas internamente ele ja vai lendo e enchedo um buffer. Assim, a maioria das chamadas para
read() nao ficam "bloqueadas": o proximo byte ja fica no buffer e entao eh imediatamente retornado para quem chama.

Assim o InputStream eh mais lento e suas herdeiras tambem pois nenhuma delas eh buffered.


2. A classe DataOutputStream tem alguns métodos para escrita, com as assinaturas descritas abaixo.
Esses métodos dão throw em exceções do tipo IOException. Por que esse tipo de exceção é
jogada? Em que contextos faz sentido jogar uma exceção do tipo IOException?
public final void writeInt(int i) throws IOException;
public final void writeFloat(float f) throws IOException;
public final void writeByte(int b) throws IOException;
public final void writeChar(int i) throws IOException;
...;

Porque podem ocorrer varios erros na escrita de arquivos: o arquivo pode nao existir ou nao estar mais la, voce pode
nao ter permissao para escrever ou ter perdido ela, etc...

Como o proprio nome ja diz, IOExceptions fazem sentido em contextos de leitura e escrita/entrada e saida de dados pois
podem ocorrer varios imprevistos na hora de obter ou exportar informacoes.


3. Explique a utilidade da interface Serializable, como ela pode ser usada com arquivos e cite
duas exceções que métodos dessa interface jogam.

A Serializable serve para serializar e salvar o estado de objetos em memoria permanente, como arquivos.
IOException e ClassNotFoundException.

*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Profile
        /*User u0 = new User();
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

        u0.removeGroup(gpu); *//*"Garanta que o método removerGrupo só remova o usuário do grupo caso ele não seja o dono (no caso de ser um grupo privado)."
        entao quer dizer que dono de grupo privado nao pode sair, mas o dono do grupo publico pode*//*
//        O diagrama UML diz que removeGroup eh para ser void
        System.out.println(gpu);

        PrivateLift l = u4.getProfile().getDriverProfile().offerPrivateLift(7.8f, now);
        l.addGroup(ec017);

        l = u2.getProfile().getDriverProfile().offerPrivateLift(7.8f, now);
        l.addGroup(ec017);

        System.out.println(u0.getProfile().getRiderProfile().askLift(l)); // deve retornar true
        System.out.println(u1.getProfile().getRiderProfile().askLift(l)); // deve retornar true
        System.out.println(u3.getProfile().getRiderProfile().askLift(l)); // deve retornar false

        *//*12*//* ArrayList<Profile> list = new ArrayList<Profile>();
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
        System.out.println(l);*/


// 16. Salve todos os dados no(s) arquivo(s) apropriado(s).

    }
}