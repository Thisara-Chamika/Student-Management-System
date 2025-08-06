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
	public static int nextIndex = 0;
	public static int studentIdCounter = 1;


//---------------------- find best in Dbms ------------------------------

	public static void sortDbmsMarkArray(){
		for(int i=nextIndex-1; i >= 0 ; i--){
			for(int j=0; j<i; j++){
				if(dbmsMarksArray[j] < dbmsMarksArray[j+1]){
					int tempPrfMarksArray = prfMarksArray[j];
					prfMarksArray[j]=prfMarksArray[j+1];
					prfMarksArray[j+1]=tempPrfMarksArray;
					
					String tempStudentIdArray = studentIdArray[j];
					studentIdArray[j]=studentIdArray[j+1];
					studentIdArray[j+1]=tempStudentIdArray;
					
					String tempStudentNameArray =studentNameArray[j];
					studentNameArray[j]=studentNameArray[j+1];
					studentNameArray[j+1]=tempStudentNameArray;
					
					int tempDbmsMarksArray = dbmsMarksArray[j];
					dbmsMarksArray[j]=dbmsMarksArray[j+1];
					dbmsMarksArray[j+1]=tempDbmsMarksArray;
				}
			}
						
		}
	}




//---------------------- find best in Prf ------------------------------

	public static void sortPrfMarksArray(){
		for(int i=nextIndex-1; i >= 0 ; i--){
			for(int j=0; j<i; j++){
				if(prfMarksArray[j] < prfMarksArray[j+1]){
					int tempPrfMarksArray = prfMarksArray[j];
					prfMarksArray[j]=prfMarksArray[j+1];
					prfMarksArray[j+1]=tempPrfMarksArray;
					
					String tempStudentIdArray = studentIdArray[j];
					studentIdArray[j]=studentIdArray[j+1];
					studentIdArray[j+1]=tempStudentIdArray;
					
					String tempStudentNameArray =studentNameArray[j];
					studentNameArray[j]=studentNameArray[j+1];
					studentNameArray[j+1]=tempStudentNameArray;
					
					int tempDbmsMarksArray = dbmsMarksArray[j];
					dbmsMarksArray[j]=dbmsMarksArray[j+1];
					dbmsMarksArray[j+1]=tempDbmsMarksArray;
				}
			}
						
		}
	}



//------------------------- find Rank ----------------------------------

	public static void findRank(){
		for (int i = 0; i < nextIndex; i++) {
		int rank = 1;
			for (int j = 0; j < nextIndex; j++) {
				if (totalArray[j] > totalArray[i]) {
					rank++;
				}
			}
			rankArray[i] = rank;
		}                                                                                                                                                               
	}


//------------------------- sort Arrays --------------------------------

	public static void sortArrays(){
		for(int i=nextIndex-1; i >= 0 ; i--){
			for(int j=0; j<i; j++){
				if(totalArray[j] < totalArray[j+1]){
					String tempStudentIdArray = studentIdArray[j];
					studentIdArray[j]=studentIdArray[j+1];
					studentIdArray[j+1]=tempStudentIdArray;
					
					String tempStudentNameArray =studentNameArray[j];
					studentNameArray[j]=studentNameArray[j+1];
					studentNameArray[j+1]=tempStudentNameArray;
					
					int tempPrfMarksArray = prfMarksArray[j];
					prfMarksArray[j]=prfMarksArray[j+1];
					prfMarksArray[j+1]=tempPrfMarksArray;
					
					int tempDbmsMarksArray = dbmsMarksArray[j];
					dbmsMarksArray[j]=dbmsMarksArray[j+1];
					dbmsMarksArray[j+1]=tempDbmsMarksArray;
					
					int tempTotalArray = totalArray[j];
					totalArray[j]=totalArray[j+1];
					totalArray[j+1]=tempTotalArray;
					
					double tempAverageArray = averageArray[j];
					averageArray[j]=averageArray[j+1];
					averageArray[j+1]=tempAverageArray;
				}
			}
		}
	}

//-------------------------- get Average -------------------------------

	public static double getAverage(int total){
		double average = total/2;
		return average;
	}


