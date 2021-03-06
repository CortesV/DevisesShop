package com.devcortes.componets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcortes.componets.entity.RAM;
import com.devcortes.componets.entity.RAMRequest;
import com.devcortes.repository.IRAMRepository;
/**
 * Dao class for entity RAM contain methods for add, remove, update, get ram
 * @author cortes
 *
 */
@Service
public class RAMDao implements IRAMDao{
	@Autowired
	private IRAMRepository ramRepository;
	/**
	 * Add new RAM
	 * @param clientRequest
	 */
	@Override
	public void addRAM(RAMRequest ramRequest) {
		RAM ram = new RAM(ramRequest.getProducer(), ramRequest.getSeries(), ramRequest.getVolume());		
		ramRepository.save(ram);		
	}
	/**
	 * Update information about RAM
	 * @param id
	 * @param clientRequest
	 */
	@Override
	public void updateRAM(Long id, RAMRequest ramRequest) {
		ramRepository.findOne(id).setProducer(ramRequest.getProducer());
		ramRepository.findOne(id).setSeries(ramRequest.getSeries());
		ramRepository.findOne(id).setVolume(ramRequest.getVolume());
		ramRepository.save(ramRepository.findOne(id));		
	}
	/**
	 * Delete RAM
	 * @param id
	 */
	@Override
	public void removeRAM(Long id) {
		ramRepository.delete(id);		
	}
	/**
	 * Get information about all RAMs
	 * @return
	 */
	@Override
	public List<RAM> getAllRAMs() {
		return ramRepository.findAll();
	}

}
