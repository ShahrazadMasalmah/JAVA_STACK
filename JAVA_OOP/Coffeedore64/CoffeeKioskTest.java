public class CoffeeKioskTest {
    public static void main(String[] args) {
        CoffeeKiosk test = new CoffeeKiosk();
        //test.addMenuItem("Banana", 2.00);
        //test.addMenuItem("Coffee", 1.50);
        //test.addMenuItem("latte", 4.50);
        //test.addMenuItem("Cappuccino", 3.00);
        //test.addMenuItem("Muffin", 4.00);
        test.addMenuItemByInput();
        test.newOrder();
    }
}
