package arvores;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvore =  new ArvoreBinaria();
		
		arvore.inserir(3);
		arvore.inserir(6);
		arvore.inserir(9);
		arvore.inserir(8);
		arvore.inserir(5);
		arvore.inserir(0);
		
		LinkedList<Integer> lista = arvore.arvoreParaListaEncadeada();
		
		for(Integer dado : lista) {
			System.out.println(dado);
		}
				
	}

}
