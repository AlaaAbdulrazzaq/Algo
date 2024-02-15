package NB26_3;

public class OpenAddressingHashTable<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private final float Capacity = 0.75f;

    @SuppressWarnings("unchecked")
    public OpenAddressingHashTable(int initialCapacity) {
        table = new Entry[initialCapacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = findSlot(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
            if (size > (0.75 * table.length)) {
                resize();
            }
        } else {
            table[index].value = value;
        }
    }

    public V get(K key) {
        int index = findSlot(key);
        if (table[index] == null) {
            return null;
        }
        return table[index].value;
    }

    public void remove(K key) {
        int index = findSlot(key);
        if (table[index] != null || table[index].value != null) {
            table[index] = new Entry<>(null, null);
            size--;
        }
    }

    private int findSlot(K key) {
        int index = key.hashCode() % table.length;
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length; // Linear probing
        }
        return index;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] newTable = table;
        int newSize = table.length * 2;
        newTable = new Entry[newSize];
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null || table[i].value == null) {
                int index = table[i].key.hashCode() % newSize;
                if(index < 0) {
                    index += newSize;
                }
                newTable[index] = table[i];
            }
        }
        table = newTable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                sb.append(table[i].value+" ");
            } else if (table[i] == null || table[i].value == null) {
                sb.append("NULL ");
            }
        }
        return sb.toString();
    }
}
