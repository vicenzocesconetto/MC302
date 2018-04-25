import java.util.ArrayList;

/*

Há diversos relacionamentos bi-direcionais em todo o sistema, como é o caso entre Carona e CaronaCaroneiro,
por exemplo. Quais são as vantagens e desvantagens de se utilizar relacionamentos
bi-direcionais?

Vantagens: ambos os lados conseguem ver a relacao; ambos conseguem mandar mensagens para a outra entidade;
ambos tem informacao um do outro.

Desvantagens: provavelmente ira haver informacao duplicada; pode causar inconsistencia;


O relacionamento entre a classe Carona e Caronante não é de muitos para muitos. Considerando
esse fato, foi realmente necessário criar a classe CaronaCaronante? Qual seria uma alternativa se
não quiséssemos criar a classe associativa, mas ainda assim guardar informação do relacionamento
(nesse caso, a nota)? Quais as vantagens e desvantagens dessa abordagem alternativa, comparando
com a atual?

Nao foi. Poderiamos fazer a referencia para Carona diretamente assim tambem para o Caronante. A Alternativa seria
guardar essas informacoes na propria carona. Simplicidade; haveria menos classes, seria mais facil manter o sistema,
haveria menos dados desnecessarios;


Em um sistema real, o funcionamento dos métodos criados (caso nenhuma modificação adicional
tenha sido feita) são suficientes para garantir consistência do sistema? É possível que haja algum
problema com um relacionamento entre as classes caso não seja feito alguma verificação adicional?
Por exemplo, poderíamos chegar em um estado onde um caronante se relaciona com uma carona,
mas tal carona não tem referência a esse caronante? Como poderíamos impedir que algo assim
ocorra? Caso no seu sistema não seja possível criar esse tipo de inconsistência, então "Não é
possível"é uma resposta válida (mas iremos verificar se é verdade).


Nao, nao eh. Sim, nosso sistema ainda eh vulneravel a inconsistencias. Sim. Checando nas classes relacionadas se os dados
estao batendo corretamente.

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

        r2.setProfile(p2);
        r3.setProfile(p3);
        r4.setProfile(p4);

        ArrayList<PaymentMethod> pay = new ArrayList<PaymentMethod>();
        pay.add(PaymentMethod.CASH);
        ArrayLift carona = d1.offerLift(1.4f, pay);
        carona.addRider(r2);
        carona.addRider(r3);
        carona.addRider(r4);

        boolean var = carona.giveRiderRating(2, p1.getRating());

        System.out.println(var);
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

        System.out.println(carona);
        System.out.println("User id = 1, Driver, rating: " + p1.getRating());
        System.out.println("User id = 2, Rider, rating: " + p2.getRating());
        System.out.println("User id = 3, Rider, rating: " + p3.getRating());
        System.out.println("User id = 4, Rider, rating: " + p4.getRating());

    }
}
