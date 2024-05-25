package org.example.repositories;

import org.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий для работы с продуктами
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
