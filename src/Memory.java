import java.security.MessageDigest;
import java.math.BigInteger;

public class Memory {
    private String name;
    private int hitCount;

    public Memory() {
        this.name = "Memory";
        this.hitCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getHitCount() {
        return this.hitCount;
    }

    public String lookup (int address) {
        this.hitCount ++;
        System.out.printf("address %d Memory hit ", address);
        return Integer.toHexString(address);
    }
    public static String hashAddress(int address) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(((byte) address));
        byte[] digest = messageDigest.digest();
        return String.format("%08x", new BigInteger(1, digest));

    }
}
