package telran.b7a.forum.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.FindPostByPeriodDto;
import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;

public interface ForumService {

PostDto addNewPost (NewPostDto newPost, String author);
 PostDto findPostById (String id);
 void addlike (String id);
 Iterable<PostDto> findPostByAuthor (String author);
 PostDto addComment (String id, NewCommentDto comment, String author);
 PostDto deletePost (String id);
 List<PostDto> findPostByTags (Set<String> tags);
 List<PostDto> findPostByPeriod (FindPostByPeriodDto madePeriod);
 PostDto updatePost (NewPostDto postUpdateDto ,String id);
	
}
