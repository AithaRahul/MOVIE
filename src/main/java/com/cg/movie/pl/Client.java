package com.cg.movie.pl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.AdminService;
import com.cg.movie.service.AdminServiceImpl;
public class Client {

	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		AdminService adminService = new AdminServiceImpl();
		AdminDao adminDao = new AdminDaoImpl();
	    Movie movie =null;
	   int choice = 0;
	   Theater theater = new Theater();

	while(choice!=5)
	        {
	       
	        System.out.println("1.Add Theater\n2.Delete Theater\n3.Add Movie\n4.Delete Movie");
	        System.out.println("Enter your choice");
	        choice = scanner.nextInt();
	
	switch(choice) {
	       
	 case 1:    System.out.println("Enter theater Id");
     int theaterId = scanner.nextInt();
     scanner.nextLine();
     System.out.println("Enter theater Name");
     String theaterName = scanner.nextLine();
     System.out.println("Enter theater City");
     String theaterCity= scanner.nextLine();
     System.out.println("Enter Manager Name");
     String managerName = scanner.nextLine();
     System.out.println("Enter Manager Contact");
     String managerContact =scanner.nextLine();

    

     theater.setTheaterId(theaterId);
     theater.setTheaterName(theaterName);
     theater.setTheaterCity(theaterCity);
     theater.setManagerName(managerName);
     theater.setManagerContact(managerContact);

     try {
    Theater theater1= adminService.addTheater(theater);
    System.out.println("Added theater sucessfully ");
     }
     catch (MovieException e)
     {
    System.err.println(e.getMessage());
     }

     break;


case 2:    System.out.println("Enter theater id to delete");

int theaterId1= scanner.nextInt();
try
{
boolean flag= adminService.deleteTheater(theaterId1);
if(flag==true)
{
System.out.println("Deleted successfully");
}

}
catch (MovieException e)
{
System.err.println(e.getMessage());
}  
break;

	       
	       
	       
	    case 3:   System.out.println("Enter Movie Id");
	              int movieId = scanner.nextInt();
	              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yy");
	              System.out.println("Enter Movie Name");
	              scanner.nextLine();
	              String movieName = scanner.nextLine();
	              System.out.println("Enter Movie Director name");
	              String moviedirector= scanner.nextLine();
	              System.out.println("Enter Movie Length");
	              int movielength = scanner.nextInt();
	              
	              System.out.println("Enter Movie Release date");
	              LocalDate releasedate =LocalDate.now();
	              System.out.println(releasedate);

	              movie = new Movie();

	              movie.setMovieId(movieId);
	              movie.setMovieName(movieName);
	              movie.setMovieDirector(moviedirector);
	              movie.setMovieLength(movielength);
	              movie.setMovieReleaseDate(releasedate);
	              
	              int theaterId2  = theater.getTheaterId();

	              try {
	              adminService.addMovie(theaterId2,movie);
	              System.out.println("Added Movie");
	              }
	              catch (MovieException e)
	              {
	              System.err.println(e.getMessage());
	              }
	              break;
	             
	             
	 case 4:     System.out.println("Enter movie id to delete");
	            int movieId1= scanner.nextInt();
	            int theaterId3 = theater.getTheaterId();
	            try
	            {
	            	boolean flag= adminService.deleteMovie(theaterId3,movieId1);
	            	if(flag==true)
	            	{
	            		System.out.println("Deleted successfully");
	            	}
	       
	            }
	            catch (MovieException e)
	            {
	            	System.err.println(e.getMessage());
	            }  
	                   break;

		  }
	   }
   }
}


