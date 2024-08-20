package br.ufp.dcx.rian.ed.listasimplesEncadeada;

public class ListaSimplesEncadeada<Dado> {
    private Node cabeca = null;
    private Node cauda = null;
    private Node atual;
    private int n= 0; //tamanho da lista

    private class Node {
        private Dado dado; //Dado que o nó recebe
        private Node prox = null; //Vai indicar qual proximo desse nó
        private Node(Dado dado){
            this.dado = dado;
        }
    }

    public void addInicio(Dado dado){
        Node novoNo = new Node(dado);

        atual = cabeca;
        cabeca = novoNo;

        if (atual == null) cauda = cabeca;
        else {
            cabeca.prox= atual;
        }
        n++;
    }
    public void addFim(Dado dado){
        Node novoNo = new Node(dado);
        atual = cauda;
        cauda = novoNo;

        if(atual == null) cabeca= cauda;
        else  atual.prox= cauda;
        n++;
    }
    public Dado buscaLista (Dado dado){
        atual = cabeca;
        while (atual != null && atual.dado != dado) atual = atual.prox;
        if(atual == null) return null;
        return atual.dado;
    }
    public Dado remover(){
        if(cabeca == null) return null;
        Dado item = cabeca.dado;
        cabeca.prox= cabeca; // Avança a cabeça para o próximo nó

        if(cabeca == null) cauda=null;
        n--;
        return item;
    }
    public Dado buscaERemocao(Dado dado){

        if(cabeca == null) return  null;
        atual = cabeca;
        Node noAntigo = cabeca;
        if(atual.dado == dado){
            cabeca = cabeca.prox; //dado foi encontrando entao essa linha faz com que a cabeça aponte para o proximo no
            n--;
            return atual.dado;
        }else{
            while (atual != null && atual.dado != dado){
             noAntigo =atual;
             atual = atual.prox;
            }
        }

        Dado item = cabeca.dado;

    }
}


