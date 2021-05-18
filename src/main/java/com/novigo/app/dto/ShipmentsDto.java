package com.novigo.app.dto;

import java.io.Serializable;
import java.util.List;

public class ShipmentsDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String trackId;
	private String actualTechnicalTimestamp;
	private String actualBusinessTimestamp;
	private String actualBusinessTimeZone;
	private String altKey;
	private List<PlannedEventsDto> plannedEvents;
	private String shipmentNo;
	private String serviceAgentLbnId;
	private String transportationMode_code;
	private List<StopsDto> stops;
	private String shippingType_code;
	private String trackedObjects;
	private List<StopsDto> stopsForVP;
	private String departureLocationId;
	private String departureLocationType_code;
	private String arrivalLocationId;
	private String arrivalLocationType_code;
	private String Containerid;
	public ShipmentsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShipmentsDto(String trackId, String actualTechnicalTimestamp, String actualBusinessTimestamp,
			String actualBusinessTimeZone, String altKey, List<PlannedEventsDto> plannedEvents, String shipmentNo,
			String serviceAgentLbnId, String transportationMode_code, List<StopsDto> stops, String shippingType_code,
			String trackedObjects, List<StopsDto> stopsForVP, String departureLocationId,
			String departureLocationType_code, String arrivalLocationId, String arrivalLocationType_code,
			String containerid) {
		super();
		this.trackId = trackId;
		this.actualTechnicalTimestamp = actualTechnicalTimestamp;
		this.actualBusinessTimestamp = actualBusinessTimestamp;
		this.actualBusinessTimeZone = actualBusinessTimeZone;
		this.altKey = altKey;
		this.plannedEvents = plannedEvents;
		this.shipmentNo = shipmentNo;
		this.serviceAgentLbnId = serviceAgentLbnId;
		this.transportationMode_code = transportationMode_code;
		this.stops = stops;
		this.shippingType_code = shippingType_code;
		this.trackedObjects = trackedObjects;
		this.stopsForVP = stopsForVP;
		this.departureLocationId = departureLocationId;
		this.departureLocationType_code = departureLocationType_code;
		this.arrivalLocationId = arrivalLocationId;
		this.arrivalLocationType_code = arrivalLocationType_code;
		Containerid = containerid;
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	public String getActualTechnicalTimestamp() {
		return actualTechnicalTimestamp;
	}
	public void setActualTechnicalTimestamp(String actualTechnicalTimestamp) {
		this.actualTechnicalTimestamp = actualTechnicalTimestamp;
	}
	public String getActualBusinessTimestamp() {
		return actualBusinessTimestamp;
	}
	public void setActualBusinessTimestamp(String actualBusinessTimestamp) {
		this.actualBusinessTimestamp = actualBusinessTimestamp;
	}
	public String getActualBusinessTimeZone() {
		return actualBusinessTimeZone;
	}
	public void setActualBusinessTimeZone(String actualBusinessTimeZone) {
		this.actualBusinessTimeZone = actualBusinessTimeZone;
	}
	public String getAltKey() {
		return altKey;
	}
	public void setAltKey(String altKey) {
		this.altKey = altKey;
	}
	public List<PlannedEventsDto> getPlannedEvents() {
		return plannedEvents;
	}
	public void setPlannedEvents(List<PlannedEventsDto> plannedEvents) {
		this.plannedEvents = plannedEvents;
	}
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getServiceAgentLbnId() {
		return serviceAgentLbnId;
	}
	public void setServiceAgentLbnId(String serviceAgentLbnId) {
		this.serviceAgentLbnId = serviceAgentLbnId;
	}
	public String getTransportationMode_code() {
		return transportationMode_code;
	}
	public void setTransportationMode_code(String transportationMode_code) {
		this.transportationMode_code = transportationMode_code;
	}
	public List<StopsDto> getStops() {
		return stops;
	}
	public void setStops(List<StopsDto> stops) {
		this.stops = stops;
	}
	public String getShippingType_code() {
		return shippingType_code;
	}
	public void setShippingType_code(String shippingType_code) {
		this.shippingType_code = shippingType_code;
	}
	public String getTrackedObjects() {
		return trackedObjects;
	}
	public void setTrackedObjects(String trackedObjects) {
		this.trackedObjects = trackedObjects;
	}
	public List<StopsDto> getStopsForVP() {
		return stopsForVP;
	}
	public void setStopsForVP(List<StopsDto> stopsForVP) {
		this.stopsForVP = stopsForVP;
	}
	public String getDepartureLocationId() {
		return departureLocationId;
	}
	public void setDepartureLocationId(String departureLocationId) {
		this.departureLocationId = departureLocationId;
	}
	public String getDepartureLocationType_code() {
		return departureLocationType_code;
	}
	public void setDepartureLocationType_code(String departureLocationType_code) {
		this.departureLocationType_code = departureLocationType_code;
	}
	public String getArrivalLocationId() {
		return arrivalLocationId;
	}
	public void setArrivalLocationId(String arrivalLocationId) {
		this.arrivalLocationId = arrivalLocationId;
	}
	public String getArrivalLocationType_code() {
		return arrivalLocationType_code;
	}
	public void setArrivalLocationType_code(String arrivalLocationType_code) {
		this.arrivalLocationType_code = arrivalLocationType_code;
	}
	public String getContainerid() {
		return Containerid;
	}
	public void setContainerid(String containerid) {
		Containerid = containerid;
	}
	@Override
	public String toString() {
		return "ShipmentsDto [trackId=" + trackId + ", actualTechnicalTimestamp=" + actualTechnicalTimestamp
				+ ", actualBusinessTimestamp=" + actualBusinessTimestamp + ", actualBusinessTimeZone="
				+ actualBusinessTimeZone + ", altKey=" + altKey + ", plannedEvents=" + plannedEvents + ", shipmentNo="
				+ shipmentNo + ", serviceAgentLbnId=" + serviceAgentLbnId + ", transportationMode_code="
				+ transportationMode_code + ", stops=" + stops + ", shippingType_code=" + shippingType_code
				+ ", trackedObjects=" + trackedObjects + ", stopsForVP=" + stopsForVP + ", departureLocationId="
				+ departureLocationId + ", departureLocationType_code=" + departureLocationType_code
				+ ", arrivalLocationId=" + arrivalLocationId + ", arrivalLocationType_code=" + arrivalLocationType_code
				+ ", Containerid=" + Containerid + "]";
	}
	
	
}
