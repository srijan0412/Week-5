import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    public String name;
    public String email;
    public int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

public class JavaObjectsToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("John Doe", "john@example.com", 30),
                new Person("Alice Smith", "alice@example.com", 25),
                new Person("Bob Johnson", "bob@example.com", 35)
        );

        // Convert list to JSON array
        String jsonArray = objectMapper.writeValueAsString(people);

        // Print JSON output
        System.out.println(jsonArray);
    }
}
