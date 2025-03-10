package lista;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();

        ListaArray lista = new ListaArray(capacidade);
        
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Imprimir lista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    lista.adicionar(elemento);
                    break;
                case 2:
                    System.out.print("Digite a posição a ser removida: ");
                    int posicao = scanner.nextInt();
                    lista.remover(posicao);
                    break;
                case 3:
                    lista.imprimirLista();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
        
        scanner.close();
    }
}