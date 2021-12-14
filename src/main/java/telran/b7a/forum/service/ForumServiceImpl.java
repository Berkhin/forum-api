package telran.b7a.forum.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import telran.b7a.forum.dao.ForumMongoRepository;
import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;

public class ForumServiceImpl implements ForumService {
	
	ForumMongoRepository forumRepository;
	
	ModelMapper modelMapper;
	
	

	public ForumServiceImpl(ForumMongoRepository forumRepository, ModelMapper modelMapper) {
		this.forumRepository = forumRepository;
		this.modelMapper = modelMapper;
	}



	@Override
	public PostDto addNewPost(NewPostDto newPost, String author) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PostDto FindPostById(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addlike(String id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Iterable<PostDto> FindPostByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PostDto AddComment(String id, NewCommentDto comment, String author) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PostDto DeletePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PostDto FindPostByTags(String tags) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<PostDto> FindPostByPeriod(LocalDateTime dateFrom, LocalDateTime to) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PostDto UpdatePost(NewPostDto postUpdateDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
