package com.devcortes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcortes.componets.entity.Client;

/**
 * Repository that store information about clients
 * 
 */
@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

}
