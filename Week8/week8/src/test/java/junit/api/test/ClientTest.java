package junit.api.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import junit.controller.ClientController;
import junit.exception.NameTooShortException;
import junit.model.Client;

public class ClientTest {

	private ClientController clientController;
	@Before
	public void setUp() throws Exception {
		clientController = new ClientController();
	}

	@Test
	public void Client_insertClientWithEnoughLength() throws NameTooShortException {
		String name = "garvit";
		
		assertEquals(name, clientController.insertClient(new Client(101, "garvit")).getClientName());

	}
	@Test(expected = NameTooShortException.class)
	public void clientShouldThrowExceptionOninsertClientWithShortLength() throws NameTooShortException{
	
		clientController.insertClient(new Client(101, "gj"));
		
	}
}
