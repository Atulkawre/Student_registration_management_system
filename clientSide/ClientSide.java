package clientSide;


	

	import java.util.InputMismatchException;
	import java.util.List;
	import java.util.Scanner;

	import bean.Course;
	import bean.Student;
	import dao.Dao;
	import dao.DaoImpl;
	import usecase.AdminAddNewCourse;
	import usecase.AdminAllocateStudentsInaBatchUnderaCourse;
	import usecase.AdminCreatBatchunderaCourse;
	import usecase.AdminDeleteCourse;
	import usecase.AdminDisplayCourseInfo;
	import usecase.AdminUpdateFeesOfCourse;
	import usecase.AdminUpdateTotalSeatsOfaBatch;
	import usecase.AdminViewStudentsOfEveryBatch;
	import usecase.LoginStudent;
	import usecase.RegisterStudentCourseBatch;
	

	public class ClientSide {

		public static void main(String[] args) throws Exception {
			System.out.println();
			System.out.println(" Welcome to Automated Student registration system!");
			Dao daoObj = new DaoImpl();

			Scanner sc = new Scanner(System.in);
			
			daoObj.displayHomePageOptionToUser();

			try {
				
			int profile = sc.nextInt(); 
			
			if(profile == 1){
				
				if(daoObj.checkForAdmin()) {
					daoObj.displayOptionsForAdmin();
					
					int aOpt = sc.nextInt();
					
					switch (aOpt) {
					case 1: {
						AdminAddNewCourse a = new AdminAddNewCourse();
						break;
					}
					case 2: {
						AdminUpdateFeesOfCourse a = new AdminUpdateFeesOfCourse();
						break;

					}
					case 3: {
						AdminDeleteCourse a = new AdminDeleteCourse();
						break;

					}
					case 4: {
						AdminDisplayCourseInfo a = new AdminDisplayCourseInfo();
						break;

					}
					case 5: {
						AdminCreatBatchunderaCourse a = new AdminCreatBatchunderaCourse();		
						break;
					}
					case 6: {
						AdminAllocateStudentsInaBatchUnderaCourse a = new AdminAllocateStudentsInaBatchUnderaCourse();
						break;
					}
					case 7: {
						AdminUpdateTotalSeatsOfaBatch a = new AdminUpdateTotalSeatsOfaBatch();
						break;
					}
					case 8: {
						AdminViewStudentsOfEveryBatch a = new AdminViewStudentsOfEveryBatch();
						break;
					}
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + aOpt+ " enter valid options please.");
					}
				}
				else System.out.println("Please enter correct ID and Password!");
				
			}
			
			else if(profile == 2) {
				RegisterStudentCourseBatch rscb = new RegisterStudentCourseBatch();
			}
			else if(profile == 3) {
				LoginStudent ls = new LoginStudent();
			}

			else System.out.println("Please enter valid input 1, 2 or 3");
			
			}
			catch(InputMismatchException ime) {
				System.out.println("Please enter valid input");
			}
			
			
		}

	}


