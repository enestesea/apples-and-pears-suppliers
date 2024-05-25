package org.example.dtos;

import java.util.Date;
/**
 * DTO для представления информации о ценах
 * Этот класс используется для передачи данных о ценах на разные продукты
 * от разных поставщиков за разные промежутки времени
 */
public class ProductPriceDTO {

    private Long id;
    private Long supplierId;
    private Long productId;
    private double price;
    private Date startDate;
    private Date endDate;

    public ProductPriceDTO() {
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

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

