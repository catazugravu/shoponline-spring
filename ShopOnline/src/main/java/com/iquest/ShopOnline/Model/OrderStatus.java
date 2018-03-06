package com.iquest.ShopOnline.Model;

import javax.persistence.*;

@Entity
@Table(name = "Order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "status_name", nullable = false)
    private String Name;

    @Column(name = "status_description", nullable = false)
    private String Description;

    public OrderStatus(String name, String description) {
        Name = name;
        Description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
