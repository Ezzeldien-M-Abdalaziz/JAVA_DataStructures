import java.nio.charset.StandardCharsets;

public class HashFunctions {

    public long hash32(String str) {
        final long OFFSET_BASIS = 0x811C9DC5L;   // 2166136261
        final long FNV_PRIME = 0x01000193L;      // 16777619

        byte[] data = str.getBytes(StandardCharsets.US_ASCII);  // ASCII encoding

        long hash = OFFSET_BASIS;


        for (byte b : data) {
            hash ^= (b & 0xFF);     // Convert byte to unsigned
            hash *= FNV_PRIME;
            hash &= 0xFFFFFFFFL;    // Keep it 32-bit
        }

        System.out.println(str + ", hash code: " + hash + "x (0x" + Long.toHexString(hash) + ")");

        return hash;
    }
}
