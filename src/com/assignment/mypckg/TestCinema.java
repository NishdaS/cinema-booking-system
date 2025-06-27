package com.assignment.mypckg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCinema {

	//assertEquals
	@Test
	public void testBookSeats() {
		
		Cinema c = new Cinema(10, 100, new char[100], "2023/07/15", 15.00, 12.00, 10.00);
		
		int availableSeats = c.getAvailableSeats();
		int seatsToBook = availableSeats - 95;
		for(int i = 1; i <= seatsToBook; i++) {
			c.bookSeats(i, 'S');
		}

		char[] seats = c.getSeats();
		for(int i = 0; i < seatsToBook; i++) {
			Assertions.assertEquals('S', seats[i]);
		}
		
	}
	
	//Fail Test case
	@Test
	public void testBookSeatsFail() {
		
		Cinema c = new Cinema(5, 50, new char[50], "2023/07/20", 15.00, 12.00, 10.00);
		
		int availableSeats = c.getAvailableSeats();
		int seatsToBook = availableSeats - 45;
		for(int i = 1; i <= seatsToBook; i++) {
			c.bookSeats(i, 'S');
		}
		
		char[] seats = c.getSeats();
		for(int i = 0; i < seatsToBook; i++) {
			Assertions.assertEquals('F', seats[i], "seat category");
		}
	
	}
	
	//assertTrue
    @Test
    public void testAvailableSeatsIncreaseAfterRefund() {
    	
    	Cinema c = new Cinema(5, 50, new char[50], "2023/07/20", 15.00, 12.00, 10.00);
		
        //Assuming there are initially 5 available seats
        int initialAvailableSeats = 5;
        c.setAvailableSeats(initialAvailableSeats);

        // Refund 2 standard seats
        c.refundSeats('S');
        c.refundSeats('P');

        //Checking if the available seats have increased by 2
        assertTrue(c.getAvailableSeats() == initialAvailableSeats + 2);
    }
    
    //assertFalse
    @Test
    public void testDisplayReport() {
        Cinema c = new Cinema(5, 50, new char[50], "2023/12/31", 20.0, 15.0, 10.0);
        
        //Assuming
        int availableSeats = c.getAvailableSeats();
        int totalSeatsBooked = availableSeats - 40;
        double percentageSold = (totalSeatsBooked / availableSeats) * 100;
        double averageSeatPrice = (c.getPriceStandard() + c.getPricePensioner() + c.getPriceFrequent() / 3);

        
        Assertions.assertTrue(totalSeatsBooked >= 0, "Total seats sold should be greater than or equal to zero");
        Assertions.assertFalse(percentageSold >= 10 && percentageSold <= 100, "Percentage sold should be between 0 and 100");
        Assertions.assertFalse(averageSeatPrice <= 0, "Average seat price should be greater than or equal to zero");
    }
    
    //assertFalse - fail
    @Test
    public void testDisplayReportFail() {
        Cinema c = new Cinema(10, 100, new char[100], "2023/12/31", 20.0, 15.0, 10.0);
        
        //Assuming
        int availableSeats = c.getAvailableSeats();
        int totalSeatsBooked = availableSeats - 40;
        double percentageSold = (totalSeatsBooked / availableSeats) * 100;
        double averageSeatPrice = (c.getPriceStandard() + c.getPricePensioner() + c.getPriceFrequent() / 3);

        
        Assertions.assertTrue(totalSeatsBooked >= 0, "Total seats sold should be greater than or equal to zero");
        Assertions.assertFalse(percentageSold <= 0 || percentageSold <= 100, "Percentage sold should be between 0 and 100");
        Assertions.assertFalse(averageSeatPrice <= 0, "Average seat price should be greater than or equal to zero");
    }
	
  
	
	
	

}