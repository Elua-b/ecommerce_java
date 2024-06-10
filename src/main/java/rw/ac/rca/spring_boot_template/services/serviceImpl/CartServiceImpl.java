package rw.ac.rca.spring_boot_template.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartDTO;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.enumerations.EOrderStatus;
import rw.ac.rca.spring_boot_template.models.Cart;
import rw.ac.rca.spring_boot_template.models.CartItem;
import rw.ac.rca.spring_boot_template.models.User;
import rw.ac.rca.spring_boot_template.repositories.ICartItemRepository;
import rw.ac.rca.spring_boot_template.repositories.ICartRepository;
import rw.ac.rca.spring_boot_template.repositories.IUserRepository;
import rw.ac.rca.spring_boot_template.services.CartService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final IUserRepository userRepository;
    private final ICartItemRepository cartItemRepository;
    private final ICartRepository cartRepository;

    @Override
    public Cart createCart(CreateCartDTO createCartDTO) {

        try {
            User user = this.userRepository.findById(createCartDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

            Cart cart = new Cart();
            cart.setDateCreated(LocalDate.now());
            cart.setTotalAmount(0.0);
            cart.setStatus(EOrderStatus.PENDING);
            cart.setUser(user);
            return cartRepository.save(cart);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Cart getCart(UUID cartId) {
        try {
            return cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @Override
    public List<Cart> getAllCarts() {
        try{
            List <Cart> carts = cartRepository.findAll();
            return carts;
        } catch (Exception e) {
            throw new RuntimeException("Error work: " + e.getMessage());
        }

    }

    @Override
    public Cart updateCart(UUID cartId, CreateProductDTO createProductDTO) {
        try{
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));

            cart.setTotalAmount(createProductDTO.getPrice());

            return cartRepository.save(cart);
        }catch (Exception e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public Cart deleteCart(UUID cartId) {
        try{
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));

            cartRepository.deleteById(cartId);
            return cart;
        }catch (Exception e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public User getCartByUserId(UUID userId) {
        try {
            return cartRepository.findByUserId(userId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Cart addItemToCart(UUID cartItemId, UUID cartId) {
        try {
            // Fetch the cart and cart item by their IDs
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
            CartItem cartItem = cartItemRepository.findById(cartItemId)
                    .orElseThrow(() -> new RuntimeException("Cart item not found"));

            cart.getItems().add(cartItem);

            // Update the total amount
            double totalAmount = cart.getItems().stream()
                    .mapToDouble(CartItem::getPrice)
                    .sum();
            cart.setTotalAmount(totalAmount);

            // Save the cart and cart item (if needed)
            cartRepository.save(cart);
            cartItemRepository.save(cartItem);

            return cart;
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    //remove item from cart
    public Cart removeItemFromCart(UUID cartItemId, UUID cartId) {
        try {
            // Fetch the cart and cart item by their IDs
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
            CartItem cartItem = cartItemRepository.findById(cartItemId)
                    .orElseThrow(() -> new RuntimeException("Cart item not found"));

            cart.getItems().remove(cartItem);

            // Update the total amount
            double totalAmount = cart.getItems().stream()
                    .mapToDouble(CartItem::getPrice)
                    .sum();
            cart.setTotalAmount(totalAmount);

            // Save the cart and cart item (if needed)
            cartRepository.save(cart);
            cartItemRepository.save(cartItem);

            return cart;
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

//updateCartItemInCart
    public Cart updateCartItemInCart(UUID cartItemId, UUID cartId, CreateProductDTO createProductDTO) {
        try {
            // Fetch the cart and cart item by their IDs
            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
            CartItem cartItem = cartItemRepository.findById(cartItemId)
                    .orElseThrow(() -> new RuntimeException("Cart item not found"));

            cart.getItems().remove(cartItem);
            cartItem.setPrice(createProductDTO.getPrice());
            cart.getItems().add(cartItem);

            // Update the total amount
            double totalAmount = cart.getItems().stream()
                    .mapToDouble(CartItem::getPrice)
                    .sum();
            cart.setTotalAmount(totalAmount);

            // Save the cart and cart item (if needed)
            cartRepository.save(cart);
            cartItemRepository.save(cartItem);

            return cart;
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}
