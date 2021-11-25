
//classe generica que possui como parametro um elemento do tipo T
public class QuickInsertSortGenerics <T extends Comparable<? super T>> implements StrategeySort<T> {

    void quickSort(T []vet) {
        quickSort(vet,  0, vet.length - 1);
    }

    void quickSort(T []vet, int inicio, int fim) {
        if (inicio < fim) {
            insertSort(vet, inicio, fim);
        }else{
            int posicaoPivo = particiona(vet, inicio, fim);
            quickSort(vet,  inicio, posicaoPivo - 1);
            quickSort(vet,  posicaoPivo + 1, fim);
        }
    }    
    
    int particiona (T []vet, int inicio, int fim) {
        T pivo = vet[inicio];
        int i = inicio + 1, f = fim;

        while (i <= f) {

            // Se o valor da parte esquerda do vetor for menor que o pivô.
            while (vet[i].compareTo(pivo) < 0) {
                i++;
            } 
            // Se o valor da parte direita do vetor for maior que o pivô.
            while (vet[f].compareTo(pivo) > 0) {
                f--;
            } 
            if (i <= f) {
                T troca = vet[i];
                vet[i] = vet[f];
                vet[f] = troca;
                i++;
                f--;
            }           
        }
        return f;
    }

    // funcao InsertSort
    void insertSort(T[] array, int i, int j) {
        T aux;
        //percorrendo o array
        for (i=1; i<array.length; i++){
            aux = array[i]; //auxiliar recebe o elemento da posicao i
            j = i-1; //j recebe a posicao anterior de i
            while (j >= 0 && array[j].compareTo(aux) > 0){ //loop que percorre o array enquanto j for menor que zero e o vetor na posicao j seja maior que o auxiliar
                array[j+1] = array[j]; //joga o elemento para a posicao a frente
                j--;
            }
            array[j+1] = aux; //coloca o valor de aux na posicao correta no array
        }
    }
    
    @Override
    public void sort(T[] array, T[] auxArray) {
        quickSort(array, 0, array.length-1);   
    }

   
}