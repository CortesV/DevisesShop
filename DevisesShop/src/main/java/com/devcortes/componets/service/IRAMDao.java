package com.devcortes.componets.service;

import java.util.List;

import com.devcortes.componets.entity.RAM;
import com.devcortes.componets.entity.RAMRequest;

public interface IRAMDao {
	public void addRAM(RAMRequest ramRequest);
    public void updateRAM(Long id, RAMRequest ramRequest);
    public void removeRAM(Long id);    
    public List<RAM> getAllRAMs();
}