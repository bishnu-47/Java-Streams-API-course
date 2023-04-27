## Notes

- **Predicate:**
  It is functional interface which represents a predicate(boolean valued function) of one argument

```java
public class PredicateInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> pr = a -> (a > 18); // Creating predicate
        System.out.println(pr.test(10)); // Calling Predicate method
    }
}
```

**Output**
false

- **Comparator**
  **Java Comparator interface** is used to order the objects of a user-defined class. It provides multiple sorting
  sequences.

| Method                                         | Description                                                         |
|------------------------------------------------|---------------------------------------------------------------------|
| `public int compare(Object obj1, Object obj2)` | It compares the first object with the second object.                |
| `public boolean equals(Object obj)`            | It is used to compare the current object with the specified object. |
