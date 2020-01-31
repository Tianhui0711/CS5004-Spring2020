import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a Person object and initializes it
     * to the given first name, last name and year of birth
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     Returns a string representation of this person with first
     and last name
     @return a formatted string
     */
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Get the first name of this person
     * @return the first name of this person
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Return the last name of this person
     * @return the last name of this person
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * check if this person is the same as the person in the argument.
     * two persons are the same iff they have the same first and last names
     * @param o the other person to be compared to
     * @return true if this person is the same as other, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName);
    }
}
