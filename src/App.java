import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        Product TV = new ShippableProduct("TV", 200, 5, 100); // shippable
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, LocalDate.of(2025, 1, 1), 700); // expired
                                                                                                             // &
                                                                                                             // shippable
        Product mobileScratch = new Product("Mobile Scratch", 100, 100); // neither

        System.out.println(" ");
        System.out.println("## success case test ##");
        System.out.println(" ");
        Customer customer1 = new Customer("Karim", "karimslkamel@gmail.com",
                "01112653391", 10000);
        Cart cart1 = customer1.getCart();
        // mix of shippable and non shippable items
        cart1.addItem(new CartItem(mobileScratch, 2));
        cart1.addItem(new CartItem(TV, 2));
        customer1.checkout();
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("## insufficent balance case test ##");
        System.out.println(" ");

        Customer customer2 = new Customer("Karim", "karimslkamel@gmail.com",
                "01112653391", 100);
        Cart cart2 = customer2.getCart();
        cart2.addItem(new CartItem(TV, 1));
        customer2.checkout();
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("## order exceeds quantity case test ##");
        System.out.println(" ");
        Customer customer3 = new Customer("Karim", "karimslkamel@gmail.com",
                "01112653391", 5000);
        Cart cart3 = customer3.getCart();
        cart3.addItem(new CartItem(TV, 10));
        cart3.addItem(new CartItem(mobileScratch, 2));
        customer3.checkout();
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("## expired product case test ##");
        System.out.println(" ");

        Customer customer4 = new Customer("Karim", "karimslkamel@gmail.com",
                "01112653391", 5000);
        Cart cart5 = customer4.getCart();
        cart5.addItem(new CartItem(biscuits, 1));
        customer4.checkout();
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("## empty cart case test ##");
        System.out.println(" ");
        Customer customer5 = new Customer("Karim", "karimslkamel@gmail.com",
                "01112653391", 500);
        customer5.checkout();
        System.out.println(" ");
    }
}
