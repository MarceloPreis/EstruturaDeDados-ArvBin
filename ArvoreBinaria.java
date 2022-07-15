package arvores;

import java.util.LinkedList;

public class ArvoreBinaria {
	private static LinkedList<Integer> lista = new LinkedList<Integer>();

	private class Nodo {
		private int dado;
		private Nodo esq, dir;


		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
		}
	}

	Nodo raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	public void inserir(int dado) {
		raiz = inserirDado(raiz, dado);
	}

	private Nodo inserirDado(Nodo raiz, int dado) {
		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if (dado < raiz.dado)
			raiz.esq = inserirDado(raiz.esq, dado);
		else if (dado > raiz.dado)
			raiz.dir = inserirDado(raiz.dir, dado);
		return raiz;
	}

	public void mostrarOrdenado() {
		mostrandoOrdenado(raiz);
	}

	private void mostrandoOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado);
			mostrandoOrdenado(raiz.dir);
		}
	}
	
	//a) Mostrar o maior número
	public void maior() {
		encontraMaior(raiz);
	}

	private void encontraMaior(Nodo raiz) {
		if (raiz == null)
			return;
		if (raiz.dir == null)
			System.out.println(raiz.dado);
		else
			encontraMaior(raiz.dir);
	}
	
//	b) Mostrar o menor número
	public void menor() {
		encontraMenor(raiz);
	}

	private void encontraMenor(Nodo raiz) {
		if (raiz == null)
			return;
		if (raiz.esq == null)
			System.out.println(raiz.dado);
		else
			encontraMenor(raiz.esq);
	}
	
	//c) Mostrar Folhas
	public void mostraFolhas() {
		encontraFolhas(raiz);
	}

	private void encontraFolhas(Nodo raiz) {
		if (raiz == null)
			return;
		else if ((raiz.esq == null) && (raiz.dir == null))
			System.out.println(raiz.dado);
		encontraFolhas(raiz.esq);
		encontraFolhas(raiz.dir);
	}
	
//	d) Mostrar os nós ancestrais de um nó
	public void mostrarAncestrais(int dado) {
		mostrandoAncestrais(raiz, dado);
	}

	private void mostrandoAncestrais(Nodo raiz, int dado) {
		if (dado == raiz.dado || raiz == null) return;
		System.out.println(raiz.dado);
		if (dado > raiz.dado) mostrandoAncestrais(raiz.dir, dado);
		else mostrandoAncestrais(raiz.esq, dado);
	}
	
//	e) Mostrar os nós descendentes de um nó
	public void mostrarDescendentes(int dado) {
		mostrandoDescendentes(raiz, dado, false);
	}

	private void mostrandoDescendentes(Nodo raiz, int dado, boolean nodoAchado) {
		if (raiz == null) return;
		if (nodoAchado)
			System.out.println(raiz.dado);
		if (raiz.dado == dado) 
			nodoAchado = true;
		mostrandoDescendentes(raiz.dir, dado, nodoAchado);
		mostrandoDescendentes(raiz.esq, dado, nodoAchado);
	}
	
//	f) Mostrar a subárvore da direita de um nó
	public void mostrarSubarvoreDireita(int dado) {
		mostrandoSubarvoreDireita(raiz, dado);
	}
	
	private void mostrandoSubarvoreDireita(Nodo raiz, int dado) {
        if(raiz == null)
            return;
        if(raiz.dado == dado) {
            mostrandoOrdenado(raiz.dir);
            return;
        }else {
        	mostrandoSubarvoreDireita(raiz.dir, dado);
        	mostrandoSubarvoreDireita(raiz.esq, dado);
        }
    }
	
//	g) Mostrar a subárvore da esquerda de um nó
	public void mostrarSubarvoreEsquerda(int dado) {
		mostrandoSubarvoreEsquerda(raiz, dado);
	}
	
	private void mostrandoSubarvoreEsquerda(Nodo raiz, int dado) {
        if(raiz == null)
            return;
        if(raiz.dado == dado) {
            mostrandoOrdenado(raiz.esq);
            return;
        }else {
        	mostrandoSubarvoreEsquerda(raiz.dir, dado);
        	mostrandoSubarvoreEsquerda(raiz.esq, dado);
        }
    }
	
//	h) Contar quantos elementos existe na árvore
	public int numeroElementos() {
        return numeroElementos(raiz);
    }

    private int numeroElementos(Nodo raiz) {
        if(raiz == null)
            return 0;
        return 1 + numeroElementos(raiz.esq) + numeroElementos(raiz.dir);
    }
    
//   i) Transformar a árvore numa lista encadeada
    public LinkedList<Integer> arvoreParaListaEncadeada(){
    	return transformandoArvoreParaListaEncadeada(raiz);
    }
    
    public LinkedList<Integer> transformandoArvoreParaListaEncadeada(Nodo raiz){
    	if (raiz == null)
    		return null;
    	lista.add(raiz.dado);
    	transformandoArvoreParaListaEncadeada(raiz.dir);
    	transformandoArvoreParaListaEncadeada(raiz.esq);
        return lista; 
    }


//	j) Mostrar somente os números pares
	public void mostrarPares() {
		mostrandoPares(raiz);
	}

	private void mostrandoPares(Nodo raiz) {
		if (raiz != null) {
			if (raiz.dado % 2 == 0) {
				System.out.println(raiz.dado);
			}
			mostrandoPares(raiz.esq);
			mostrandoPares(raiz.dir);
		}
	}
}