//---------------------------- get Total -------------------------------

	public static int getTotal(int prfMarks, int dbmsMarks){
		int total = prfMarks + dbmsMarks;
		return total;
	}


//------------------ narrow Arrays -------------------------------------

	public static void narrowArray(){
		String[] tempStudentIdArray = new String[nextIndex];
		String[] tempStudentNameArray = new String[nextIndex];
		int[] tempPrfMarksArray = new int [nextIndex];
		int[] tempDbmsMarksArray = new int[nextIndex];
		int[] tempTotalArray = new int[nextIndex];
		double[] tempAverageArray = new double[nextIndex];
		int[] tempRankArray = new int [nextIndex];
		
		for (int i = 0; i < nextIndex; i++){
			tempStudentIdArray[i] = studentIdArray[i];
			tempStudentNameArray[i] = studentNameArray[i];
			tempPrfMarksArray[i] = prfMarksArray[i];
			tempDbmsMarksArray[i] = dbmsMarksArray[i];
			tempTotalArray[i] = totalArray[i];
			tempAverageArray[i] = averageArray[i];
			tempRankArray[i] = rankArray[i];
		}
		
		studentIdArray = tempStudentIdArray;
		studentNameArray = tempStudentNameArray;
		prfMarksArray = tempPrfMarksArray;
		dbmsMarksArray = tempDbmsMarksArray;
		totalArray = tempTotalArray;
		averageArray = tempAverageArray;
		rankArray = tempRankArray;
	}

	
//----------------- is Marks Added -------------------------------------	
	
	public static boolean isMarksAdded(String stuId){
		int index = findStudentIndex(stuId);
		if (index == -1) {
			return false;
		}else{
			return prfMarksArray[index]!=0 && dbmsMarksArray[index]!=0;
		}
	}
	
	
//------------------ Find Student Index --------------------------------

	public static int findStudentIndex(String stuId){
		for (int i = 0; i <nextIndex ; i++){
			if (studentIdArray[i].equals(stuId)){
				return i;
			}
		}
		return -1;
	}
		
//------------------ get Valid Student Id (for searching)---------------
	
	public static String getValidStudentId(){
		String stuId;
		while(true){
			System.out.print("Enter Student ID : ");
			stuId = input.next();
			if (isIdExist(stuId)){
				return stuId;
			}else{
				System.out.print("Invalid Student ID. Do you want to search again ?  (Y/n): ");
				char ch = input.next().charAt(0);
				if(Character.toLowerCase(ch)=='n'){
					return null;
				}
			}
		}
	}
	
//------------------ get Valid Marks -----------------------------------

	public static int getValidMarks(String subject){
		int marks;
		
		while(true){
			System.out.print(subject+"Marks : ");
			marks = input.nextInt();
			
			if (marks>= 0 && marks <= 100){
				return marks;
			}else{
				System.out.println("Invalid Marks, Please enter Correct Marks.");
			}
		}
		
	}
	
//------------------- check student Id exist or not --------------------
	
	public static boolean isIdExist(String stuId){
		for (int i = 0; i <nextIndex ; i++){
			if(studentIdArray[i].equals(stuId)){
				return true;
			}
		}
		return false;
	}
	

//---------------------- Student Id Generate (Auto) --------------------

	public static String generateStudentId() {
		String id = String.format("S%03d", studentIdCounter);
		studentIdCounter++;
		return id;
	}
	
		
//------------------- Extend Arrays ------------------------------------

	public static void extendArrays(){
		String[] tempStudentIdArray = new String [studentIdArray.length+1];
		String[] tempStudentNameArray = new String [studentNameArray.length+1];
		int[] tempPrfMarksArray = new int [prfMarksArray.length+1];
		int[] tempDbmsMarksArray = new int [dbmsMarksArray.length+1];
		int[] tempTotalArray = new int [totalArray.length+1];
		double[] tempAverageArray = new double [averageArray.length+1];
		int[] tempRankArray = new int [rankArray.length+1];
		
		for (int i = 0; i < studentIdArray.length; i++){
			tempStudentIdArray[i] = studentIdArray[i];
			tempStudentNameArray[i] = studentNameArray[i];
			tempPrfMarksArray[i] = prfMarksArray[i];
			tempDbmsMarksArray[i] = dbmsMarksArray[i];
			tempTotalArray[i] = totalArray[i];
			tempAverageArray[i] = averageArray[i];
			tempRankArray[i] = rankArray[i];
		}
		
		studentIdArray = tempStudentIdArray;
		studentNameArray = tempStudentNameArray;
		prfMarksArray = tempPrfMarksArray;
		dbmsMarksArray = tempDbmsMarksArray;
		totalArray = tempTotalArray;
		averageArray = tempAverageArray;
		rankArray = tempRankArray;
		
	}
	
