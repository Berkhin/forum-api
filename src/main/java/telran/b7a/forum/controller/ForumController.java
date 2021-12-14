package telran.b7a.forum.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public ContentDto AddPost(String author) {
		return null;
	}

	public ContentDto FindPostById(String id) {
		return null;
	}

	public void Addlike() {
	}

	public ContentDto FindPostByAuthor(String author) {
		return null;
	}

	public ContentDto AddComment(String id, CommentDto comment, String author) {
		return null;
	}

	public ContentDto DeletePost(String id) {
		return null;
	}

	public List<ContentDto> FindPostByPeriod(LocalDateTime dateFrom, LocalDateTime to) {
		return null;
	}

	public ContentDto UpdatePost(String id) {
		return null;
	}
}
