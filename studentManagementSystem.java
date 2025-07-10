import java.util.*;
class studentManagementSystem {
	public static final Scanner input = new Scanner(System.in);

	public static String [] studentIdArray = new String[0];
	public static String [] studentNameArray = new String[0];
	public static  int [] prfMarksArray = new int[0];
	public static  int [] dbmsMarksArray = new int[0];
	public static  int [] totalArray = new int[0];
	public static double [] averageArray = new double [0];
	public static int [] rankArray = new int [0];
	
	
	
	
//------------------- Best in Database Management ----------------------------

	public static void bestInDbms(){
		System.out.println("-------------------------------------------------");
		System.out.println("|      BEST IN DATABASE MANAGEMENT SYSTEM       |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
	
//------------------- Best in Programming Fundementals -------------------------

	public static void  bestInPrf(){
		System.out.println("-------------------------------------------------");
		System.out.println("|       BEST IN PROGRAMMING FUNDEMENTALS        |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	
//------------------- Print Students Ranks -------------------------

	public static void printStudentRarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|             PRINT STUDENT RANKS               |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
	
//------------------- Print Students Details -------------------------
	
	public static void printStudentDetails(){
		System.out.println("-------------------------------------------------");
		System.out.println("|            PRINT STUDENT DETAILS              |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
//------------------- Delete Student -------------------------

	public static void deleteStudent(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 DELETE MARKS                  |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
	
//------------------- update Marks ----------------------------

	public static void updateMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 UPDATE MARKS                  |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
	
//------------------- Update Student Details -------------------------	

	public static void updateStudentDetails(){
		System.out.println("-------------------------------------------------");
		System.out.println("|            UPDATE STUDENT DETAILS             |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	
//------------------- add Marks -------------------------

	public static void addMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 ADD MARKS                     |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
	
//------------------- add New Student With Marks -------------------------

	public static void addNewStudentWithMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|          ADD NEW STUDENT WITH MARKS           |");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}
	
//------------------- add New Student -------------------------	

	public static void addNewStudent(){
		System.out.println("-------------------------------------------------");
		System.out.println("|               ADD NEW STUDENTS                |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		
	}


//------------------- home page -------------------------

	public static void homePage(){
		System.out.println("-------------------------------------------------");
		System.out.println("|     WELCOME TO GDSE MARKS MANAGEMENT SYSTEM   |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.print("[1] Add New Student");
		System.out.print("\t\t\t[2] Add New Student With Marks");
		System.out.print("\n[3] Add Marks");
		System.out.print("\t\t\t\t[4] Update Student Details");
		System.out.print("\n[5] Update Marks");
		System.out.print("\t\t\t[6] Delete Students");
		System.out.print("\n[7] Print Student Details");
		System.out.print("\t\t[8] Print Student Ranks");
		System.out.print("\n[9] Best in Programing Fundamentals");
		System.out.print("\t[10] Best in Database Management System");
		System.out.println();
		System.out.print("\nEnter an Option to Continue > ");
		int option  = input.nextInt();
		
		
		switch(option) {
			case 1:
				clearConsole();
				addNewStudent();
				break;
				
			case 2:
				clearConsole();
				addNewStudentWithMarks();
				break;
				
			case 3:
				clearConsole();
				addMarks();
				break;
				
			case 4:
				clearConsole();
				updateStudentDetails();
				break;
				
			case 5:
				clearConsole();
				updateMarks();
				break;
				
			case 6:
				clearConsole();
				deleteStudent();
				break;
				
			case 7:
				clearConsole();
				printStudentDetails();
				break;
				
			case 8:
				clearConsole();
				printStudentRarks();
				break;
				
			case 9:
				clearConsole();
				bestInPrf();
				break;
				
			case 10:
				clearConsole();
				bestInDbms();
				break;
		}
	
	}


//------------------ clear console ---------------------
	public final static void clearConsole() { 
	try { 
		final String os = System.getProperty("os.name"); 
		if (os.contains("Windows")) { 
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
		}else { 
			System.out.print("\033[H\033[2J"); 
			System.out.flush(); 
		} 
	} catch (final Exception e) { 
		e.printStackTrace(); 
	// Handle any exceptions. 
	} 
}



//------------------- main method -----------------------
	public static void main (String[] args) {
		homePage();
	}
}