//------------------- Best in Database Management ----------------------

	public static void bestInDbms(){
		System.out.println("-------------------------------------------------");
		System.out.println("|      BEST IN DATABASE MANAGEMENT SYSTEM       |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.println("+------+-------------------+-------------+------------+");
		System.out.println("|ID    |Student's Name     |Dbms Marks   |prf Marks   |");
		System.out.println("+------+-------------------+-------------+------------+");
		
		sortDbmsMarkArray();
		
		for (int i = 0; i < nextIndex; i++){
			if (totalArray[i]!=0){
				System.out.printf("|%6s|%19s|%13d|%12d|",studentIdArray[i],studentNameArray[i],dbmsMarksArray[i],prfMarksArray[i]);
				System.out.println();
			}
		}
		System.out.print("+------+-------------------+-------------+------------+");
		System.out.println();
		
		System.out.print("\nDo you want to go back to main menu (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'y'){
					clearConsole();
					homePage();
				}
				System.exit(0);
	}
	
//------------------- Best in Programming Fundementals -----------------

	public static void  bestInPrf(){
		System.out.println("-------------------------------------------------");
		System.out.println("|       BEST IN PROGRAMMING FUNDEMENTALS        |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.println("+------+-------------------+------------+------------+");
		System.out.println("|ID    |Student's Name     |Prf Marks   |Dbms Marks  |");
		System.out.println("+------+-------------------+------------+------------+");
		
		sortPrfMarksArray();
		
		for (int i = 0; i < nextIndex; i++){
			if (totalArray[i]!=0){
				System.out.printf("|%6s|%19s|%12d|%12d|",studentIdArray[i],studentNameArray[i],prfMarksArray[i],dbmsMarksArray[i]);
				System.out.println();
			}
		}
		System.out.print("+------+-------------------+------------+------------+");
		System.out.println();
		
		System.out.print("\nDo you want to go back to main menu (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'y'){
					clearConsole();
					homePage();
				}
		System.exit(0);
	}

	
//------------------- Print Students Ranks -----------------------------

	public static void printStudentRarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|           PRINT STUDENTS' RANKS               |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.println("+------+------+-------------------+--------------+--------------+");
		System.out.println("|Rank  |ID    |Student's Name     |Total Marks   |Avg. Marks    |");
		System.out.println("+------+------+-------------------+--------------+--------------+");
		
		for (int i = 0; i < nextIndex; i++){
			if (totalArray[i]!=0){
				System.out.printf("|%6d|%6s|%19s|%14d|%14.1f|",rankArray[i],studentIdArray[i],studentNameArray[i],totalArray[i],averageArray[i]);
				System.out.println();
			}
		}
		System.out.print("+------+------+-------------------+--------------+--------------+");
		System.out.println();
		
		System.out.print("\nDo you want to go back to main menu (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'y'){
					clearConsole();
					homePage();
				}	
	}
	
	
//------------------- Print Students Details ---------------------------
	
	public static void printStudentDetails(){
		System.out.println("-------------------------------------------------");
		System.out.println("|            PRINT STUDENT DETAILS              |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while(true){
			String stuId = getValidStudentId();
			if (stuId == null){
				break;
			}
			
			int index = findStudentIndex(stuId);
			
			System.out.println("Student Name : "+studentNameArray[index]);
			
			
			if (!isMarksAdded(stuId)){
				System.out.println("\nMarks yet to be Added.");
				
				System.out.print("Do you want to search another student details(Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					clearConsole();
					homePage();
				}
				clearConsole();
				printStudentDetails();
				
			}else{
				
				System.out.println("+---------------------------------+----------+");
				System.out.printf("|Programming Fundamentals Marks   |%10d|",prfMarksArray[index]);
				System.out.printf("\n|Database Management System Marks |%10d|",dbmsMarksArray[index]);
				System.out.printf("\n|Total Marks                      |%10d|",totalArray[index]);
				System.out.printf("\n|Avg. Marks                       |%10.1f|",averageArray[index]);
				System.out.printf("\n|Rank                             |%3d(place)|",rankArray[index]);
				System.out.println("\n+---------------------------------+----------+");
				
				System.out.print("\nDo you want to search another student details(Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					clearConsole();
					homePage();
				}
				clearConsole();
				printStudentDetails();
			
			}
				
		}
		clearConsole();
		homePage();	
	}
	
//------------------- Delete Student -----------------------------------

	public static void deleteStudent(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 DELETE STUDENT                |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while(true){
			String stuId = getValidStudentId();
			if (stuId == null){
				break;
			}
			
			int index = findStudentIndex(stuId);
			
			for (int i = index; i < nextIndex - 1; i++){
				studentIdArray[i] = studentIdArray[i+1];
				studentNameArray[i] = studentNameArray[i+1];
				prfMarksArray[i] = prfMarksArray[i+1];
				dbmsMarksArray[i] = dbmsMarksArray[i+1];
				totalArray[i] = totalArray[i+1];
				averageArray[i] = averageArray[i+1];
				rankArray[i] = rankArray[i+1];
			}
			nextIndex--;
			
			narrowArray();
			sortArrays();
			findRank();
			
			System.out.println("Student has been deleted successfully.");
			System.out.print("Do you want to delete another student (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					break;
				}
				clearConsole();
				deleteStudent();
		}
		clearConsole();
		homePage();
	}
	
//------------------- update Marks -------------------------------------

	public static void updateMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 UPDATE MARKS                  |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while(true){
			String stuId = getValidStudentId();
			if (stuId == null){
				break;
			}
			
			int index = findStudentIndex(stuId);
			System.out.println("Student Name : "+studentNameArray[index]);
			
			if (!isMarksAdded(stuId)){
				System.out.println("This Student's Marks yet to be Added.");
				
			}else{
				System.out.println("Programming Fundamentals Marks : "+prfMarksArray[index]);
				System.out.println("Database Management System Marks : "+dbmsMarksArray[index]);
				
				int prfMarks = getValidMarks("Programming Fundementals ");		
				int dbmsMarks = getValidMarks("Database Management System ");
				int total = getTotal(prfMarks,dbmsMarks);
				double average = getAverage(total);
				
				prfMarksArray[index] = prfMarks;
				dbmsMarksArray[index] = dbmsMarks;
				totalArray[index] = total;
				averageArray[index] = average;
				
				sortArrays();
				findRank();
				
				System.out.println("Student's Marks have been updated successfully.");
				
			}
			
			System.out.print("Do you want to update another student's Marks (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					break;
				}
				clearConsole();
				updateMarks();
		}
		clearConsole();
		homePage();
	}
	
