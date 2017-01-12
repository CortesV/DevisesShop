package com.devcortes.dao;

import java.util.List;

import com.devcortes.entity.RAM;
import com.devcortes.entity.RAMRequest;

public interface IRAMDao {
	public void addRAM(RAMRequest ramRequest);
    public void updateRAM(Long id, RAMRequest ramRequest);
    public void removeRAM(Long id);    
    public List<RAM> getAllRAMs();
}