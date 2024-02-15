package NB26_2;

public class minStringCounter {
    String[] arrayOfString;
    int nrOfString;
    public minStringCounter(String[] arrayOfString) {
        this.arrayOfString = arrayOfString;
        nrOfString = 0;
    }
    public int getMostUsedString() {
        HashMap<String, Integer> map = new HashMap<>(4);
        int count = Integer.MAX_VALUE;
        for (String str : this.arrayOfString) {
            if(map.get(str) != null) {
                map.put(str, map.get(str) + 1);
            } else map.put(str, 1);
            if (map.get(str) < count) {
                count = map.get(str);
            }
        }
        return count;
    }
}
