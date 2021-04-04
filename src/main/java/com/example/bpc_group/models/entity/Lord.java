package com.example.bpc_group.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@NoArgsConstructor
@Data
@Entity
public class Lord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "lord", fetch = FetchType.LAZY)
    private List<Planet> planets;

    @Override
    public String toString() {
        return new StringJoiner(", ", Lord.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}
