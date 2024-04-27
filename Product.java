// Kelas dasar Product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Kelas turunan FoodProduct
class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    // Metode untuk menampilkan informasi produk makanan
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Expiration Date: " + expirationDate);
    }
}

// Kelas turunan NonFoodProduct
class NonFoodProduct extends Product {
    private String category;

    public NonFoodProduct(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    // Metode untuk menampilkan informasi produk non-makanan
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Category: " + category);
    }
}

// Kelas Store
class Store {
    private Product[] products;

    public Store(Product[] products) {
        this.products = products;
    }

    // Metode untuk menampilkan semua produk yang tersedia di toko
    public void displayProducts() {
        System.out.println("Products available in the store:");
        for (Product product : products) {
            if (product instanceof FoodProduct) {
                ((FoodProduct) product).displayInfo();
            } else if (product instanceof NonFoodProduct) {
                ((NonFoodProduct) product).displayInfo();
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat beberapa objek produk
        Product foodProduct = new FoodProduct("Rice", 10.99, "2024-12-31");
        Product nonFoodProduct = new NonFoodProduct("Soap", 2.50, "Personal Care");

        // Menampilkan informasi produk
        if (foodProduct instanceof FoodProduct) {
            ((FoodProduct) foodProduct).displayInfo();
        }
        if (nonFoodProduct instanceof NonFoodProduct) {
            ((NonFoodProduct) nonFoodProduct).displayInfo();
        }

        // Menampilkan informasi produk melalui toko
        Product[] products = {foodProduct, nonFoodProduct};
        Store store = new Store(products);
        store.displayProducts();
    }
}
