package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.entities.Cart;
import edu.wgu.d288_backend.entities.CartItem;
import edu.wgu.d288_backend.entities.Customer;
import lombok.Data;
import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}