/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Theatre;

/**
 *
 * @author Moden
 */
// Class: Theater
// Purpose: Uses a two-dimensional array to represent 
// the seating arrangement of customers in a theater. The seats in the theater 
// are in a rectangular arrangement of rows and columns.
//
// Tim Gallagher
// 2019 APCS A Facebook Summit

import java.util.*;

public class Theater 
{
   private Customer[][] seats;
	

/* *  Creates a Theater seating chart with the given number of rows and columns 
   *  from the Customers in customerList. Empty seats are represented by null.
   *
   *  @param rows the number of rows of seats in the theater
   *  @param cols the number of columns of seats in the theater
   *  @param customerList The customers to be given seats in the theater
   *  @param rand indicator if customers should be given random seats
   
   *  Precondition: rows > 0; cols > 0;
   *             rows * cols >= customerList.size()
   *  Postcondition:
   *    - Customers appear in the seats in the same order as they appear in
   *      customerList, starting at seats[0][0], and seats is filled row by row from
   *      customerList, followed by any empty seats (represented by null).
   *        OR
   *      Customers are placed in the seats in random order, with empty seats null
   *    - customerList is unchanged.
*/	



   public Theater(int rows, int cols, ArrayList<Customer> customerList, boolean rand) 
   {
    	// Construct the seats 2D array
      seats = new Customer[rows][cols];
    	
      if (rand)  // fill the 2D array with Customers from the customerList into random seats
      {
         int index = 0;
         while(index < customerList.size())
         {
            int r = (int)(Math.random()*rows);
            int c = (int)(Math.random()*cols);
            while (seats[r][c] != null)
            {
               r = (int)(Math.random()*rows);
               c = (int)(Math.random()*cols);
            }
            seats[r][c] = customerList.get(index);
            index++;
         }
      }
      else // fill the 2D array with Customers from the customerList in row-major order
      {
         int index = 0;
         for (int r = 0; r < rows; r++)
         {
            for (int c = 0; c < cols; c++)
            {
               if (index < customerList.size())
               {
                  seats[r][c] = customerList.get(index);
                  index++;
               }
            }
         }
      }
   }

/* This method should return true if the seat is occupied, false otherwise.
 */ 
   public boolean isSeatOccupied(int row, int col)
   {
    if (seats[row][col] == null){
      return false;
    } 
    
    return true;
  
   }
   
/* This method should return the row number with the greatest number of occupied seats
 */
   public int findMostOccupiedRow()
   {
      int maxRow = 0;
      int maxPeople = 0;

      for(int i = 0; i < seats.length; i++){
        System.out.println(seats[i].length);
      }
      return 0;
   }    
 


/* This method should return the tallest customer in the theater
 */
   public Customer getTallestCustomer()
   {
        int maxHeight = seats[0][0].getHeight();
        int maxRow = 0;
        int maxCol = 0;

        for(int i = 0; i < seats.length; i++){
          for(int j = 0; j < seats[i].length; j++){
            //System.out.println("i:" + i + " j:" + j);
            if(seats[i][j].getHeight() > maxHeight ){
              maxHeight = seats[i][j].getHeight();
              maxRow = i;
              maxCol = j;
            }
          }
        }
        return seats[maxRow][maxCol];
   }    
     
/* This method should return a list of Customers who need to have their seats moved
 * because there is someone more than 3 inches taller than them sitting directly
 * in front of them (one row closer, but in the same seat).
 *
 * This method does not actually change any seats, but constructs and returns a NEW 
 * arrayList filled with customers who have someone sitting in front of them that 
 * is more than 3 inches taller than they are.
 */
   public ArrayList<Customer> getCustomersToBeMoved()
   {
      ArrayList<Customer> toMove = new ArrayList<>();
      
      //rows
      for(int i = 1; i < seats.length; i++){
      
      //columns 
        for(int j = 0; j < seats[0].length; j++){
          if(isSeatOccupied(i,j)){
            System.out.println("This person's height: " + seats[i][j].getHeight());
            System.out.println("The person in front height: " + seats[i-1][j].getHeight());
          }
          
        }
      }
      
      
      return toMove;
   }
    
    
/* This method returns a String that can be used to print out the contents 
 * of the seats in the theater
 */
   public String toString()
   {
      String output="";
   	
      for (int r = 0; r < seats.length; r++)
      {
         output = output + "[" + r +"] ";
         for (int c = 0; c < seats[r].length; c++)
         {
            if (seats[r][c] == null)
               output = output + "<empty>        ";
            else
               output = output + seats[r][c];
         }
         output = output + "\n";
      }
      return output;
   }    
      
}
