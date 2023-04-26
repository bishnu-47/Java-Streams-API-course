package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    System.out.println("Range Exclusive");
    IntStream.range(0, 10).forEach(System.out::println);

    System.out.println("Range Inclusive");
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    IntStream.range(0, people.size())
            .forEach(num -> System.out.println(people.get(num)));
  }

  @Test
  public void intStreamIterate() throws Exception {
    IntStream.iterate(0, operand -> operand+1)
            .filter(num -> num %2 != 0)
            .limit(20)
            .forEach(System.out::println);
  }
}
