package com.devcortes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcortes.entity.RAM;
/**
 * Repository that store information about ram
 * 
 */
@Repository
public interface IRAMRepository extends JpaRepository<RAM, Long> {

}
