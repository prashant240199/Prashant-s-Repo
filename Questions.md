1. Why String is immutable? What happens if string were mutable?
Ans - String is immutable to ensure security, thread safety and efficient memory usage via String Pool. 
In collections like HashMap, immutability ensures that the hashcode of the key remains constant.

If String were mutable it leads to change in the hashcode of the key which creates inappropriate behaviour while retrieving data.

2. Explain internal working of HashMap?
Ans - HashMap interally uses array of buckets to store key-value where each bucket can store multiple entries in the form of linked list or balanced tree. The trrify threshold value of the hashmap is 8.

Flow:
1. When a key-value pair is inserted, HashMap calls the hashcode() method of the key.
2. The hash is then converted into an index using (n-1) & hash where n is array size.
3. The entry is stored at that index inside bucket.
4. If multiple key map to the same index (collision), they are stored in a linked list.
5. If bucket size exceeds 8, it is converted into a red-black tree for better performance.
6. During retrieval, hashcode is used to find the bucket and equals() used to find exact key.

Also when size exceeds threshold (capacity * load factor), HashMap resizes and rehashes entries.

T.C - Average time complexity is O(1), in worst case (heavy collisions), it can go upto O(log n) after treeification.

3. Why hashCode() and equals() both are required in HashMap? Sirf ek se kaam kyun nahi chal sakta?
Ans - Hashcode() is used to determine the bucket location, while equals() is used to compare keys within that bucket to find the exact match.
If we use only hashCode(), then multiple keys can have same hashCode (collision), so we won't able to identify the correct key.
If we use only equals(), then we would have to search for all keys in the hashMap, making it inefficient with O(n) complexity.
So, hashCode() provides fast access, and equals() ensures accuracy.

Note: hashCode improves performance while equals ensures correctness.

4. Agar 2 objects ka hashCode same ho but equals() false ho to kya hoga?
Ans - If 2 objects have the same hashCode but equals() return false, they will be stored in the same bucket due to collision but as separate entries. During retrieval, equals() is used to identify the correct key, so there will be no issue in fetching the correct value.

hashCode = konse room me jana hai
equals = room ke andar konsa banda hai

5. Agar equals() true ho but hashCode different ho to kya problem hogi?
Ans - In java, if equals() returns true, then hashCode() must also return the same value. This is part of the contract.

If this rule is violated, then HashMap may store equal objects in different buckets, because hashCode is used to determine the bucket.

As a result, during retrieval, the object may not be found even though it logically exists, leading to inconsistent behaviour.

Note: This breaks the HashMap contract and leads to data retrieval failure.

6. ArrayList vs LinkedList - real-world use case ke saath bata?
Ans - ArrayList is based on a dynamic array, while LinkedList is based on a doubly linked list.

ArrayList provides fast random access (O(1)) because it uses indexing, but insertion and deletion are slower due to shifting of elements.

LinkedList provides faster insertion and deletion (O(1)) because it only updates pointers, but access time is slower (O(n)) as it requires traversal.

Use case:

ArrayList is preferred when frequent read operations are required.
LinkedList is preferred when frequent insertions and deletions are required, especially in the middle.

Note : ArrayList is better for search-heavy operations, while LinkedList is better for modification-heavy operations.

7. HashSet aur TreeSet me difference kya hai? Aur internally kaise kaam karte hain?
Ans - HashSet and TreeSet both implement Set interface and do not allow duplicate elements.

HashSet is backed by a HashMap and uses hashing for storage. It does not maintain any order and provides O(1) average time complexity.

TreeSet is backed by a Red-Black Tree and maintains elements in sorted order. It provides O(log n) time complexity.

Differences:

HashSet → Unordered, faster
TreeSet → Sorted, slower

Internal working:

HashSet stores elements as keys in a HashMap
TreeSet stores elements in a self-balancing Red-Black Tree

Other points:

HashSet allows one null value
TreeSet does not allow null (throws exception)

Use case:

HashSet → when order is not required and performance matters
TreeSet → when sorted data is required

Note : HashSet is optimized for performance, TreeSet is optimized for ordering.

8. HashMap thread-safe nahi hai — to uska alternative kya hai? Aur wo internally kaise kaam karta hai?
Ans - We can use ConcurrentHashMap as a thread-safe alternative to HashMap.

Unlike HashMap, it allows multiple threads to read and write simultaneously without locking the entire map.

Internally, it uses segment-level locking (in older versions) or bucket-level locking (in Java 8+), which means only a portion of the map is locked instead of the whole map.

This improves performance compared to Hashtable, which locks the entire map.

Note : ConcurrentHashMap provides thread safety with better performance using fine-grained locking.

9. Thread aur Process me difference kya hai? Real-life example ke saath bata.
Ans - A process is an independent program in execution with its own memory space, while a thread is the smallest unit of execution within a process.

A process is heavy-weight as it has separate memory and resources, whereas threads are lightweight as they share the same memory within a process.

Example: A browser, each tab is a process, and within a tab, multiple threads handle tasks like rendering, loading, and user interaction.

Note : “Process is isolated and heavy, while threads are lightweight and share resources.”

10. Thread create karne ke 2 tarike kya hain? Kaunsa better hai aur kyun?
Ans - There are two ways to create a thread:
    1. By extending the Thread class
    2. By implementing the Runnable interface

