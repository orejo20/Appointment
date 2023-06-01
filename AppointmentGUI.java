package ProjectOOP;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentGUI {
    private String ID;
    private String patientName;
    private String doctorName;
    private LocalDateTime dateTime;
    private String duration;
    
    public AppointmentGUI() {
        this.ID = "";
        this.patientName = "";
        this.doctorName = "";
        this.dateTime = null;
        this.duration = "";
    }
    
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public static void main(String[] args) {
    	
    	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Appointment ID: ");
			String ID = scanner.nextLine();
			
			System.out.println("Enter Patient's Name: ");
			String patientName = scanner.nextLine();
			
			System.out.println("Enter Doctor's Name: ");
			String doctorName = scanner.nextLine();
			
			System.out.println("Enter Appointment Date and Time (YYYY-MM-DD HH:MM AM/PM): ");
			String dateTime = scanner.nextLine();
			
	        AppointmentGUI appointment = new AppointmentGUI();
	        appointment.setID(ID);
	        appointment.setPatientName(patientName);
	        appointment.setDoctorName(doctorName);
	        appointment.setDateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")));
	        
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        if (appointment.getDateTime().isAfter(currentDateTime)) {
	        	System.out.println("\n-----------------------------\n");
	            System.out.println("This appointment is scheduled!");
		        System.out.println("\n-----------------------------\n");
	            System.out.println("Appointment Details:");
		        System.out.println("ID: " + appointment.getID());
		        System.out.println("Patient Name: " + appointment.getPatientName());
		        System.out.println("Doctor Name: " + appointment.getDoctorName());
		        System.out.println("Date: " + appointment.getDateTime().toLocalDate());
		        System.out.println("Time: " + appointment.getDateTime().toLocalTime());
		        System.out.println("\n-----------------------------\n");
		        System.out.println("Do you want to cancel the appointment? Yes or No?");
		        String answer = scanner.nextLine();
			        if (answer.equalsIgnoreCase("Yes") && answer.equalsIgnoreCase("yes") && answer.equalsIgnoreCase("YES")) {
			            System.out.println("This appointment has been cancelled. Thank You...");
			        } 
			        else if (answer.equalsIgnoreCase("No") && answer.equalsIgnoreCase("no") && answer.equalsIgnoreCase("NO")) {
			            System.out.println("This appointment has not been cancelled.");
			        } 
			        else {
			            System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
			        }
	        } 
	        else if (appointment.getDateTime().isBefore(currentDateTime)) {
	            System.out.println("Enter Appointment Duration (Minutes): ");
	            String duration = scanner.nextLine();
	            appointment.setDuration(duration);

		        System.out.println("\n-----------------------------\n");
	            System.out.println("This appointment has been finished!");
		        System.out.println("\n-----------------------------\n");
	            System.out.println("Appointment Details:");
		        System.out.println("ID: " + appointment.getID());
		        System.out.println("Patient Name: " + appointment.getPatientName());
		        System.out.println("Doctor Name: " + appointment.getDoctorName());
		        System.out.println("Date: " + appointment.getDateTime().toLocalDate());
		        System.out.println("Time: " + appointment.getDateTime().toLocalTime());
		        System.out.println("Duration: " + appointment.getDuration() + " minutes.");
	        } 
	        else {
	            System.out.println("Invalid input.");
	        }
	        
    	}
    }
}