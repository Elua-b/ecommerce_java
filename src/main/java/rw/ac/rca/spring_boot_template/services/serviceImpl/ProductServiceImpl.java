package rw.ac.rca.spring_boot_template.services.serviceImpl;

import org.springframework.stereotype.Service;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.exceptions.NotFoundException;
import rw.ac.rca.spring_boot_template.models.Product;
import rw.ac.rca.spring_boot_template.repositories.IProductRepository;
import rw.ac.rca.spring_boot_template.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl  implements ProductService {
    private  IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(CreateProductDTO createProductDTO) {
        try{
            Optional<Product> product = productRepository.findByName(createProductDTO.getName());
            System.out.println(product);
            if(product.isPresent()){
                throw new RuntimeException("Product already exists");
            }
            Product newProduct = new Product();
            newProduct.setName(createProductDTO.getName());
            newProduct.setDescription(createProductDTO.getDescription());
            newProduct.setPrice(createProductDTO.getPrice());
            newProduct.setImageUrl(createProductDTO.getImageUrl());
            newProduct.setCategory(createProductDTO.getCategory());
            return productRepository.save(newProduct);


        }catch (RuntimeException e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public Product updateProduct(UUID productId,CreateProductDTO createProductDTO) {
        try{
            Optional<Product> product = productRepository.findById(productId);
            if(product.isEmpty()){
                throw new NotFoundException("Product does not exist");
            }
            Product updatedProduct = product.get();
            updatedProduct.setName(createProductDTO.getName());
            updatedProduct.setDescription(createProductDTO.getDescription());
            updatedProduct.setPrice(createProductDTO.getPrice());
            updatedProduct.setImageUrl(createProductDTO.getImageUrl());
            updatedProduct.setCategory(createProductDTO.getCategory());
            return productRepository.save(updatedProduct);
        }catch (RuntimeException e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }
    @Override
    public Product deleteProduct(UUID id) {
        try{

            Optional<Product> product = productRepository.findById(id);
            if(product.isEmpty()){
                throw new RuntimeException("Product does not exist");
            }
            productRepository.deleteById(id);
            return product.get();
        }catch (    RuntimeException e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public Product getProduct(UUID id) {
        try{
            Optional<Product> product = productRepository.findById(id);
            if(product.isEmpty()){
                throw new RuntimeException("Product does not exist");
            }
            return product.get();
        }catch (RuntimeException e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public List<Product> getProducts() {
        try{
            return productRepository.findAll();
        }catch (RuntimeException e){
            throw new RuntimeException("Error: "+e.getMessage());
        }

    }
}
