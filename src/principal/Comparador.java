package principal;
import java.util.Comparator;

class Comparador implements Comparator<int[]> {
	private int index_to_compare;

	public Comparador(int index) {
		index_to_compare = index;
	}

        @Override
	public int compare(int[] elem1, int[] elem2) {
		return compare(elem1, elem2, index_to_compare); // recursividade para tratar diferentes colunas
	}
	
	public int compare(int[] elem1, int elem2[], int index) {
    if (elem1.length == index) // verifica se ja procurou em todas as colunas
      return 0; // elementos iguais

    if (elem1[index] == elem2[index]) // verifica se os elementos nos indices "index" sao iguais
      return compare(elem1, elem2, index + 1); // verifica na coluna seguinte

    return elem1[index] - elem2[index]; // retorna a diference entre os elementos
  }
}