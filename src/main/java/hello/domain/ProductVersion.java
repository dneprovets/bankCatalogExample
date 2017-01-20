package hello.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Created by mda on 1/19/17.
 */
@Document
public class ProductVersion {
    @Id
    private String id;
    private String state;
    private Map<String, String> productPreferences;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getProductPreferences() {
        return productPreferences;
    }

    public void setProductPreferences(Map<String, String> productPreferences) {
        this.productPreferences = productPreferences;
    }
}
