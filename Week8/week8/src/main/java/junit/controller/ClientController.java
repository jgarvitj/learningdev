package junit.controller;

import junit.exception.NameTooShortException;
import junit.model.Client;
import junit.service.ClientService;


public class ClientController {

	private ClientService clientService = new ClientService();

	public Client insertClient(Client client) throws NameTooShortException {
		System.out.println("Client insert started");
		clientService.insertClient(client);
		return client;
	}

}
