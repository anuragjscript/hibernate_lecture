package client;

import model.Address;
import service.AddressCRUD;

public class AddressCRUDClient {
	
	AddressCRUD crudService = new AddressCRUD();

	public static void main(String[] args) {
		
		AddressCRUDClient action = new AddressCRUDClient();
		
		//action.deleteAddressById(3);
		
		action.showAddressById(4);

	}
	
	public void showAddressById(int addressId) {
		Address address = crudService.fetchAddressById(addressId);
		if( address == null ) {
			System.out.println("No record found");
		} else {
			System.out.println( address.toString() );
			System.out.println( "Associated : " + address.getStudent().toString() );			
		}
	}
	
	public void deleteAddressById(int addressId) {
		if ( crudService.deleteAddressById(addressId) ) {
			System.out.println("Deleted");
		} else {
			System.out.println("Nothing to delete");
		}
		
	}

}
