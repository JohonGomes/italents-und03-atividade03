package AtividadesUnd03.exe01;
/*
2 - Validação de BST:
Escreva um metodo para verificar se uma árvore binária é uma árvore binária de busca (BST)
*/

public class exe02 {
    //Define uma classe estática interna chamada Node para representar os nós da árvore.

    static class Node {
        // Declara os atributos do nó:
        // valor (o valor armazenado), left (referência ao filho esquerdo) e right (referência ao filho direito).
        int valor;
        No left;
        No right;

        //Construtor da classe Node que inicializa o valor e define os filhos como null.
        public Node(int valor) {
            this.valor = valor;
            left = null;
            right = null;
        }
    }
    //Declara um atributo privado raiz do tipo No para armazenar a raiz da árvore.
    private No raiz;

    //Define um metodo público que verifica se a árvore é uma BST.
    public boolean verificaBST() {
        return verificaBSTRecursivo(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //Chama o metodo recursivo privado, passando a raiz e os valores mínimo e máximo possíveis para um int.
    private boolean verificaBSTRecursivo(No no, int valorMin, int valorMax) {

        //Se o nó é nulo, retorna true (um nó nulo é considerado uma BST válida).
        if (no == null) {
            return true;
        }

        //Verifica se o valor do nó está dentro do intervalo permitido. Se não estiver, retorna false.
        if (no.valor < valorMin || no.valor > valorMax) {
            return false;
        }

        //Chama recursivamente o metodo para os filhos esquerdo e direito, ajustando os limites.
        //Para o filho esquerdo, o novo máximo é o valor do nó atual menos 1.
        //Para o filho direito, o novo mínimo é o valor do nó atual mais 1.
        //Retorna true apenas se ambas as chamadas recursivas retornarem true.
        return (verificaBSTRecursivo(no.esquerda, valorMin, no.valor - 1) &&
                verificaBSTRecursivo(no.direita, no.valor + 1, valorMax));
    }

    // Metodo main para testar a classe. Cria uma nova instância da árvore.
    public static void main(String[] args) {
        exe02 arvore = new exe02();

    // Chama o método para verificar se a árvore é uma BST e armazena o resultado.
        boolean ehBST = arvore.verificaBST();
        // Imprime o resultado da verificação.
        if (ehBST) {
            System.out.println("A árvore é uma Árvore Binária de Busca (BST).");
        } else {
            System.out.println("A árvore não é uma Árvore Binária de Busca (BST).");
        }
    }
}
