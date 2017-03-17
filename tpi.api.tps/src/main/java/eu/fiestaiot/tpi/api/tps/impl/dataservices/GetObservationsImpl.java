package eu.fiestaiot.tpi.api.tps.impl.dataservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Katerina Pechlivanidou (kape) e-mail: kape@ait.gr
 * 
 */
public class GetObservationsImpl {

	/**
	 * The logger's initialization.
	 */
	final static Logger logger = LoggerFactory.getLogger(GetObservationsImpl.class);

	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The stop date.
	 */
	private Date stopDate;

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
	 * @param timePeriod
	 *            the time interval for the observations.
	 */
	public GetObservationsImpl(List<String> sensorID, Date startDate, Date stopDate) {
		this.setSensorID(sensorID);
		this.setStartDate(startDate);
		this.setStopDate(stopDate);
	}

	/**
	 * Gets the observations for specific SensorIDs.
	 * 
	 * @return the observations returned in json format.
	 */
	public String getObservationResultSet() {
		
		return observationResultSet;
	}
	
	/**
	 * Getter for the stopDate.
	 */
	public Date getStopDate() {
		return stopDate;
	}

	/**
	 * Setter for the stopDate.
	 */
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	/**
	 * Getter for the startDate.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Setter for the startDate.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Getter for the sensorID.
	 */
	public List<String> getSensorID() {
		return sensorID;
	}
	
	/**
	 * Setter for the sensorID.
	 */
	public void setSensorID(List<String> sensorID) {
		this.sensorID = sensorID;
	}

	public String getObservationResultSetType() {
		
		return observationResultSetType;
	}
}
