import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CustomerTest {

    private static final String STATEMENT = "Rental Record for Mario\n" +
            "\tIT\t15.0\n" +
            "\tL'uomo di neve\t3.5\n" +
            "\tCars\t7.5\n" +
            "Amount owed is 26.0\n" +
            "You earned 4 frequent renter points";


    public ArrayList<Movie> getAllMovies() {
        return new ArrayList<Movie>(Arrays.asList(
                new Movie("IT", Movie.NEW_RELEASE),
                new Movie("L'uomo di neve", Movie.REGULAR),
                new Movie("Cars", Movie.CHILDRENS)
        ));
    }


    public ArrayList<Rental> getAllRentals() {
        ArrayList<Movie> movies = getAllMovies();
        return new ArrayList<Rental>(Arrays.asList(
                new Rental(movies.get(0), 5),
                new Rental(movies.get(1), 3),
                new Rental(movies.get(2), 7)
        ));
    }


    @Test
    public void testCustomerStatement() {
        Customer mario = new Customer("Mario");
        ArrayList<Rental> rentals = getAllRentals();

        for (int i = 0; i < rentals.size(); i++) {
            mario.addRental(rentals.get(i));
        }

        assertEquals(STATEMENT, mario.statement());
    }


}