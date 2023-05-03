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

### **Consumer**

In Java, a consumer is a functional interface that represents an operation that takes in a single input argument and
doesn't return any result. It is part of the java.util.function package and can be used to pass behavior as a parameter
in methods.

Example:

```java
public class ConsumerExample {
    public static void main(String[] args) {

        // Create a consumer that prints a String
        Consumer<String> printString = s -> System.out.println(s);

        // Use the consumer to print a String
        printString.accept("Hello, World!");

        // Create a consumer that appends a String to a StringBuilder
        Consumer<StringBuilder> appendString = sb -> sb.append("Hello, World!");

        // Use the consumer to append a String to a StringBuilder
        StringBuilder sb = new StringBuilder();
        appendString.accept(sb);
        System.out.println(sb.toString());
    }
}
```

In this example, we create two consumers: printString and appendString. The printString consumer takes in a String
argument and prints it to the console using System.out.println(). The appendString consumer takes in a StringBuilder
argument and appends the string "Hello, World!" to it.

We then use the consumers to print a string and append a string to a StringBuilder. The accept() method is used to pass
the input argument to the consumer and execute the operation.

### **BiConsumer**

In Java, a biconsumer is a functional interface that takes in two input arguments and performs some operation on them.
It is defined in the java.util.function package and has a single method, accept(), which accepts two arguments and
returns no result.

Example:

```java
public class BiconsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printDetails = (name, age) -> System.out.println(name + " is " + age + " years old.");
        printDetails.accept("John", 30);
    }
}
```

Output:

```text
John is 30 years old.
```

In this example, we have created a Biconsumer called printDetails that takes in two input arguments: a String for the
name and an Integer for the age. The accept() method is then used to print out the details of the person with the given
name and age.

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

### Additional Notes

#### Function.identity():

In Java, Function.identity() is a static method that returns a Function which simply returns its input argument. It is
often used as a placeholder when a Function is expected but no transformation is needed.

For example, if you have a list of strings and you want to create a new list with the same elements as the original
list, you can use Function.identity() as the mapping function:

```java
List<String> originalList=Arrays.asList("apple","banana","cherry");
        List<String> newList=originalList.stream()
        .map(Function.identity())
        .collect(Collectors.toList());
```

In this example, Function.identity() acts as a pass-through function that returns the input argument (i.e. the string)
as is.