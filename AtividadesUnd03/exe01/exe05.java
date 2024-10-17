package AtividadesUnd03.exe01;
/*
5 - Representação de Grafos:
Crie uma classe que represente um grafo em Java utilizando lista de adjacências ou matriz de
adjacências.
*/

import java.util.ArrayList;
import java.util.List;

public class exe05 {
        // Número de vértices
        private int V;
        // Lista de adjacências
        private List<List<Integer>> adj;

        // Construtor
        public exe05(int v) {
            V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // Adiciona uma aresta ao grafo
        public void adicionarAresta(int v, int w) {
            adj.get(v).add(w);
            // Se o grafo for não direcionado, descomente a linha abaixo
            // adj.get(w).add(v);
        }

        // Remove uma aresta do grafo
        public void removerAresta(int v, int w) {
            adj.get(v).remove(Integer.valueOf(w));
            // Se o grafo for não direcionado, descomente a linha abaixo
            // adj.get(w).remove(Integer.valueOf(v));
        }

        // Verifica se existe uma aresta entre dois vértices
        public boolean existeAresta(int v, int w) {
            return adj.get(v).contains(w);
        }

        // Retorna os vértices adjacentes a um vértice
        public List<Integer> getAdjacentes(int v) {
            return new ArrayList<>(adj.get(v));
        }

        // Retorna o número de vértices
        public int getNumeroVertices() {
            return V;
        }

        // Imprime o grafo
        public void imprimirGrafo() {
            for (int i = 0; i < V; i++) {
                System.out.print("Vértice " + i + " está conectado a: ");
                for (int w : adj.get(i)) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            exe05 g = new exe05(4);

            g.adicionarAresta(0, 1);
            g.adicionarAresta(0, 2);
            g.adicionarAresta(1, 2);
            g.adicionarAresta(2, 0);
            g.adicionarAresta(2, 3);
            g.adicionarAresta(3, 3);

            System.out.println("Grafo:");
            g.imprimirGrafo();

            System.out.println("\nExiste aresta entre 1 e 2? " + g.existeAresta(1, 2));
            System.out.println("Existe aresta entre 3 e 1? " + g.existeAresta(3, 1));

            System.out.println("\nVértices adjacentes a 2: " + g.getAdjacentes(2));

            g.removerAresta(2, 3);
            System.out.println("\nApós remover a aresta (2,3):");
            g.imprimirGrafo();
        }
}
