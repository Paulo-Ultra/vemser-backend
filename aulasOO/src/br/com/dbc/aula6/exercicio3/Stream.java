package br.com.dbc.aula6.exercicio3;

import br.com.dbc.aula6.Pessoa;
import br.com.dbc.aula6.PessoaNomeId;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        List<Salario> listaSalario = new ArrayList<>();
        listaSalario.add(new Salario(1, 6500));
        listaSalario.add(new Salario(2, 5300));

        //1- listar todas as pessoas
        lista.stream()
                .forEach(pessoa -> System.out.println(pessoa));
        //2- filtrar todas as pessoas com salario maior do que 5 mil
        List<Pessoa> listaTodos = lista.stream()
                .filter(pessoa -> {
                    return pessoa.getSalario() > 5000;
                })
                .toList();
        System.out.println(listaTodos);
        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        List<Pessoa> listaDesenvolvedor = lista.stream()
                .filter(pessoa -> {
                    return pessoa.getCargo() == "Desenvolvedor";
                })
//                .allMatch(pessoa -> pessoa.getCargo() == "Desenvolvedor")
                .toList();
        System.out.println(listaDesenvolvedor);
        //4- fazer a média salarial de todos
        Double listaMediaSalarios = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println (listaMediaSalarios);
        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        Boolean listaSalarioMaior20000 = lista.stream()
                .anyMatch(pessoa -> {
                    return pessoa.getSalario() > 20000;
                });
        System.out.println(listaSalarioMaior20000);

        //6 - retornar uma lista de todos os ids das pessoas
        List<Integer> listaIds = lista.stream()
                .map(pessoa -> pessoa.getId()).toList();
        System.out.println(listaIds);
        //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        Map<Integer, Double> meuMapaDeSalario = listaSalario.stream()
                .collect(Collectors.toMap(Salario::getId, Salario::getSalario));
        System.out.println(meuMapaDeSalario);

        //8- retornar um Map contendo os ids e os nomes dos colaboradores
                Map<Integer, String> meuMapaDePessoasPorId = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(meuMapaDePessoasPorId);
        //9- com o mapa da 8, retornar o nome com o id=2
//        meuMapaDePessoasPorId = lista.stream()
//        .filter(pessoa -> pessoa.getId() == 2)
//                .toList();
        System.out.println(meuMapaDePessoasPorId);
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }
    }

    public static class Salario {

        private int id;
        private double salario;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "salario=" + salario +
                    ", id=" + id +
                    '}';
        }
    }

}
