package telran.b7a.forum.service;

import java.time.LocalDateTime;
import java.util.List;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.PostDto;

public interface ForumService {

 PostDto AddPost (String author);
 PostDto FindPostById (String id);
 void Addlike ();
 PostDto FindPostByAuthor (String author);
 PostDto AddComment (String id, CommentDto comment, String author);
 PostDto DeletePost (String id);
 PostDto FindPostByTags (String tags);
 List<PostDto> FindPostByPeriod (LocalDateTime dateFrom, LocalDateTime to);
 PostDto UpdatePost (String id);
	
}
