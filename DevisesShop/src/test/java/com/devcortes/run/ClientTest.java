package com.devcortes.run;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.devcortes.componets.entity.Client;
import com.devcortes.componets.entity.ClientRequest;
import com.devcortes.componets.service.ClientDao;
import com.devcortes.controller.ClientController;
import com.devcortes.repository.IClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@DataJpaTest
public class ClientTest {

	private ClientRequest clientRequest;

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private IClientRepository clientRepository;

	@Before
	public void setUp() {
		clientRequest = new ClientRequest();
		clientRequest.setName("adas");
		clientRequest.setGender("asa");
		clientRequest.setAge(12);
	}

	@Test
	public void testDao() {
		// Add client
		clientDao.addClient(clientRequest);
		// Get all clients
		assertEquals(clientRepository.findAll(), clientDao.getAllClients());
		assertThat(clientDao.getAllClients().get(0).getName()).as("name").isEqualTo("adas");

		List<Client> clientlist = clientRepository.findAll();
		assertEquals(clientlist.get(0), clientRepository.findOne(Long.valueOf(1)));

		// Update client
		clientRequest.setName("aaaa");
		clientRequest.setGender("aaaa");
		clientRequest.setAge(123);

		clientDao.updateClient(Long.valueOf(1), clientRequest);
		clientlist = clientRepository.findAll();
		assertEquals(clientlist.get(0).getName(), clientRepository.findOne(Long.valueOf(1)).getName());

		// Add client
		clientDao.addClient(clientRequest);
		// Get all clients
		assertEquals(clientRepository.findAll(), clientDao.getAllClients());

		// Remove client
		clientDao.removeClient(Long.valueOf(1));
		clientlist = clientRepository.findAll();
		assertEquals(clientlist.size(), 1);
	}
}
