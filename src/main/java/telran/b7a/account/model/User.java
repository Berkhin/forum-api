package telran.b7a.account.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import telran.b7a.account.dto.RolesDto;
import telran.b7a.forum.model.Comments;
//@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class User {
	@Id
	@Setter 
	String login;
	@Setter 
	String password;
	@Setter 
	String firstName;
	@Setter 
	String lastName;
	@Setter 
	Set<String> roles;
	

	public User() {
		roles = new HashSet<String>();
		roles.add("USER");
	
	}

	public User(String login, String password, String firstName, String lastName) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		roles = new HashSet<String>();
		roles.add("USER");
		}

	public void addRole(String role) {
		roles.add(role);
		
	}

	
	


}
