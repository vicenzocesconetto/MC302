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
    }
}






















