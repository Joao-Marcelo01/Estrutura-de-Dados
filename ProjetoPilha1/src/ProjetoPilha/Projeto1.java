package ProjetoPilha;

public class Projeto1 {
	 
	private int topo;
	private int[] elementos;
	private int capacidade;
	public Projeto1(int capacidade) {
	this.capacidade = capacidade;
	this.elementos = new int[capacidade];
	this.topo = -1; // Indica que a pilha está vazia
	}
	public boolean isEmpty() {
	return topo == -1;

	}
	public boolean isFull() {
	return topo == capacidade - 1;
	}
	public void push(int elemento) {
	if (isFull()) {
	System.out.println("Erro: Pilha cheia!");
	return;
	}
	elementos[++topo] = elemento;
	}
	public int pop() {
	if (isEmpty()) {
	System.out.println("Erro: Pilha vazia!");
	return -1; // Indicativo de erro
	}
	return elementos[topo--];
	}
	public int peek() {
	if (isEmpty()) {
	System.out.println("Erro: Pilha vazia!");
	return -1;
	}
	return elementos[topo];
	}
	public int size() {
	return topo + 1;
	}
	public void imprimirPilha() {
	if (isEmpty()) {
	System.out.println("A pilha está vazia.");

	return;
	}
	System.out.print("Pilha: ");
	for (int i = 0; i <= topo; i++) {
	System.out.print(elementos[i] + " ");
	}
	System.out.println();
	}
	public class TestePilha {
		public static void main(String[] args) {
		Projeto1 pilha = new Projeto1(5);
		pilha.push(10);
		pilha.push(20);
		pilha.push(30);
		pilha.imprimirPilha();
		System.out.println("Topo da pilha: " + pilha.peek());
		System.out.println("Removendo: " + pilha.pop());
		pilha.imprimirPilha();
		}

	}
	}
	