package com.TP.eval;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import com.TP.eval.model.*;
import com.TP.eval.model.Animal;



import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU")) {
			ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
			EntityManager em = EntityManagerFactory.createEntityManager();

			System.out.println("Hello World!, creation des tables et insertion des données");
			em.getTransaction().begin();
			// Création de trois animaleries
			PetStore petStore1 = new PetStore();
			petStore1.setName("Animalerie du Centre");
			petStore1.setManagerName("bradley Du Centre");

			PetStore petStore2 = new PetStore();
			petStore2.setName("Animalerie du Sud");
			petStore2.setManagerName("alice du Sud");

			PetStore petStore3 = new PetStore();
			petStore3.setName("Animalerie du Nord");
			petStore3.setManagerName("karim Nord");

			//creation de trois addresses
			Address address1 = new Address();
			address1.setStreet("123 Main Street");
			address1.getZipCode("23456");
			address1.setCity("London");

			Address address2 = new Address();
			address2.setStreet("123 rue Street");
			address2.getZipCode("45678");
			address2.setCity("Maroc");

			Address address3 = new Address();
			address3.setStreet("123 rue bazille");
			address3.getZipCode("45679");
			address3.setCity("France");

			petStore1.setAdress(address1);
			petStore2.setAdress(address2);
			petStore3.setAdress(address3);

			//Creation de trois produits

			Product product1 = new Product();
			product1.setLabel("premium product");
			product1.setPrice(50.00);
			product1.setType(ProdType.FOOD);

			Product product2 = new Product();
			product2.setLabel("free product");
			product2.setPrice(0.00);
			product2.setType(ProdType.ACCESSORY);

			Product product3 = new Product();
			product3.setLabel("big product");
			product3.setPrice(70.00);
			product3.setType(ProdType.CLEANING);

			petStore1.setProducts(List.of(product1, product2, product3));
			petStore2.setProducts(List.of(product1, product3));
			petStore3.setProducts(List.of(product2, product3));

			//creation de trois poissons

			Fish fish1 = new Fish();
			fish1.setBirth(new Date());
			fish1.setCouleur("blue");
			fish1.setLivingEnv(FishLiveEnv.FRESH_WATER);


			Fish fish2 = new Fish();
			fish2.setBirth(new Date());
			fish2.setCouleur("red");
			fish2.setLivingEnv(FishLiveEnv.FRESH_WATER);

			Fish fish3 = new Fish();
			fish3.setBirth(new Date());
			fish3.setCouleur("green");
			fish3.setLivingEnv(FishLiveEnv.FRESH_WATER);

			//creation de trois chats
			Cat cat1 = new Cat();
			cat1.setBirth(new Date());
			cat1.setCouleur("blue");

			Cat cat2 = new Cat();
			cat2.setBirth(new Date());
			cat2.setCouleur("red");

			Cat cat3 = new Cat();
			cat3.setBirth(new Date());
			cat3.setCouleur("green");

			petStore1.setAnimals(List.of(fish1, cat1));
			petStore2.setAnimals(List.of(fish2, cat2));
			petStore3.setAnimals(List.of(fish3, cat3));

			em.persist(address1);
			em.persist(address2);
			em.persist(address3);
			em.persist(petStore1);
			em.persist(petStore2);
			em.persist(petStore3);
			em.persist(product1);
			em.persist(product2);
			em.persist(product3);
			em.persist(fish1);
			em.persist(fish2);
			em.persist(fish3);
			em.persist(cat1);
			em.persist(cat2);
			em.persist(cat3);

			em.getTransaction().commit();

			System.out.println("Données insérées");

			// extraire les animaux d'une animalerie donnée exemple "animalerie du centre"
			String spaceName = "Animalerie du Centre";
			TypedQuery<Animal> query = em.createQuery(
					"SELECT a FROM Animal a WHERE a.petStore.name = :spaceName", Animal.class);
			query.setParameter("spaceName", spaceName);

			List<Animal> animals = query.getResultList();

			System.out.println("\nAnimaux présents dans l'animalerie '" + spaceName + "':");
			for (Animal animal : animals) {
				if (animal instanceof Fish) {
					System.out.println("- Poisson " + ((Fish) animal).getCouleur() + " (" + ((Fish) animal).getLivingEnv() + ")");
				} else if (animal instanceof Cat) {
					System.out.println("- Chat " + ((Cat) animal).getCouleur() + " (ID puce: " + ((Cat) animal).getChipId() + ")");
				}
			}


		}
	}
}