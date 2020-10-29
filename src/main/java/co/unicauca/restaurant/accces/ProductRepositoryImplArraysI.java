
package co.unicauca.restaurant.accces;
import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;


/**
* Implementación por defecto. El framewok contenedor de CDI (Contexts and
* Dependency Injection) carga la implementación por defecto.
*
* @author Cristian Pinto,Julio Mellizo
*/

public class ProductRepositoryImplArraysI implements IProductRepository {

/**
* Por simplicidad los datos se cargan en un array.
*/
    public static List<Product> products;
    
    public ProductRepositoryImplArraysI(){
        products = new ArrayList<>();
            initialize();
    }
    
    private void initialize() {
        products.add(new Product(1, "Pizza", 3000d));
        products.add(new Product(2, "Lasaña", 3500d));
        products.add(new Product(3, "Sopa Minestrone", 7000d));
        products.add(new Product(4, "Ensalada Capresse", 9000d));
        products.add(new Product(5, "Espaguetis a la carbonara", 8500d));
        products.add(new Product(6, "Risotto", 4400d));
        
    }
    
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
                //Ya existe
                return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
        return true;
        }
    return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
