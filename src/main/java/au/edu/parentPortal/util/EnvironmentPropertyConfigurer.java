package au.edu.parentPortal.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


public class EnvironmentPropertyConfigurer extends	PropertyPlaceholderConfigurer {	
	private Logger LOG = LogManager.getLogger(EnvironmentPropertyConfigurer.class);
	
	private static final String DEFAULT_LOCATION = "classpath:environment/application.properties";
	private static final String APPLICATION_ENVIRONMENT = "application.environment";	
	
	private String defaultResourceLocation = DEFAULT_LOCATION;
	
	public String getDefaultResourceLocation() {
		return defaultResourceLocation;
	}
	
	public EnvironmentPropertyConfigurer(String defaultResourceLocation) {
		this.defaultResourceLocation = defaultResourceLocation;
		
		ResourceLoader resourceLoader = new DefaultResourceLoader();		
		Resource defaultResource = resourceLoader.getResource(getDefaultResourceLocation()); 
		
		String environment = System.getProperty(APPLICATION_ENVIRONMENT);
		environment = environment == null ? "dev" : environment;
		
		LOG.info("application.environment system property is set to " + environment);
		Resource environmentProps = resourceLoader.getResource("classpath:environment/"	+ environment + "-application.properties");
		
		if (environmentProps != null) {
			Resource[] resources = null;
			
			LOG.info("Setting property resource locations to: " + defaultResource + " and " + environmentProps);
			resources = new Resource[] {
					defaultResource, // use default					
					environmentProps // override with specified environment		
				};
			
			setLocations(resources);
			
		} else {
			LOG.info("Setting property resource locations to: " + defaultResource);
			setLocation(defaultResource); // if none provided use default
		}	
	}
	
	public EnvironmentPropertyConfigurer() {
		this(DEFAULT_LOCATION);
	}
	
	@Override
	protected void loadProperties(Properties properties) throws IOException {		
		super.loadProperties(properties);
		
		// for each property that begins with "system" set it as a system property (dropping the "system" prefix)
		for (Object propertyName : properties.keySet()) {		
			int systemIndex = ((String)propertyName).indexOf("system"); 
			
			if (systemIndex >=0 ) {
				System.setProperty(((String)propertyName).substring(systemIndex + "system.".length()), properties.getProperty((String)propertyName));
				if (LOG.isTraceEnabled()) {
					LOG.trace("System property " + ((String)propertyName).substring(systemIndex + "system.".length()) + " set to " + properties.getProperty((String)propertyName));
				}				
			}
		}
		
	}
		
}
