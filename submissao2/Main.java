/*É possível escrever uma classe sem escrever nenhum construtor? Por quê?

Sim, pois todas as classes sao subclasses de Object que ja possui um construtor
que todas as classes herdam.

Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?

Nao, porque o compilador nao permite referencias a variaveis nao estaticas em contextos
estaticos: "non-static variable isso(minha variavel) cannot be referenced from a static context".

Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?

Sim, pois a mesma copia e' acessivel para todos os objetos daquela classe.

*/
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Driver d1 = new Driver();
        Rider r1 = new Rider();

        Scanner scan = new Scanner(System.in);

        System.out.println("[Dados do caronante]");
        System.out.println("Tempo de habilitacao: ");
        d1.setHabilitationTime(scan.nextInt());

        System.out.println("Genero de musica preferido: ");
        d1.setFavoriteMusicGenre(scan.next());

        System.out.println("Placa do carro: ");
        d1.setDriverLicense(scan.next());

        System.out.println("Licenca: ");
        d1.setLicensePlate(scan.next());

        System.out.println("Marca do carro: ");
        d1.setVehicleBrand(scan.next());

        System.out.println("Modelo: ");
        d1.setVehicleModel(scan.next());

        System.out.println("Quantidade de lugares: ");
        d1.setSeatsAvailable(scan.nextInt());

        System.out.println("[Dados do caroneiro]");
        System.out.println("Cartao de credito: ");
        r1.setCreditCard(scan.next());

        System.out.println("Pagara com cartao?");
        String answer = scan.next();
        boolean ans = false;

        if(answer.equals("sim") || answer.equals("Sim") || answer.equals("s") ) {
            ans = true;
        }

        r1.setPayWithCash(ans);


        System.out.println("Caronante 1:\n" + d1);
        System.out.println("Caroneiro 1:\n" + r1);
    }
}