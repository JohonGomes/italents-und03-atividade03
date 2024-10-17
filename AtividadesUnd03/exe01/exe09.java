package AtividadesUnd03.exe01;
/*
Modifique o algoritmo BFS para encontrar o caminho mais curto entre dois nós em um grafo
ponderado.

*/

import java.util.*;

public class exe09 {
        // Classe que representa o grafo
        static class Grafo {
            private Map<Integer, Map<Integer, Integer>> adjacencias; // Mapa para representar as adjacências

            // Construtor do grafo
            public Grafo() {
                adjacencias = new HashMap<>();
            }

            // Adiciona um vértice ao grafo
            public void adicionarVertice(int vertice) {
                adjacencias.put(vertice, new HashMap<>());
            }

            // Adiciona uma aresta entre dois vértices com um peso
            public void adicionarAresta(int origem, int destino, int peso) {
                adjacencias.get(origem).put(destino, peso);
                adjacencias.get(destino).put(origem, peso); // Para um grafo não direcionado
            }

            // Busca o caminho mais curto entre dois vértices usando o algoritmo de Dijkstra
            public List<Integer> buscaCaminhoMaisCurto(int origem, int destino) {
                Map<Integer, Integer> distancia = new HashMap<>(); // Armazena as distâncias mínimas
                Map<Integer, Integer> predecessores = new HashMap<>(); // Armazena o predecessor de cada vértice
                PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

                // Inicializa as distâncias e predecessores
                for (int vertice : adjacencias.keySet()) {
                    distancia.put(vertice, Integer.MAX_VALUE);
                    predecessores.put(vertice, -1); // Define -1 para indicar nenhum predecessor
                }

                distancia.put(origem, 0); // A distância para a origem é zero
                filaPrioridade.add(origem); // Adiciona a origem à fila de prioridade

                // Processa a fila de prioridade
                while (!filaPrioridade.isEmpty()) {
                    int atual = filaPrioridade.poll();

                    // Percorre os vizinhos do vértice atual
                    for (int vizinho : adjacencias.get(atual).keySet()) {
                        int novaDistancia = distancia.get(atual) + adjacencias.get(atual).get(vizinho);
                        if (novaDistancia < distancia.get(vizinho)) {
                            distancia.put(vizinho, novaDistancia); // Atualiza a distância
                            predecessores.put(vizinho, atual); // Atualiza o predecessor
                            filaPrioridade.add(vizinho); // Adiciona o vizinho na fila
                        }
                    }
                }

                // Verifica se existe um caminho até o destino
                if (distancia.get(destino) == Integer.MAX_VALUE) {
                    return new ArrayList<>(); // Retorna uma lista vazia se não houver caminho
                }

                // Reconstrói o caminho do destino para a origem
                List<Integer> caminho = new ArrayList<>();
                int noAtual = destino;
                while (noAtual != -1) {
                    caminho.add(noAtual);
                    noAtual = predecessores.get(noAtual);
                }

                Collections.reverse(caminho); // Inverte a lista para obter o caminho correto
                return caminho; // Retorna o caminho encontrado
            }
        }

        public static void main(String[] args) {
            Grafo grafo = new Grafo();

            // Adiciona os vértices ao grafo
            for (int i = 1; i <= 7; i++) {
                grafo.adicionarVertice(i);
            }

            // Adiciona as arestas e os pesos
            grafo.adicionarAresta(1, 2, 4);
            grafo.adicionarAresta(1, 3, 2);
            grafo.adicionarAresta(2, 4, 5);
            grafo.adicionarAresta(2, 5, 3);
            grafo.adicionarAresta(3, 6, 7);
            grafo.adicionarAresta(3, 7, 4);

            int origem = 1; // Vértice de origem
            int destino = 6; // Vértice de destino

            // Busca o caminho mais curto
            List<Integer> caminhoMaisCurto = grafo.buscaCaminhoMaisCurto(origem, destino);

            // Imprime o resultado
            if (caminhoMaisCurto.isEmpty()) {
                System.out.println("Não há caminho entre os vértices " + origem + " e " + destino);
            } else {
                System.out.println("Caminho mais curto entre " + origem + " e " + destino + ": " + caminhoMaisCurto);
            }
        }
}