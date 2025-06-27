package com.assignment.mypckg;

public class Cinema {
	
	//member variables
	private int numOfRows;
	private int availableSeats;
	char[] seats;
	private String dateOfShow;
    private double priceStandard;
    private double pricePensioner;
    private double priceFrequent;
    private double totalRefundAmount = 0;
    private int standardSeats = 0, pensionerSeats = 0, frequentSeats = 0;
    private int refundedStandardSeats = 0, refundedPensionerSeats = 0, refundedFrequentSeats = 0;
    private String seatNumbers;
    
    //Constructor to initialize
	public Cinema(int numOfRows, int availableSeats, char[] seats, String dateOfShow, double priceStandard,
			double pricePensioner, double priceFrequent) {
		this.numOfRows = numOfRows;
		this.availableSeats = availableSeats;
		this.seats = seats;
		this.dateOfShow = dateOfShow;
		this.priceStandard = priceStandard;
		this.pricePensioner = pricePensioner;
		this.priceFrequent = priceFrequent;
	}
	
	//getter methods
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public char[] getSeats() {
		return seats;
	}
	
	public double getPriceStandard() {
		return priceStandard;
	}

	public double getPricePensioner() {
		return pricePensioner;
	}

	public double getPriceFrequent() {
		return priceFrequent;
	}

	//setter method
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	//Method to display available seats
	public void displayAvailableSeats() {
		System.out.println();
		System.out.println("***********************************************************");
	    System.out.println("*                         SCREEN                          *");
	    System.out.println("***********************************************************"); 
	    System.out.println();
	    
		int seatCounter = 0;
		int rowGap = 1;
		for(int i = 0; i < numOfRows * 10; i++) {
			if(seatCounter == 0){
				System.out.print("     "); //First row space
			}
			System.out.print((i + 1) + ":" + seats[i] + " ");
			seatCounter++;
			//Row gap - passage
			if (seatCounter / 5 == rowGap) {
				System.out.print("          ");
				rowGap++;
			}
			//To check if 10 seats per row
			if (seatCounter % 10 == 0) {
				System.out.println(); //Moves to the next row
			}
		}
		System.out.println();
        //Total number of seats
        System.out.println("Number of available seats: " + availableSeats);
        System.out.println();
	}
	
	//Method to book seats
	public void bookSeats(int seatNum, char category) {
		switch (category) {
        case 'S':
            standardSeats++;
            	break;
            
        case 'P':
            pensionerSeats++;
            	break;
            
        case 'F':
            frequentSeats++;
            	break;
            
        default:
        	System.out.println("Invalid seat category. Please try again");
        	return;
		}
		
		seats[seatNum - 1] = category;
        availableSeats--;  //Updating the number of available seats
        
	}
	
	public void printReciepts() {
		 //Calculate totalCost based on booked seats
        double totalCost = (standardSeats* priceStandard) + (pensionerSeats * pricePensioner) + (frequentSeats * priceFrequent);

		//Printing the reciept details
	    System.out.println("Receipt\n*******");
	    System.out.println("Date: " + dateOfShow);
	    System.out.println("Number of seats booked: " + (standardSeats + pensionerSeats + frequentSeats));
	    System.out.println(standardSeats  + " * Standard  @ $" + priceStandard +  " = $" + (standardSeats * priceStandard) +   " seat(s): " + getBookedSeats('S'));
	    System.out.println(pensionerSeats + " * Pensioner @ $" + pricePensioner + " = $" + (pensionerSeats * pricePensioner) + " seat(s): " + getBookedSeats('P'));
	    System.out.println(frequentSeats  + " * Frequent  @ $" + priceFrequent +  " = $" + (frequentSeats * priceFrequent) +   " seat(s): " + getBookedSeats('F'));
	    
	    System.out.println("                 Total : $" + totalCost);
	    
	    System.out.println();
	   
	    //Resetting the seat count 
	    standardSeats = 0;
	    pensionerSeats = 0;
	    frequentSeats = 0;
        
	}
	
	//Method to print the number of seats for a specific category
	public String getBookedSeats(char category) {
		String seatNumbers = "";
        boolean firstSeat = true;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == category) {
            	if (!firstSeat) {
                    seatNumbers += ", ";
                    } else {
                        firstSeat = false;
                    }
                    seatNumbers += (i + 1);
            }
       }
    
        return seatNumbers;
	}
	
	//Method to refund seats
	public void refundSeats(char category) {
		
		switch (category) {
        case 'S':
            standardSeats--;
            refundedStandardSeats++;
            break;

        case 'P':
            pensionerSeats--;
            refundedPensionerSeats++;
            
            break;

        case 'F':
            frequentSeats--;
            refundedFrequentSeats++;
            break;
		 }
		 availableSeats++;
	}
	
	//Method to print the refunded reciept
	public void printRefundReceipt(int refundedSeats) {
		
		//Calculate total refund amount 
        double totalRefundAmount = (refundedStandardSeats* priceStandard) + (refundedPensionerSeats * pricePensioner) + (refundedFrequentSeats * priceFrequent);

		//Printing the refund details
        System.out.println("Refund Receipt\n**************");
        System.out.println("Date: " + dateOfShow);
        System.out.println("Number of seats refunded: " + refundedSeats);
        System.out.println(refundedStandardSeats  + " * Standard  @ $" + priceStandard +  " = $" + (refundedStandardSeats * priceStandard) +   " seat(s): " + getRefundedSeats('S'));
	    System.out.println(refundedPensionerSeats + " * Pensioner @ $" + pricePensioner + " = $" + (refundedPensionerSeats * pricePensioner) + " seat(s): " + getRefundedSeats('P'));
	    System.out.println(refundedFrequentSeats  + " * Frequent  @ $" + priceFrequent +  " = $" + (refundedFrequentSeats * priceFrequent) +   " seat(s): " + getRefundedSeats('F'));
	    
        System.out.println("Total Refund: $" + totalRefundAmount);
        
        //Resetting the refund seat count
	    refundedStandardSeats = 0;
	    refundedPensionerSeats = 0;
	    refundedFrequentSeats = 0;
	}
	
	//Method to get the number of seats for a specific category
	public String getRefundedSeats(char category) {
        
		String seatNumbers = "";
        boolean firstSeat = true;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == category) {
            	if (!firstSeat) {
                    seatNumbers += ", ";
                    } else {
                        firstSeat = false;
                    }
                    seatNumbers += (i + 1);
            }
       }
        return seatNumbers;
	}
	
	//Method to print the statistic report
	public void displayReport() {
    	
		double averageSeatPrice = 0.0;

    	System.out.println(); //Extra line for formatting
    	
    	//Calculating the total number of seats booked
    	int totalSeatsBooked = numOfRows * 10 - availableSeats;
    	
    	//Calculating the percentage of seats sold
        double percentageSold = ((double) totalSeatsBooked / (numOfRows * 10)) * 100;
        String percentageSeatsSold = String.format("%.2f%", percentageSold);

        if (totalSeatsBooked > 0) {
            averageSeatPrice = ((totalSeatsBooked * priceStandard) + (totalSeatsBooked * pricePensioner)
                    + (totalSeatsBooked * priceFrequent)) / totalSeatsBooked;
        }
        
        //Printing the report details
	    System.out.println("Statistic Report\n****************");
	    System.out.println("Number of seats sold     : " + totalSeatsBooked);
	    System.out.println("Percentage of seats sold : " + percentageSeatsSold + "%");
	    System.out.println("Average seat price       : $" + averageSeatPrice);
	    
	    System.out.println();
	}
}
