public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // overriding from parent class product
    @Override
    public boolean isShippable() {
        return true;
    }

    // overriding from interface Shippable
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
