package springApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private static int PEOPLE_COUNTER = 0;

    private int id;
    private String name;
    private String surname;
    private String email;
}
