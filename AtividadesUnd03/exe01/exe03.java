package AtividadesUnd03.exe01;
/*
3 - Busca Linear:
Escreva um metodo que realize uma busca linear em um array de inteiros para encontrar um número
específico e retorne a posição do número ou -1 se não for encontrado.
*/

public class exe03 {

        // Metodo que realiza a busca linear
        public static int buscaLinear(int[] array, int alvo) {
            // Loop que percorre cada elemento do array
            for (int i = 0; i < array.length; i++) {
                // Verifica se o elemento atual é igual ao alvo
                if (array[i] == alvo) {
                    // Se encontrou, retorna o índice atual
                    return i;
                }
            }
            // Se chegou aqui, o alvo não foi encontrado, então retorna -1
            return -1;
        }

        // Metodo principal para testar a busca linear
        public static void main(String[] args) {
            // Cria um array de exemplo
            int[] numeros = {5, 2, 8, 12, 1, 6};
            // Define o número alvo para busca
            int alvo = 8;

            // Chama o metodo de busca linear e armazena o resultado
            int resultado = buscaLinear(numeros, alvo);

            // Verifica o resultado da busca
            if (resultado != -1) {
                // Se encontrou, imprime a posição
                System.out.println("O número " + alvo + " foi encontrado na posição " + resultado + ".");
            } else {
                // Se não encontrou, informa que o número não está no array
                System.out.println("O número " + alvo + " não foi encontrado no array.");
            }
        }
}
