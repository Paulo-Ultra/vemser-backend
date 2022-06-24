package br.com.dbc.aula5;

import java.util.ArrayList;

public class Lista {
    public static void main(String[] args) {

        ArrayList<String> listaCompras =  new ArrayList<>();

        listaCompras.add("Batata"); // Indice = 0
        listaCompras.add("Creme de Leite"); // Indice = 1
        listaCompras.add("Frango"); // Indice = 2
        listaCompras.add("Cebola"); //Indice = 3

        System.out.println(listaCompras.size());

        System.out.println(listaCompras.get(2));
        listaCompras.remove(2);
        System.out.println(listaCompras);

        listaCompras.set(1, "Tomate");

        System.out.println(listaCompras);
    }
}
