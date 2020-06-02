package junit.dao;

import junit.model.Client;

public class ClientDAO {
	public Client insertClientToDb(Client client) {
		System.out.println("client inserted to db" + client);
		return client;
	}

}
