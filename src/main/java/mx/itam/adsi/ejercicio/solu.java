package examenADSI;

public class solu {
    class Node {
        String data;
        Node next;
        
        /**
         * 
         * @param data El dato del nodo
         */
        
        Node(String data) {
            this.data = data;
        }
        
        /**
         * 
         * @return El nodo final de la solu
         */
        
        Node gus() {
            if(next == null) return this; //Si es el ultimo, se regresa a el mismo
            Node otro = next; 
            next      = null; //Vacia el siguiente nodo, pero lo guarda como auxiliar
            Node tavo = otro.gus(); //Recursivamente busca el nodo final y lo guarda en tavo
            otro.next = this; //Regresa al siguiente nodo al que deberia ser
            return tavo; //Regresa el nodo final de la solu
        }
      
        /**
         * Imprime en la consola la secuencia de Nodos que 
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el método "build", la invocación de
         * este método escribe en la consola: 
         * 
         * A-->B-->C-->D-->E-->F-->
         * 
         * Lo anterior sería lo que se visualiza en la consola 
         * justo después de ejecutar las siguintes dos lineas:
         * 
         *         Node a = build();
         *         a.prn();
         *         
         */
        void prn() {
            // Este método requiere sólo de 3 a 7 lineas de código para funcionar correctamente
        	if(data.equals(null)){ //Estamos en un nodo sin datos
        		System.out.print(" -->");
        		next.prn();
        	} else if (gus().data.equals(data)) { //Temporal, si los datos del nodo final son iguales a los de mi nodo entonces es el nodo final
        		System.out.print(data + " -->");
        	} else { //Estamos en un nodo con datos y no final
            	System.out.print(data + " -->");
            	next.prn();
        	}
        }
        
    }// ends Node class
    
    /**
     * COMENTARIO INCORRECTO:
     * 
     * Metodo que genera una cadena de 6 nodos con datos diferentes y los asigna secuencialmente al 
     * next del previo.
     * 
     * @return Node Regresa el primer Node de la cadena que se creo.
     */
    private Node build() {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    /**
     * Prueba la funcionalidad de el método "gus" con distintos casos de prueba
     */
    public void ok() {
        Node a = build();
        a.prn();
        a = a.gus();
        a.prn();
        a = a.gus();
        a.prn();
        
        Node b = new Node("X");
        b = b.gus();
        b.prn();
        
        Node c = new Node("X");
        Node d = new Node("Y");
        c.next = d;
        c = c.gus();
        c.prn();   
    }

    public static void main(String...argv) {
        new solu().ok();
    }

}