import java.util.Scanner;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.imprimirPilha();

        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());

        pilha.imprimirPilha();

        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());
        System.out.println("Removendo: " + pilha.pop());
        pilha.imprimirPilha();

        System.out.println("Tentando remover de uma pilha vazia: " + pilha.pop());
    }
}
