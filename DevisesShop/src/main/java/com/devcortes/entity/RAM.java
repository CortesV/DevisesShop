package com.devcortes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RAM implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue
	private Long id;
	
	@Column(name = "producer", nullable = false)
	private String producer;
	
	@Column(name = "model", nullable = false)
	private String model;
	
	@Column(name = "volume", nullable = false)
	private Integer volume;
	
	public RAM() {}
	/**
	 * Constructor with parameters for RAM
	 * @param producer
	 * @param model
	 * @param volume
	 */
	public RAM(String producer, String model, Integer volume) {			
		this.producer = producer;
		this.model = model;
		this.volume = volume;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	@Override
	public String toString() {
		return "RAM [id=" + id + ", producer=" + producer + ", model=" + model + ", volume=" + volume + "]";
	}

	
	
	
}
