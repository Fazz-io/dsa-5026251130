package Lw01.Prelab;

public class Monoprint extends PrintJob {
    private static final int RATE_PER_PAGE = 500;
 
    public Monoprint(String id, int pages) {
        super(id, pages);
    }
 
    @Override
    public int calculateCharge() {
        return getPages() * RATE_PER_PAGE;
    }
 
    @Override
    public String label() {
        return "Mono";
    }
}
