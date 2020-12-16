package by.kotoki.webapp.dao;

import by.kotoki.webapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Jhonny", 52, "johnny@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ember", 21, "ember@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tony", 24, "tony@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Gerold", 54, "gerold@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kid", 14, "kid@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Edvard", 47, "edvard@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Leo", 69, "leo@mail.ru"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person ->person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p->p.getId() == id);
    }
}
