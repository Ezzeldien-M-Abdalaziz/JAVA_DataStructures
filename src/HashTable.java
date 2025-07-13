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

    public long getHash(Tkey key , int tableSize) {
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

        return (int)hash % tableSize;
    }

    public void ResizeOrNot(){
        if(this.entriesCount < this.entries.length){
            return;
        }
        int newSize = this.entries.length + this.initialSize;
        System.out.println("resize from " + this.entries.length + " to " + newSize);
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
