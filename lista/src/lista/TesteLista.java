package lista;

import java.util.Scanner;

public class TesteLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListaArray lista = new ListaArray(5);
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar elemento ao final");
            System.out.println("2. Adicionar elemento em posição específica");
            System.out.println("3. Remover elemento");
            System.out.println("4. Imprimir lista");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o número para adicionar ao final: ");
                    int numero = scanner.nextInt();
                    lista.adicionar(numero);
                    break;
                case 2:
                    System.out.print("Digite o número para adicionar: ");
                    numero = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    lista.adicionarNaPosicao(numero, posicao);
                    break;
                case 3:
                    System.out.print("Digite a posição do elemento a remover: ");
                    posicao = scanner.nextInt();
                    lista.remover(posicao);
                    break;
                case 4:
                    lista.imprimirLista();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}