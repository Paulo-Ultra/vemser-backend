package br.com.dbc.aula1;

public class VariaveisEConstantes {
    public static void main(String[] args) {
        //Inicia o meu programa atribuindo as variáveis
        /*
        Variável, idade,
        nome,
        Altura e assim por diante...
         */
        int idade = 30;
        String nome = "Paulo";
        float altura = 1.70f;
        double peso = 71.0;
        boolean ehSolteiro = false;

        final String SEU_NOME_EH = "Seu nome é ";

        nome = "Paulo Ricardo";
        //SEU_NOME_EH = "Seu apelido é ";


        //Imprime o valor das variáveis
        System.out.println(SEU_NOME_EH + nome + ", tem " + idade + " anos, " + altura + "m e "
                + peso + "kg.");
    }
}
