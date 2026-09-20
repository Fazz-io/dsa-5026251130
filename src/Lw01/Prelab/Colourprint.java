package Lw01.Prelab;

public class Colourprint extends PrintJob {
    private static final int FIRST_TIER_PAGES = 10;
    private static final int FIRST_TIER_RATE = 1500;
    private static final int NEXT_TIER_RATE = 1000;
    private static final int SETUP_FEE = 2000;
 
    public Colourprint(String id, int pages) {
        super(id, pages);
    }
 
    @Override
    public int calculateCharge() {
        int pages = getPages();
        int firstTier = Math.min(pages, FIRST_TIER_PAGES);
        int beyondTier = Math.max(0, pages - FIRST_TIER_PAGES);
        return firstTier * FIRST_TIER_RATE + beyondTier * NEXT_TIER_RATE + SETUP_FEE;
    }
 
    @Override
    public String label() {
        return "Colour";
    }
}
