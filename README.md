## Notes

### **Method Reference**

Method reference is a shorthand syntax that allows you to refer to an existing method by its name. It is used to
simplify lambda expressions that are calling existing methods.

There are four types of method references in Java 8:

1. Reference to a static method: `ClassName::methodName`
2. Reference to an instance method of an object: `objectName::methodName`
3. Reference to an instance method of a class: `ClassName::methodName`
4. Reference to a constructor: `ClassName::new`

```java
public class Example {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emily");

        // Using a lambda expression
        names.forEach((name) -> System.out.println(name));

        // Using a method reference
        names.forEach(System.out::println);
    }
}
```

### **Predicate:**

Predicate is a functional interface that represents a boolean-valued function that takes a single input argument and
returns a boolean value. The input argument is typically an object, and the function tests some condition on the input
object and returns true or false.

```java
public class PredicateInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> pr = a -> (a > 18); // Creating predicate
        System.out.println(pr.test(10)); // Calling Predicate method
    }
}
```

**Output:**
false

### **Comparator**

Comparator is a functional interface that allows you to compare two objects of the same type. It has a single abstract
method compare(T o1, T o2) that returns a negative integer, zero, or a positive integer depending on whether the first
argument is less than, equal to, or greater than the second argument.

| Method                                         | Description                                                         |
|------------------------------------------------|---------------------------------------------------------------------|
| `public int compare(Object obj1, Object obj2)` | It compares the first object with the second object.                |
| `public boolean equals(Object obj)`            | It is used to compare the current object with the specified object. |

```java
public class Example {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Emily");

        // Sorting the list in ascending order
        Comparator<String> ascendingOrder = (s1, s2) -> s1.compareTo(s2);
        Collections.sort(names, ascendingOrder);
        System.out.println(names);

        // Sorting the list in descending order
        Comparator<String> descendingOrder = (s1, s2) -> s2.compareTo(s1);
        Collections.sort(names, descendingOrder);
        System.out.println(names);
    }
}
```

### **Optional**

In Java, the "optional" is a container object that may or may not contain a value. It is a way to represent the absence
of a value in a type-safe manner, without resorting to using "null".

Example:

```java
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        // Create an Optional that contains a value
        Optional<String> optionalValue = Optional.of("Hello, World!");

        // Print the value if it is present
        optionalValue.ifPresent(System.out::println);

        // Create an Optional that does not contain a value
        Optional<String> emptyValue = Optional.empty();

        // Print the value if it is present
        emptyValue.ifPresent(System.out::println);

        // Get the value from an Optional or return a default value
        String value = optionalValue.orElse("Default value");
        System.out.println(value);

        // Get the value from an Optional or throw an exception
        String nonNullValue = optionalValue.orElseThrow(IllegalArgumentException::new);
        System.out.println(nonNullValue);
    }
}
```

In this example, we create two Optional objects: one that contains the string "Hello, World!", and another that is
empty. We use the ifPresent() method to print the value of the Optional if it is present.

We also use the orElse() method to get the value of the Optional, or a default value if it is empty. Finally, we use the
orElseThrow() method to get the value of the Optional or throw an exception if it is empty.