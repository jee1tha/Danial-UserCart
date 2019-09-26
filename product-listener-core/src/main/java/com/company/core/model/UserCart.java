package com.company.core.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_card")
public class UserCart implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid",parameters = {
            @Parameter(name = "separator", value = "-") })
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Column(name = "user_id", length = 40, nullable = false, columnDefinition = "VARCHAR(40) COMMENT 'User id '")
    private String userId;

    @Column(name = "product_id", length = 40, nullable = false, columnDefinition = "VARCHAR(40) COMMENT 'Product id '")
    private String productId;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
