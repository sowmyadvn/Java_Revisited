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




  
