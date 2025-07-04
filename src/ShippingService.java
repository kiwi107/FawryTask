import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    private List<Shippable> items;

    public ShippingService(List<Shippable> items) {
        this.items = items;
    }

    public void shipItems() {
        if (items.isEmpty())
            return;

        System.out.println(" ");
        System.out.println("** Shipment Notice **");

        double totalWeight = 0.0;
        Map<String, Double> weightMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            weightMap.put(name, weightMap.getOrDefault(name, 0.0) + weight);
            totalWeight += weight;
        }

        for (String name : countMap.keySet()) {
            int count = countMap.get(name);
            double totalItemWeight = weightMap.get(name);
            System.out.printf("%-20s %6.0fg\n", count + "x " + name, totalItemWeight);
        }

        System.out.println("-----------------------");
        System.out.printf("%-20s %6.1fkg\n", "Total Weight", totalWeight / 1000);
    }

}
