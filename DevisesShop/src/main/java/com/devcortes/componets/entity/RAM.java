package com.devcortes.componets.entity;

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
	
	@Column(nullable = false)
	private String producer;
	
	@Column(nullable = false)
	private String series;
	
	@Column(nullable = false)
	private Integer volume;
	
	public RAM() {}
	/**
	 * Constructor with parameters for RAM
	 * @param producer
	 * @param series
	 * @param volume
	 */
	public RAM(String producer, String series, Integer volume) {		
		this.producer = producer;
		this.series = series;
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
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "RAM [id=" + id + ", producer=" + producer + ", series=" + series + ", volume=" + volume + "]";
	}

	
	
	
}
