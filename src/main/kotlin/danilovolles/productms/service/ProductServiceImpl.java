package danilovolles.productms.service;

import danilovolles.productms.dto.ProductDTO;
import danilovolles.productms.model.Product;
import danilovolles.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setAvailable(request.isAvailable());

        productRepository.saveAndFlush(product);

//        /* Opcional, apenas para não retornar uma request, que fica feio: */
//        ProductDTO response = new ProductDTO();
//
//        response.setName((product.getName()));
//        response.setPrice(product.getPrice());
//        response.setDescription(request.getDescription());
//        response.setAvailable(request.isAvailable());
//
//        return Optional.of(response);

        return Optional.of(request);
    }
}
