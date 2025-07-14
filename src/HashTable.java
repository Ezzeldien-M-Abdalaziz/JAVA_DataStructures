import java.nio.charset.StandardCharsets;

public class HashTable <Tkey , Tvalue>{
    private KeyValuePair<Tkey, Tvalue>[] entries;
    private int initialSize;
    private int entriesCount;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.initialSize = 3;
        this.entriesCount = 0;
        this.entries = (KeyValuePair<Tkey, Tvalue>[]) new KeyValuePair[this.initialSize];
    }

    public int getHash(Tkey key) {
        final long OFFSET_BASIS = 0x811C9DC5L;
        final long FNV_PRIME = 0x01000193L;

        // Convert any key to String and then to bytes
        byte[] data = key.toString().getBytes(StandardCharsets.US_ASCII);

        long hash = OFFSET_BASIS;

        for (byte b : data) {
            hash ^= (b & 0xFF);     // Convert byte to unsigned
            hash *= FNV_PRIME;
            hash &= 0xFFFFFFFFL;    // Keep it 32-bit
        }

        System.out.println(key + ", hash code: " + hash + "x (0x" + Long.toHexString(hash) + ")");

        return (int)hash % this.entries.length;
    }


    int CollisionHandler(Tkey key , int hash , boolean Set) {

        //linear probing solution to the collision problem  //note::there are other ways to solve this problem like "exp:double hashing"
        int newHash;
        for(int i = 1; i < this.entriesCount; i++){
            newHash = (hash + i ) % this.entries.length;
            if(Set && (this.entries[newHash] == null || this.entries[newHash]._key == key)){
                return newHash;
            }
            else if (!Set && this.entries[newHash]._key == key) {
                return newHash;
            }
        }
        return -1;
    }


    void AddToEntries(Tkey key , Tvalue value) {
        int hash = this.getHash(key);
        if(this.entries[hash] != null && this.entries[hash]._key != key){
            hash = this.CollisionHandler(key , hash , true);
        }
        if(hash == -1){
            throw new RuntimeException("Invalid Hashtable !!");
        }

        if(this.entries[hash] == null){
            KeyValuePair<Tkey, Tvalue> newPair = new KeyValuePair<>(key, value);
            this.entries[hash] = newPair;
            this.entriesCount++;
        }else if (this.entries[hash]._key == key){
            this.entries[hash]._value = value;
        }else{
            throw new RuntimeException("Invalid Hashtable !!");
        }
    }



    public void ResizeOrNot(){
        if(this.entriesCount < this.entries.length){
            return;
        }
        int newSize = this.entries.length * 2;  //newsize
        System.out.println("resize from " + this.entries.length + " to " + newSize);

        @SuppressWarnings("unchecked")
        KeyValuePair<Tkey, Tvalue>[] entriesCopy = (KeyValuePair<Tkey, Tvalue>[]) new KeyValuePair[this.entries.length];  //make new entries
        System.arraycopy(this.entries, 0, entriesCopy, 0, this.entries.length);   //copy the entries

        this.entries = new KeyValuePair[newSize];  //make a new entries with the new size

        for(int i = 0; i < entriesCopy.length; i++){
            if(entriesCopy[i] != null){
                this.AddToEntries(entriesCopy[i]._key , entriesCopy[i]._value);
            }
        }
    }

    public void set(Tkey key , Tvalue value) {
        this.ResizeOrNot();
        this.AddToEntries(key , value);
    }

    public Tvalue get(Tkey key) {
        int hash = this.getHash(key);
        if(this.entries[hash] != null && this.entries[hash]._key != key){
            hash = this.CollisionHandler(key , hash , false);
        }
        if(hash == -1 || this.entries[hash] == null){
            return null;
        }

        if(this.entries[hash]._key == key){
            return this.entries[hash]._value;
        }
        else{
            throw new RuntimeException("Invalid Hashtable !!");
        }
    }

    public int size(){
        return this.entriesCount;
    }

    public void print(){
        System.out.println("Size: " + this.size());
        for(int i = 0; i < this.entriesCount; i++){
            System.out.println(this.entries[i].get_key() + ": " + this.entries[i].get_value());
        }
        System.out.println("=============");
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
