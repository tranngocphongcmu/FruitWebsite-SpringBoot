package com.fruitweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long id;
	
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String image;
    
    @ManyToMany()
	@JoinTable(name = "admin_role",
	joinColumns = @JoinColumn(name = "admin_id",referencedColumnName = "admin_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    private List<Role> roles;

}
