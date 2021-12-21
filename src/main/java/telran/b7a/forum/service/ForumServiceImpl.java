package telran.b7a.forum.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import telran.b7a.forum.dao.ForumMongoRepository;
import telran.b7a.forum.dto.CommentDto;
import telran.b7a.forum.dto.FindPostByPeriodDto;
import telran.b7a.forum.dto.NewCommentDto;
import telran.b7a.forum.dto.NewPostDto;
import telran.b7a.forum.dto.PostDto;
import telran.b7a.forum.exception.PostNotFoundException;
import telran.b7a.forum.model.Comments;
import telran.b7a.forum.model.Post;
import telran.b7a.forum.service.logging.PostLogger;

@Slf4j /* static final Logger log = LoggerFactory.getLogger(ForumServiceImpl.class); */
@Component
public class ForumServiceImpl implements ForumService {
//	static final Logger log = LoggerFactory.getLogger(ForumServiceImpl.class);
	ForumMongoRepository forumRepository;

	ModelMapper modelMapper;

	@Autowired
	public ForumServiceImpl(ForumMongoRepository forumRepository, ModelMapper modelMapper) {
		this.forumRepository = forumRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PostDto addNewPost(NewPostDto newPost, String author) {
		Post post = modelMapper.map(newPost, Post.class);
		post.setAuthor(author);
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	@PostLogger
	public void addlike(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		post.addLike();
		forumRepository.save(post);

	}

	@Override
	public List<PostDto> findPostByAuthor(String author) {
//		long t1 = System.currentTimeMillis();
		List<PostDto> res = forumRepository.findByAuthorIgnoreCase(author).map(s -> modelMapper.map(s, PostDto.class))
				.collect(Collectors.toList());
//		long t2 = System.currentTimeMillis();
//		log.info("method - FindPostByAuthor(String author), duration = {}", (t2 - t1));
		return res;
	}

	@Override
	public PostDto addComment(String id, NewCommentDto comment, String author) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		Comments newComment = new Comments(comment.getMessage(), author);
		System.out.println(newComment);
		post.addComment(newComment);
		System.out.println(newComment);
		forumRepository.save(post);
		System.out.println(newComment);
		return modelMapper.map(post, PostDto.class);

	}

	@Override
	public PostDto deletePost(String id) {
		PostDto post = findPostById(id);
		forumRepository.deleteById(id);
		return post;
	}

	@Override
	public List<PostDto> findPostByTags(Set<String> tags) {
		return forumRepository.findByTagsInIgnoreCase(tags).map(s -> modelMapper.map(s, PostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<PostDto> findPostByPeriod(FindPostByPeriodDto madePeriod) {
		return forumRepository.findByDateCreatedBetween(madePeriod.getDateFrom(), madePeriod.getDateTo())
				.map(s -> modelMapper.map(s, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	@PostLogger
	public PostDto updatePost(NewPostDto postUpdateDto, String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));

		String content = postUpdateDto.getContent();
		if (content != null) {
			post.setContent(content);
		}

		String title = postUpdateDto.getTitle();
		if (title != null) {
			post.setTitle(title);
		}

		Set<String> tags = postUpdateDto.getTags();
		if (tags != null) {
			post.setTags(postUpdateDto.getTags());
		}

		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

}
