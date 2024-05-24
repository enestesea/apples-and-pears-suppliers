package org.example.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_prices")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;

    private Long productId;

    private double price;

    private LocalDate startDate;

    private LocalDate endDate;

    public ProductPrice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long id) {
        this.supplierId = id;
    }public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
