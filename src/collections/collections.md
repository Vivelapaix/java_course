# Collections

#### Interfaces

Base

```java
public interface Collection<E> extends Iterable<E> {}

public interface List<E> extends Collection<E> {}
public interface Set<E> extends Collection<E> {}
public interface Queue<E> extends Collection<E> {}
public interface Deque<E> extends Queue<E> {}
```

and

```java
public interface Map<K, V> {}
```

#### Implementations

* General-Purpose Implementations

```java
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {}
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {}
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable {}

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {}
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {}

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {}
public class TreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable {}
public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {}

public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {}

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {}
```

* Abstract Implementations

```java
see above
```

* Convenience implementations

```java
Arrays.asList()
Collections.singletonList()
Collections.singletonMap()
Collections.emptyList()
Collections.emptySet()
Collections.emptyMap()
```

#### Iterator

```java
List<String> list = new ArrayList<>();
list.add("Title");
list.add("SourceLink");
list.add("TaskSolution");

for (String item : list) {
    System.out.println(item);
}

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

#### Class Collections

This class consists exclusively of static methods that operate on or return collections. It contains algorithms that operate on collections.

```java
Collections.sort()
Collections.binarySearch()
Collections.reverse()
Collections.fill()
```

#### Interface Stream

```java
public interface Stream<T> extends BaseStream<T, Stream<T>> {}
```

Example 1
```java
List<String> sites = Arrays.asList(
    "https://coursera.org", "http://mysite.ru", "https://stepik.org", "https://leetcode.com"
);
List<String> result = sites.stream().filter(s -> s.startsWith("https")).map(s -> {
    return s.split("https://")[1];
}).map(String::toUpperCase).sorted().collect(Collectors.toList());
result.forEach(System.out::println);
```

Example 2

```java
see BaseCollection class
```




