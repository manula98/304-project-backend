package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    
}
