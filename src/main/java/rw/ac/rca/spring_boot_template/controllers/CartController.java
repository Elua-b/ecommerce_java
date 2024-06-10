package rw.ac.rca.spring_boot_template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateCartDTO;
import rw.ac.rca.spring_boot_template.dtos.requests.CreateProductDTO;
import rw.ac.rca.spring_boot_template.models.Cart;
import rw.ac.rca.spring_boot_template.models.User;
import rw.ac.rca.spring_boot_template.services.serviceImpl.CartServiceImpl;
import rw.ac.rca.spring_boot_template.utils.ApiResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartService;

    @GetMapping("/all")
    public ResponseEntity getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();

        return ResponseEntity.ok().body(
                new ApiResponse(
                        true,
                        "Successfully fetched the carts",
                        carts
                )
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCart(@PathVariable UUID id) {
        Cart cart = cartService.getCart(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully fetched the cart",
                cart
        ));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getCartByUserId(@PathVariable UUID userId) {
        User cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully fetched the cart",
                cart
        ));
    }

    @PostMapping("/create")
    public ResponseEntity createCart(CreateCartDTO createCartDTO) {
        Cart cart = cartService.createCart(createCartDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully created the cart",
                cart
        ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCart(@PathVariable UUID id, CreateProductDTO createProductDTO) {
        Cart cart = cartService.updateCart(id, createProductDTO);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully updated the cart",
                cart
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCart(@PathVariable UUID id) {
        Cart cart = cartService.deleteCart(id);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully deleted the cart",
                cart
        ));
    }

    @PostMapping("/add-item/{cartItem}/{cartId}")
    public ResponseEntity addItemToCart(@PathVariable UUID cartItem, @PathVariable UUID cartId) {
        Cart cart = cartService.addItemToCart(cartItem, cartId);
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully added the item to the cart",
                cart
        ));
    }

}
