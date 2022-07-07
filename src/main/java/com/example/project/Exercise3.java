package com.example.project;

public class Exercise3 {

    public static void main(String[] args) {
        Exercise3 obj = new Exercise3();

        BST<Integer> tree = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree.insert(value);
        }

        System.out.print(obj.bstEstrictamenteBinario(tree));
        
    }


     public <T extends Comparable<T>> boolean bstEstrictamenteBinario(BST<T> a){
    	Node<T> aux = a.root; //extraemos la raiz para acceder a los nodos
    	if(a.isEmpty()) {
    		return true; //si esta vacio asumiremos que es binario
    	}
    	return nodeBinario(aux); //llamamos al metodo recursivo

    }
    private <T extends Comparable<T>> boolean nodeBinario(Node<T> a){
    	if(a.right != null && a.left != null) { //Si sus hijos son diferente de nulo bajaremos de nivel
    		return nodeBinario(a.left) && nodeBinario(a.right); //si ambos hijos son perfectamente binarios el arbol sera estrictamente binario
    	}
    	else if((a.right != null && a.left == null) || (a.right == null && a.left != null)) { //si un nodo hijo es nulo y el otro no, no sera 
    		//estrictamente binario
    		return false;
    	}
    	else //si ambos hijos son nulos sera estrictammente binario
    		return true;
    }
}
