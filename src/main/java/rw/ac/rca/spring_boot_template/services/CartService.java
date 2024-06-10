package rw.ac.rca.spring_boot_template.services;

import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartDTO;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.models.Cart;
import rw.ac.rca.spring_boot_template.models.User;

import java.util.List;
import java.util.UUID;

public interface CartService {
    public Cart createCart(CreateCartDTO createCartDTO);
    public Cart getCart(UUID cartId);
    public List<Cart> getAllCarts();
    public Cart updateCart(UUID cartId, CreateProductDTO createProductDTO);
    public Cart deleteCart(UUID cartId);
    public User getCartByUserId(UUID userId);
    //addItems to cart
    public Cart addItemToCart(UUID cartItem, UUID cartId);
    public Cart removeItemFromCart(UUID cartItem, UUID cartId);

}
