package com.devcortes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devcortes.entity.RAM;
import com.devcortes.entity.RAMRequest;
import com.devcortes.service.RAMService;

@RestController
@RequestMapping(value="/ram")
public class RAMController {
	@Autowired	
	private RAMService ramService;
	/**
	 * Get information about all RAMs
	 * @return
	 */
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<RAM> getAllRAMs(){			
		return ramService.getAllRAMs();
	} 	
	/**
	 * Add new RAM
	 * @param ramRequest
	 */
	@RequestMapping(value="/addRAM", method = RequestMethod.POST)
	public void addRAM(@RequestBody RAMRequest ramRequest){
		ramService.addRAM(ramRequest);
	}
	/**
	 * Delete RAM
	 * @param id
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public void deleteRAM(@PathVariable("id") Long id){
		ramService.removeRAM(id);
	}
	/**
	 * Update information about RAM
	 * @param id
	 * @param ramRequest
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public void putRAM(@PathVariable("id") Long id, @RequestBody RAMRequest ramRequest){		
		ramService.updateRAM(id, ramRequest);
	}

}
