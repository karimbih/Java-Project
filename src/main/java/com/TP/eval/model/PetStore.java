package com.TP.eval.model;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import java.util.List;
//classe Petstore qui represente l'entité Petstore
@Entity
@Table (name = "petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String managerName;

    @ManyToMany
    @JoinTable(
            name = "petstore_product",
            joinColumns = @JoinColumn(name = "petstore_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public PetStore() {

    }
    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;

    }

    //Getters et Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    public Address getAdress() {
        return address;
    }
    public void setAdress(Address address) {
        this.address = address;
    }

}
