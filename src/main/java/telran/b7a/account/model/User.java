package telran.b7a.account.model;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import telran.b7a.forum.model.Comments;

@NoArgsConstructor
@Getter
@ToString
public class User {
	@Setter 
	String login;
	@Setter 
	String password;
	@Setter 
	String firstName;
	@Setter 
	String lastName;
	
	public User(String login, String password, String firstName, String lastName) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
