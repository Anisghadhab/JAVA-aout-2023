import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 0; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double [] lineItems) {
        double sum = 0.0;
        for (int i=0; i <= lineItems.length-1; i++ ) {
            sum += lineItems[i];
        }
        return sum;
    }

    public ArrayList<String> displayMenu(ArrayList<String> menu) {
        int index = 0;
        for( String cafe : menu) {
            System.out.println(index + " " + cafe );
            index ++;
        }
        return null;
    }

    public ArrayList<String> addCustomer(ArrayList<String> customer) {
        System.out.println("Please enter your name:" );
        String userName = System.console().readLine();
        System.out.println( "Hello, " + userName+"!");
        System.out.println("There are "+customer.size()+" people in front of you");
        customer.add(userName); // to add an item to an ArrayList
        return null;

    }
}