package consantiagocom.tercertrimestre.tema10.ejercicios.hashmap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class HashMap<K,V> {
    //no puede pasar tipo primitivo
    // equals() compara drrecciones de memoria
    private static final int DEFUALT_CAPACITY = 1000;
    private static final int GROW_FACTOR = 3;
    private static final float MAX_LOAD_FACTOR = 0.7f;
    private Node<K,V>[] data;
    private int size;
    public HashMap() {
        data = new Node[DEFUALT_CAPACITY];
        size =0;
    }

    private float getLoadFactor(){
        return (float)size / data.length;
    }

    public V put(K key, V value){
        if(getLoadFactor()>MAX_LOAD_FACTOR){
            resize();
        }
        int index = hash(key);
        Node<K,V> oldNode = data[index];
        Node<K,V> newNode = new Node<>(key,value,index);
        if(oldNode == null || oldNode.key.equals(key)) {
            data[index] =  newNode;
            if (oldNode == null){
                size++;
                return  null;
            }else
                return oldNode.value;

        }
        int i = index +1;
        while (i < data.length && i != index){
            if(data[i] == null){
                data[i] = newNode;
                break;
            }
            i = (i +1) % data.length;
        }
        return null;
    }


    public V get(K key){
        int index = hash(key);
        Node<K,V> node = data[index];
        if(node == null)
            return null;
        if (node.key.equals(key)){
            return node.value;
        }
        int i = index +1;
        while (i < data.length && i != index){
            if(data[i] != null && data[i].key.equals(key)){
                return data[i].getV();
            }
            i = (i +1) % data.length;
        }
        return null;
    }

    public Collection<V> values(){
        Collection<V> resultado = new ArrayList<>();
        for(int i =0 ; i< data.length ;i++){
            if(data[i] != null)
                resultado.add(data[i].value);
        }
        return resultado;
    }

    public  V remove(K key){
        int index = hash(key);
        Node<K,V> node = data[index];
        if(node == null)
            return null;
        if (node.key.equals(key)){
            data[index] = null;
            size--;
            return node.value;
        }
        int i = index +1;
        while (i < data.length && i != index){
            if(data[i] != null && data[i].key.equals(key)){
                size--;
                V value = data[i].getV();
                data[i] = null;
                return value;
            }
            i = (i +1) % data.length;
        }
        return null;
    }
    private void resize(){
        //Punteros de array viejo
        Node<K,V>[] oldArray = new Node[data.length];
        for (int i =0 ; i < data.length;i++){
            oldArray[i] = data[i];
        }
        //Vacciar el array
        data = new Node[data.length *GROW_FACTOR];
        size = 0;
        for(int i = 0; i <oldArray.length;i++){
            // put trabaja con datos no hay necesidad de crear un nodo nuevo
            if(oldArray[i] != null)
                put(oldArray[i].key, oldArray[i].value);
        }
    }

    private int hash(K key){
        return key.hashCode() % data.length;
    }


    public class Node<K,V>{
        private final K key;
        private final V value;
        private final int hash;
        public Node(K key, V value, int hash){
            this.key = key;
            this.value = value;
            //indice de donde esta el valor
            this.hash = hash;
        }

        public K getK() {
            return key;
        }

        public V getV() {
            return value;
        }
    }

}
