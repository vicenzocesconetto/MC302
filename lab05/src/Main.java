/*

Qual a diferença de um enumerate que foi declarado com um modificador public e um que
não foi?

O public tem acesso para qualquer codigo enquanto o nao public eh package private: so o codigo do pacote conseque acessar.

Qual a vantagem e quando se deve utilizar um enumerate ao invés de um campo String?

Com o enum, o codigo fica consistente e limita as possibilidades para opcoes imutaveis que fazem sentido, enquanto um campo com
String teria infinitas possibilidades e teriamos que checar para as todas as opcoes de pagamento (o que nao eh o mesmo que todos
os anagramas que um string comporta, o que eh literalmente infinito). Alem disso, as opcoes se tornam constantes,
ou seja, imutavies, imutaveis. Por exemplo, nesse lab tivemos que testar 3 possibilidades pra pagamentos ao inves de comparar
strings que tinha a chance de nao cair em nenhum dos 3 casos.

*/
public class Main {
    public static void main(String[] args) {
        Driver d = new Driver();
        PrivateArrayLift pv = new PrivateArrayLift(d);
        PublicArrayLift pb = new PublicArrayLift(d);
        ArrayLift lift = new ArrayLift(d);

        System.out.println("ArrayLift: " + lift.addPaymentMethod(PaymentMethod.CREDITCARD));
        System.out.println("PublicArrayLift: " + pb.addPaymentMethod(PaymentMethod.CREDITCARD));
        System.out.println("PrivateArrayLift: " + pv.addPaymentMethod(PaymentMethod.CREDITCARD));

        System.out.println("ArrayLift: " + lift.addPaymentMethod(PaymentMethod.CASH));
        System.out.println("PublicArrayLift: " + pb.addPaymentMethod(PaymentMethod.CASH));
        System.out.println("PrivateArrayLift: " + pv.addPaymentMethod(PaymentMethod.CASH));

        System.out.println("ArrayLift: " + lift.isLiftFree());
        System.out.println("PublicArrayLift: " + pb.isLiftFree());
        System.out.println("PrivateArrayLift: " + pv.isLiftFree());

        System.out.println("ArrayLift: " + lift.checkPaymentMethod(PaymentMethod.CASH));
        System.out.println("PublicArrayLift: " + pb.checkPaymentMethod(PaymentMethod.CASH));
        System.out.println("PrivateArrayLift: " + pv.checkPaymentMethod(PaymentMethod.CASH));

        System.out.println("ArrayLift: " + lift.removePaymentMethod(PaymentMethod.CASH));
        System.out.println("PublicArrayLift: " + pb.removePaymentMethod(PaymentMethod.CASH));
        System.out.println("PrivateArrayLift: " + pv.removePaymentMethod(PaymentMethod.CASH));

        System.out.println("ArrayLift: " + lift.addPaymentMethod(PaymentMethod.FREE));
        System.out.println("PublicArrayLift: " + pb.addPaymentMethod(PaymentMethod.FREE));
        System.out.println("PrivateArrayLift: " + pv.addPaymentMethod(PaymentMethod.FREE));

        System.out.println("ArrayLift: " + lift.checkPaymentMethod(PaymentMethod.CASH));
        System.out.println("PublicArrayLift: " + pb.checkPaymentMethod(PaymentMethod.CASH));
        System.out.println("PrivateArrayLift: " + pv.checkPaymentMethod(PaymentMethod.CASH));

        System.out.println("ArrayLift: " + lift.isLiftFree());
        System.out.println("PublicArrayLift: " + pb.isLiftFree());
        System.out.println("PrivateArrayLift: " + pv.isLiftFree());

        System.out.println("ArrayLift: " + lift);
        System.out.println("PublicArrayLift: " + pb);
        System.out.println("PrivateArrayLift: " + pv);
    }
}
