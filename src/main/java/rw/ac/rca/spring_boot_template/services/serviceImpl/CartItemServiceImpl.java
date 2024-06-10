package rw.ac.rca.spring_boot_template.services.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartItemDTO;
import rw.ac.rca.spring_boot_template.models.CartItem;
import rw.ac.rca.spring_boot_template.models.Order;
import rw.ac.rca.spring_boot_template.models.Product;
import rw.ac.rca.spring_boot_template.repositories.ICartItemRepository;
import rw.ac.rca.spring_boot_template.repositories.IOrderRepository;
import rw.ac.rca.spring_boot_template.repositories.IProductRepository;
import rw.ac.rca.spring_boot_template.services.CartItemService;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
@NoArgsConstructor

public class CartItemServiceImpl  implements CartItemService {
    private ICartItemRepository cartItemRepository;
    private IProductRepository productRepository;
    private IOrderRepository orderRepository;
    @Override
    public CartItem saveCartItem(CreateCartItemDTO createCartItemDTO) {
        try {
            if(createCartItemDTO.getOrderId() == null) {
                throw new Exception("Order Id is required");
            }
            if(createCartItemDTO.getProductId() == null) {
                throw new Exception("Product Id is required");
            }
            //if cartItem exists
            if(cartItemRepository.existsByOrderIdAndProductId(createCartItemDTO.getOrderId(), createCartItemDTO.getProductId())) {
                throw new Exception("CartItem already exists");
            }
            Product product = productRepository.findById(createCartItemDTO.getProductId()).orElseThrow(() -> new Exception("Product not found"));
            Order order = orderRepository.findById(createCartItemDTO.getOrderId()).orElseThrow(() -> new Exception("Order not found"));


            CartItem cartItem = new CartItem();
            cartItem.setOrder(order);
            cartItem.setProduct(product);
            cartItem.setPrice(createCartItemDTO.getPrice());
            cartItem.setQuantity(createCartItemDTO.getQuantity());
            return cartItemRepository.save(cartItem);



        }catch (Exception e) {
               throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public CartItem updateCartItem(UUID cartItemId,CreateCartItemDTO createCartItemDTO) {
        try{
            if(cartItemRepository.existsById(cartItemId)){
                CartItem cartItem = cartItemRepository.findById(cartItemId).get();
                cartItem.setPrice(createCartItemDTO.getPrice());
                cartItem.setQuantity(createCartItemDTO.getQuantity());
                return cartItemRepository.save(cartItem);
            }else{
                throw new RuntimeException("CartItem does not exist");
            }

        }catch (Exception e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public CartItem deleteCartItem(UUID id) {
        try{
            if(cartItemRepository.existsById(id)){
                CartItem cartItem = cartItemRepository.findById(id).get();
                cartItemRepository.delete(cartItem);
                return cartItem;
            }else{
                throw new RuntimeException("CartItem does not exist");
            }

        }catch (Exception e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public CartItem getCartItem(UUID id) {
        try{
            if(cartItemRepository.existsById(id)){
                return cartItemRepository.findById(id).get();
            }else{
                throw new RuntimeException("CartItem does not exist");
            }

        }catch (Exception e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public List<CartItem> getCartItems() {
        try{
            return  cartItemRepository.findAll();
        }catch (Exception e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }
}
