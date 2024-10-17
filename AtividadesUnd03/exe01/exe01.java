package AtividadesUnd03.exe01;
/*
1 - Implementação da Árvore Binária:
Crie uma classe em Java para representar uma árvore binária e implemente métodos para inserir
elementos, percorrer a árvore em pré-ordem, pós-ordem e em ordem.
*/

//Esta é a definição da classe No, que representa um nó na árvore binária.
// Cada nó tem um valor inteiro e referências para os nós filhos à esquerda e à direita.
class No {
    int valor;
    No esquerda;
    No direita;

    //Este é o construtor da classe No.
    // Ele inicializa um novo nó com um valor e define os filhos esquerdo e direito como null.
    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

//Esta é a definição da classe principal exe01, que representa a árvore binária.
// Ela tem um atributo privado raiz que é o nó raiz da árvore.
public class exe01 {
    private No raiz;

    //Este é o construtor da classe ex1_uni3. Ele inicializa a árvore com uma raiz nula.
    public exe01() {
        raiz = null;
    }

    //Este metodo público inicia o processo de inserção de um novo valor na árvore,
    // chamando o metodo privado inserirRecursivo.
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    //Este metodo privado insere recursivamente um novo valor na árvore. Se o nó atual é nulo, cria um novo nó.
    // Se o valor é menor que o valor do nó atual, insere à esquerda. Se é maior, insere à direita.
    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    //Este metodo público inicia o percurso pré-ordem da árvore,
    // chamando o metodo privado percorrerPreOrdemRecursivo.
    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(raiz);
        System.out.println();
    }

    //Este metodo privado realiza o percurso pré-ordem recursivamente:
    // visita o nó atual, depois o filho esquerdo, depois o filho direito.
    private void percorrerPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percorrerPreOrdemRecursivo(no.esquerda);
            percorrerPreOrdemRecursivo(no.direita);
        }
    }

    //Este metodo público inicia o percurso pós-ordem da árvore,
    // chamando o metodo privado percorrerPosOrdemRecursivo.
    public void percorrerPosOrdem() {
        percorrerPosOrdemRecursivo(raiz);
        System.out.println();
    }

    //Este metodo privado realiza o percurso pós-ordem recursivamente:
    // visita o filho esquerdo, depois o filho direito, depois o nó atual.
    private void percorrerPosOrdemRecursivo(No no) {
        if (no != null) {
            percorrerPosOrdemRecursivo(no.esquerda);
            percorrerPosOrdemRecursivo(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    //Este metodo público inicia o percurso em-ordem da árvore,
    // chamando o metodo privado percorrerEmOrdemRecursivo.
    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    //Este metodo privado realiza o percurso em-ordem recursivamente:
    // visita o filho esquerdo, depois o nó atual, depois o filho direito.
    private void percorrerEmOrdemRecursivo(No no) {
        if (no != null) {
            percorrerEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            percorrerEmOrdemRecursivo(no.direita);
        }
    }

    //O metodo main cria uma nova árvore e insere vários valores nela.
    public static void main(String[] args) {
        exe01 arvore = new exe01();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(3);
        arvore.inserir(8);
        arvore.inserir(15);
        arvore.inserir(30);

        //Finalmente, o metodo main chama os três tipos de percurso na árvore e imprime os resultados.

        System.out.println("Percorrendo em Pré-Ordem:");
        arvore.percorrerPreOrdem();

        System.out.println("Percorrendo em Pós-Ordem:");
        arvore.percorrerPosOrdem();

        System.out.println("Percorrendo em Em-Ordem:");
        arvore.percorrerEmOrdem();
    }
}