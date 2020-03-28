import java.util.LinkedList;
import java.util.Queue;
public class LRU extends Memory implements Cache{
    Queue<Integer> cache = new LinkedList<>();
    int cacheSize;

    public LRU(int cacheSize) {
        super.setName("LRU");
        this.cacheSize = cacheSize;
    }

    @Override
    public String lookup(int address) {
        this.cache.forEach((n) -> System.out.print(" "+n +" "));
        System.out.println();
        if(this.inCache(address)) {
            System.out.print("LRU hit ");
            this.cache.remove(address);
            this.cache.add(address);
        }else {
            super.lookup(address);
            this.cache.add(address);
            if (this.cache.size() > this.cacheSize){
                this.cache.remove();
            }

        }
        try {
            return LRU.hashAddress(address);
        }catch (Exception e){
            return "LLL";
        }
    }

    @Override
    public boolean inCache(int address){
        return this.cache.contains(address);
    }
}
