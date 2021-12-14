package telran.b7a.forum.service;

import java.time.LocalDateTime;
import java.util.List;

import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.ContentDto;

public class ForumServiceImpl implements ForumService {

	@Override
	public ContentDto AddPost(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto FindPostById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Addlike() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContentDto FindPostByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto AddComment(String id, CommentDto comment, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto DeletePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto FindPostByTags(String tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentDto> FindPostByPeriod(LocalDateTime dateFrom, LocalDateTime to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto UpdatePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
