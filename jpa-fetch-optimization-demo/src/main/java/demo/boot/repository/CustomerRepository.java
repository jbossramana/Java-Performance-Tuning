package demo.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo.boot.dto.CustomerSummary;
import demo.boot.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    // N+1 FIX using fetch join
    @Query("""
        select distinct c
        from Customer c
        left join fetch c.orders
    """)
    List<Customer> findAllWithOrders();

    // DTO projection optimization
    @Query("""
        select new demo.boot.dto.CustomerSummary(
            c.name,
            count(o)
        )
        from Customer c
        left join c.orders o
        group by c.name
    """)
    List<CustomerSummary> getCustomerSummary();

    // EntityGraph optimization
    @EntityGraph(attributePaths = "orders")
    @Query("select c from Customer c")
    List<Customer> findAllUsingEntityGraph();

    // Pagination optimization example
    @Query("select c.id from Customer c")
    List<Long> findCustomerIds();

    @Query("""
        select distinct c
        from Customer c
        left join fetch c.orders
        where c.id in :ids
    """)
    List<Customer> findCustomersWithOrders(
            @Param("ids") List<Long> ids);
}
