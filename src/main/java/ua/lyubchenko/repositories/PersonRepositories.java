package ua.lyubchenko.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ua.lyubchenko.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonRepositories implements IRepositories<Person> {
    private static int PEOPLE_COUNT;

    private final List<Person> arrayList = new ArrayList<>();

    {
        arrayList.add(new Person(++PEOPLE_COUNT, "Bob", "A", "@A"));
        arrayList.add(new Person(++PEOPLE_COUNT, "Katrin", "B", "@B"));
        arrayList.add(new Person(++PEOPLE_COUNT, "Mike", "C", "@C"));
        arrayList.add(new Person(++PEOPLE_COUNT, "Jenny", "D", "@D"));
    }

    @Override
    public List<Person> getArrayList() {
        return arrayList;
    }

    @Override
    public Person getPersonById(int id) {
        return arrayList.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public void addPersonToRepository(Person person) {
        person.setId(++PEOPLE_COUNT);
        arrayList.add(person);
    }

    @Override
    public void update(int id, Person person) {
        Person updated = getPersonById(id);
        updated.setName(person.getName());
    }
}
