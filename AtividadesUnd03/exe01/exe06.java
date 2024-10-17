package AtividadesUnd03.exe01;

import java.util.*;
/*
6 - BFS em Grafos:
Implemente o algoritmo de Busca em Largura (BFS) para encontrar o caminho mais curto entre dois
nós em um grafo não ponderado.
*/
public class exe06 {
        private int V; // Número de vértices
        private List<List<Integer>> adj; // Lista de adjacências

        // Construtor
        public exe06(int v) {
            V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // Adiciona uma aresta ao grafo
        public void adicionarAresta(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v); // Grafo não direcionado
        }

        // Metodo BFS para encontrar o caminho mais curto
        public List<Integer> bfsCaminhoMaisCurto(int inicio, int fim) {
            // Array para armazenar as distâncias
            int[] distancia = new int[V];
            Arrays.fill(distancia, -1);

            // Array para armazenar os predecessores
            int[] predecessor = new int[V];
            Arrays.fill(predecessor, -1);

            // Fila para BFS
            Queue<Integer> fila = new LinkedList<>();

            // Marca o nó inicial
            distancia[inicio] = 0;
            fila.offer(inicio);

            // Loop principal do BFS
            while (!fila.isEmpty()) {
                int atual = fila.poll();

                // Se chegamos ao nó de destino, paramos a busca
                if (atual == fim) {
                    break;
                }

                // Explora os vizinhos do nó atual
                for (int vizinho : adj.get(atual)) {
                    if (distancia[vizinho] == -1) {
                        distancia[vizinho] = distancia[atual] + 1;
                        predecessor[vizinho] = atual;
                        fila.offer(vizinho);
                    }
                }
            }

            // Reconstrói o caminho
            return reconstruirCaminho(inicio, fim, predecessor);
        }

        // Metodo auxiliar para reconstruir o caminho
        private List<Integer> reconstruirCaminho(int inicio, int fim, int[] predecessor) {
            List<Integer> caminho = new ArrayList<>();
            for (int atual = fim; atual != -1; atual = predecessor[atual]) {
                caminho.add(atual);
            }
            Collections.reverse(caminho);
            return caminho.get(0) == inicio ? caminho : new ArrayList<>();
        }

        public static void main(String[] args) {
            exe06 g = new exe06(8);
            g.adicionarAresta(0, 1);
            g.adicionarAresta(0, 3);
            g.adicionarAresta(1, 2);
            g.adicionarAresta(3, 4);
            g.adicionarAresta(3, 7);
            g.adicionarAresta(4, 5);
            g.adicionarAresta(4, 6);
            g.adicionarAresta(4, 7);
            g.adicionarAresta(5, 6);
            g.adicionarAresta(6, 7);

            int inicio = 0, fim = 6;
            List<Integer> caminho = g.bfsCaminhoMaisCurto(inicio, fim);

            if (caminho.isEmpty()) {
                System.out.println("Não há caminho entre " + inicio + " e " + fim);
            } else {
                System.out.println("Caminho mais curto de " + inicio + " para " + fim + ": " + caminho);
            }
        }
}