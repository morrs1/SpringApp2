package springApp.DAO;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import springApp.models.Person;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleDAO {

    private JdbcTemplate jdbcTemplate;

    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO people (id, name, surname, age, email) VALUES (1,?,?,?,?)",
                person.getName(), person.getSurname(), person.getAge(), person.getEmail()
        );
    }

    public List<Person> read() {
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person read(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM people WHERE id=?",
                preparedStatement -> preparedStatement.setInt(1, id),
                new BeanPropertyRowMapper<>(Person.class)
        ).stream().findFirst().orElse(null);

    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }

    public void update(Person updatedPerson) {
        jdbcTemplate.update("UPDATE people SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), updatedPerson.getId());
    }
}
