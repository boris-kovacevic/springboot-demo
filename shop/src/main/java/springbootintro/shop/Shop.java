package springbootintro.shop;

import javax.persistence.*;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="shopID", unique=true, nullable=false)
    private Integer id;

    @Column(name="name", unique=false, nullable=false, length=100)
    private String name;
    @Column(name="address", unique=false, nullable=false, length=40)
    private String address;

    @Column(name="city", unique=false, nullable=false, length=40)
    private String city;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
