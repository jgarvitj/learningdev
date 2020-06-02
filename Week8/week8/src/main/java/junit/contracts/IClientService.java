package junit.contracts;

import junit.exception.NameTooShortException;
import junit.model.Client;

public interface IClientService {
	public Client insertClient(Client client) throws NameTooShortException;
}
