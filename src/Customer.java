public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private double balance;
    private Cart cart;

    public Customer(String name, String email, String phoneNumber, double balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.cart = new Cart(this);
    }

    public void checkout() {

        // if cart is empty
        if (cart.getItems().isEmpty()) {
            System.out.println("cart is emptyy");
            System.out.println("checkout cancelled due to empty cart");
            return;
        }

        Checkout checkout = new Checkout(cart);
        // if cart has expired items
        if (checkout.hasExpiredItems()) {
            System.out.println("checkout cancelled due to expired products");
            return;
        }

        double total = checkout.calculateTotal();

        // if balance is not enough
        if (balance < total) {
            System.out.println("checkout cancelled due insufficient balance. your total is " + total
                    + ", but you only have " + balance);
            return;
        }

        if (checkout.hasQuantityIssues()) {
            System.out.println("checkout cancelled due to stock shortage");
            return;
        }

        checkout.generateReceipt();
        checkout.sendShippableItemsToShippingService();

        balance -= total;
        System.out.println(" ");
        System.out.println("payment successful, remaining balance: " + balance);
        System.out.println(" ");

        cart.clear();
    }

    // getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
