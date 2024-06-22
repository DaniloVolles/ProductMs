package danilovolles.productms.service;

import danilovolles.productms.dto.ProductDTO;
import danilovolles.productms.model.Product;
import danilovolles.productms.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {

        Product product = modelMapper.map(request, Product.class);
        productRepository.saveAndFlush(product);
        ProductDTO response = modelMapper.map(product, ProductDTO.class);
        return Optional.of(response);

    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductDTO> responses = new ArrayList<>();

        products.forEach(product -> {
            ProductDTO response = modelMapper.map(product, ProductDTO.class);
            responses.add(response);
        });

        return responses;
    }


}
