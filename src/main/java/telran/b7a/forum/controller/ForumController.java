package telran.b7a.forum.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;
import telran.b7a.forum.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
@Autowired
	ForumService service;

	@Autowired
	public ForumController(ForumService forumService) {
		super();
		this.service = forumService;
	}

	@PostMapping ("/post/{author}")
	public PostDto addNewPost(@RequestBody NewPostDto newPost,@PathVariable String author) {
		return service.addNewPost(newPost, author);
	}

	@GetMapping("/post/{id}")
	public PostDto findPostById(@PathVariable("id") String id) {
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
	public PostDto addComment(String id, NewCommentDto comment, String author) {
		return service.AddComment(id, comment, author);
	}

	@DeleteMapping("/forum/post/{id}")
	public PostDto deletePost(@PathVariable String id) {
		return service.DeletePost(id);
	}
	
	@PostMapping ("/forum/post/{tags}")
	public PostDto findPostByTags (@RequestBody String tags) {
		return service.FindPostByTags(tags);
		
	}
	
	@PostMapping("/forum/post/?0/?1")
	public List<PostDto> findPostByPeriod(@RequestBody LocalDateTime dateFrom,@RequestBody LocalDateTime to) {
		return service.FindPostByPeriod(dateFrom, to);
	}

	@PutMapping("/forum/post/{id}")
	public PostDto updatePost(NewPostDto postUpdateDto ,String id) {
		return service.UpdatePost(postUpdateDto, id);
	}
}
