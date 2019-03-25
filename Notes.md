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

## Interfaces vs Abstract classes
http://mindprod.com/jgloss/interfacevsabstract.html#TABLE

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
__Extend Thread class__
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

__Implement Runnable Interface:__
* An anonymous class can also implement Runnable and pass an instance of it to constructor
* Runnable is convenient because of lambda expressions since Java 8. More flexible and recommended.
* Don't call run(), always call start(). Else, run() performs operations on thread that called run() method


* Interrupted Exception if thread is woken up by another thread.
* Interrupts can occur when monitoring thread needs to terminate => 
	1. Catch interrupted exception
	2. Interrupt method can be called on instance of the thread
	
### Interrupts and Joins in threads
``` Thread.sleep(9000) // 9 second sleep ```
``` threadName.interrupt() //interrupts threadName ```
Joining thread means first thread waits for second thread to terminate and continues executing then
```threadName.join() or join(timeout); ```
setPriority() method forces thread to run in particular order, but depends on the OS

### Multi-threading
Why is the output out of order and i quite not decreasing when i is instance variable and shared between threads in the code below?  
Heap is the application memory shared by threads, where as thread stack is not. Local variables are stored in thread stack and instance value is allocated on the heap. Instance variable is hence shared among threads. 

```
class CountDown {
	private int i; //if i is private instance variable, then both together make i zero, not two separate i values
	public void doCountDown() {
		String color;
		switch(Thread.currentThread().getName()) {
			case "Thread 1": 
					color = ThreadColor.ANSI_CYAN;
					break;
			case "Thread 2":
					color = ThreadColor.ANSI_PURPLE;
					break;
			default:
					color = ThreadColor.ANSI_RED;
					break;
		}

		for(i = 10; i > 0; i--) { // If i is local variable, thread 1 and 2 create separate count downs
			System.out.println(color + Thread.currentThread().getName()+":"+i);
		}
 }
```


When switching between threads, a thread can be suspended for another to resume in potential three conditions for a 'for loop':
* Before checking the condition
* Before decrementing and 
* Before printing the value etc.   
There are many others, but below are potential suspension points
10 10 => Thread1 suspended before decrementing the value, so thread2 has 10 too  
The skipping of values also occurs due to __thread interference__ or __race condition__. Occurs when one of the threads is writing or updating a resource.
T2: 4 2 T1: 3 => Why did t1 print 3? There are potential suspension points within print() statement, and before t1 could prepare the method result and print, it is suspended. So, value 3 is still stored in T1. T2 completely printd 4 and 2, and T1 resumes from printing 3 and reducing it to 1.  

### Preventing race condition
Possibilities:  
* Creating two instances of the CountDown object would prevent race condition but that doesn't work in the real-world applications, as resources might be limited or data integrity needs to be maintained like Bank balance or employee record.
* Synchronization is making sure data integrity is maintained by allowing only one thread to write or read at a time. Only then that the heap can be accessed.

__Synchronization:__  
Synchronization can be applied to methods or statements.
__Method synchronization:__
* __synchronized__ keyword is used to synchronize a whole method
__Statement synchronization:__ 
It is called as __intrinsic lock or monitor__ 
* Only one thread can access the lock at a time
* Statements cannot be synchronized (Intrinsic locks cannot be primitives) by primitive variables.
* Local variables (except STRINGS) cannot be used for intrinsic locks, because a copy of local variables is created on each thread's stack leading to locks on their own copies.
* String objects are reused within jvm. JVM uses string pools for allocation of string objects.
* ***When using local variables, references are stored on thread stack, where as values are stored on the heap*** 
Note:
* **Local variables cannot be used to synchronize, as synchronization requires threads competing for the same object**
* Only one synchronized method can run at a time and only one thread can access it even if there are three synchronized methods and 100 threads waiting to access the synchronized methods.
* When synchronized keyword is used, a thread completes executing a method before another one can access it.
* Static methods can be synchronized. And when done, lock will be associated with class object. 
* Re-entrant => if a thread acquires lock on an object and within the synchronized code, calls the method that's using the synchronized code, it can keep executing. Thread can acquire a lock it already owns. 
* Critical section: Code that requires lock to allow multi-threading. Only one thread at a time can access critical section.
* Thread-safe: Developer synchronized the code and we need not worry about critical sections.
* Synchronized code must be minimal to avoid blocking threads unnecessarily. Statement synchronization is better than method synchronization


### Producer - consumer problem:
__Methods that can be called only in critical section:__
Wait, notify and notifyAll methods
Try, finally with threads  
Re-entrant locks   
java.util.concurrent and java.util.concurrent.locks  
tryLock() method  
ExecutorService and Executors to optimize thread management. ExecutorException and InterruptedException to handle interruptions or execution issues.    
submit() method: To get value in return from a thread executing in background. Accepts callable object, which is similar to runnable but returns the result. Return of type __Future__.   
``` Future<String> future = ExecutorService.submit(new Callable<String>());```
ArrayBlockingQueue class: instead of a list used in the producer and consumer. put(), peek() and take() methods block where as add() and remove() throw exceptions when cannot be performed.  
Also, put is a thread-safe method. peek() doesn't block, but returns null when queue is empty.  => Null Pointer Exception 
Synchronization is still required when using thread-safe methods.  

### Deadlocks:


### Lambda expressions
lambda expression follows the basic syntax:

(parameter list) OR single_variable_without_type -> { regular lines of code ; } OR just_an_expression_without_semicolon
A comma-separated list of formal parameters enclosed in parentheses. You can omit the data type of the parameters in a lambda expression. In addition, you can omit the parentheses if there is only one parameter.
The arrow token: ->
A body, which consists of a single expression or a statement block.
If you specify a single expression, then the Java runtime evaluates the expression and then returns its value. Alternatively, you can use a return statement.
A return statement is not an expression; in a lambda expression, you must enclose statements in braces ({}). However, you do not have to enclose a void method invocation in braces.
Note that a lambda expression looks a lot like a method declaration, you can consider lambda expressions as anonymous methods, methods without a name. When you write a lambda expression for a functional interface, you are essentially providing an implementation of the method declared in that interface but in a very concise manner. Therefore, the lambda expression code that you write must contain all the pieces of the regular method code except the ones that the compiler can easily figure out on its own such as the parameter types, return keyword, and brackets.

A lambda expression does not create a new scope for variables. Therefore, you cannot reuse the variable names that have already been used to define new variables in your argument list .
The body of the lambda expression must return a boolean.
If you write a return statement in your method body, you must enclose it within curly braces and include the semi-colon.

