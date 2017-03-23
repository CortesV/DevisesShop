package com.devcortes.run;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.annotation.Rollback;

import com.devcortes.componets.entity.Client;
import com.devcortes.componets.entity.ClientRequest;
import com.devcortes.componets.service.ClientDao;
import com.devcortes.service.ClientService;

@Rollback(false)
public class UnitTest {
	private ClientService clientService;
	private ClientRequest clientRequest;
	private ClientDao clientDao;
	
	@Spy
	List<Client> listClient = new ArrayList<>();
	
	@Before
	public void setUp() {
		clientService = new ClientService();

		clientDao = Mockito.mock(ClientDao.class);
		clientService.setClientDao(clientDao);

		clientRequest = new ClientRequest();
		clientRequest.setName("qqqq");
		clientRequest.setGender("aaa");
		clientRequest.setAge(11111);

		listClient.add(new Client(clientRequest.getName(), clientRequest.getGender(), clientRequest.getAge()));
		
		clientRequest.setName("www");
		clientRequest.setGender("www");
		clientRequest.setAge(111);
		
		listClient.add(new Client(clientRequest.getName(), clientRequest.getGender(), clientRequest.getAge()));
		
		clientRequest.setName("aaaa");
		clientRequest.setGender("aaaa");
		clientRequest.setAge(222);
		
		listClient.add(new Client(clientRequest.getName(), clientRequest.getGender(), clientRequest.getAge()));
	}

	@Test
	public void createClient() throws Exception {
		when(clientDao.getAllClients()).thenReturn(listClient);

		assertThat(listClient.size()).as("size").isEqualTo(3);
		assertThat(clientService.getAllClients().get(0).getName()).as("name").isEqualTo("qqqq");

		
		clientRequest.setName(listClient.get(1).getName());
		clientRequest.setGender(listClient.get(1).getGender());
		clientRequest.setAge(listClient.get(1).getAge());
		
		doNothing().when(clientDao).addClient(any(ClientRequest.class));
		clientService.addClient(clientRequest);
		verify(clientDao, times(1)).addClient(clientRequest);
		assertThat(clientService.getAllClients().get(1).getName()).as("name").isEqualTo("www");
		
		doNothing().when(clientDao).removeClient(Long.valueOf(1));
		clientService.removeClient(Long.valueOf(1));
		verify(clientDao, times(1)).removeClient(Long.valueOf(1));
		
		
		clientRequest.setName("1111");
		clientRequest.setGender("11111");
		clientRequest.setAge(1111);
		doNothing().when(clientDao).updateClient(Long.valueOf(1), clientRequest);
		clientService.updateClient(Long.valueOf(1), clientRequest);
		verify(clientDao, times(1)).updateClient(Long.valueOf(1), clientRequest);
		
		
		
	}
}
