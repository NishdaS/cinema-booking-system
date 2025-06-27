package com.assignment.mypckg;

import java.util.Scanner;

public class Demo {
	
	//main method
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int seatNumber = 0;
		char category;
		
		System.out.println("Welcome to the MC Ticket Booking System");
	
	
		//Entering the number of rows
		System.out.println("Enter the Number of Rows");
		int numOfRows = input.nextInt();
		
		int availableSeats = numOfRows * 10;
		char[] seats = new char[availableSeats]; //Initialize the seat Array
		
        for (int i = 0; i < numOfRows * 10; i++) {
            seats[i] = '-'; //Initializing all the seats as not booked
        }
        
        input.nextLine();

        
		System.out.println("Enter the Date of Show");
		String dateOfShow = input.nextLine();
	
		//Entering the price for different seat categories
		System.out.println("Enter the price for a Standard Seat (S): ");
		double priceStandard = input.nextDouble();
		
		System.out.println("Enter the price for a Pensioner Seat (P): ");
		double pricePensioner = input.nextDouble();
		
		System.out.println("Enter the price for a Frequent patron Seat (F): ");
		double priceFrequent = input.nextDouble();
		
		System.out.println();
	
		//creating a cinema object
		Cinema c = new Cinema(numOfRows, availableSeats, seats, dateOfShow, priceStandard,
				pricePensioner, priceFrequent);
		
		boolean program = true;
		
		while(program) {
			
			System.out.println("1. Display available seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Refund a seat");
            System.out.println("4. Display a report");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = input.nextInt();
            
            //Handles user choices
            switch(choice) {
            case 1:
            	c.displayAvailableSeats();
            		break;
            	
            case 2:
            	System.out.println();
            	System.out.println("Enter the number of seats to book");
            	int seatsToBook = input.nextInt();
            	
            	//Checking seat availability
            	if(seatsToBook <= availableSeats) {
            		System.out.println("Enter the required seat number");
            		
            		//Seat Number
            		for(int i = 0; i < seatsToBook; i++) {
            			System.out.println("Seat " + (i + 1) + ":");
            			seatNumber = input.nextInt();
            			
            			if(seatNumber > 0 && seatNumber <= numOfRows * 10) {
            				if(seats[seatNumber - 1] == '-') {
            					availableSeats--; //Updating the available seats
            					
            					//Seat category
            					System.out.println("Enter the seat category");
                    
            					while (true) {
            						category = input.next().charAt(0);
            	                    if (category == 'S' || category == 'P' || category == 'F' ) {
            	                    	c.bookSeats(seatNumber, category); //Calling the book seats method
            	                    		break;
            	                    } else {
            	                        System.out.println("Invalid seat category. Please try again");
            	                    }
            	                }
            				}else {
                				System.out.println("Seat " + seatNumber + " is already booked.");
                				i--; //Re-enter the seat number
                			}
                		}else {
                			System.out.println("Invalid seat number. Seat " +  seatNumber + " does not exist.");
                			i--; //Re-enter the seat number
                	}	 
            	}
            	System.out.println();
                c.printReciepts(); //Printing the receipt for the currently booked seats
            	}else {
            		System.out.println("Seats Unavailable. There are only " + availableSeats + " seat(s) available");
                	System.out.println();
                	break;
            	}
            	break;
            	
            case 3:
            	System.out.println();
           
        		int refundedSeats = 0;
        		
            	System.out.println("Enter the number of seats to refund:");
            	int seatsToRefund = input.nextInt();
            	
            	//Counting the booked seats
            	int bookedSeats = 0;
            	for (char seat : seats) {
            	    if (seat != '-') {
            	        bookedSeats++;
            	    }
            	}
            	if(seatsToRefund <= bookedSeats) {
            		System.out.println("Enter the booked seat number to refund:");
            		
            		for(int i = 0; i < seatsToRefund; i++) {
            			System.out.println("Seat " + (i + 1) + ":");
            			seatNumber = input.nextInt();
            			
            			if (seatNumber > 0 && seatNumber <= numOfRows * 10) {
            				if(seats[seatNumber - 1] != '-') {
            					category = seats[seatNumber - 1];
            					seats[seatNumber - 1] = '-';
            					refundedSeats++; //Updating the refunded seat count
            					c.refundSeats(category); //Calling the refund seats methods
	            			}else {
	            				System.out.println("Seat " + seatNumber + " was not booked. Enter the correct seat number.");
	                            i--; //Re-enter the seat number
	            			}
	            		}else {
	            			System.out.println("Invalid seat number. Please enter a valid seat number.");
	                        i--; //Re-enter the seat number
	            		}
	            	}
            		availableSeats += refundedSeats; //Updating the available seats
            		System.out.println();
	                c.printRefundReceipt(refundedSeats); //Printing the refund receipt
	            }else {
	            	System.out.println("Refund quantity cannot exceed the number of seats booked");
	            }
	            System.out.println();
	            	break;
            
            case 4:
            	c.displayReport(); 
            		break;
            		
            case 5:
                program = false;
                System.out.println("Leaving the system. Appreciate your interaction!");
                	break;
                
            default:
                System.out.println("Invalid selection. Please choose a valid option.");
        
            }
		}
	}
}



