package danilovolles.productms.service;

import danilovolles.productms.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    Optional<ProductDTO> create(ProductDTO request);
}
