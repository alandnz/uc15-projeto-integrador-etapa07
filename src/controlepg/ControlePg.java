package controlepg;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ControlePg {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcao;
        List<Programa> programas = new ArrayList();

        do {
            System.out.println("##  Bem vindo ao sistema ControlePG  ##");
            System.out.println("Selecione a opção desejada abaixo");
            System.out.println("1 - Cadastro de Programa");
            System.out.println("2 - Cadastro de Pedido");
            System.out.println("3 - Sair");

            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    Programa programa = new Programa();
                    programa.cadastrar(teclado);
                    programas.add(programa);
                    System.out.println("Programa cadastrado com sucesso!" + programa);
                    break;
                case "2":
                    if (programas.isEmpty()) {
                        System.out.println("Nenhum Programa cadastrado. É necessário cadastrar um Programa.");
                    } else {
                        Pedido pedido = new Pedido();
                        pedido.cadastrar(teclado, programas);
                        System.out.println("Pedido cadastrado com sucesso!" + pedido);
                    }
                    break;
                case "3":
                    System.out.println("Encerrando o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        } while (!opcao.equals("3"));

        teclado.close();
    }

}
