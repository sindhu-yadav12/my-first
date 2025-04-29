import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Person (common for Patient and Doctor)
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Class to represent a Patient
class Patient extends Person {
    String patientId;

    public Patient(String name, int age, String patientId) {
        super(name, age);
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Class to represent a Doctor
class Doctor extends Person {
    String specialty;

    public Doctor(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + name + ", Age: " + age + ", Specialty: " + specialty;
    }
}

// Class to represent an Appointment
class Appointment {
    String appointmentId;
    String patientId;
    String doctorName;
    String date;

    public Appointment(String appointmentId, String patientId, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + 
               ", Doctor: " + doctorName + ", Date: " + date;
    }
}

// Main Hospital Management System Class
public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Create Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    createAppointment();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.println("\nAdd Patient");
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        patients.add(new Patient(name, age, patientId));
        System.out.println("Patient added successfully.");
    }

    private static void addDoctor() {
        System.out.println("\nAdd Doctor");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();

        doctors.add(new Doctor(name, age, specialty));
        System.out.println("Doctor added successfully.");
    }

    private static void createAppointment() {
        System.out.println("\nCreate Appointment");
        System.out.print("Enter Appointment ID: ");
        String appointmentId = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        appointments.add(new Appointment(appointmentId, patientId, doctorName, date));
        System.out.println("Appointment created successfully.");
    }

    private static void viewPatients() {
        System.out.println("\nList of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctors() {
        System.out.println("\nList of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void viewAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}