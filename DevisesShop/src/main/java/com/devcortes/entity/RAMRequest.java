package com.devcortes.entity;

import javax.persistence.Column;

public class RAMRequest {
	private String producer;	
	private String model;	
	private Integer volume;
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
}
