public interface Frontier{
    
    public void add(Location loc);
    public boolean hasNext();
    public Location next();
    public int size();

}
