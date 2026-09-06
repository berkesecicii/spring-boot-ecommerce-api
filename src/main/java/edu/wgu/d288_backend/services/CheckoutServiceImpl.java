package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.CartRepository;
import edu.wgu.d288_backend.entities.Cart;
import edu.wgu.d288_backend.entities.CartItem;
import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();

        cart.setId(null);

        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        Set<CartItem> cartItems = purchase.getCartItems();
        if (cartItems != null) {
            cartItems.forEach(item -> {
                item.setCart(cart);
            });
            cart.setCartItems(cartItems);
        }

        Customer customer = purchase.getCustomer();
        if (customer != null) {
            cart.setCustomer(customer);
        }

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
}