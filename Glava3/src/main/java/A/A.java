package A;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 9
class Product {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private int shelfLife;
    private int quantity;

    public Product(int id, String name, String upc, String manufacturer, double price, int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public Product(String name, double price) {
        this(0, name, "000000", "Unknown", price, 0, 0);
    }

    public Product() {
        this(0, "Unknown", "000000", "Unknown", 0.0, 0, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                ", quantity=" + quantity +
                '}';
    }
}

class ProductDemo {
    private List<Product> products;

    public ProductDemo() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductsByNameAndPrice(String name, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductsByShelfLife(int minShelfLife) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                result.add(product);
            }
        }
        return result;
    }

    public void printProducts(List<Product> productList) {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        ProductDemo demo = new ProductDemo();

        demo.addProduct(new Product(1, "Milk", "123456", "Dairy Co.", 1.5, 10, 100));
        demo.addProduct(new Product(2, "Bread", "654321", "Bakery Ltd.", 0.8, 3, 50));
        demo.addProduct(new Product(3, "Milk", "123457", "Dairy Co.", 1.3, 15, 200));
        demo.addProduct(new Product(4, "Butter", "987654", "Dairy Co.", 2.5, 20, 30));
        demo.addProduct(new Product(5, "Eggs", "456789", "Farm Co.", 2.0, 30, 12));

        System.out.println("a) Список товаров для заданного наименования 'Milk':");
        demo.printProducts(demo.findProductsByName("Milk"));

        System.out.println("\nb) Список товаров для заданного наименования 'Milk' с ценой не более 1.4:");
        demo.printProducts(demo.findProductsByNameAndPrice("Milk", 1.4));

        System.out.println("\nc) Список товаров, срок хранения которых больше 10 дней:");
        demo.printProducts(demo.findProductsByShelfLife(10));
    }
}

