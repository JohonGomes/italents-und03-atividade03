package AtividadesUnd03.exe01;
/*
Implemente um algoritmo de busca binária para encontrar um elemento específico em um array
ordenado de inteiros. Retorne a posição do número ou -1 se não for encontrado.
*/

public class exe04 {

        // Metodo que realiza a busca binária
        public static int buscaBinaria(int[] array, int alvo) {
            // Inicializa os índices de início e fim
            int inicio = 0;
            int fim = array.length - 1;

            // Continua a busca enquanto o início não ultrapassar o fim
            while (inicio <= fim) {
                // Calcula o índice do meio
                int meio = inicio + (fim - inicio) / 2;

                // Verifica se o elemento do meio é o alvo
                if (array[meio] == alvo) {
                    return meio; // Elemento encontrado, retorna sua posição
                }

                // Se o alvo for menor que o elemento do meio, ajusta o fim
                if (array[meio] > alvo) {
                    fim = meio - 1;
                }
                // Se o alvo for maior que o elemento do meio, ajusta o início
                else {
                    inicio = meio + 1;
                }
            }

            // Se chegou aqui, o elemento não foi encontrado
            return -1;
        }

        public static void main(String[] args) {
            // Array ordenado para teste
            int[] numeros = {1, 3, 5, 7, 9, 11, 13, 15, 17};
            int alvo = 7; // Número a ser buscado

            // Chama o metodo de busca binária
            int resultado = buscaBinaria(numeros, alvo);

            // Verifica e exibe o resultado
            if (resultado != -1) {
                System.out.println("O número " + alvo + " foi encontrado na posição " + resultado + ".");
            } else {
                System.out.println("O número " + alvo + " não foi encontrado no array.");
            }
        }
}
