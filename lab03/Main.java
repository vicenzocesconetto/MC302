/*

Tente modificar o valor da carteira de motorista (que agora é um atributo final) de algum caronante.
Crie um setter se necessário. Foi possível fazer a modificação? Explique

Obviamente nao, por que o objetivo de um atributo final eh sua imutabilidade: error: cannot assign a value to final variable driverLicense


Agora, no método main, crie uma variável final do tipo Caronante, e instancie ela com os valores
que preferir. Tente modificar algum atributo do objeto através de um setter, como o atributo referente
ao tempo de habilitação. Foi possível modificar esse atributo, mesmo com o objeto sendo
final? Por quê?

Obviamente, o "ponteiro" eh imutavel mas o que tem na posicao de memoria que ele aponta nao esta protegido pelo final


Agora adicione o modificador final no atributo caroneiros da classe Carona, e execute seu programa
novamente. O comportamento do programa mudou? Por que essa alteração fez/não fez efeito?

Mais uma vez nao, pois a referencia eh que eh imutavel. Nao mudando ela, tudo ocorre sem problemas.

No cenário que foi construído, onde a ocupação máxima é definida no objeto carona, qual(is) a(s)
vantagem(ns)/desvantagem(ns) (caso existam) de se adotar a solução com array e com ArrayList?

Arraylist eh mais lento e aloca mais memoria desnecessariamente em contexto em que sabemos que a quantidade de itens eh fixa.
Arrays tem o tamanho fixo entao adicionar requer desalocar, alocar e copiar. Arraylist sao mais rapidos nesses casos de imprevisibilidade.


*/


import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Driver driver = new Driver();
        Rider[] riders = new Rider[4];
        Lift lift = new Lift(driver);
        lift.setMaxOccupation(3);

        for (int i = 0; i < 4; i++) {
            riders[i] = new Rider();
            System.out.println(lift.addRider(riders[i]));
        }

//        final Driver j = new Driver();
//        j.setHabilitationTime(4);

        System.out.println(lift);


        ArrayLift arrayLift = new ArrayLift(driver);
        arrayLift.setMaxOccupation(3);


        for (int i = 0; i < 4; i++) {
            System.out.println(arrayLift.addRider(riders[i]));
        }

        System.out.println(arrayLift);

    }
}