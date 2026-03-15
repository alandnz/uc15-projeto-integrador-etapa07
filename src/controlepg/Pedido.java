package controlepg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class Pedido {

    private int id;
    private Programa programa;
    private String numeroProtocolo;
    private String nomeSolicitante;
    private String numeroPcdp;
    private float valorDiaria;
    private float valorPassagem;
    private LocalDate data;
    private String fonteRecurso;
    private TipoBeneficiario tipoBeneficiario;
    private String observacao;

    public Pedido() {
    }

    public Pedido(int id, Programa programa, String numeroProtocolo,
            String nomeSolicitante, String numeroPcdp, float valorDiaria,
            float valorPassagem, LocalDate data, String fonteRecurso,
            TipoBeneficiario tipoBeneficiario, String observacao) {
        this.id = id;
        this.programa = programa;
        this.numeroProtocolo = numeroProtocolo;
        this.nomeSolicitante = nomeSolicitante;
        this.numeroPcdp = numeroPcdp;
        this.valorDiaria = valorDiaria;
        this.valorPassagem = valorPassagem;
        this.data = data;
        this.fonteRecurso = fonteRecurso;
        this.tipoBeneficiario = tipoBeneficiario;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getNumeroPcdp() {
        return numeroPcdp;
    }

    public void setNumeroPcdp(String numeroPcdp) {
        this.numeroPcdp = numeroPcdp;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public float getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(float valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getFonteRecurso() {
        return fonteRecurso;
    }

    public void setFonteRecurso(String fonteRecurso) {
        this.fonteRecurso = fonteRecurso;
    }

    public TipoBeneficiario getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void cadastrar(Scanner teclado, List<Programa> programas) {
        System.out.println("Informe o ID do pedido a ser cadastrado:");
        this.id = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Selecione um programa já cadastrado:");

        for (int i = 0; i < programas.size(); i++) {
            System.out.println((i + 1) + " - " + programas.get(i).getNome());
        }

        while (true) {
            System.out.print("Digite o número do programa: ");
            int opcaoPrograma = Integer.parseInt(teclado.nextLine());

            if (opcaoPrograma >= 1 && opcaoPrograma <= programas.size()) {
                this.programa = programas.get(opcaoPrograma - 1);
                break;
            } else {
                System.out.println("Programa inválido! Selecione um número existente.");
            }
        }

        System.out.println("Informe o número do protocolo:");
        this.numeroProtocolo = teclado.nextLine();

        System.out.println("Informe o nome do solicitante:");
        this.nomeSolicitante = teclado.nextLine();

        System.out.println("Informe o número da PCDP:");
        this.numeroPcdp = teclado.nextLine();

        System.out.println("Informe o valor da diária:");
        this.valorDiaria = Float.parseFloat(teclado.nextLine());

        System.out.println("Informe o valor da passagem:");
        this.valorPassagem = Float.parseFloat(teclado.nextLine());

        System.out.println("Informe a data da viagem no formato dd/MM/yyyy::");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(teclado.nextLine(), formatter);

        System.out.println("Informe a fonte do recurso:");
        this.fonteRecurso = teclado.nextLine();

        System.out.println("Informe o tipo do beneficiário:");
        System.out.println("ALUNO, PROFESSOR, SERVIDOR ou EXTERNO");
        this.tipoBeneficiario = TipoBeneficiario.valueOf(teclado.nextLine().toUpperCase());

        System.out.println("Informe alguma observação caso exista:");
        this.observacao = teclado.nextLine();

    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "\n Id: " + id
                + "\n Programa: " + programa.getNome()
                + "\n Número do Protocolo: " + numeroProtocolo
                + "\n Nome do Solicitante: " + nomeSolicitante
                + "\n Número PCDP: " + numeroPcdp
                + "\n Valor da Diária: " + String.format("%.2f", valorDiaria)
                + "\n Valor da Passagem: " + String.format("%.2f", valorPassagem)
                + "\n Data da Viagem: " + data.format(formatter)
                + "\n Fonte de Recurso: " + fonteRecurso
                + "\n Tipo do Beneficiário: " + tipoBeneficiario
                + "\n Observação: " + observacao;
    }
}
