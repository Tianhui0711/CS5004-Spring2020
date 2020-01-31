import java.util.Objects;

public class Book {
    private String title;
    private Person author;
    private double price;

    /**
     * Construct a Book object that has the
     * provided title, author and  price
     *
     * @param title the title to be given to this book
     * @param author the author to be given to this book
     * @param price the price to be assigned to this book
     */
    public Book(String title, Person author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Return the author of this object
     * @return the author of this object
     */
    public Person getAuthor() {
        return this.author;
    }

    /**
     * Return a formatted string that contains the information
     * of this object. The string should be in the following format:
     *
     * Title: [title of the book]
     * Author: [first-name last-name]
     * Price: [Price as a decimal number with two numbers after decimal]
     *
     * @return the formatted string as above
     */
    public String toString() {
        String res = "Title: ";
        res = res + this.title + "\n";
        res = res + "Author: ";
        res = res + this.author + "\n";
        res = res + "Price: ";
        res = res + this.price;

        return res;
    }

    /**
     * Compute and return the price of this book with the given discount (as a
     * percentage)
     *
     * @param discount the percentage discount to be applied
     * @return the discounted price of this book
     * @throws IllegalArgumentException if a negative discount is passed as an
     * argument
     */
    public double salePrice(int discount) throws IllegalArgumentException {
        if (discount <= 0) {
            throw new IllegalArgumentException("negative discount");
        }
        return this.price - (this.price * discount) / 100.0;
    }

    /**
     * check if this book has the same author as another
     * and return true if so, false otherwise
     * @param b the other book
     * @return true if the two books have the same author, false otherwise
     */
    public boolean sameAuthor(Book b) {
        Person p1 = this.author;
        Person p2 = b.getAuthor();

        return p1.getFirstName().equals(p2.getFirstName())
                && p1.getLastName().equals(p2.getLastName());
    }

    /**
     * Create a sequel of this book
     * the sequel of the book adds "II" to the title of the book, and its price increases by twice
     * @return the sequel of the book
     */
    public Book createSequel() {
        String newTitle = this.title + " II";
        double newPrice = this.price * 2.0;

        Book newBook = new Book(newTitle, this.author, newPrice);

        return newBook;
    }


    /**
     * check if this book is the same as the book in the argument.
     * two books are the same if they have the same price, title and author
     * @param o the other book to be compared to
     * @return true if this book is the same as other, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }
}
