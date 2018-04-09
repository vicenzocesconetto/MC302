/* 
• Qual o impacto de se tentar mudar diretamente o valor do atributo nome de um dos objetos Usuario
no método main? Por quê?

Em compilation time o compilador nao permite acesso a variavel, dizendo que ha um erro e que a variavel
em questao tem acesso privado ("error: password has private access in User")


• Como você trataria o problema levantado na questão anterior? Qual seriam os prós e os contras
desta nova abordagem? Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?

Uma solucao é tornar publico.

Isso tornaria muito mais facil o acesso as variaveis mais quebraria o encapsulamento e tornaria
o codigo nao seguro.

Isso quebraria o encapsulamento.

*/
public class Main {
    public static void main(String[] args) {
        User one = new User(1, "Dali", "salvador.dali@spain.com", "moneda", true);
        User two = new User(2, "Andy", "andy.warhol@aol.com", "shoot", false);

        Profile James_Barksdale = new Profile('M', "24/Jan/1943", "Jackson", "Mizppippi", "7703394", false, 0);
        Profile Reed_Hastings = new Profile('M', "8/Out/1960", "Menlo Park", "California", "3967302", true, 7);

        System.out.println("User one:\n" + one);
        System.out.println("User two:\n" + two);
        System.out.println("Profile James Barksdale:\n" + James_Barksdale);
        System.out.println("Profile Reed Hastings:\n" + Reed_Hastings);

    }
}