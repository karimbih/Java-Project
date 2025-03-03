package com.TP.eval.model;

import jakarta.persistence.*;
import java.util.*;
import jakarta.persistence.EnumType;

@Entity
@Table (name = "fish")
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    private FishLiveEnv livingEnv;

    //Getters et Setters

    public FishLiveEnv getLivingEnv() {
        return livingEnv;
    }
    public void setLivingEnv(FishLiveEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

}
