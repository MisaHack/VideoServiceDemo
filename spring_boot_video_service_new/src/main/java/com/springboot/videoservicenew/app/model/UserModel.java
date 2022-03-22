package com.springboot.videoservicenew.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "userName")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleModel> roles = new ArrayList<>();

}
