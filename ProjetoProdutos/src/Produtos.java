import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Produtos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto[] produtos = new Produto[10];

        System.out.println("Digite os dados dos 10 produtos:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.printf("Produto %d:%n", i + 1);
            System.out.print("Código: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Valor: ");
            double valor = sc.nextDouble();

            produtos[i] = new Produto(codigo, nome, valor);
            System.out.println();
        }

        // A) Ordenar por código
        Arrays.sort(produtos, Comparator.comparingInt(p -> p.codigo));
        System.out.println("Produtos ordenados por CÓDIGO:");
        for (Produto p : produtos) {
            System.out.printf("Código: %d, Nome: %s, Valor: R$ %.2f%n", p.codigo, p.nome, p.valor);
        }

        System.out.println("\n=============================\n");

        // B) Ordenar por valor
        Arrays.sort(produtos, Comparator.comparingDouble(p -> p.valor));
        System.out.println("Produtos ordenados por VALOR (crescente):");
        for (Produto p : produtos) {
            System.out.printf("Valor: R$ %.2f, Código: %d, Nome: %s%n", p.valor, p.codigo, p.nome);
        }

        sc.close();
    }

    // Classe Produto
    static class Produto {
        int codigo;
        String nome;
        double valor;

        Produto(int codigo, String nome, double valor) {
            this.codigo = codigo;
            this.nome = nome;
            this.valor = valor;
        }
    }
}