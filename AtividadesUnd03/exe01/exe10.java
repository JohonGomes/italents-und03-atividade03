package AtividadesUnd03.exe01;
/*
Implemente um algoritmo para ordenar os vértices de um grafo, de acordo com a topologia das
conexões entre eles.
*/

import java.util.*;

public class exe10 {
        // Classe que representa o grafo
        static class Grafo {
            private Map<Integer, List<Integer>> adjacencias; // Mapa para representar as adjacências dos vértices

            // Construtor do grafo
            public Grafo() {
                adjacencias = new HashMap<>(); // Inicializa o mapa de adjacências
            }

            // Adiciona um vértice ao grafo
            public void adicionarVertice(int vertice) {
                adjacencias.put(vertice, new ArrayList<>()); // Associa o vértice a uma nova lista de adjacências
            }

            // Adiciona uma aresta entre dois vértices
            public void adicionarAresta(int origem, int destino) {
                adjacencias.get(origem).add(destino); // Adiciona o destino à lista de adjacências da origem
            }

            // Realiza a ordenação topológica do grafo
            public List<Integer> ordenacaoTopologica() {
                Map<Integer, Integer> grauEntrada = new HashMap<>(); // Mapa para armazenar o grau de entrada de cada vértice

                // Inicializa o grau de entrada de todos os vértices com zero
                for (int vertice : adjacencias.keySet()) {
                    grauEntrada.put(vertice, 0);
                }

                // Calcula o grau de entrada para cada vértice
                for (List<Integer> vizinhos : adjacencias.values()) {
                    for (int vizinho : vizinhos) {
                        grauEntrada.put(vizinho, grauEntrada.get(vizinho) + 1); // Incrementa o grau de entrada do vizinho
                    }
                }

                // Adiciona todos os vértices com grau de entrada zero na fila
                Queue<Integer> fila = new LinkedList<>();
                for (int vertice : adjacencias.keySet()) {
                    if (grauEntrada.get(vertice) == 0) {
                        fila.add(vertice); // Vértices com grau de entrada zero são candidatos para iniciar a ordenação
                    }
                }

                // Lista para armazenar o resultado da ordenação topológica
                List<Integer> resultado = new ArrayList<>();
                while (!fila.isEmpty()) {
                    int vertice = fila.poll(); // Remove o primeiro vértice da fila
                    resultado.add(vertice); // Adiciona o vértice ao resultado

                    // Para cada vizinho do vértice atual
                    for (int vizinho : adjacencias.get(vertice)) {
                        grauEntrada.put(vizinho, grauEntrada.get(vizinho) - 1); // Diminui o grau de entrada do vizinho
                        if (grauEntrada.get(vizinho) == 0) {
                            fila.add(vizinho); // Se o grau de entrada do vizinho se tornar zero, adiciona-o à fila
                        }
                    }
                }

                // Verifica se o grafo contém ciclos
                if (resultado.size() != adjacencias.size()) {
                    // Se a ordenação não incluir todos os vértices, há um ciclo no grafo
                    return new ArrayList<>(); // Retorna uma lista vazia indicando que a ordenação topológica falhou
                }

                return resultado; // Retorna a lista com a ordenação topológica
            }
        }

        public static void main(String[] args) {
            Grafo grafo = new Grafo();

            // Adiciona os vértices ao grafo
            for (int i = 1; i <= 6; i++) {
                grafo.adicionarVertice(i);
            }

            // Adiciona as arestas entre os vértices
            grafo.adicionarAresta(1, 2);
            grafo.adicionarAresta(1, 3);
            grafo.adicionarAresta(2, 4);
            grafo.adicionarAresta(2, 5);
            grafo.adicionarAresta(3, 5);
            grafo.adicionarAresta(4, 6);
            grafo.adicionarAresta(5, 6);

            // Realiza a ordenação topológica
            List<Integer> ordenacaoTopologica = grafo.ordenacaoTopologica();

            // Verifica se foi possível realizar a ordenação topológica
            if (ordenacaoTopologica.isEmpty()) {
                System.out.println("O grafo possui ciclo. Não é possível realizar a ordenação topológica.");
            } else {
                System.out.println("Ordenação topológica dos vértices: " + ordenacaoTopologica);
            }
        }
}

