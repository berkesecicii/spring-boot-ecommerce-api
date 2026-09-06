package edu.wgu.d288_backend.bootstrap;

import edu.wgu.d288_backend.dao.CustomerRepository;
import edu.wgu.d288_backend.dao.DivisionRepository;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {
            Division division = divisionRepository.findAll().get(0);

            Customer customer1 = new Customer();
            customer1.setFirstName("Berke");
            customer1.setLastName("Secici");
            customer1.setAddress("2389 Seattle Way");
            customer1.setPostal_code("98106");
            customer1.setPhone("3343149961");
            customer1.setDivision(division);
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setFirstName("Simal");
            customer2.setLastName("Secici");
            customer2.setAddress("2389 Seattle Way");
            customer2.setPostal_code("98106");
            customer2.setPhone("555-0102");
            customer2.setDivision(division);
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("Mert");
            customer3.setLastName("Kara");
            customer3.setAddress("482 Federal Way");
            customer3.setPostal_code("98003");
            customer3.setPhone("584932017");
            customer3.setDivision(division);
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("Omer");
            customer4.setLastName("Dibecki");
            customer4.setAddress("100 Renton Ave");
            customer4.setPostal_code("98055");
            customer4.setPhone("285473892");
            customer4.setDivision(division);
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("Suleyman");
            customer5.setLastName("Soyvural");
            customer5.setAddress("400 Kirkland Ave");
            customer5.setPostal_code("98033");
            customer5.setPhone("1234567");
            customer5.setDivision(division);
            customerRepository.save(customer5);
        }
    }
}