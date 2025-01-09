package exam.kea.dk.deletelater.repository;

import exam.kea.dk.deletelater.model.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
