package booking_site.xws_proj.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import booking_site.xws_proj.controller.exceptions.AllreadyCommentedThisAccommodationException;
import booking_site.xws_proj.controller.exceptions.AlreadyExistsException;
import booking_site.xws_proj.controller.exceptions.CancelReservationException;
import booking_site.xws_proj.controller.exceptions.DateQueryException;
import booking_site.xws_proj.controller.exceptions.LoginFailedException;
import booking_site.xws_proj.controller.exceptions.NeverReservedException;
import booking_site.xws_proj.controller.exceptions.NotAuthorizedException;
import booking_site.xws_proj.controller.exceptions.NotFoundException;
import booking_site.xws_proj.controller.exceptions.NotLoggedException;
import booking_site.xws_proj.controller.exceptions.ReservationNotAvailableException;
import booking_site.xws_proj.controller.exceptions.ServerErrorException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NotLoggedException.class })
	protected ResponseEntity<Object> handleNotLoggedConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(value = { NotAuthorizedException.class })
	protected ResponseEntity<Object> handleNotAuthorizedConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(value = { NotFoundException.class })
	protected ResponseEntity<Object> handleNotFoundConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { AlreadyExistsException.class })
	protected ResponseEntity<Object> handleAlreadyExistConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { LoginFailedException.class })
	protected ResponseEntity<Object> handleUserBlockedOrDeletedConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(value = { AllreadyCommentedThisAccommodationException.class })
	protected ResponseEntity<Object> handleAlreadyCommentedConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { NeverReservedException.class })
	protected ResponseEntity<Object> handleNeverReservedConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { ReservationNotAvailableException.class })
	protected ResponseEntity<Object> handleReservationNotAvailableConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { CancelReservationException.class })
	protected ResponseEntity<Object> handleCancelReservationConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { DateQueryException.class })
	protected ResponseEntity<Object> handleDateQueryConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value = { ServerErrorException.class })
	protected ResponseEntity<Object> handleServerErrorConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}