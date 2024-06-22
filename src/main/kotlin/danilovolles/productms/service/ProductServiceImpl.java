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

    @Autowired
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

    @Override
    public Optional<ProductDTO> getProductById(Long id) {

        Optional<Product> product = productRepository.findById(id);

        // return product.map(value -> modelMapper.map(value, ProductDTO.class)); // Pode finalizar aqui
        if (product.isPresent()){
            return Optional.of(modelMapper.map(product.get(), ProductDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public Optional<ProductDTO> updateProductById(Long id, ProductDTO request) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            product.get().setName(request.getName());
            product.get().setPrice(request.getPrice());
            product.get().setDescription(request.getDescription());
            productRepository.save(product.get());
            return Optional.of(modelMapper.map(product.get(), ProductDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean inactiveProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            product.get().setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }


}
