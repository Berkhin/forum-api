package telran.b7a.forum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = { "user", "dateCreated" })
@ToString
public class Comments {
	String user;
	@Setter
	String message;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	int likes;

	public Comments(String user, String message) {
		dateCreated = LocalDateTime.now();
		this.user = user;
		this.message = message;
		
	}
	
	public void addLike() {
		likes++;
	}
}
