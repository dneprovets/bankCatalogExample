
package catalog.repository;

import java.util.List;

import catalog.domain.Product;
import catalog.domain.ProductProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "product", excerptProjection = ProductProjection.class)
public interface ProductRepository extends MongoRepository<Product, String> {

}
