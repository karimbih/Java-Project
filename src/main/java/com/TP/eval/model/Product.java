package com.TP.eval.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
//la classe product qui represente l'entité product
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private double price;
    @ManyToMany(mappedBy = "products")
    @JoinColumn(name = "petstore_id")
    private List<PetStore> petStores;
    

    //Getters et Setters
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLabel(){
        return label;
    }


    public void setType(ProdType type) {
        this.type = type;
    }
    public ProdType getType() {
        return type;
    }
    public List<PetStore>getPetStores() {
        return getPetStores();
    }
    public void setPetStores(List<PetStore> petStores) {
        this.petStores = petStores;
    }


    public void setLabel(String label) {
        this.label = label;
    }
    public double getPrice(double price){
        return price;
    }
    public double setPrice(double price) {
        this.price = price;
        return price;
    }


}
