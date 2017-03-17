package eu.fiestaiot.tpi.api.tps.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.fiestaiot.tpi.api.tps.impl.dataservices.GetLastObservationsImpl;
import eu.fiestaiot.tpi.api.tps.impl.dataservices.GetObservationsImpl;
import eu.fiestaiot.tpi.api.tps.impl.dataservices.PushLastObservationsImpl;
import eu.fiestaiot.tpi.api.tps.impl.dataservices.PushSingleObservationsImpl;
import eu.fiestaiot.tpi.api.tps.impl.dataservices.StopPushOfObservationsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Katerina Pechlivanidou (kape) e-mail: kape@ait.gr
 * 
 * @author Nikos Kefalakis (nkef) e-mail: nkef@ait.gr
 */
@Path("/tps")
@Consumes({ "application/xml", "application/json" })
@Produces({ "application/xml", "application/json" })
public class TpiApiTestbedProviderServices {

	/**
	 * The logger's initialization
	 */
	final static Logger logger = LoggerFactory.getLogger(TpiApiTestbedProviderServices.class);

	/**
	 * @return a message that should be shown under /tps
	 */
	@GET()
	@Produces("text/plain")
	public String welcomeMessage() {
		String welcomeText = "Welcome to Testbed Provider Interface Data Managment Services\n"
				+ "=============================================================\n\n";
		logger.debug(welcomeText);
		return welcomeText;
	}

	/**
	 * @param getLastObservationsPayload
	 *            the getLastObservationsPayload is a JSON as the following 
	 *            {
	 *            		"sensorIDs": [<String> sensorIDs] 
	 *            }
	 * 
	 * @return the latest observations
	 */
	@POST
	@SuppressWarnings("unchecked")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getLastObservations")
	public Response getLastObservations(String getLastObservationsPayload) {
		logger.info("Get the latest Observations.");

		try {
			final ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(getLastObservationsPayload,
					new TypeReference<HashMap<String, Object>>() {
					});
			final List<String> sensorIDs = (List<String>) map.get("sensorIDs");
			GetLastObservationsImpl glo = new GetLastObservationsImpl(sensorIDs);
			
			return Response.ok(glo.getObservationResultSet().trim(), glo.getObservationResultSetType()).build(); 
		} catch (IOException e) {
			logger.error("[ERROR]: Failed to get last observations. " + e.getMessage());
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(e.getMessage()).build(); 
		}
	}

	/**
	 * @param getObservationsPayload
	 *            the getObservationsPayload is a JSON as the following 
	 *            {
	 *            		"sensorIDs": [<String> sensorIDs], 
	 *            		"startDate": <Date> startDate,
	 *            		"stopDate" : <Date> stopDate
	 *            }
	 * 
	 * @return the Observations for a specific timePeriod
	 */
	@POST
	@SuppressWarnings("unchecked")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getObservations")
	public Response getObservations(String getObservationsPayload) {
		logger.info("Get Observations." + getObservationsPayload);		
		try {
			final ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(getObservationsPayload,
					new TypeReference<HashMap<String, Object>>() {
					});
			final List<String> sensorIDs = (List<String>) map.get("sensorIDs");
			//TODO: need to covert to DATE_FORMAT
			DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	        Date startDate=new Date(((long) map.get("startDate")));
	        Date stopDate=new Date(((long) map.get("startDate")));
	        
			GetObservationsImpl go = new GetObservationsImpl(sensorIDs, startDate, stopDate);
			return Response.ok(go.getObservationResultSet().trim(), go.getObservationResultSetType()).build(); 
		} catch (IOException e) {
			logger.error("[ERROR]: Failed to get observations. " + e.getMessage());
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(e.getMessage()).build(); 
		}
	}
	
	/**
	 * @param pushLastObservationsPayload
	 *            the pushLastObservationsPayload is a JSON as the following 
	 *            {
	 *            		"sensorIDs": [<String> sensorIDs], 
	 *            		"endpointURI": <String> theEndpointURI 
	 *            }
	 * 
	 * @return successMessage
	 */
	@POST
	@SuppressWarnings("unchecked")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pushLastObservations")
	public Response pushLastObservations(String pushLastObservationsPayload) {
		logger.info("Push Single Observation.");

		try {
			final ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(pushLastObservationsPayload,
					new TypeReference<HashMap<String, Object>>() {
					});
			final List<String> sensorIDs = (List<String>) map.get("sensorIDs");
			final String endpointURI = (String) map.get("endpointURI");
			PushLastObservationsImpl plo = new PushLastObservationsImpl(endpointURI, sensorIDs);
			return plo.pushLastObservationResultSet();
		} catch (IOException e) {
			logger.error("[ERROR]: Failed to get push last observations. " + e.getMessage());
			
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(e.getMessage()).build(); 
		}
	}

	/**
	 * @param pushLastObservationsPayload
	 *            the pushLastObservationsPayload is a JSON as the following 
	 *            {
	 *            		"sensorIDs": [<String> sensorIDs], 
	 *            		"endpointURI": <String> theEndpointURI 
	 *            }
	 * 
	 * @return successMessage
	 */
	@POST
	@SuppressWarnings("unchecked")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/stopPushOfObservations")
	public Response stopPushOfObservations(String pushLastObservationsPayload) {
		logger.info("Push Single Observation.");

		try {
			final ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(pushLastObservationsPayload,
					new TypeReference<HashMap<String, Object>>() {
					});
			final List<String> sensorIDs = (List<String>) map.get("sensorIDs");
			final String endpointURI = (String) map.get("endpointURI");
			StopPushOfObservationsImpl spo = new StopPushOfObservationsImpl(endpointURI, sensorIDs);
			return spo.stopPushOfObservations();

		} catch (IOException e) {
			logger.error("[ERROR]: Failed to stop push of last observations. " + e.getMessage());
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(e.getMessage()).build(); 
		}
			
			
	}

	/**
	 * @QueryParam sensorID the sensor ID
	 * 
	 * @QueryParam endpointURI the endpoint URI
	 * 
	 *             The service has a URL that has the following format: http://
	 *             <host>:<port>/tpi.api.dms/rest/tps?sensorID=<sensorID>&endpointURI=<endpointURI>
	 * 
	 * @return successMessage
	 */
	@Path("/pushSingleObservation")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pushSingleObservation(@QueryParam("sensorID") String sensorID,
			@QueryParam("endpointURI") String endpointURI) {
		logger.info("Push Single Observation.");
		logger.info("sensorID    = " + sensorID);
		logger.info("endpointUri = " + endpointURI);

		PushSingleObservationsImpl pso = new PushSingleObservationsImpl(endpointURI, sensorID);
		return pso.pushSingleObservation();
	}
}
