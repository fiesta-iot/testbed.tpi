package eu.fiestaiot.tpi.api.tps.impl.dataservices;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Katerina Pechlivanidou (kape) e-mail: kape@ait.gr
 * 
 */
public class StopPushOfObservationsImpl {
	/**
	 * The logger's initialization.
	 */
	final static Logger logger = LoggerFactory.getLogger(StopPushOfObservationsImpl.class);

	/**
	 * The endpoint URI.
	 */
	private String endpointURI;

	/**
	 * The sensors ID list.
	 */
	private List<String> sensorIDs = new ArrayList();

	/**
	 * Initializes class variables.
	 *
	 * @param endpointURI
	 *            the endpoint URI.
	 * 
	 * @param sensorID
	 *            the list of sensor IDs.
	 */
	public StopPushOfObservationsImpl(String endpointURI, List<String> sensorIDs) {
		this.endpointURI = endpointURI;
		this.sensorIDs = sensorIDs;
	}

	/**
	 * Stops pushing of observations.
	 * 
	 * @return success message
	 */
	public Response stopPushOfObservations() {
		
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity("Push_Schedule_ Successfully_Stoped").build();
	}
}
