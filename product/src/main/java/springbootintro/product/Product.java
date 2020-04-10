package springbootintro.product;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="productID", unique=true, nullable=false)
    private Integer id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="productCategoryID")
    private ProductCategory prodCat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProdCat() {
        return prodCat;
    }

    public void setProdCat(ProductCategory prodCat) {
        this.prodCat = prodCat;
    }
}