//------------------- Update Student Details ---------------------------	

	public static void updateStudentDetails(){
		System.out.println("-------------------------------------------------");
		System.out.println("|            UPDATE STUDENT DETAILS             |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while (true){
			String stuId = getValidStudentId();
			if (stuId == null){
				break;
			}
			
			int index = findStudentIndex(stuId);
			System.out.println("Student Name : "+studentNameArray[index]);
			
			System.out.print("Enter the new Student Name : ");
			String stuNewName = input.next();
			
			studentNameArray[index] = stuNewName; 
			System.out.println("Student Details has been updated successfully.");
			
			System.out.print("Do you want to update another student details (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					break;
				}
				clearConsole();
				updateStudentDetails();
			}
			clearConsole();
			homePage();
	}

//------------------- add Marks ----------------------------------------

	public static void addMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|                 ADD MARKS                     |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while (true){
			String stuId = getValidStudentId();
			if (stuId == null){
				break;
			}
			
			int index = findStudentIndex(stuId);
			if (isMarksAdded(stuId)){
				System.out.println("This student's marks have been already added.");
                System.out.println("If you want to update the marks, please use [5] Update Marks option.");
			}else{
				System.out.println("Student Name : "+studentNameArray[index]);
				
				int prfMarks = getValidMarks("Programming Fundementals ");		
				int dbmsMarks = getValidMarks("Database Management System ");		
				int total = getTotal(prfMarks,dbmsMarks);
				double average = getAverage(total);
		
				prfMarksArray[index] = prfMarks;
				dbmsMarksArray[index] = dbmsMarks;
				totalArray[index] = total;
				averageArray[index] = average;
				
				sortArrays();
				findRank();
				
				System.out.println("Student's Marks have been added successfully.");
			}
			
				System.out.print("Do you want to add marks for another student (Y/n)?  ");
				char ch = input.next().charAt(0);
			
				if(Character.toLowerCase(ch) == 'n'){
					break;
				}
				clearConsole();
				addMarks();
			}
			clearConsole();
			homePage();	
	}

