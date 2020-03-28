public class Cyclic extends Memory implements Cache {
    private int[] cache;
    private int cacheSize;
    private int cachePointer;
    private int evictionPointer;
    public Cyclic(int cacheSize) {
        super.setName("Cyclic");
        this.cacheSize = cacheSize;
        this.cache = new int[this.cacheSize];
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public String lookup (int address) {
        if (! this.inCache(address)){
            super.lookup(address);
            if(this.cachePointer < this.cacheSize){
                this.cache[cachePointer] = address;
                this.cachePointer ++;
            }else {
                this.cache[evictionPointer] = address;
                evictionPointer ++;
                if(evictionPointer == cacheSize) {
                    evictionPointer = 0;
                }
            }
        }
        try {
            return Cyclic.hashAddress(address);
        }catch (Exception e){
            return "CCC";
        }
    }

    @Override
    public boolean inCache(int address){
        for (int i : this.cache){
            if (address == i){
                return true;
            }
        }
        return false;
    }

}
