package consantiagocom.tercertrimestre.tema11.ej05;

public class Invent extends ItemList {
    private String item;
    private final int stack;

    public String getItem() {
        return item;
    }

    public int getStack() {
        return stack;
    }

    public Invent() {
        super();
        this.item = "";
        this.stack = 0;
    }

    public Invent(String item, int stack) {
        this.item = item;
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "Invent{" +
                "item='" + item + '\'' +
                ", stack=" + stack +
                '}';
    }

    public void setItem(String item) {
        if (confirmItem(item) == 1) {
            this.item = item;
        }
    }
}
