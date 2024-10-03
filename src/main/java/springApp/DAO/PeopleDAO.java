package springApp.DAO;

import org.springframework.stereotype.Component;
import springApp.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PeopleDAO {
    private static int PEOPLE_COUNTER;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNTER, "Max"));
        people.add(new Person(++PEOPLE_COUNTER, "Jack"));
        people.add(new Person(++PEOPLE_COUNTER, "John"));
        people.add(new Person(++PEOPLE_COUNTER, "Jane"));
    }

    public void create(Person person) {
        people.add(person);
    }

    public List<Person> read(){
        return people;
    }

    public Person read(int id) {
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}
