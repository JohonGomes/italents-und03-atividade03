package BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grafo2 {
    private Map<String, List<Aresta>> adjacencias;

    public Grafo2(){
        adjacencias = new HashMap<>();
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
        Grafo2 grafo = new Grafo2();

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

        grafo.imprimirGrafo();

    }
}
