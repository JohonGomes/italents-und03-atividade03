package AtividadesUnd03.exe01;
/*
8 - Mínimo de uma BST:
Escreva um metodo para encontrar o menor valor em uma árvore binária de busca.
*/
public class exe08 {
        // Classe interna para representar um nó da árvore
        private class No {
            int valor;
            No esquerda, direita;

            No(int valor) {
                this.valor = valor;
                this.esquerda = this.direita = null;
            }
        }

        private No raiz; // Raiz da árvore

        // Construtor
        public exe08() {
            raiz = null;
        }

        // Metodo para inserir um valor na árvore
        public void inserir(int valor) {
            raiz = inserirRecursivo(raiz, valor);
        }

        // Metodo auxiliar recursivo para inserção
        private No inserirRecursivo(No no, int valor) {
            // Se a árvore está vazia, cria um novo nó
            if (no == null) {
                return new No(valor);
            }

            // Caso contrário, percorre a árvore
            if (valor < no.valor) {
                no.esquerda = inserirRecursivo(no.esquerda, valor);
            } else if (valor > no.valor) {
                no.direita = inserirRecursivo(no.direita, valor);
            }

            // Retorna o nó (inalterado)
            return no;
        }

        // Metodo para encontrar o menor valor na árvore
        public int encontrarMenorValor() {
            if (raiz == null) {
                throw new IllegalStateException("A árvore está vazia");
            }
            return encontrarMenorValorRecursivo(raiz);
        }

        // Metodo auxiliar recursivo para encontrar o menor valor
        private int encontrarMenorValorRecursivo(No no) {
            // O menor valor sempre estará na subárvore esquerda
            // Se não houver subárvore esquerda, o nó atual é o menor
            if (no.esquerda == null) {
                return no.valor;
            }
            return encontrarMenorValorRecursivo(no.esquerda);
        }

        public static void main(String[] args) {
            exe08 arvore = new exe08();
            arvore.inserir(5);
            arvore.inserir(3);
            arvore.inserir(7);
            arvore.inserir(1);
            arvore.inserir(9);

            System.out.println("O menor valor na árvore é: " + arvore.encontrarMenorValor());
        }
    }
