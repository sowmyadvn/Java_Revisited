# Java Revisited

### Arrays - Lecture 79
```Arrays.copyOf(array,length);``` instead of old for loop copy
Primitive types: int, bool, long etc.   
Reference types: Arrays, lists etc.  

```
int[] array = new int[5];
int[] anotherArray = array;
anotherArray[0] = 1;
```
Impacts both arrays as memory of both arrays is the same

Reference type (array) is passed to the method => Address is copied to the parameter.  
__Hence, Array values change when changed in the method as long as not dereferenced__

```
Arrays.toString(array)
```
prints all the array elements

## Lists and Array Lists - Lecture 81
List Interface extends Collection Interface. ArrayList inherits from List.
ArrayList is a resize-able array. As ArrayLists can hold objects => For example, ArrayList<String> is how arraylists are defined. ArrayList is a class and it can have its own constructor. So, () are required.

```
  arrayList.contains("Sowmya"); 
  
``` 
can be used to search for some value in array list. Time complexity: O(n)

```
  arrayList.getIndex("Sowmya"); //=> return position of value
```
```
  arrayList.get(0); //=> get value at a position
``` 
```
arrayList.set(position,newItem); //set value at a position to a new one
```
```
newArrayList.addAll(oldArrayList); //copy old to new arrayLists
ArrayList<String> newArrayList =  new ArrayList<String>(oldArrayList);
```
```
String[] array = new String[arrayList.size()];
array = arrayList.toArray(array);    //ArrayList to String Array
```

## Auto-boxing and unboxing
Cannot create ArrayList<int> => as int is a primitive type and is not a class
ArrayList<Integer> can be possible. 
String is a class and not a primitive type.  
__What is auto-boxing?__
JAVA suppots primitive types using object-wrappers. Automatic conversion between primitive types and object wrappers is called auto-boxing
Integer is object-wrapper class of int,
Double for double,
Long for long,
Boolean for bool.

```
Integer to int: Integer.valueOf()
int to Integer: arrayList.get(i).intValue()
```
Integer integer = 56; //Code is compiled when typed and auto-boxing happens at compile time  
int myInt = integer; //again works because Java converts it to: (int myInt = integer.intValue();)  


## Lecture-239 Java Concurrency
What's threading?
* Process - Unit of execution and has its own memory space. Each instance of JVM is a process (Each JVM has Heap of its own)
* Thread - unit of execution in process. Every app in java has minimum of one thread and is called main thread. In UI, JavaFX application thread. 
* Memory and files shared by threads. Each thread has its own stack. 
* Why not stick to main thread? Code within each thread executes in linear fashion, so idle time is very high. This wastes resources. Creating thread to do long running task frees main thread and other operations can be performed.Second, API sometimes requires creating another thread.
* Progress can be made on multiple tasks at a time using multi-threading
Note: Threads are scheduled to run differently in every OS and how is dependent on the JVM and OS used.

__Creating threads:__
Two ways to create threads:
* Subclass of Thread Class is created and run() method of it is overriden
* Run only once? Anonymous class
```
new Thread() {
			public void run() {
				System.out.println("Hello from the anoynmous");
			}
		}.start();
```
* Several times?Dont start instance of thread multiple times. Create instance of subclass whenever thread is run.
* We cannot reuse the same instance when already running. So, thread.start() for the second time leads to IllegalThreadStateException
* 


  
