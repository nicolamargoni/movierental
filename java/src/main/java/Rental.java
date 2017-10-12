public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRendeted() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double amountFor(){
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRendeted() > 2)
                    result += (getDaysRendeted() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRendeted() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRendeted() > 3)
                    result += (getDaysRendeted() - 3) * 1.5;
                break;
        }
        return result;
    }
}
