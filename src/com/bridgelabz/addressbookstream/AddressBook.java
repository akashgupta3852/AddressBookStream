package com.bridgelabz.addressbookstream;

import java.util.*;



public class AddressBook {
	private List<ContactPerson> addressBook;
	private static Map<String, List<ContactPerson>> addressBookSystem = new TreeMap<>();

	public List<ContactPerson> getAddressBook(){
		return addressBook;
	}
	
	public void setAddressBook(List<ContactPerson> addressBook){
		this.addressBook=addressBook;
	}
	
	public void addContactPerson(ContactPerson contactPerson) {
		addressBook.add(contactPerson);
	}
	
	public void addAddressBookToSystem(String addressBookName, List<ContactPerson> addressBook) {
		addressBookSystem.put(addressBookName, addressBook);
	}

	public boolean isPresentAddressBook(String addressBookName) {
		for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
			String adBookName= me.getKey();
			if(adBookName.equals(addressBookName)) 
				return true;
		}
		return false;
	}
	
	public boolean editContactPersonDetails(String addressBookName, String personName) {
		for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
			String adBookName= me.getKey();
			List<ContactPerson> addressBook=me.getValue();	
			if(adBookName.equals(addressBookName)) {
				for(ContactPerson contactPerson : addressBook)
				{
					String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
					if(name.equals(personName)) {
						addressBook.remove(contactPerson);
						ContactPerson contactPerson1 =addContactPersonDetails();
						addressBook.add(contactPerson1);
						addAddressBookToSystem(addressBookName,addressBook);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean deleteContactPersonDetails(String addressBookName, String personName) {
		for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
			String adBookName= me.getKey();
			List<ContactPerson> addressBook=me.getValue();
			if(adBookName.equals(addressBookName)) {
				for(ContactPerson contactPerson : addressBook)
				{
					String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
					if(name.equals(personName)) {
						addressBook.remove(contactPerson);
						addAddressBookToSystem(addressBookName,addressBook);
						return true;
					}
				}				
			}
		}
		return false;
	}
	
	public void showAddressBook(String addressBookName) {
		int check=0;
		for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
			String adBookName= me.getKey();
			List<ContactPerson> addressBook=me.getValue();
			if(adBookName.equals(addressBookName)) {
				check=1;
				if(addressBook.size()==0) {
					System.out.println("Sorry, there is no contact deatails in the "+addressBookName+".");
					break;
				}
				else {
					System.out.println("The contact details of the "+addressBookName+":");
					for(ContactPerson contactPerson: addressBook)
						System.out.println(contactPerson);
					break;
				}
			}
		}
		if(check!=1)
			System.out.println("Sorry, Address Book: "+addressBookName+" is not present in the system.");
	}
	
	public void showAddressBookSystem() {
		if(addressBookSystem.size()==0)
			System.out.println("There is no address book in the system.");
		else {
			for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
				String addressBookName= me.getKey();
				List<ContactPerson> addressBook=me.getValue();
				System.out.println("The contact details of the "+addressBookName+":");
				if(addressBook.size()==0)
					System.out.println("Sorry, there is no contact in the "+addressBookName+".");
				else
					for(ContactPerson contactPerson: addressBook)
						System.out.println(contactPerson);
			}
		}

	}
	
	public ContactPerson addContactPersonDetails(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first name:");
		String firstName=sc.next();
		System.out.println("Enter the last name:");
		String lastName=sc.next();
		System.out.println("Enter the address:");
		sc.nextLine();
		String address=sc.nextLine();
		System.out.println("Enter the city:");
		String city=sc.nextLine();
		System.out.println("Enter the state:");
		String state=sc.nextLine();
		System.out.println("Enter the zip:");
		int zip=sc.nextInt();
		System.out.println("Enter the phoneNo:");
		long phoneNo=sc.nextLong();
		System.out.println("Enter the email:");
		String emailId=sc.next();
		
		ContactPerson personDetails=new ContactPerson(firstName,lastName,address,city,state,zip,phoneNo,emailId);
		return personDetails;
	}		
}
	
