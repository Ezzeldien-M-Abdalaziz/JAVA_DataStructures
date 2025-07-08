import java.io.Console;

public class Dictionary <Tkey , Tvalue> {
    private KeyValuePair<Tkey, Tvalue>[] entries;
    private int initialSize;
    private int entriesCount;

    @SuppressWarnings("unchecked")
    public Dictionary() {
        this.initialSize = 3;
        this.entries = (KeyValuePair<Tkey, Tvalue>[]) new KeyValuePair[this.initialSize];
    }

    public void ResizeOrNot(){
        if(this.entriesCount >= this.entries.length){
            int oldSize = this.entries.length;
            int newSize = this.entries.length + this.initialSize;

            System.out.println("🔄 RESIZING: " + oldSize + " → " + newSize);

            @SuppressWarnings("unchecked")
            KeyValuePair<Tkey, Tvalue>[] newArray = (KeyValuePair<Tkey, Tvalue>[]) new KeyValuePair[newSize];
            System.arraycopy(this.entries, 0, newArray, 0, this.entries.length);
            this.entries = newArray;

            System.out.println("✅ Resize completed successfully!");
        }
    }

    public int size(){
        return this.entriesCount;  // Return actual count, not array length
    }

    public void set(Tkey key, Tvalue value){
        for(int i = 0; i < this.entriesCount; i++){
            if (this.entries[i] != null && this.entries[i].get_key().equals(key)){
                this.entries[i].set_value(value);
                return;
            }
        }
        //if didn't update then it will add
        ResizeOrNot();  //check if there is enough size first

        KeyValuePair<Tkey, Tvalue> newEntry = new KeyValuePair<>(key, value);
        this.entries[this.entriesCount] = newEntry;
        this.entriesCount++;
    }

    public Tvalue get(Tkey key){
        for(int i = 0; i < this.entriesCount; i++){
            if (this.entries[i] != null && this.entries[i].get_key().equals(key)){
                return this.entries[i].get_value();
            }
        }
        return null;
    }

    public boolean remove(Tkey key){
        for(int i = 0; i < this.entriesCount; i++){
            if (this.entries[i] != null && this.entries[i].get_key().equals(key)){
                // Move last element to this position to avoid gaps
                this.entries[i] = this.entries[this.entriesCount-1];
                this.entries[this.entriesCount-1] = null;  // Clear the last position
                this.entriesCount--;
                return true;
            }
        }
        return false;
    }

    public void print(){
        System.out.println("Size: " + this.size());
        if(this.entriesCount == 0){
            return;
        }
        for(int i = 0; i < this.entriesCount; i++){
            System.out.println(this.entries[i].get_key() + ": " + this.entries[i].get_value());
        }
    }

    public static class KeyValuePair<K, V>{
        private K _key;
        private V _value;

        public K get_key() {
            return _key;
        }

        public V get_value() {
            return _value;
        }

        public void set_value(V value) {
            this._value = value;
        }

        KeyValuePair(K key, V value) {
            this._key = key;
            this._value = value;
        }
    }
    }