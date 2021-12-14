package telran.b7a.forum.service;

import java.time.LocalDateTime;
import java.util.List;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;

public interface ForumService {

 PostDto addNewPost (NewPostDto newPost, String author);
 PostDto FindPostById (String id);
 void addlike (String id);
 Iterable<PostDto> FindPostByAuthor (String author);
 PostDto AddComment (String id, NewCommentDto comment, String author);
 PostDto DeletePost (String id);
 PostDto FindPostByTags (String tags);
 List<PostDto> FindPostByPeriod (LocalDateTime dateFrom, LocalDateTime to);
 PostDto UpdatePost (NewPostDto postUpdateDto ,String id);
	
}