Implementing Runnable is preferred because it allows the class to extend another class as Java does not support multiple inheritance with classes.

Also, Runnable separates the task from the thread, making the design more flexible and reusable.

Note : “Runnable is preferred because it promotes better design by separating task and thread.”

11. Synchronization kya hota hai? Agar na kare to kya problem hogi?
Ans - Synchronization is a mechanism to control access to shared resources so that only one thread can access the critical section at a time, preventing data inconsistency.

If synchronization is not used, multiple threads can modify shared data simultaneously, leading to race conditions and unpredictable results.

For example, if two threads increment a shared counter without synchronization, the final value may be incorrect due to overlapping operations.

Note : “Synchronization ensures data consistency in multithreaded environments.”

12. sleep() aur wait() me difference kya hai?
Ans - sleep() is a method of Thread class that pauses the execution of the current thread for a specified time, but it does not release the lock.

wait() is a method of Object class that causes the current thread to release the lock and go into waiting state until another thread calls notify() or notifyAll().

Also, wait() must be called inside a synchronized block, while sleep() can be called anywhere.

Note : “sleep() pauses thread execution, while wait() is used for inter-thread communication.”

13. Deadlock kya hota hai? Real-life example de.
Ans - Deadlock is a situation where two or more threads are permanently blocked because each thread is waiting for a resource held by another thread.

This happens when threads hold one resource and wait for another, creating a circular dependency.

For example, if Thread A holds resource 1 and waits for resource 2, while Thread B holds resource 2 and waits for resource 1, both threads will be stuck forever.

Note : “Deadlock occurs due to circular waiting and improper resource handling.”

14. Checked vs Unchecked exception?
Ans - Checked exceptions are exceptions that are checked at compile time. The compiler forces us to handle them using try-catch or declare them using throws.

Example: IOException, SQLException.

Unchecked exceptions are exceptions that occur at runtime and are not checked at compile time. They usually happen due to programming mistakes.

Example: NullPointerException, ArithmeticException.

The key difference is that checked exceptions must be handled explicitly, whereas unchecked exceptions are not mandatory to handle.

Note : “Checked exceptions are compile-time enforced, while unchecked exceptions indicate programming errors at runtime.”

15. throw aur throws me difference kya hai?
Ans - throw and throws are used for exception handling but they serve different purposes.

👉 throw is used to explicitly throw an exception inside a method or block.
It is used with an exception object.

Example:
throw new ArithmeticException("error");

👉 throws is used in method signature to declare exceptions that a method might throw.
It is mainly used to propagate exceptions to the caller.

Example:
void readFile() throws IOException { }

Key difference:

throw is used to actually throw an exception
throws is used to declare an exception

Note : “throw is for manual exception creation, while throws is for exception declaration and propagation.”

16. Difference between List, Set and Map? But give real-world use case also.
Ans - List, Set and Map are core collection interfaces with different use cases.

👉 List allows duplicate elements and maintains insertion order. It also supports indexing, making it useful when we need ordered data and frequent access by index.
Example: storing user order history.

👉 Set does not allow duplicate elements. Some implementations like HashSet do not maintain order, while LinkedHashSet maintains insertion order and TreeSet maintains sorted order.
Example: storing unique email IDs.

👉 Map stores key-value pairs where keys are unique. It provides fast lookup using keys. Some implementations like HashMap are unordered, LinkedHashMap maintains insertion order, and TreeMap maintains sorted order.
Example: storing userId → user details.

Overall:
List → ordered data
Set → unique data
Map → key-based retrieval

17. Kya Set me order hota hai? Agar haan to kaunse implementations me?
Ans - Yes, order can be maintained in Set depending on the implementation.

HashSet → does not maintain any order
LinkedHashSet → maintains insertion order
TreeSet → maintains sorted order using a Red-Black Tree

Note : “So, Set itself does not guarantee order, but its implementations define the ordering behavior.”

18. Comparable aur Comparator me difference kya hai? Aur real-world scenario me kab use karoge?
Ans - Comparable and Comparator are used for sorting in Java.

👉 Comparable is used to define natural ordering of objects and the sorting logic is written inside the class using compareTo() method.

👉 Comparator is used to define custom sorting and the logic is written outside the class using compare() method.

Use case:

Comparable → when we want default sorting (e.g., sort students by age)
Comparator → when we want multiple sorting options (e.g., sort by name, then by age)

Note : “Comparable defines natural ordering, while Comparator provides flexible and multiple sorting strategies.”

19. Java me sorting internally kaunsi algorithm use hoti hai? Aur wo stable hai ya nahi?
Ans - Java uses TimSort for sorting objects, which is a hybrid of Merge Sort and Insertion Sort. It is stable, meaning it maintains the relative order of equal elements.

Note : “TimSort is optimized for real-world data and performs efficiently on partially sorted data.”

20. Agar Comparable aur Comparator dono defined ho to kaunsa use hoga?
Ans - If both Comparable and Comparator are defined, then it depends on how sorting is performed.

If we use Collections.sort(list) → Comparable is used (natural ordering)
If we use Collections.sort(list, comparator) → Comparator is used (custom ordering)

Comparator always overrides Comparable when explicitly provided.

Note : “Comparator takes priority when explicitly passed, otherwise Comparable is used by default.”