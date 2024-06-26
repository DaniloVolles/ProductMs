package danilovolles.productms.controller;

import danilovolles.productms.dto.ProductDTO;
import danilovolles.productms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO request){
        Optional<ProductDTO> response = service.create(request);
        if(response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        Optional<ProductDTO> response = service.getProductById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody @Valid ProductDTO request
    ){
        Optional<ProductDTO> response = service.updateProductById(id, request);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> inactiveProduct(@PathVariable("id") Long id){
        boolean inactive = service.inactiveProductById(id);
        return inactive
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}