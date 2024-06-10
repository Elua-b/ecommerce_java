package rw.ac.rca.spring_boot_template.services;

import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.models.Product;

import java.util.UUID;

public interface ProductService {

    public Product saveProduct(CreateProductDTO createProductDTO);
    public Product updateProduct(UUID productId,CreateProductDTO createProductDTO);
    public Product deleteProduct(UUID id);
    public Product getProduct(UUID id);
    public Iterable<Product> getProducts();

}
