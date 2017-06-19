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
	
	private String stopPushOfObservationsURL = "the_stop_push_of_observations_URL";

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
		
		return Response
				.ok("{\"response\" : \"Push_Schedule_ Successfully_Set_Up.\" , \n \"stopPushOfObservations\" : \""
						+ stopPushOfObservationsURL + "\"}").build();
		
		
	}
}
