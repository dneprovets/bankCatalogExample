package catalog.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by mda on 1/20/17.
 */
@Projection(name = "product", types = {Business.class, Employee.class, ProductVersion.class})
public interface ProductProjection {


    public List<Business> getBusinessesList();

    public Employee getProductOwner();

    public List<ProductVersion> getProductVersions();

    public String getProductName();

    public String getProductType();


}
