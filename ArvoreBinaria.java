public class ArvoreBinaria {
    Node root;

    public ArvoreBinaria(){
        root = null;
    }

    static class Node{
        String nome;
        Node left, right;

        public Node(String nome){
            this.nome = nome;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.root = new Node("AAA");
        arvore.root.right = new Node("BBB");
        arvore.root.left = new Node("CCC");


        arvore.root.right.right = new Node("DDD");
        arvore.root.right.left = new Node("EEE");

        arvore.root.left.right = new Node("FFF");
        arvore.root.left.left = new Node("GGG");

        System.out.println(arvore.root.nome);
        System.out.println(arvore.root.right.nome);
        System.out.println(arvore.root.left.nome);


    }


}