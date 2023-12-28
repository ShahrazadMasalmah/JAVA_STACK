public class Item {
    // MEMBER VARIABLES
    private String name;
    private double price;
    private int index;

    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.index = 0;
    }

    // GETTERS & SETTERS  - for name and price
    public String getItemName(){
        return this.name;
    }

    public void setItemName(String name){
        this.name = name;
    }

    public double getItemPrice(){
        return this.price;
    }

    public void setItemPrice(double price){
        this.price = price;
    }

    public int getItemIndex(){
        return this.index;
    }

    public void setItemIndex(int index){
        this.index = index;
    }
}