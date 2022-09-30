package com.mutant.common.exception;

import com.mutant.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalHandler {

	/**
	 * notSquare method to receive the exception type
	 * @param ex object that contain the exception type
	 * @return The response object with information details
	 */
	@ExceptionHandler(NotSquare.class)
	public ResponseDto notSquare(NotSquare ex) {
		ResponseDto response = new ResponseDto(HttpStatus.FORBIDDEN.toString(),HttpStatus.FORBIDDEN.getReasonPhrase(),ex.getMessage(),null);
		return response;
	}

	/**
	 * invalidCharacters method to receive the exception type
	 * @param ex object that contain the exception type
	 * @return The response object with information details
	 */
	@ExceptionHandler(InvalidCharacters.class)
	public ResponseDto invalidCharacters(InvalidCharacters ex) {
		ResponseDto response = new ResponseDto(HttpStatus.FORBIDDEN.toString(),HttpStatus.FORBIDDEN.getReasonPhrase(),ex.getMessage(),null);
		return response;
	}

	/**
	 * notValidMatrix method to receive the exception type
	 * @param ex object that contain the exception type
	 * @return The response object with information details
	 */
	@ExceptionHandler(NotValidMatrix.class)
	public ResponseDto notValidMatrix(NotValidMatrix ex) {
		ResponseDto response = new ResponseDto(HttpStatus.FORBIDDEN.toString(),HttpStatus.FORBIDDEN.getReasonPhrase(),ex.getMessage(),null);
		return response;
	}
}