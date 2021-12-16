package telran.b7a.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyAccountNotFoundExcrption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7486477590118074203L;

	public MyAccountNotFoundExcrption (String id) {
		super("Post with id " + id + " not found");
	}
	
}
