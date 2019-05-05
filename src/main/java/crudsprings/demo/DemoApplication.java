package crudsprings.demo;

import crudsprings.demo.DAO.ProductRepository;
import crudsprings.demo.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      productRepository.save(new Produit(null,"PC HP",6000,12));
//        productRepository.save(new Produit(null,"TV SONY",180000,40));
//        productRepository.save(new Produit(null,"VOITTURE",106000,13));
//        productRepository.save(new Produit(null,"MOTO",450000,72));
//        productRepository.findAll().forEach(p->{
//            System.out.println(p.getDesignation());
//        });
    }
}
