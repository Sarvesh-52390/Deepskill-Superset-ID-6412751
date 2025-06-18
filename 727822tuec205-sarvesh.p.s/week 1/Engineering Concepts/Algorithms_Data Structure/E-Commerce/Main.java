import java.util.*;

public class Main {

    
    static class Product {
        int id;
        String name;
        String category;

        Product(int id, String name, String category) {
            this.id = id;
            this.name = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return id + " - " + name + " (" + category + ")";
        }
    }

    
    private static final Comparator<Product> NAME_COMPARATOR = Comparator.comparing(
        p -> p.name.toLowerCase()
    );

   
    public static Product linearSearch(List<Product> productList, String targetName) {
        for (Product product : productList) {
            if (product.name.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    
    public static Product binarySearch(List<Product> sortedList, String targetName) {
        int left = 0, right = sortedList.size() - 1;
        String targetLower = targetName.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = sortedList.get(mid).name.toLowerCase();
            int compareResult = targetLower.compareTo(midName);

            if (compareResult == 0) return sortedList.get(mid);
            else if (compareResult < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Smartphone", "Electronics"),
            new Product(104, "Book", "Education"),
            new Product(105, "SmartWatch", "Electronics")
        ));

        String searchName = "SmartWatch";

       
        System.out.println("LINEAR SEARCH:");
        Product foundLinear = linearSearch(products, searchName);
        if (foundLinear != null)
            System.out.println("Product Found: " + foundLinear);
        else
            System.out.println("Product Not Found");

        
        products.sort(NAME_COMPARATOR);

        System.out.println("\nBINARY SEARCH:");
        Product foundBinary = binarySearch(products, searchName);
        if (foundBinary != null)
            System.out.println("Product Found: " + foundBinary);
        else
            System.out.println("Product Not Found");
    }
}
