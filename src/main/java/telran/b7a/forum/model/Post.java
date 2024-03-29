package telran.b7a.forum.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import telran.b7a.forum.dto.CommentDto;


@NoArgsConstructor
@Getter
@ToString
public class Post {
	String id;
	@Setter 
	String title;
	@Setter 
	String content;
	@Setter
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime dateCreated = LocalDateTime.now();
	@Setter
	Set<String> tags = new HashSet<String>();
	int likes;
	Set<Comments> comments = new HashSet<Comments>();
	
	public Post(String title, String content, String author, Set<String> tags) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = new HashSet<>();
		this.comments = new HashSet<>();
	}
	
	public Post(String title, String content, String author) {
		this(title, content, author, new HashSet<>());
	}
	
	public void addLike() {
		likes++;
	}
	
	public boolean addComment(Comments comment) {
		return comments.add(comment);
	}
	
	public boolean addTag(String tag) {
		return tags.add(tag);
	}
	
	public boolean removeTag(String tag) {
		return tags.remove(tag);
	}

}
