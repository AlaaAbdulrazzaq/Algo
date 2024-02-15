package NB24;

import java.util.Iterator;
import java.util.LinkedList;

public class HTB_ToStringRemove<K,V> {
    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        public String toString() {
            return ""+ value;
        }
    }
    private LinkedList<Entry<K,V>>[] table;
    @SuppressWarnings("unchecked")
    public HTB_ToStringRemove(int size) {
        table = new LinkedList[size];
    }

    public V put(K key, V value) {
        int index = key.hashCode()%table.length;
        if(index<0) index += table.length;
        if(table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
            table[index].add(new Entry<K,V>(key, value));
            return null;
        } else {
            V oldValue;
            for(Entry<K,V> e : table[index]){
                if(e.key.equals(key)){
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            table[index].add(0, new Entry<K,V>(key, value));
            return null;
        }
    }

    public V get(K key) {
        int index = key.hashCode()% table.length;
        if(index<0){
            index += table.length;
        }
        if(table[index] == null) {
            return null;
        }
        for(Entry<K,V> e : table[index]) {
            if(e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }
    public V remove(K key) {
        int index = key.hashCode()% table.length;
        if(index<0) {
            index += table.length;
        }
        if(table[index] != null) {
            Iterator<Entry<K,V>> iterator = table[index].iterator();
            while (iterator.hasNext()) {
                Entry<K,V> entry = iterator.next();
                if(entry.key.equals(key)) {
                    V value = entry.value;
                    iterator.remove();
                    return value;
                }
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null && !table[i].isEmpty()) {
                for (Entry<K,V> entry : table[i]) {
                    sb.append(entry.toString() + ", ");
                }
                sb.append("\n");
            } else {
                sb.append("NULL \n");
            }
        }
        return sb.toString();
    }
}

