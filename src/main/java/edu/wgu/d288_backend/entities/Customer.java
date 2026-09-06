package edu.wgu.d288_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @NotBlank(message = "First name is required")
    @Column(name = "customer_first_name")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Column(name = "customer_last_name")
    private String lastName;
    @NotBlank(message = "Address is required")
    @Column(name = "address", nullable = false)
    private String address;
    @NotBlank(message = "Postal code is required")
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @NotBlank(message = "Phone is required")
    @Column(name = "phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;
}