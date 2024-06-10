package rw.ac.rca.spring_boot_template.services;

import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartItemDTO;
import rw.ac.rca.spring_boot_template.models.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    public CartItem saveCartItem(CreateCartItemDTO createCartItemDTO);
    public  CartItem updateCartItem(UUID cartItemId,CreateCartItemDTO createCartItemDTO);

    public CartItem deleteCartItem(UUID id);
    public CartItem getCartItem(UUID id);
    public List<CartItem> getCartItems();

}
