package demo.boot.service;


import java.util.List;

import org.springframework.stereotype.Service;

import demo.boot.dto.CustomerSummary;
import demo.boot.entity.Customer;
import demo.boot.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
public class DemoService {

    private final CustomerRepository customerRepository;

    public DemoService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Demonstrates N+1 problem
    @Transactional
    public void demonstrateNPlusOne() {

        System.out.println("\n===== N+1 PROBLEM =====");

        List<Customer> customers =
                customerRepository.findAll();

        for (Customer c : customers) {
            System.out.println(
                    c.getName()
                    + " Orders: "
                    + c.getOrders().size()
            );
        }
    }

    // Optimized using JOIN FETCH
    @Transactional
    public void optimizedFetchJoin() {

        System.out.println("\n===== FETCH JOIN =====");

        List<Customer> customers =
                customerRepository.findAllWithOrders();

        for (Customer c : customers) {
            System.out.println(
                    c.getName()
                    + " Orders: "
                    + c.getOrders().size()
            );
        }
    }

    // DTO Projection
    public void dtoProjection() {

        System.out.println("\n===== DTO PROJECTION =====");

        List<CustomerSummary> summaries =
                customerRepository.getCustomerSummary();

        summaries.forEach(System.out::println);
    }

    // EntityGraph
    @Transactional
    public void entityGraphDemo() {

        System.out.println("\n===== ENTITY GRAPH =====");

        List<Customer> customers =
                customerRepository.findAllUsingEntityGraph();

        for (Customer c : customers) {
            System.out.println(
                    c.getName()
                    + " Orders: "
                    + c.getOrders().size()
            );
        }
    }

    // Batch Fetching
    @Transactional
    public void batchFetchingDemo() {

        System.out.println("\n===== BATCH FETCHING =====");

        List<Customer> customers =
                customerRepository.findAll();

        customers.forEach(c ->
                System.out.println(
                        c.getName()
                        + " Orders: "
                        + c.getOrders().size()));
    }
}
