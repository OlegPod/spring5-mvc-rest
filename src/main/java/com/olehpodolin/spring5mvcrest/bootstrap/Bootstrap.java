package com.olehpodolin.spring5mvcrest.bootstrap;

import com.olehpodolin.spring5mvcrest.domain.Category;
import com.olehpodolin.spring5mvcrest.domain.Customer;
import com.olehpodolin.spring5mvcrest.repositories.CategoryRepository;
import com.olehpodolin.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();

        System.out.println("Categories Loaded : " + categoryRepository.count());
        System.out.println("Customers Loaded : " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Michael");
        customer1.setLastName("Lachappele");

        Customer customer2 = new Customer();
        customer2.setFirstName("David");
        customer2.setLastName("Winter");

        Customer customer3 = new Customer();
        customer3.setFirstName("Anne");
        customer3.setLastName("Hine");

        Customer customer4 = new Customer();
        customer4.setFirstName("Alice");
        customer4.setLastName("Eastman");

        Customer customer5 = new Customer();
        customer5.setFirstName("Freddy");
        customer5.setLastName("Meyers");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
    }
}
