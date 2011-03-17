#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Will be thrown if entity is not found. The web container will handle this as
 * a HTTP 404 error.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception {

	/** autogenerated serial. */
	private static final long serialVersionUID = 1L;

}
