package telran.b7a.forum.dto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

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
public class ContentDto {
	String id;
	@Setter
	String title;
	@Setter
	String content;
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated;
	Set<String> tags;
	Integer likes;
}
