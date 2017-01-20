package hello.repository;

import hello.domain.Business;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by mda on 1/19/17.
 */
@RepositoryRestResource(collectionResourceRel = "business", path = "business")
public interface BusinessRepository extends MongoRepository<Business, String> {


}