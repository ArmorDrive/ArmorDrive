package com.ua.armordrive.armor_drive.domain;

import com.ua.armordrive.armor_drive.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "\"User\"")
public class User implements UserDetails {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String firstName;

    @Column(nullable = false, unique = true)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column
    private Boolean ban;

    @Column
    private Role role;

    @Column
    private Boolean confirmed;
    @OneToMany(targetEntity = SaleListing.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<SaleListing> saleListings = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_favorite_salelistings",
            joinColumns =
            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "salelisting_id", referencedColumnName = "id"))
    private List<SaleListing> favoriteSaleListings;

    public void addSaleListing(SaleListing saleListing) {
        saleListings.add(saleListing);
        saleListing.setUser(this);
    }

    public void removeSaleListing(SaleListing saleListing) {
        saleListings.remove(saleListing);
        saleListing.setUser(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //todo getAuthorities()
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !ban;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return confirmed;
    }
}
