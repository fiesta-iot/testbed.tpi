package eu.fiestaiot.tpi.api.tps.impl.dataservices;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Katerina Pechlivanidou (kape) e-mail: kape@ait.gr
 * 
 */
public class PushSingleObservationsImpl {
	/**
	 * The logger's initialization.
	 */
	final static Logger logger = LoggerFactory.getLogger(PushSingleObservationsImpl.class);

	/**
	 * The testbed URI.
	 */
	private String endpointURI;

	/**
	 * The sensors ID list.
	 */
	private String sensorID;

	/**
	 * Initializes class variables.
	 *
	 * @param endpointURI
	 *            the endpoint URI.
	 * 
	 * @param sensorID
	 *            the list of sensor IDs.
	 */
	public PushSingleObservationsImpl(String endpointURI, String sensorID) {
		this.endpointURI = endpointURI;
		this.sensorID = sensorID;
	}

	/**
	 * Pushes the obtained observation.
	 * 
	 * @return success message
	 */
	public Response pushSingleObservation() {
		return null;
	}
}
