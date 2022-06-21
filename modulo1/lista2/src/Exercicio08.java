import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer linha = 5, coluna = 4, maiorNotaMatricula = 0;
        Integer[][] alunos = new Integer[linha][coluna];
        Double mediaNotaFinal = 0.0, maiorNotaFinal = 0.0;

        for (Integer i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                switch (j) {

                    case 0 -> {
                        System.out.println("Informe o " + (i + 1) + "° número de matrícula: ");
                        alunos[i][j] = sc.nextInt();
                    }
                    case 1 -> {
                        System.out.println("Informe a média das provas: ");
                        alunos[i][j] = sc.nextInt();
                    }
                    case 2 -> {
                        System.out.println("Informe a média dos trabalhos: ");
                        alunos[i][j] = sc.nextInt();
                        mediaNotaFinal += (alunos[i][1] * 0.6) + (alunos[i][2] * 0.4);
                        alunos[i][j + 1] = (int) ((alunos[i][1] * 0.6) + (alunos[i][2] * 0.4));
                        if (alunos[i][j + 1] > maiorNotaFinal) {
                            maiorNotaMatricula = (alunos[i][0]);
                            maiorNotaFinal = Double.valueOf(alunos[i][j + 1]);
                        }
                    }
                }
            }
        }
                        sc.close();
                        mediaNotaFinal /= alunos.length;
                        System.out.printf("Matrícula que obteve a maior nota final: %d %nNota: %.2f", maiorNotaMatricula, maiorNotaFinal);
                        System.out.printf("%nMédia das notas finais: %.2f", mediaNotaFinal);
    }
}