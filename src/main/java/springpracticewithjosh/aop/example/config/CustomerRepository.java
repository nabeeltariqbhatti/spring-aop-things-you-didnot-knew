package springpracticewithjosh.aop.example.config;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nabeel Tariq Bhatti
 * @created on  3/28/23
 */

@Repository
public	interface CustomerRepository extends CrudRepository<ApplicationConfiguration.Customer, Integer> {

}