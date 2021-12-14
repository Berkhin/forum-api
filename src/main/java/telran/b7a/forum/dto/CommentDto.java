package telran.b7a.forum.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CommentDto {
	String user;
	@Setter
	String message;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	Integer likes;

	public CommentDto(String user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	public void addLike() {
		likes++;
	}

}
