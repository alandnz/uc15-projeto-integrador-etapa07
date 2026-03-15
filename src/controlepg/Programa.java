package controlepg;

import java.util.Scanner;

public class Programa {

    private int id;
    private String nome;
    private String sigla;
    private float valorRecebido;

    public Programa() {
    }

    public Programa(int id, String nome, String sigla, float valorRecebido) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.valorRecebido = valorRecebido;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public void cadastrar(Scanner teclado) {
        System.out.println("Informe o ID do Programa a ser cadastrado:");
        this.id = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Informe o nome do Programa:");
        this.nome = teclado.nextLine();

        System.out.println("Informe a sigla do Programa:");
        this.sigla = teclado.nextLine();

        System.out.println("Informe o valor recebido pelo Programa");
        this.valorRecebido = teclado.nextFloat();
        teclado.nextLine();
    }

    @Override
    public String toString() {
        return "\n Id: " + id
                + "\n Nome do Programa: " + nome
                + "\n Sigla: " + sigla
                + "\n Valor Recebido: " + String.format("%.2f", valorRecebido);
    }

}
