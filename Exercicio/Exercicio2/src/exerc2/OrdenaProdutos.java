package exerc2;

import java.util.Scanner;

class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class OrdenaProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o nome do " + (i + 1) + "º produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto \"" + nome + "\": ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            produtos[i] = new Produto(nome, preco);
        }

        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < produtos.length - 1; i++) {
                if (produtos[i].preco < produtos[i + 1].preco) {
                    Produto temp = produtos[i];
                    produtos[i] = produtos[i + 1];
                    produtos[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);

        System.out.println("\nProdutos do mais caro para o mais barato:");
        for (Produto p : produtos) {
            System.out.printf("%s: R$ %.2f%n", p.nome, p.preco);
        }

        scanner.close();
    }
}
