package exercício2;

public class main {
    public static void main(String[] args) {
      
        Estoque estoque = new Estoque();

        estoque.adicionarProduto(new Produto(1, "Arroz", 50));
        estoque.adicionarProduto(new Produto(2, "Feijão", 30));

        System.out.println("Produtos no estoque:");
        estoque.listarProdutos();

        System.out.println("\nBuscando produto por código 1:");
        Produto produto1 = estoque.buscarPorCodigo(1);
        System.out.println(produto1 != null ? produto1 : "Produto não encontrado.");

        System.out.println("\nBuscando produto por nome 'Feijão':");
        Produto produto2 = estoque.buscarPorNome("Feijão");
        System.out.println(produto2 != null ? produto2 : "Produto não encontrado.");

        System.out.println("\nRemovendo produto com código 1:");
        System.out.println(estoque.removerProduto(1));

        System.out.println("\nProdutos restantes no estoque:");
        estoque.listarProdutos();
    }
}
