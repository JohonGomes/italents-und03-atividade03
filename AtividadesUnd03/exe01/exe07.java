package AtividadesUnd03.exe01;

import java.util.ArrayList;
import java.util.List;

/*
7 - DFS em Grafos:
Escreva um metodo para realizar a Busca em Profundidade (DFS) em um grafo, exibindo todos os
vértices visitados.
*/
public class exe07 {
        private int V; // Número de vértices
        private List<List<Integer>> adj; // Lista de adjacências

        // Construtor
        public exe07(int v) {
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

        // Metodo para iniciar a DFS
        public void dfs(int inicio) {
            // Cria um array para marcar os vértices visitados
            boolean[] visitado = new boolean[V];

            // Chama o metodo auxiliar recursivo
            System.out.println("Ordem de visita DFS começando do vértice " + inicio + ":");
            dfsUtil(inicio, visitado);
            System.out.println();
        }

        // Metodo auxiliar recursivo para DFS
        private void dfsUtil(int v, boolean[] visitado) {
            // Marca o nó atual como visitado e o exibe
            visitado[v] = true;
            System.out.print(v + " ");

            // Recorre para todos os vértices adjacentes ao vértice atual
            for (int adjacente : adj.get(v)) {
                if (!visitado[adjacente]) {
                    dfsUtil(adjacente, visitado);
                }
            }
        }

        public static void main(String[] args) {
            exe07 g = new exe07(8);
            g.adicionarAresta(0, 1);
            g.adicionarAresta(0, 2);
            g.adicionarAresta(1, 3);
            g.adicionarAresta(2, 4);
            g.adicionarAresta(3, 5);
            g.adicionarAresta(4, 5);
            g.adicionarAresta(5, 6);
            g.adicionarAresta(5, 7);

            g.dfs(0); // Inicia a DFS a partir do vértice 0
        }
}
