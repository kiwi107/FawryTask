import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private Cart cart;
    private static final double SHIPPING_COST = 30.0;

    public Checkout(Cart cart) {
        this.cart = cart;
    }

    public double calculateSubTotal() {
        double total = 0.0;
        for (CartItem item : cart.getItems()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public double calculateTotal() {
        double subTotal = calculateSubTotal();
        double total = subTotal + SHIPPING_COST;
        return total;
    }

    public void generateReceipt() {
        System.out.println(" ");
        System.out.println("** Checkout Receipt **");
        for (CartItem item : cart.getItems()) {
            String productName = item.getProduct().getName();
            int quantity = item.getQuantity();
            double price = item.getProduct().getPrice();
            double totalPrice = price * quantity;

            System.out.printf("%-20s %6.0f\n", quantity + "x " + productName, totalPrice);
        }

        System.out.println("-----------------------");

        System.out.printf("%-20s %6.0f\n", "Subtotal", calculateSubTotal());
        System.out.printf("%-20s %6.0f\n", "Shipping", SHIPPING_COST);
        System.out.printf("%-20s %6.0f\n", "Amount", calculateTotal());
    }

    public void sendShippableItemsToShippingService() {
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;

                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add(shippable);
                }
            }
        }

        ShippingService service = new ShippingService(shippableItems);
        service.shipItems();
    }

    public boolean hasExpiredItems() {
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof ExpirableProduct) {
                ExpirableProduct expirable = (ExpirableProduct) product;
                if (expirable.isExpired()) {
                    System.out.println("cannot proceed, product " + expirable.getName() + " is expired");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasQuantityIssues() {
        for (CartItem item : cart.getItems()) {
            int requested = item.getQuantity();
            int available = item.getProduct().getQuantity();
            if (requested > available) {
                System.out.println("no enough stock for " + item.getProduct().getName() +
                        ", available is only " + available);
                return true;
            }
        }
        return false;
    }

}
