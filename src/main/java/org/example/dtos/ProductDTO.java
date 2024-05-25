package org.example.dtos;

/**
 * Этот класс используется для передачи данных о продукте
 */
public class ProductDTO {

    private Long id;
    private String name;
    private String type;

    public ProductDTO() {
    }

    /**
     * Конструктор для создания объекта ProductDTO с указанными значениями
     *
     * @param id   идентификатор продукта
     * @param name название продукта
     * @param type тип продукта
     */
    public ProductDTO(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
