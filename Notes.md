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
