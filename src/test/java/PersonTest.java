import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;

public class PersonTest {


    @Test
    public void shouldBeEqualWhenConvertedToJSONandCreatedFromThatJSON() {
        Gson gson = new Gson();
        Person person1 = new Person("Jarek", "Browarek", 18, 196, new String[]{"Python", "Soccer", "Karate"});
        String json = gson.toJson(person1);
        Person person2 = gson.fromJson(json, Person.class);
        Person actual = person1;
        Person expected = person2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GenericBoxConvertedToJSONAndConvertedBackToGenericBox(){
        Gson gson2 = new Gson();
        Person person3 = new Person("Jarek", "Browarek", 18, 196, new String[]{"Python", "Soccer", "Karate"});
        GenericBox<Person> pBox1 = new GenericBox<Person>(person3);
        String json2 = gson2.toJson(pBox1);
        Type pBox1Type = new TypeToken<GenericBox<Person>>(){}.getType();

        GenericBox<Person> pBox2 = gson2.fromJson(json2, pBox1Type);

        GenericBox<Person> actual = pBox1;
        GenericBox<Person> expected = pBox2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shoulJSON_ContainNulls() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        Person person1 = new Person("Jarek", null, 18, 196, new String[]{"Python", "Soccer", "Karate"});
        String json = gson.toJson(person1);
//        System.out.println(person1);
//        System.out.println(json);
        boolean actual = json.contains("\"lastName\":null");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shoudlMissStringfirstNameAndLastName(){
        Gson gson = new Gson();
        Person2 person = new Person2("Jarek", "Browarek", 18, 196, new String[]{"Python", "Soccer", "Karate"});
        String json = gson.toJson(person);
        System.out.println(person);
        System.out.println(json);
        boolean actual = json.contains("lastName");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

}
