package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orders_id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @NotNull
    @Column(name = "total_quantity")
    private long total_quantity;
    @NotNull
    @Column(name = "total_price")
    private long total_price;
    @ManyToMany(mappedBy = "orders")
    private Set<Books> books = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payments payment;


    public Orders(){

    }

    public Orders(User user, @NotNull long total_quantity, @NotNull long total_price, Set<Books> books, Payments payment) {
        this.user = user;
        this.total_quantity = total_quantity;
        this.total_price = total_price;
        this.books = books;
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(long total_quantity) {
        this.total_quantity = total_quantity;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }
}
