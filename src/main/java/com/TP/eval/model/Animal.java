package com.TP.eval.model;

import jakarta.persistence.*;
import java.util.Date;

    @Entity
    @Inheritance(strategy = InheritanceType.JOINED) //une tabla par classe (heritage)
    public abstract class Animal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Temporal(TemporalType.DATE)
        private Date birth;

        private String couleur;

        @ManyToOne
        @JoinColumn(name = "petstore_id")
        private PetStore petStore;

        // Constructeurs
        public Animal() {}

        public Animal(Date birth, String couleur) {
            this.birth = birth;
            this.couleur = couleur;
        }

        //getters et setters

        public void setPetStore(PetStore petStore) {
            this.petStore = petStore;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }

        public String getCouleur() {
            return couleur;
        }

        public void setCouleur(String couleur) {
            this.couleur = couleur;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "id=" + id +
                    ", birth=" + birth +
                    ", couleur='" + couleur + '\'' +
                    '}';
        }
}
