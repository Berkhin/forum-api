package telran.b7a.forum.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;
import telran.b7a.forum.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {

	ForumService service;

	@Autowired
	public ForumController(ForumService forumService) {
		super();
		this.service = forumService;
	}

	@PostMapping ("/forum/post/{author}")
	public PostDto addNewPost(NewPostDto newPost, String author) {
		return service.addNewPost(null, author);
	}

	@GetMapping("/forum/post/{id}")
	public PostDto findPostById(String id) {
		return service.FindPostById(id);
	}

	@PutMapping("/forum/post/{id}/like")
	public void addlike(String id) {
	}

	@GetMapping("/forum/posts/author/{author}")
	public Iterable<PostDto> findPostByAuthor(String author) {
		return service.FindPostByAuthor(author);
	}

	@PutMapping("/forum/post/{id}/comment/{author}")
	public PostDto addComment(String id, CommentDto comment, String author) {
		return service.AddComment(id, null, author);
	}

	@DeleteMapping("/forum/post/{id}")
	public PostDto deletePost(String id) {
		return service.DeletePost(id);
	}
	
	@PostMapping ("/forum/post/{tags}")
	public PostDto findPostByTags (String tags) {
		return service.FindPostByTags(tags);
		
	}
	
	@PostMapping("/forum/post/?0/?1")
	public List<PostDto> findPostByPeriod(LocalDateTime dateFrom, LocalDateTime to) {
		return service.FindPostByPeriod(dateFrom, to);
	}

	@PutMapping("/forum/post/{id}")
	public PostDto updatePost(NewPostDto postUpdateDto ,String id) {
		return service.UpdatePost(null, id);
	}
}
