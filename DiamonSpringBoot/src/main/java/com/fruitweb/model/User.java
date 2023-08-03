package com.fruitweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String password;
	
	@ManyToMany()
	@JoinTable(name = "user_role",
		joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

}
