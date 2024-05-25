package org.example.dtos;
/**
 * Этот класс используется для передачи данных о поставщике
 */
public class SupplierDTO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

