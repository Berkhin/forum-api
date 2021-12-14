package telran.b7a.forum.service;

import java.time.LocalDateTime;
import java.util.List;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.ContentDto;

public interface ForumService {

 ContentDto AddPost (String author);
 ContentDto FindPostById (String id);
 void Addlike ();
 ContentDto FindPostByAuthor (String author);
 ContentDto AddComment (String id, CommentDto comment, String author);
 ContentDto DeletePost (String id);
 List<ContentDto> FindPostByPeriod (LocalDateTime dateFrom, LocalDateTime to);
 ContentDto UpdatePost (String id);
	
}