//------------------- add New Student With Marks -----------------------

	public static void addNewStudentWithMarks(){
		System.out.println("-------------------------------------------------");
		System.out.println("|          ADD NEW STUDENT WITH MARKS           |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while(true){
			String stuId;
			while(true){
				stuId = generateStudentId();
				System.out.print("Enter Student ID\t: "+stuId);
				//stuId = input.next();
			
				if(isIdExist(stuId)){
					System.out.println("The Student ID already exists.");
				}else{
					break;
				}
					
			}
			
			System.out.print("\nEnter Student Name\t: ");
			String stuName = input.next();
			
		
			int prfMarks = getValidMarks("Programming Fundementals ");		
			int dbmsMarks = getValidMarks("Database Management System ");
			int total = getTotal(prfMarks,dbmsMarks);
			double average = getAverage(total);		
			
			extendArrays();
			
			studentIdArray[nextIndex] = stuId;
			studentNameArray[nextIndex] = stuName;
			prfMarksArray[nextIndex] = prfMarks;
			dbmsMarksArray[nextIndex] = dbmsMarks;
			totalArray[nextIndex] = total;
			averageArray[nextIndex] = average;
		
			nextIndex++;
			sortArrays();
			findRank();
		
			System.out.println("Student has been added successfully.");
			System.out.print("Do you want to add a new student (Y/n) ? ");
			char ch = input.next().charAt(0);
			
			if(Character.toLowerCase(ch) == 'n'){
				break;
			}
			clearConsole();
			addNewStudentWithMarks();
		}
		clearConsole();
		homePage();
	}
	
//------------------- add New Student ----------------------------------	

	public static void addNewStudent(){
		System.out.println("-------------------------------------------------");
		System.out.println("|               ADD NEW STUDENTS                |");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		while(true){
			String stuId;
			while(true){
				stuId = generateStudentId();
				System.out.print("Enter Student ID\t: "+stuId);
				//stuId = input.next();
			
				if(isIdExist(stuId)){
					System.out.println("The Student ID already exists.");
				}else{
					break;
				}
					
			}
			
			System.out.print("\nEnter Student Name\t: ");
			String stuName = input.next();
			
			extendArrays();
			
			studentIdArray[nextIndex] = stuId;
			studentNameArray[nextIndex] = stuName;
			prfMarksArray[nextIndex] = 0;
			dbmsMarksArray[nextIndex] = 0;
			totalArray[nextIndex] = 0;
			averageArray[nextIndex] = 0;
			
			nextIndex++;
			sortArrays();
			
			System.out.println("Student has been added successfully.");
			System.out.print("Do you want to add a new student (Y/n) ? ");
			char ch = input.next().charAt(0);
			
			if(Character.toLowerCase(ch) == 'n'){
				break;
			}
			clearConsole();
			addNewStudent();
		}
		clearConsole();
		homePage();
	}

//------------------- home page ----------------------------------------

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
		System.out.print("\n[11] Exit");
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
				
			case 11:
				clearConsole();
				System.exit(0);
				break;
		}
	
	}

//------------------ clear console -------------------------------------
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

//------------------- main method --------------------------------------
	public static void main (String[] args) {
		homePage();
	}
}

