package springbootintro.product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="productCategoryID", unique=true, nullable=false)
    private Integer id;

    @Column(name="name", unique=true, nullable=false)
    private String name;

    @OneToMany(mappedBy = "prodCat")
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        this.products.add(product);
        product.setProdCat(this);
    }
}
