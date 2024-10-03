package springApp.DAO;

import org.springframework.stereotype.Component;
import springApp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private static int PEOPLE_COUNTER;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNTER, "Max", "Smith", "gg@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Jack", "Black", "aa@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "John", "White", "bb@gmail.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Jane", "Blue", "cc@gmail.com"));
    }

    public void create(Person person) {
        person.setId(++PEOPLE_COUNTER);
        people.add(person);
    }

    public List<Person> read() {
        return people;
    }

    public Person read(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
