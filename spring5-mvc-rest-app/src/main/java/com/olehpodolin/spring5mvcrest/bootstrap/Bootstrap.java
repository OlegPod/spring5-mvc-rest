package com.olehpodolin.spring5mvcrest.bootstrap;

import com.olehpodolin.spring5mvcrest.domain.Category;
import com.olehpodolin.spring5mvcrest.domain.Customer;
import com.olehpodolin.spring5mvcrest.domain.Vendor;
import com.olehpodolin.spring5mvcrest.repositories.CategoryRepository;
import com.olehpodolin.spring5mvcrest.repositories.CustomerRepository;
import com.olehpodolin.spring5mvcrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();

        System.out.println("Categories Loaded : " + categoryRepository.count());
        System.out.println("Customers Loaded : " + customerRepository.count());
        System.out.println("Vendors Loaded : " + vendorRepository.count());
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
        customer1.setFirstname("Michael");
        customer1.setLastname("Lachappele");

        Customer customer2 = new Customer();
        customer2.setFirstname("David");
        customer2.setLastname("Winter");

        Customer customer3 = new Customer();
        customer3.setFirstname("Anne");
        customer3.setLastname("Hine");

        Customer customer4 = new Customer();
        customer4.setFirstname("Alice");
        customer4.setLastname("Eastman");

        Customer customer5 = new Customer();
        customer5.setFirstname("Freddy");
        customer5.setLastname("Meyers");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
    }

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Company 1");

        Vendor vendor2 = new Vendor();
        vendor2.setName("Company 2");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Company 3");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
    }
}
