package formation.sopra.springBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class EmployeException extends RuntimeException {
	public EmployeException() {

	}

	public EmployeException(String message) {
		super(message);
	}

}
