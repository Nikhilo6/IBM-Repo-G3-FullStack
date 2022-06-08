package com.lti.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


import com.lti.configuration.AppConfig;
import com.lti.exception.CourseNotFound;
import com.lti.exception.NewUserProperName;
import com.lti.exception.ProfessorNotFound;
import com.lti.exception.StudenNotApproved;
import com.lti.exception.StudentNotFound;
import com.lti.exception.StudentsNotEnrolled;
import com.lti.exception.UserNotFound;
import com.lti.service.AdminInterface;
import com.lti.service.ProfessorInterface;
import com.lti.service.StudentInterface;
import com.lti.service.UserInterface;

@SpringBootApplication
@Configurable
@EnableAutoConfiguration
@Import((AppConfig.class))
public class LtiCrsSpringCoreProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppConfig.class);
		
		AdminInterface ad = (AdminInterface) context.getBean("adminBean");
		StudentInterface st = (StudentInterface) context.getBean("studentBean");
		ProfessorInterface pf = (ProfessorInterface) context.getBean("professorBean");
		UserInterface us = (UserInterface) context.getBean("userBean");
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		List<String> ls = new ArrayList<String>();
		
		boolean run = true;
		while(run) {
		System.out.println("\nWelcome to CRSApplication");
		System.out.println("\n1. Login\n"
				+ "2. New Registration\n"
				+ "3. Change Password\n"
				+ "4. Exit");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		switch(n) {
		case 1:
			System.out.println("Login Page");
			System.out.println("\nChoose one of the following\n"
					+ "\n1. Student\n"
					+ "2  Professor\n"
					+ "3. Admin");
			Scanner sc1 = new Scanner(System.in);
			int n1 = sc1.nextInt();
			
			switch(n1) {
			case 1:
				System.out.println("Enter the username");
				Scanner sccc4 = new Scanner(System.in);
				String n91 = sccc4.next();
				System.out.println("Enter the password");
				Scanner sccc5 = new Scanner(System.in);
				String n81 = sccc5.next();
				try {
					us.login(n91, n81);
					try {
						st.check_appr(n91);
					} catch (StudenNotApproved e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UserNotFound e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					break;
				}
				System.out.println("Login Successful");
				System.out.println("Date and time: " + localDate.getDayOfMonth()+ " " + localDate.getMonth()+ " "  + 
				                    localDate.getYear()+ " "  + localDate.getDayOfWeek() + " " + localTime);
				boolean ex = true;
				while (ex) {
				System.out.println("\nStudent Menu\nChoose any number from the Following\n"
						+ "1. CourseRegistration\n"
						+ "2. Delete New Course\n"
						+ "3. Add New Course\n"
						+ "4. View Report Card\n"
						+ "5. Pay Fee\n"
						+ "6. View Courses\n"
						+ "7. Update(Delete and Add) Already Registered Course");
				Scanner sc2 = new Scanner(System.in);
				int n2 = sc2.nextInt();

				switch(n2) {
				case 1:
					System.out.println("                  Names of Courses                      ");
					System.out.println("========================================================");
					System.out.println("  Course Name            CourseID              CourseType");
					System.out.println("    Physics                110                   Engineering");
					System.out.println("  Electronics              113                   Engineering");          
					System.out.println("  C_Programming            112                   Engineering");         
					System.out.println("  Chemistry                111                   Engineering");
					System.out.println("\n               Alterantive Courses                     ");
					System.out.println("==========================================================");
					System.out.println("  English                   109                  Engineering");           
					System.out.println(" Mathematics                114                  Engineering");            
					System.out.println("\nChoose any four courses from the above.");
					for(int i = 1; i <= 4; i++) {
						Scanner sc10 = new Scanner(System.in);
						String n10 = sc10.next();
						ls.add(n10);
					}
					System.out.println("\nEnter the Student id");
					Scanner sc11 = new Scanner(System.in);
					int n16 = sc11.nextInt();
					try {
						st.registerCourse(n16, ls);
					} catch (StudenNotApproved e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						st.viewCourses(n16);
					} catch (StudentNotFound e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					break;
				case 2:
					System.out.println("\nEnter the Student_id");
					Scanner sc19 = new Scanner(System.in);
					int n191 = sc19.nextInt();
					System.out.println("                  Names of Courses                      ");
					System.out.println("========================================================");
					System.out.println("  Course Name            CourseID              CourseType");
					System.out.println("    Physics                110                   Engineering");
					System.out.println("  Electronics              113                   Engineering");          
					System.out.println("  C_Programming            112                   Engineering");         
					System.out.println("  Chemistry                111                   Engineering");
					System.out.println("\n               Alterantive Courses                     ");
					System.out.println("==========================================================");
					System.out.println("  English                   109                  Engineering");           
					System.out.println(" Mathematics                114                  Engineering");   
					System.out.println("\nEnter the Course id");
					Scanner sc16 = new Scanner(System.in);
					int n19 = sc16.nextInt();
					try {
						st.dropCourse(n191, n19);
					} catch (StudentNotFound e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
					System.out.println("Course Deleted");
					break;
				case 3:
					System.out.println("\nEnter the Student id");
					Scanner sc12 = new Scanner(System.in);
					int n12 = sc12.nextInt();
					System.out.println("                  Names of Courses                      ");
					System.out.println("========================================================");
					System.out.println("  Course Name            CourseID              CourseType");
					System.out.println("    Physics                110                   Engineering");
					System.out.println("  Electronics              113                   Engineering");          
					System.out.println("  C_Programming            112                   Engineering");         
					System.out.println("  Chemistry                111                   Engineering");
					System.out.println("\n               Alterantive Courses                     ");
					System.out.println("==========================================================");
					System.out.println("  English                   109                  Engineering");           
					System.out.println(" Mathematics                114                  Engineering");   
					System.out.println("\nEnter the course_id");
					Scanner sc14 = new Scanner(System.in);
					int n14 = sc14.nextInt();
					try {
						try {
							st.addCourse(n12, n14);
						} catch (StudenNotApproved e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (CourseNotFound e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					break;
				case 4:
					System.out.println("Enter the student_id");
					Scanner sc145 = new Scanner(System.in);
					int n145 = sc145.nextInt();
					try {
						st.viewReportCard(n145);
					} catch (StudentNotFound e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					break;
				case 5:
					System.out.println("\nEnter the Student id");
					Scanner sc121 = new Scanner(System.in);
					int n141 = sc121.nextInt();
					System.out.println("Enter the payment type"
							+ "\n1. Debit card"
							+ "\n2. Credit Card"
							+ "\n3. UPI");
					Scanner dc = new Scanner(System.in);
					int ndc = dc.nextInt();
					switch(ndc) {
					case 1:
						String db = "Debit Card";
						System.out.println("Enter the Debit card number");
						Scanner dc1 = new Scanner(System.in);
						int ndc1 = dc1.nextInt();
						System.out.println("Enter cvv");
						Scanner dc2 = new Scanner(System.in);
						System.out.println("\nTotal Registration cost is 10000");
						System.out.println("\nEnter the amount");
						Scanner dc5 = new Scanner(System.in);
						int ndc5 = dc5.nextInt();
						try {
							st.payFee(n141, ndc5, db);
						} catch (StudentNotFound e6) {
							// TODO Auto-generated catch block
							e6.printStackTrace();
						}
					case 2:
						String db2 = "Credit Card";
						System.out.println("Enter the Credit card number");
						Scanner dc3 = new Scanner(System.in);
						int ndc3 = dc3.nextInt();
						System.out.println("Enter cvv");
						Scanner dc4 = new Scanner(System.in);
						int ndc4 = dc4.nextInt();
						System.out.println("\nTotal Registration cost is 10000");
						System.out.println("\nEnter the amount");
						Scanner dc6 = new Scanner(System.in);
						int ndc6 = dc6.nextInt();
						try {
							st.payFee(n141, ndc6, db2);
						} catch (StudentNotFound e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
						break;
					case 3:
						String db3 = "UPI";
						System.out.println("Enter the mobile number");
						Scanner dc7 = new Scanner(System.in);
						int ndc7 = dc7.nextInt();
						System.out.println("\nTotal Registration cost is 10000");
						System.out.println("\nEnter the amount");
						Scanner dc8 = new Scanner(System.in);
						int ndc8 = dc8.nextInt();
						try {
							st.payFee(n141, ndc8, db3);
						} catch (StudentNotFound e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
						break;
					default:
						break;
					}		
					break;
				case 6:
					System.out.println("Enter the student id");
					Scanner sc34 = new Scanner(System.in);
					int n34 = sc34.nextInt();
					try {
						st.viewCourses(n34);
					} catch (StudentNotFound e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					break;
				case 7:
					System.out.println("Enter student id");
					Scanner sccc24 = new Scanner(System.in);
					int n901 = sccc24.nextInt();
					try {
						st.viewCourses(n901);
					} catch (StudentNotFound e5) {
						// TODO Auto-generated catch block
						e5.printStackTrace();
					}
					System.out.println("\nEnter the course name that you want to delete");
					Scanner sccc14 = new Scanner(System.in);
					String n801 = sccc14.next();
					System.out.println("Enter new course name");
					Scanner sccc145 = new Scanner(System.in);
					String n8015 = sccc145.next();
					st.update_already_registered_course(n901, n801, n8015);
				default:
					break;
				}
				}
				break;
			case 2:
				System.out.println("Enter the username");
				Scanner sccc2 = new Scanner(System.in);
				String n90 = sccc2.next();
				System.out.println("Enter the password");
				Scanner sccc1 = new Scanner(System.in);
				String n80 = sccc1.next();
				try {
					us.login(n90, n80);
				} catch (UserNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Login Successful");
				System.out.println("Date and time: " + localDate.getDayOfMonth()+ " " + localDate.getMonth()+ " "  + localDate.getYear()+ " "  + localDate.getDayOfWeek() + " " + localTime);
				boolean ex1 = true;
				while(ex1) {
				System.out.println("\nProfessor Menu\nChoose any number from the Following for activity\n"
						+ "1. View Course\n"
						+ "2. View Enrolled Students\n"
						+ "3. Add Grades");
				Scanner sc3 = new Scanner(System.in);
				int n3 = sc3.nextInt();
				switch(n3) {
				case 1:
					pf.viewCourse();
					break;
				case 2:
					System.out.println("Names of the Enrolled Students");
					System.out.println("==============================");
					try {
						pf.viewEnrolledStudents();
					} catch (StudentsNotEnrolled e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the name of the student");
					Scanner scc3 = new Scanner(System.in);
					String nn1 = scc3.next();
					System.out.println("Enter the id");
					Scanner scc6 = new Scanner(System.in);
					int nn2 = scc6.nextInt();
					System.out.println("Enter the grade to add");
					Scanner scc7 = new Scanner(System.in);
					String nn3 = scc7.next();
					try {
						pf.addGrades(nn2, nn1, nn3);
					} catch (StudentNotFound e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					break;
				default:
					break;
				}
				}
				break;
			case 3:
				System.out.println("Enter the username");
				Scanner scc2 = new Scanner(System.in);
				String n7 = scc2.next();
				System.out.println("Enter the password");
				Scanner scc6 = new Scanner(System.in);
				String n8 = scc6.next();
				try {
					us.login(n7, n8);
				} catch (UserNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Login Successful");
				System.out.println("Date and time: " + localDate.getDayOfMonth()+ " " + localDate.getMonth()+ " "  + localDate.getYear()+ " "  + localDate.getDayOfWeek()+ " " + localTime);
				boolean ex3 = true;
				while(ex3) {
				System.out.println("Admin Menu\n\nChoose any number from the Following\n"
						+ "\n1. Add Course\n"
						+ "2. Approve Student\n"
						+ "3. Drop Course\n"
						+ "4. Add Professor\n"
						+ "5. Assign Course to Professors\n");
				Scanner sc4 = new Scanner(System.in);
				int n4 = sc4.nextInt();
				switch(n4) {
				case 1:
					System.out.println("Enter the course name");
					Scanner scc1 = new Scanner(System.in);
					String n6 = scc1.next();
					System.out.println("Enter the new id");
					Scanner scc9 = new Scanner(System.in);
					int n0 = scc9.nextInt();
					try {
						ad.addCourse(n6, n0);
					} catch (CourseNotFound e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("\nCourse Added");
					break;
				case 2:
					System.out.println("Enter the student id");
					Scanner scc5 = new Scanner(System.in);
					int n77 = scc5.nextInt();
					try {
						ad.set_admin_approval(n77);
					} catch (StudentNotFound e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the course id");
					Scanner scc8 = new Scanner(System.in);
					int n78 = scc8.nextInt();
					try {
						ad.removeCourse(n78);
					} catch (CourseNotFound e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					break;
				case 4:
					System.out.println("Enter the professor user_id");
					Scanner scc = new Scanner(System.in);
					int n5 = scc.nextInt();
					System.out.println("Enter the professor name");
					Scanner scc55 = new Scanner(System.in);
					String n55 = scc55.next();
					try {
						ad.addProfessor(n5, n55);
					} catch (ProfessorNotFound e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("Professors Added Successfully");
					break;
				case 5:
					System.out.println("Enter the professor id");
					Scanner scc3 = new Scanner(System.in);
					int st3 = scc3.nextInt();
					System.out.println("                  Names of Courses                      ");
					System.out.println("========================================================");
					System.out.println("  Course Name            CourseID              CourseType");
					System.out.println("    Physics                110                   Engineering");
					System.out.println("  Electronics              113                   Engineering");          
					System.out.println("  C_Programming            112                   Engineering");         
					System.out.println("  Chemistry                111                   Engineering");
					System.out.println("\n               Alterantive Courses                     ");
					System.out.println("==========================================================");
					System.out.println("  English                  109                   Engineering");           
					System.out.println(" Mathematics                114                  Engineering");   
					System.out.println("\nEnter the course id from the following");
					Scanner sccc = new Scanner(System.in);
					int st4 = sccc.nextInt();
					try {
						ad.assignCourseProfessor(st3, st4);
					} catch (ProfessorNotFound e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				default:
					break;
				
				}
				}
				break;
			}
			break;
			
		case 2:
			System.out.println("Enter your email id");
			Scanner sccc1 = new Scanner(System.in);
			String u_d = sccc1.next();
			System.out.println("Enter a user name");
			Scanner sccc2 = new Scanner(System.in);
			String nm = sccc2.next();
			System.out.println("Enter a password");
			Scanner sccc3 = new Scanner(System.in);
			String pw = sccc3.next();
				try {
					us.new_user(u_d, nm, pw);
				} catch (NewUserProperName e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("\nChoose your role\n"
					+ "\n1. Student\n"
					+ "2  Professor\n"
					+ "3. Admin");
			Scanner sv = new Scanner(System.in);
			int nv = sv.nextInt();
			switch(nv) {
				case 1: 
					us.add_stud(nm, u_d);
					break;
				case 2:
					us.add_prof(nm,u_d);
					break;
				case 3:
					us.add_admin(nm, u_d);
					break;
				default:
					break;
			}
			
			
			break;
		case 3:
			System.out.println("Enter the user id");
			Scanner sccc4 = new Scanner(System.in);
			int i_d = sccc4.nextInt();
			System.out.println("Enter the new password");
			Scanner sccc5 = new Scanner(System.in);
			String pd = sccc5.next();
			try {
				us.password_change(i_d, pd);
			} catch (UserNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("Password has been updated.");
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	}

}

	
	

