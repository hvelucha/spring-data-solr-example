package au.edu.parentPortal.interceptors;

import au.edu.parentPortal.exceptions.ForbiddenException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by blim on 10/12/2014.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private Logger LOG = LogManager.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response, Object handler) throws Exception {

		LOG.info("############ Do your login logic here ############");

		return true;
	}
}
