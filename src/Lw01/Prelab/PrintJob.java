package Lw01.Prelab;

public abstract class PrintJob implements Chargeable {
    private final String id;
    private final int pages;
 
    protected PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("pages must be positive");
        }
        this.id = id;
        this.pages = pages;
    }
 
    public String getId() {
        return id;
    }
 
    public int getPages() {
        return pages;
    }
 
    @Override
    public abstract int calculateCharge();
 
    // Overload: same name, different parameter list. Implemented once here.
    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("copies must be positive");
        }
        return copies * calculateCharge();
    }
 
    public String label() {
        return "Print";
    }
 
    // Not overridden in subclasses: label() and calculateCharge() are resolved at runtime.
    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
