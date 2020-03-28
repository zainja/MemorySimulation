import java.util.ArrayList;

public class Random extends Memory implements Cache{
    int cacheSize;
    ArrayList<Integer> cache = new ArrayList<>();
    public Random(int cacheSize)
    {
        super.setName("Random");
        this.cacheSize = cacheSize;
    }

    @Override
    public String lookup(int address) {
        if(this.inCache(address)){
            System.out.print("Random hit ");
        }else {
            super.lookup(address);
            if (cache.size() < this.cacheSize)
                cache.add(address);
            else{
                int random = (int) (Math.random() * (cacheSize - 1));
                cache.remove(random);
                cache.add(address);
            }
        }
        try {
            return Random.hashAddress(address);
        }catch (Exception e){
            return "RRR";
        }
    }

    @Override
    public boolean inCache(int address){
        return  this.cache.contains(address);
    }
}
