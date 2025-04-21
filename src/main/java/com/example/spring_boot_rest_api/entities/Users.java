//package com.example.spring_boot_rest_api.entities;
//
//import com.example.spring_boot_rest_api.enums.Role;
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Data
//@Entity
//@Table(name = "users")
//public class Users implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//    private String password;
//    private String code;
//
////    @Column(nullable = false)
////    private Role role;
////    private String authority;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<RoleEntity> roles = new HashSet<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<AuthToken> tokens = new ArrayList<>();
//
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public User() {
//    }
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        Set<GrantedAuthority> authorities = role.getAuthorities().stream()
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toSet());
////
////        authorities.add(new SimpleGrantedAuthority(role.name()));
////        return authorities;
////    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
