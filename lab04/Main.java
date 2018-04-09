/*

Qual o principal benefício da herança?

Criacao de um protocolo comum entre classes relacionadas: reusabilidade de codigo

Adicione final na classe Grupo , o que aconteceu com o código? Por que isso aconteceu? Em vez
de Grupo ser final e se definirmos GrupoPublico como final?

"error: cannot inherit from final Group" ja que classes finais nao podem ter subclasses. Nada de ruim acontece pois
PublicGroup nao tem subclasse

Crie uma variável estática em Grupo e GrupoPublico com o nome testStatic do tipo inteiro. No
main, instancie 3 objetos: a da classe Grupo, b e c da classe GrupoPublico. Faça a=b e b=c.
– Se você imprimir a variável testStatic qual das duas classes foi chamada para a, b e c?

Foi impresso o valor da variavel de acordo com o tipo da variavel referencia e nao o objeto.

– Altere as variáveis testStatic das duas classes, removendo o static. Não esqueça de adicionar
o get neste caso, pois você terá que acessar o atributo por meio de instância de objeto. O
resultado é o mesmo? O que mudou?

Mesmo overriding o getStaticTest, o staticTest retornado ainda foi o da variavel referencia e nao o do objeto.


*/



class Main {

    public static void main(String[] args) {
        User stallman = new User();
        Profile markinhoZuck = new Profile('F', "20/Avril/1889", "Nice", "Provence",
                "696", true, 3);
        Rider jockey = new Rider();
        Driver babyDriver = new Driver();
        Group googleDeveloperGroup = new Group();
        PublicGroup aoCubo = new PublicGroup();
        PrivateGroup facebookDeveloperCircles = new PrivateGroup();

        System.out.println(User.getIdGenerator());
        System.out.println(stallman);
        stallman.addGroup(googleDeveloperGroup);
        stallman.addGroup(aoCubo);
        stallman.addGroup(facebookDeveloperCircles);
        System.out.println(stallman);

        System.out.println(markinhoZuck.getDriverProfile());

        System.out.println(jockey.isPayWithCash());
        System.out.println(jockey.getProfile());

        System.out.println(Driver.getNumberOfRiders());

        googleDeveloperGroup.addMember(stallman);

        System.out.println(facebookDeveloperCircles.getMembers());


        System.out.println(stallman);
        System.out.println(markinhoZuck);
        System.out.println(jockey);
        System.out.println(babyDriver);
        System.out.println(googleDeveloperGroup);
        System.out.println(aoCubo);
        System.out.println(facebookDeveloperCircles);


//        Group a = new Group();
//        PublicGroup b = new PublicGroup();
//        PublicGroup c = new PublicGroup();
//
//        a = b;
//        b = c;
//
//        System.out.println("chamando a.staticTest = " + a.staticTest);
//        System.out.println("chamando b.staticTest = " + b.staticTest);
//        System.out.println("chamando c.staticTest = " + c.staticTest);
    }
}