import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        //Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2, etc.
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        //Set the price and the name for each - "mocha", "latte", "drip coffee" and "cappuccino." The price is up to you.
        item1.name = "mocha";
        item1.price = 5.0;
        item2.name = "latte";
        item2.price = 4.0;
        item3.name = "drip coffee";
        item3.price = 2.0;
        item4.name = "cappuccino";
        item4.price = 3.0;

    
        // Order variables -- order1, order2 etc.
        //Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2, etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        //Set each order's name - "Cindhuri", "Jimmy", "Noah", and "Sam."
        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";
        //Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total = item1.price;
        //Noah ordered a cappuccino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total = item3.price;
        //Sam added a latte. Update the order accordingly.
        order4.items.add(item2);
        order4.total = item2.price;
        //Cindhuri’s order is now ready. Update her status.
        order1.ready = true;
        //Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price*2;
        //Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Application Simulations
        // Use this example code to test various orders' updates
        //Print the order1 variable to the console to see what happens.
        //System.out.printf("Name: %s\n", order1.name);
        //System.out.printf("Total: %s\n", order1.total);
        //System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        System.out.printf("Items: %s\n", order4.items);
    }
}
