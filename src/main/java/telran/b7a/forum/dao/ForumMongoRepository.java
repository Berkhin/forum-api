package telran.b7a.forum.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.b7a.forum.dto.PostDto;
import telran.b7a.forum.model.Post;

public interface ForumMongoRepository extends MongoRepository<Post, String> {

	Stream<Post> findByAuthorIgnoreCase(String author);
	
	Stream<PostDto> findByTagsIgnoreCase(String tags);
	
	Stream<PostDto> findByDateCreatedBetween(LocalDate dateFrom, LocalDate to);
	
	Stream<PostDto> findByTagsInIgnoreCase(Set<String> tags);
}