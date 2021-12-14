package telran.b7a.forum.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.ContentDto;
import telran.b7a.forum.service.ForumService;

@RestController
public class ForumController {

	ForumService forumService;

	@Autowired
	public ForumController(ForumService forumService) {
		super();
		this.forumService = forumService;
	}

	@PostMapping ("/forum/post/{author}")
	public ContentDto AddPost(String author) {
		return forumService.AddPost(author);
	}

	@GetMapping("/forum/post/{id}")
	public ContentDto FindPostById(String id) {
		return forumService.FindPostById(id);
	}

	@PutMapping("/forum/post/{id}/like")
	public void Addlike(String id) {
	}

	@GetMapping("/forum/posts/author/{author}")
	public ContentDto FindPostByAuthor(String author) {
		return forumService.FindPostByAuthor(author);
	}

	@PutMapping("/forum/post/{id}/comment/{author}")
	public ContentDto AddComment(String id, CommentDto comment, String author) {
		return forumService.AddComment(id, comment, author);
	}

	@DeleteMapping("/forum/post/{id}")
	public ContentDto DeletePost(String id) {
		return forumService.DeletePost(id);
	}
	
	@PostMapping ("/forum/post/{tags}")
	public ContentDto FindPostByTags (String tags) {
		return forumService.FindPostByTags(tags);
		
	}
	
	@PostMapping("/forum/post/?0/?1")
	public List<ContentDto> FindPostByPeriod(LocalDateTime dateFrom, LocalDateTime to) {
		return forumService.FindPostByPeriod(dateFrom, to);
	}

	@PutMapping("/forum/post/{id}")
	public ContentDto UpdatePost(String id) {
		return forumService.UpdatePost(id);
	}
}
