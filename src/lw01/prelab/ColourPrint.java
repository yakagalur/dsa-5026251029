package lw01.prelab;

public class ColourPrint extends PrintJob {
    public ColourPrint (String id, int pages){
        super (id, pages);
    }

    @Override 
    public int calculateCharge() {
        int pageCharge;
        if (getPages() <= 10) {
            pageCharge = getPages() * 1500;
        } else {
            pageCharge = (10 * 1500) + ((getPages()-10) * 1000);
        }
        return pageCharge + 2000;
    }

    @Override 
    public String label() {
        return "Colour";
    }
}