package com.bidgelab.addressbookSystemuc8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bridfggelab.addressbooksystemuc7.ContactMain;
import com.bridfggelab.addressbooksystemuc7.InputScanner;

public class AddContact  extends PersonDetails  {
	
	ArrayList <AddContact> addContactDetails;
         InputScanner inputScanner = new InputScanner();
         ContactMain contact = new ContactMain();
	     public void setContactDetails()  {
			System.out.println("enter the First Name");
			setFirstName(inputScanner.inputString() );
			System.out.println("enter the Last Name");
			setLastName(inputScanner.inputString());
			System.out.println("enter the Address Name");
			setAddress(inputScanner.inputString());
			System.out.println("enter the City Name");
			setCity(inputScanner.inputString());
			System.out.println("enter the State Name");
			setState(inputScanner.inputString());
			System.out.println("enter the Phone Number");
			setPhoneNumber(inputScanner.inputString());
			System.out.println("enter the Zip/postal Code");
			setZip(inputScanner.inputString());
			System.out.println("enter the Email");
			setEmail(inputScanner.inputString());
		}

		public ArrayList<AddContact> getContactDetails() {
			getFirstName();
			getLastName();
			getAddress();
			getCity();
			getState();
			getPhoneNumber();
			getZip();
			getEmail();
			return addContactDetails;
		}

		public void editDetails(ArrayList<AddContact> contatctDetails) {
			String name = inputScanner.inputString();
			System.out.println(contatctDetails.size());
			for (int i = 0; i < contatctDetails.size(); i++) {
				if (contatctDetails.get(i).getFirstName().equals(name)) {
					System.out.printf("enter the number to update contact details 1 First Name 2 to update Last Name 3 to phone number 4 to pincode 5 to address 6 to email 7 to state 8 to city");
					int updateChoice =  inputScanner.inputInteger();
					inputScanner.inputInteger();
					
					switch (updateChoice) {
					case 1:
						System.out.println("enter the name to update");
						String fName = inputScanner.inputString();
						contatctDetails.get(i).setFirstName(fName);
						break;
					case 2:
						System.out.println("enter the Last name to update");
						String lName = inputScanner.inputString();
						contatctDetails.get(i).setLastName(lName);
						break;
					case 3:
						System.out.println("enter the Phone Number to Update");
						String phNumber =inputScanner.inputString();
						contatctDetails.get(i).setPhoneNumber(phNumber);
						break;
					case 4:
						System.out.println("enter the Pincode/Postalcode to Update");
						String pinCode = inputScanner.inputString();
						contatctDetails.get(i).setZip(pinCode);
						break;
					case 5:
						System.out.println("enter the Address to Update");
						String address =inputScanner.inputString();
						contatctDetails.get(i).setAddress(address);
						break;
					case 6:
						System.out.println("enter the Email to Update");
						String email =inputScanner.inputString();
						contatctDetails.get(i).setEmail(email);
						break;
					case 7:
						System.out.println("enter the State to Update");
						String state = inputScanner.inputString();
						contatctDetails.get(i).setState(state);
						break;
					case 8:
						System.out.println("enter the City to Update");
						String city = inputScanner.inputString();
						contatctDetails.get(i).setState(city);
						break;
							
					default:
						System.out.println("you have not update any details");
						break;
					}

				} else
					System.out.println("not match any details");
			}
		}

		public void deleteDetails(ArrayList<AddContact> contatctDetails) {
			System.out.println("enter the name");
			String name =inputScanner.inputString();
			for(int i = 0; i < contatctDetails.size(); i++ ) {
				if (contatctDetails.get(i).getFirstName().equals(name)) {
					contatctDetails.remove(i);
					
				} else 
					System.out.println("not match any details");
			}
		}

	public boolean checkDuplicate(ArrayList<AddContact> addContactDetails2, AddContact addPersonDetails) {
	
               boolean check = false;
               for (AddContact contact : addContactDetails2) {
                   if (addPersonDetails.getFirstName().equals(contact.getFirstName()))
                       check = true;
               }
               return check;
	 }
	
	public static void search(HashMap<Integer, ArrayList<AddContact>> hashMap) {
		InputScanner inputScanner = new InputScanner();
		System.out.println("enter the city or state name");
		String cityOrState = inputScanner.inputString();
		for (int i = 1; i <= ContactMain.hashMap.size(); i++) {
			List<AddContact> list = ContactMain.hashMap.get(i).stream().filter(c -> c.getCity().equalsIgnoreCase(cityOrState)||c.getState().equalsIgnoreCase(cityOrState)).collect(Collectors.toList());
			Predicate <AddContact> predicate = c -> c.getCity().contains(cityOrState)||c.getState().contains(cityOrState);
			long count = list.stream().filter(predicate).count();
			System.out.println("List for city or state   " + list);
		}
		
	}

		

}
