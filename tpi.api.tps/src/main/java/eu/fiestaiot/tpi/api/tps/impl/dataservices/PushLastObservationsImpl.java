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
public class PushLastObservationsImpl {
	/**
	 * The logger's initialization.
	 */
	final static Logger logger = LoggerFactory.getLogger(PushLastObservationsImpl.class);

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
	public PushLastObservationsImpl(String endpointURI, List<String> sensorIDs) {
		this.endpointURI = endpointURI;
		this.sensorIDs = sensorIDs;
	}

	/**
	 * Pushes the obtained observations.
	 * 
	 * @return success message
	 */
	public Response pushLastObservationResultSet() {
		
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity("Push_Schedule_ Successfully_Set_Up").build();
	}
}
