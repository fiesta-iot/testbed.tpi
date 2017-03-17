package eu.fiestaiot.tpi.api.tps.rest;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is the Java EE 6 "no XML" approach to activating
 * JAX-RS.
 * 
 * <p>
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath} annotation.
 * </p>
 */
/**
 * @author Nikos Kefalakis (nkef) e-mail: nkef@ait.edu.gr
 * 
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {

	/**
	 * The logger
	 */
	final static Logger logger = LoggerFactory.getLogger(JaxRsActivator.class.getName());

	/**
	 * The singletons
	 */
	private Set<Object> singletons = new HashSet<Object>();
	
	/**
	 * The classes sets
	 */
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	/**
	 * The default constructor
	 */
	public JaxRsActivator() {
		singletons.add(new TpiApiTestbedProviderServices());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
