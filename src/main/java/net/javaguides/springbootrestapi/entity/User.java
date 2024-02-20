package net.javaguides.springbootrestapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false,unique=true)
	private String email;
	

}
