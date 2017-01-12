package com.devcortes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcortes.dao.IRAMDao;
import com.devcortes.entity.RAM;
import com.devcortes.entity.RAMRequest;
/**
 * Service for entity RAM contain methods for add, remove, update, get ram
 * @author cortes
 *
 */
@Service
public class RAMService {
	@Autowired	
	private IRAMDao ramDao;
	/**
	 * Add new RAM
	 * @param RAMRequest
	 */
	public void addRAM(RAMRequest ramRequest){
		ramDao.addRAM(ramRequest);
	}
	/**
	 * Update information about RAM
	 * @param id
	 * @param RAMRequest
	 */
    public void updateRAM(Long id, RAMRequest ramRequest){
    	ramDao.updateRAM(id, ramRequest);
    }
    /**
	 * Delete RAM
	 * @param id
	 */
    public void removeRAM(Long id){
    	ramDao.removeRAM(id);
    }
    /**
	 * Get information about all RAMs
	 * @return
	 */
    public List<RAM> getAllRAMs(){
		return ramDao.getAllRAMs();    	
    }

}
