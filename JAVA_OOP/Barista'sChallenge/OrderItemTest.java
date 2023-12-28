public class OrderItemTest {
    public static void main(String[] args) {
        //Menu Items
        Item item1 = new Item("mocha", 5.0);
        Item item2 = new Item("latte", 4.5);
        Item item3 = new Item("drip coffee", 1.5);
        Item item4 = new Item("capuccino", 3.5);
        //Create 2 orders for unspecified guests. Do not specify a name.
        Order order1 = new Order();
        Order order2 = new Order();
        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Sam");
        //Test orders
        System.out.println("Order1 Name: " + order1.getOrderName());
        System.out.println("Order2 Name: " + order2.getOrderName());
        System.out.println("Order3 Name: " + order3.getOrderName());
        System.out.println("Order4 Name: " + order4.getOrderName());
        System.out.println("Order5 Name: " + order5.getOrderName());

        //Add at least 2 items to each of the orders using the addItem method.
        order1.addItem(item4);
        order1.addItem(item3);
        order2.addItem(item1);
        order2.addItem(item4);
        order3.addItem(item2);
        order3.addItem(item3);
        order4.addItem(item2);
        order4.addItem(item4);
        order5.addItem(item2);
        order5.addItem(item2);

        //Test your getStatusMessage method by setting some orders to ready and printing the messages for each order.
        order1.setOrderIsReady(true);
        order3.setOrderIsReady(true);
        order5.setOrderIsReady(true);

        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        //Test the total by printing the return value like so: 'System.out.println(order1.getOrderTotal())'.
        System.out.println("Order1 Total: $" + order1.getOrderTotal());
        System.out.println("Order2 Total: $" + order2.getOrderTotal());
        System.out.println("Order3 Total: $" + order3.getOrderTotal());
        System.out.println("Order4 Total: $" + order4.getOrderTotal());
        System.out.println("Order5 Total: $" + order5.getOrderTotal());

        //Call the display method on all of your orders.
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
