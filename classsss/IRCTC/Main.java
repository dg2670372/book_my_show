import java.util.*;
import service.*;
import exception.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        BookingService booking = new BookingService();

        while (true) {
            System.out.println("\n1.Register\n2.Login\n3.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            try {

                if (ch == 1) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    auth.register(name, email, pass);
                }

                else if (ch == 2) {
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    int userId = auth.login(email, pass);

                    if (userId == -1) {
                        throw new InvalidUserException();
                    }

                    System.out.println("Login Success!");

                    System.out.print("Enter Train ID: ");
                    int trainId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Train Name: ");
                    String trainName = sc.nextLine();

                    System.out.println("Booking for Train: " + trainName);

                    booking.bookTicket(userId, trainId);
                }

                else if (ch == 3) {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
