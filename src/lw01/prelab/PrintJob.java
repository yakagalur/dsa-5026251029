package lw01.prelab;

public abstract class PrintJob {
    protected String id;
    protected int pages;

    public PrintJob(String id, int pages) {
        if (pages <= 0 || pages > 100) {
            throw new IllegalArgumentException("Halaman harus lebih dari 0 dan maksimal 100.");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages(){
        return pages;
    }

    public abstract int calculateCharge();
    public int calculateCharge (int copies) {
        if (copies <=10 || copies > 10) {
            throw new IllegalArgumentException("Jumlah copy harus lebih dari 0 dan maksimal 10");
        }
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
