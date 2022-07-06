package com.example.project;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstSimilares(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstSimilares(BST<T> a1, BST<T> a2){
    	Node<T> aux = a1.root; //extraemos la raiz para acceder a los nodos
    	Node<T> aux2 = a2.root; //extraemos la raiz para acceder a los nodos
    	if (a1.isEmpty() && a2.isEmpty()) { 
    		return true; //si ambos están vacios son similares
    	}
    	else //de lo contrario usaremos un metodo recursivo que trabajara con los nodos
    		return nodeSimilares(aux.left, aux2.left) && nodeSimilares(aux.right, aux2.right);  
    	    //Si los subarboles izquierdo y derecho son similares a1 y a2 son iguales seran bst similares
    }
    private <T extends Comparable<T>> boolean nodeSimilares(Node<T> a1, Node<T> a2){ //Metodo recursivo con los nodos 
    	if(a1 != null && a2 != null) { //Si los nodos son diferentes de null, seguremos bajando de nivel
    		return nodeSimilares(a1.left, a2.left) && nodeSimilares(a1.right, a2.right); //Comparamos los subarboles izquierdo y derecho  del siguiente nivel
    	}
    	else if((a1 != null && a2 == null) || (a1 == null && a2 != null)) { //Si un nodo es nulo y el otro tiene valor es porque 
            //los bst no son similares
    		return false;
    	}
    	else //Si ambos nodos son nulos, es porque terminamos de recorrer los bst y son similares
    		return true;
    }
    	
}
