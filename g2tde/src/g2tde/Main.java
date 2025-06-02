package g2tde;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AutomovelManager manager = new AutomovelManager();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1 - Incluir");
            System.out.println("2 - Remover");
            System.out.println("3 - Alterar");
            System.out.println("4 - Consultar");
            System.out.println("5 - Listar ordenado");
            System.out.println("6 - Salvar e sair");
            System.out.print("Opção: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    if (manager.buscar(placa) != null) {
                        System.out.println("Placa já cadastrada.");
                        break;
                    }
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble(); sc.nextLine();
                    manager.inserir(new Automovel(placa, modelo, marca, ano, valor));
                }
                case 2 -> {
                    System.out.print("Placa a remover: ");
                    String placa = sc.nextLine();
                    System.out.println(manager.remover(placa) ? "Removido." : "Não encontrado.");
                }
                case 3 -> {
                    System.out.print("Placa a alterar: ");
                    String placa = sc.nextLine();
                    if (manager.buscar(placa) == null) {
                        System.out.println("Não encontrado.");
                        break;
                    }
                    System.out.print("Novo modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Nova marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Novo ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Novo valor: ");
                    double valor = sc.nextDouble(); sc.nextLine();
                    manager.alterar(placa, new Automovel(placa, modelo, marca, ano, valor));
                }
                case 4 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    Automovel a = manager.buscar(placa);
                    System.out.println(a != null ? a.toString() : "Não encontrado.");
                }
                case 5 -> {
                    System.out.print("Ordenar por (placa/modelo/marca): ");
                    String campo = sc.nextLine();
                    for (Automovel a : manager.listar(campo)) {
                        System.out.println(a);
                    }
                }
                case 6 -> {
                    manager.salvar();
                    System.out.println("Dados salvos. Saindo...");
                }
            }
        } while (op != 6);
        sc.close();
    }
}
