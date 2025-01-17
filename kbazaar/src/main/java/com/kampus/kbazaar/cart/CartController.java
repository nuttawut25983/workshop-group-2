package com.kampus.kbazaar.cart;

import com.kampus.kbazaar.promotion.ApplyCodeRequest;
import com.kampus.kbazaar.promotion.ApplyCodeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public ResponseEntity getCart() { // NOSONAR
        return ResponseEntity.ok().build();
    }

    @PostMapping("/carts/{username}/promotions")
    public ResponseEntity<ApplyCodeResponse> applyCode(
            @PathVariable("username") String username, @RequestBody ApplyCodeRequest request) {
        return new ResponseEntity<>(cartService.applyCode(username, request), HttpStatus.OK);
    }
}
