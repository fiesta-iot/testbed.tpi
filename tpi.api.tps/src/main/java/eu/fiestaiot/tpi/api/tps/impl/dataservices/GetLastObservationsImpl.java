package eu.fiestaiot.tpi.api.tps.impl.dataservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Katerina Pechlivanidou (kape) e-mail: kape@ait.gr
 * 
 */
public class GetLastObservationsImpl {

	/**
	 * The logger's initialization.
	 */
	final static Logger logger = LoggerFactory.getLogger(GetLastObservationsImpl.class);

	/**
	 * The sensor IDs list.
	 */
	private List<String> sensorID = new ArrayList<>();

	
	
	/**
	 * Observation Result Set
	 */
	private String observationResultSet = "EmptyDocument";
	
	
	/**
	 * Observation Result Set Type (add the return type here)
	 */
	private String observationResultSetType = "application/NoTypeAvailable";
	
	/**
	 * Initializes class variables.
	 * 
	 * @param sensorID
	 *            the list of sensor IDs.
	 * 
	 */
	public GetLastObservationsImpl(List<String> sensorID) {
		this.sensorID = sensorID;
	}

	/**
	 * Gets the latest observations for specific SensorIDs.
	 * 
	 * @return the latest observations in json format.
	 */
	public String getObservationResultSet() {
		
		// TODO Auto-generated method stub
		return observationResultSet;
	}

	public String getObservationResultSetType() {
		
		// TODO Auto-generated method stub
		return observationResultSetType;
	}
}
