import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private Customer customer;

    public Cart(Customer customer) {
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    public void addItem(CartItem item) {
        // item already exists
        for (CartItem existingItem : items) {
            if (existingItem.getProduct().getName().equals(item.getProduct().getName())) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        // item does not exist
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void clear() {
        items.clear();
    }

}
