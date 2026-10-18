package HashMaps;

import java.util.Objects;

public class HashMapImpl {

    public static class Pair{
        String key;
        String val;

        public Pair(String key, String val){
            this.key = key;
            this.val = val;
        }
    }

    public int size;
    public int capacity;
    public Pair[] map;

    public HashMapImpl() {
        this.size = 0;
        this.capacity = 2;
        this.map = new Pair[2];
    }

    public int hash(String key){
        int index = 0;
        for(int i = 0; i< key.length();i++){
            index+=(int) key.charAt(i);
        }
        return index % this.capacity;
    }

    public String get(String key){
        int index = this.hash(key);
        while(this.map[index]!=null){
            if(Objects.equals(this.map[index].key, key)){
                return this.map[index].val;
            }
            // open addressing
            index+=1;
            // To maintain not exceeding the array size
            index = index%this.capacity;
        }
        return null;
    }

    public void put(String key,String val){
        int index = this.hash(key);
        while(true){
            if(this.map[index] == null){
                // value doesn't exist create it
                this.map[index] = new Pair(key,val);
                this.size++;
                if(this.size > this.capacity /2){
                    this.rehash();
                }
                return;
            }else if(Objects.equals(this.map[index].key, key)){
                // value exists but override it
                this.map[index].val = val;
                return;
            }
            // open addressing
            index ++;
            index = index % this.capacity;
        }
    }

    public void remove(String key){
        if(this.get(key) == null){
            return;
        }
        int index = this.hash(key);
        while(true){
            if(this.map[index].key.equals(key)){
                this.map[index]=null;
                this.size-=1;
                return;
            }
            index++;
            index %=this.capacity;
        }
    }

    public void rehash(){
        this.capacity = 2 * this.capacity;
        Pair[] newMap = new Pair[this.capacity];
        Pair[] oldMap = this.map;
        this.map = newMap;
        // for calling put will increase size again
        this.size = 0;
        for(Pair p : oldMap){
            if(p!=null){
                this.put(p.key,p.val);
            }
        }
    }

    public void print() {
        for (Pair p : this.map) {
            if (p != null) {
                System.out.println(p.key + " " + p.val);
            }
        }
    }
}
