package junit.service;

import junit.contracts.IClientService;
import junit.dao.ClientDAO;
import junit.exception.NameTooShortException;
import junit.model.Client;

public class ClientService implements IClientService{

	private ClientDAO clientDAO = new ClientDAO();
	
	public Client insertClient(Client client) throws NameTooShortException  {
		if(client.getClientName().length() < 5) {
			throw new NameTooShortException("Client could not be created: Name too short" + client.getClientName());
		}
		
		return clientDAO.insertClientToDb(client);
		
	}

}
