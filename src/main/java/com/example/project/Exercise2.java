package com.example.project;

public class Exercise2 {

    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstIguales(tree1, tree2));
        
    }


   public <T extends Comparable<T>> boolean bstIguales(BST<T> a1, BST<T> a2){

    	Node<T> aux = a1.root; //extraemos la raiz para acceder a los nodos
    	Node<T> aux2 = a2.root; //extraemos la raiz para acceder a los nodos
    	if (a1.isEmpty() && a2.isEmpty()) { 
    		return true; //si ambos están vacios son iguales
    	}
    	else //de lo contrario usaremos un metodo recursivo que trabajara con los nodos
    		return nodeIguales(aux.left, aux2.left) && nodeIguales(aux.right, aux2.right);  
    	    //Si los subarboles izquierdo y derecho son iguales a1 y a2 seran bst iguales
    }
    private <T extends Comparable<T>> boolean nodeIguales(Node<T> a1, Node<T> a2){ //Metodo recursivo con los nodos 
    	if(a1 != null && a2 != null) { //Si los nodos son diferentes de null
    		if(a1.data != a2.data) { //comparamos sus valores de los nodos, si son diferentes no serán iguales
    			return false;
    		}
    		else { //bajamos de nivel para seguir comprobando
    			return nodeIguales(a1.left, a2.left) && nodeIguales(a1.right, a2.right); 
    		}
    		
    	}
    	else if((a1 != null && a2 == null) || (a1 == null && a2 != null)) { //Si un nodo es nulo y el otro tiene valor es porque 
            //los bst no son iguales
    		return false;
    	}
    	else //Si ambos nodos son nulos, es porque terminamos de recorrer los bst y son iguales
    		return true;
    }
}
