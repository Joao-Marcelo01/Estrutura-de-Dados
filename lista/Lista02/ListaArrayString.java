import java.util.Scanner;

class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equals(nome)) {
                return true;
            }
        }
        return false;
    }
}

public class TesteListaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaArrayString lista = new ListaArrayString(4);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar nome");
            System.out.println("2. Remover nome por índice");
            System.out.println("3. Buscar nome");
            System.out.println("4. Imprimir lista");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome para adicionar: ");
                    String nome = scanner.nextLine();
                    lista.adicionar(nome);
                    break;
                case 2:
                    System.out.print("Digite a posição do nome a remover: ");
                    int posicao = scanner.nextInt();
                    lista.remover(posicao);
                    break;
                case 3:
                    System.out.print("Digite o nome a buscar: ");
                    nome = scanner.nextLine();
                    if (lista.buscar(nome)) {
                        System.out.println("Nome encontrado na lista.");
                    } else {
                        System.out.println("Nome não encontrado.");
                    }
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