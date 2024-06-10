package rw.ac.rca.spring_boot_template.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartItemDTO;
import rw.ac.rca.spring_boot_template.models.CartItem;
import rw.ac.rca.spring_boot_template.services.CartItemService;
import rw.ac.rca.spring_boot_template.services.serviceImpl.CartItemServiceImpl;
import rw.ac.rca.spring_boot_template.utils.ApiResponse;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart-items")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemServiceImpl cartItemService;

    @PostMapping("/create")
    public ResponseEntity saveCartItem(CreateCartItemDTO createCartItemDTO) {
        CartItem cartItem = cartItemService.saveCartItem(createCartItemDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully created the cart item",
                cartItem
        ));
    }

@PutMapping("/update/{id}")
    public ResponseEntity updateCartItem(@PathVariable UUID id,CreateCartItemDTO createCartItemDTO) {

        CartItem cartItem = cartItemService.updateCartItem(id,createCartItemDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully updated the cart item",
                cartItem
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCartItem(@PathVariable UUID id) {
        CartItem cartItem = cartItemService.deleteCartItem(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully deleted the cart item",
                cartItem
        ));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCartItem(@PathVariable  UUID id) {
        CartItem cartItem = cartItemService.getCartItem(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully fetched the cart item",
                cartItem
        ));
    }

    @GetMapping("/all")
    public ResponseEntity getCartItems() {
        List<CartItem> cartItems = cartItemService.getCartItems();
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully fetched the cart items",
                cartItems
        ));
    }


}
