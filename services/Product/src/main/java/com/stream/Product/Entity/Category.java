package com.stream.Product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String desc;
    @OneToMany(mappedBy = "category" , cascade = CascadeType.REMOVE)
    private List<Product> products;
}
