package BST;

import java.util.*;

class BFSLargura {
    private Map<String, List<Aresta>> adjacencias;

    public BFSLargura(){
        adjacencias = new HashMap<>();
    }

    public Map<String, Boolean> buscaPorLargura(String verticeInicial){
        Map<String, Boolean> visitados = new HashMap<>();
        Queue<String> fila = new LinkedList<>();

        for (String vertice : adjacencias.keySet()) {
            visitados.put(verticeInicial, false);
        }

        fila.add(verticeInicial);
        visitados.put(verticeInicial, true);

        while (!fila.isEmpty()){
            String verticeAtual = fila.poll();
            System.out.print(verticeAtual + " ");

            List<Aresta> vizinhos = adjacencias.get(verticeAtual);

            for (Aresta aresta : vizinhos) {
                if (!visitados.get(aresta.getDestino())){
                    fila.add(aresta.getDestino());
                    visitados.put(aresta.getDestino(), true);
                }
            }
        }
        return visitados;
    }

    public void adicionarVertice(String rotulo){
        adjacencias.put(rotulo, new ArrayList<>());
    }

    public void adicionarAresta(String origem, String destino, int peso){
        if(!adjacencias.containsKey(origem)){
            adicionarVertice(origem);
        }

        if (!adjacencias.containsKey(destino)){
            adicionarVertice(destino);
        }
        adjacencias.get(origem).add(new Aresta(destino, peso));
    }

    public void imprimirGrafo(){
        for (String vertice: adjacencias .keySet()){
            List<Aresta> arestas = adjacencias.get(vertice);
            System.out.println(vertice + " -> ");
            for (Aresta aresta : arestas) {
                System.out.println(aresta.getDestino() + "(" + aresta.getPeso() + ")");
            }
            System.out.println();
        }
    }

    private class Aresta {
        private String destino;
        private int peso;

        public Aresta(String destino, int peso){
            this.destino = destino;
            this.peso = peso;
        }

        public String getDestino(){
            return destino;
        }

        public int getPeso(){
            return peso;
        }
    }


    public static void main(String[] args) {
        BFSLargura grafo = new BFSLargura();

        grafo.adicionarVertice("Brasil");
        grafo.adicionarVertice("México");
        grafo.adicionarVertice("Alemanha");
        grafo.adicionarVertice("Portugal");
        grafo.adicionarVertice("Inglaterra");

        grafo.adicionarAresta("Brasil", "Japão", 5);
        grafo.adicionarAresta("Alemanha", "Portugal", 3);
        grafo.adicionarAresta("Portugal", "Alemanha", 5);
        grafo.adicionarAresta("Brasil", "México", 7);
        grafo.adicionarAresta("Inglaterra", "México", 2);

        System.out.println(grafo.adjacencias);
        System.out.println(grafo.adjacencias.get("Brasil"));

        System.out.println(grafo.adjacencias.get("Brasil").get(0).getDestino());
        System.out.println(grafo.adjacencias.get("Brasil").get(0).getPeso());

        grafo.buscaPorLargura("Brasil");



    }
}
