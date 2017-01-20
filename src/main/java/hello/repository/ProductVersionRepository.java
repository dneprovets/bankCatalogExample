package hello.repository;


import hello.domain.ProductVersion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mda on 1/19/17.
 */
@RepositoryRestResource(collectionResourceRel = "productVersion", path = "productVersion")
public interface ProductVersionRepository extends MongoRepository<ProductVersion, String> {

}
