import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {


    @Test
    public void shouldBeEqualWhenCOnvertedToJSONandCreatedFromThatJSON() {
        Gson gson = new Gson();
        Person person1 = new Person("Jarek", "Browarek", 18, 196, new String[]{"Python", "Soccer", "Karate"});
        String json = gson.toJson(person1);
        Person person2 = gson.fromJson(json, Person.class);
        Person actual = person1;
        Person expected = person2;
        Assert.assertEquals(expected, actual);
    }

}
