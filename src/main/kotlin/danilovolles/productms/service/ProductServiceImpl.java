package danilovolles.productms.service;

import danilovolles.productms.dto.ProductDTO;
import danilovolles.productms.model.Product;
import danilovolles.productms.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(request, Product.class);
        productRepository.saveAndFlush(product);
        ProductDTO response = modelMapper.map(product, ProductDTO.class);
        return Optional.of(response);
    }
}
