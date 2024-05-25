package org.example.dtos;

import org.example.models.Supply;

import java.util.Date;
/**
 * Этот класс используется для передачи данных о поставке одного
 * продукта от одного потсавщика включая цену на поставку этого продукта
 * и этот класс нужен для создания отчетов на фронтенде
 */
public class SupplyHolder {
    private Long id;
    private String supplierName;
    private String productName;
    private int quantity;
    private double price;

    private Date supplyDate;

    /**
     * Конструктор для создания объекта SupplyHolder с указанными значениями.
     *
     * @param id           идентификатор поставки
     * @param supplierName название поставщика
     * @param productName  название продукта
     * @param quantity     количество продукта в поставке
     * @param price        цена поставки
     * @param supplyDate   дата поставки
     */
    public SupplyHolder(Long id, String supplierName, String productName, int quantity, double price, Date supplyDate) {
        this.id = id;
        this.supplierName = supplierName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.supplyDate = supplyDate;
    }

    /**
     * Конструктор для создания объекта SupplyHolder на основе объекта Supply и имен поставщика и продукта.
     *
     * @param supply       объект поставки
     * @param productName  название продукта
     * @param supplierName название поставщика
     */
    public SupplyHolder(Supply supply, String productName, String supplierName) {
        this.id = supply.getId();
        this.supplierName = supplierName;
        this.productName = productName;
        this.quantity = supply.getQuantity();
        this.price = supply.getPrice();
        this.supplyDate = supply.getSupplyDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }
}

