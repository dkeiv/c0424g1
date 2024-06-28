import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<Product>();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int numberOfProducts () {
        return this.products.size();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProductList (){
        for (Product product : this.products) {
            System.out.println(product);
        }
    }

    public Product getProductByCode (String productCode) {
        for (Product product : this.products) {
            if(product.getCode().equalsIgnoreCase(productCode)) {
                return product;
            }
        }
        return null;
    }
}
