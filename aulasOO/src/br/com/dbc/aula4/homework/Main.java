package br.com.dbc.aula4.homework;

public class Main {
    public static void main(String[] args) {

        Carro fiesta = new Carro("Tesla");
        Carro tesla = new Carro();
        tesla.setModelo("Tesla Model 3");
//        fiesta.modelo = "Fiesta";
//        fiesta.quilometragem(75000);
        Carro bmw = new Carro("BMW", 8000);
        fiesta.setQuilometragem(75000);

        System.out.println(fiesta);
        System.out.println(tesla);
        System.out.println(bmw);

//        System.out.println(fiesta.getModelo());
//        fiesta.setModelo("Fiesta");
//        System.out.println(fiesta.getModelo());
//        System.out.println(fiesta.getQuilometragem());
    }
}
