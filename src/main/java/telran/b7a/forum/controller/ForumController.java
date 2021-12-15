package telran.b7a.forum.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.forum.dto.FindPostByPeriodDto;
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

	@PostMapping("/post/{author}")
	public PostDto addNewPost(@RequestBody NewPostDto newPost,@PathVariable String author) {
		return service.addNewPost(newPost, author);
	}

	@GetMapping("/post/{id}")
	public PostDto findPostById(@PathVariable("id") String id) {
		return service.FindPostById(id);
	}

	@PutMapping("/post/{id}/like")
	public void addlike(@PathVariable("id") String id) {
		service.addlike(id);
	}

	@GetMapping("/posts/author/{author}")
	public Iterable<PostDto> findPostByAuthor(@PathVariable("author") String author) {
		return service.FindPostByAuthor(author);
	}

	@PutMapping("/post/{id}/comment/{author}")
	public PostDto addComment(@PathVariable String id,@RequestBody NewCommentDto comment,@PathVariable String author) {
		return service.AddComment(id, comment, author);
	}

	@DeleteMapping("/post/{id}")
	public PostDto deletePost(@PathVariable String id) {
		return service.DeletePost(id);
	}
	
	@PostMapping("/posts/tags")
	public List<PostDto> findPostByTags (@RequestBody Set<String> tags) {
		return service.FindPostByTags(tags);
		
	}
	
	@PostMapping("/posts/period")
	public List<PostDto> findPostByPeriod(@RequestBody FindPostByPeriodDto findPostsInPeriod) {
		return service.FindPostByPeriod(findPostsInPeriod);
	}

	@PutMapping("/post/{id}")
	public PostDto updatePost(@RequestBody NewPostDto postUpdateDto ,@PathVariable("id") String id) {
		return service.UpdatePost(postUpdateDto, id);
	}
}
