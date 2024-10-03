package springApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private static int PEOPLE_COUNTER = 0;

    private int id;
    private String name;
}
