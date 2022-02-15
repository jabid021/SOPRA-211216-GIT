package formationJpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class PosteException extends RuntimeException {
	public PosteException() {

	}

	public PosteException(String message) {
		super(message);
	}

}
