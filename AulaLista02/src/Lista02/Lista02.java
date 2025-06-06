package Lista02;

public class ListaArray {
	
	final public static int TAMANHO_INICIAL = 3;
	final public static int FATOR_CRESCIMENTO = 5;
	final public static int NAO_ESTA_PRESENTE = -1;
	
	private Object[] arrayInterno;
	private int numElementos;
	
	public ListaArray() {
		this.numElementos = 0;
		this.arrayInterno = new Object[TAMANHO_INICIAL];
	}
	private void verificarNecessidadeDeCrescimento() {
		int tamanho = this.arrayInterno.lenght;
		if(tamanho = this.numElementos) {
			Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];
			for(int i = 0; i < tamanho; i++)
				novoArray[i] = this.arrayInterno[i];
			this.arrayInterno = novoArray;
		}
	}
	public boolean adicionar(Object elemento) {
		this.verificarNecessidadeDeCrescimento();
		this.arrayInterno[this.numElementos] = elemento;
		this.numElementos++;
		return true;
	}
	public boolean adicionar(Object elemento, int posicao) {
		if(posicao < 0 || posicao > this.numElementos)
			return false;
		this.verificarNecessidadeDeCrescimento();
		for(int i = this.numElementos; i > posicao; i--)
			this.arrayInterno[i] = this.arrayInterno[i-1];
		this.arrayInterno[posicao] = elemento;
		return true;
	}
	public Object obter(int posicao) {
		if(posicao < 0 || posicao >= this.numElementos)
			return null;
		return this.arrayInterno[posicao];
	}
	public int posicaoDe(Object elemento) {
		for(int i = 0; i < this.numElementos; i++)
			if(this.arrayInterno[i] == elemento)
				return i;
		return NAO_ESTA_PRESENTE;
	}
	public boolean remover(int posicao) {
		if(posicao < 0 || posicao >= this.numElementos)
			return false;
		for(int i = posicao; i < this.numElementos-1; i++)
			this.arrayInterno[i] = this.arrayInterno[i+1];
		this.arrayInterno[this.numElementos - 1] = null;
		this.numElementos--;
		return true;
	}
	public boolean remover(Object elemento) {
		int posicao = this.posicaoDe(elemento);
		if(posicao == NAO_ESTA_PRESENTE)
			return false;
		return this.remover(posicao);
	}
	public int obterNumElementos() {
		return this.numElementos;
	}
}
