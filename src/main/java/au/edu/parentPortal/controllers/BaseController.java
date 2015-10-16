package au.edu.parentPortal.controllers;

import au.edu.parentPortal.beans.errors.ErrorList;
import au.edu.parentPortal.exceptions.NotFoundException;
import au.edu.parentPortal.exceptions.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by blim on 9/12/2014.
 *
 * I had to use parent class instead of a separate @ControllerAdvice because
 * @ControllerAdvice won't allow me to trigger that error handler class via controller. Only triggers during
 * model problem
 */
public abstract class BaseController {

	private Logger LOG = LogManager.getLogger(BaseController.class);

	private HttpServletRequest request = null;
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
    public ErrorList handleNotFoundException(NotFoundException ex) {

        LOG.error("Exception Raised="+ex);
         
        
		List<FieldError> fieldErrors = new ArrayList<FieldError>();
		fieldErrors.add(new FieldError("", ex.getFieldId(), ex.getMessage()));
		return processFieldErrors(fieldErrors);
     
    }  
	
	/**
	 * Will be triggered if the model validation fails
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorList processValidationError(MethodArgumentNotValidException ex) {

		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	/**
	 * Will be triggered if our validation class throws ValidationException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorList handleValidationException(ValidationException ex) {

		List<FieldError> fieldErrors = ex.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}
	
	public HttpServletRequest getRequest() {
		if(this.request == null)
			return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		else
			return this.request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Converts field errors into error list object so it'll be readable in the json response
	 *
	 * @param fieldErrors
	 * @return
	 */
	private ErrorList processFieldErrors(List<FieldError> fieldErrors) {
		ErrorList errorList = new ErrorList();

		for (FieldError fieldError: fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			errorList.addField(fieldError.getField(), localizedErrorMessage);
		}

		return errorList;
	}

	/**
	 * Try to get the message resource if there's any
	 * @param fieldError
	 * @return
	 */
	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale =  LocaleContextHolder.getLocale();

		String localizedErrorMessage = null;
		try {
			localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
		} catch(Exception e) {
			LOG.info("Unable to find message resource for [" + fieldError+ ", with locale [" + currentLocale + "]. Using default message");
			localizedErrorMessage = fieldError.getDefaultMessage();
		}

		return localizedErrorMessage;
	}
}
