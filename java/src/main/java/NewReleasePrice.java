public class NewReleasePrice extends Price{
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented){
        double result = daysRented * 3;
        return result;
    }

    int getFrequentRenterPoints(int daysRented){
        if (daysRented > 1)
            return 2;
        else
            return 1;
    }
}
