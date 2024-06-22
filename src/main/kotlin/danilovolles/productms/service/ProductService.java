package danilovolles.productms.service;

import danilovolles.productms.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> create(ProductDTO request);
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);
    boolean inactiveProductById(Long id);
    boolean deleteProductById(Long id);
}
