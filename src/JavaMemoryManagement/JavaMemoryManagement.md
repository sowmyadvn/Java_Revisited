Generally java variables and data structures are either stored in stack or heap.

## Memory rules:    
* Local variables are stored in stack
* Objects are stored in heap
* References to objects are stored in stack

## Pass by value:
* When passed by value, local Variable value isn’t obviously changed. The reason is that when passed by value, copy of local variable is created and updated but not the original value.
* Pass by reference isn’t possible in Java
* For objects, reference to objects is passed by value. So, when an object is passed and its member is changed, automatically it is reflected in the actual object value

## final keyword:
* A variable can only be assigned (similar to constant)
* Can be assigned only once => we cannot change which object in the heap the variable points to
![alt text](https://github.com/sowmyadvn/Java_Revisited/blob/master/src/JavaMemoryManagement/Images/finalKeyWord.jpg)
* The one below is absolutely fine
![alt text](https://github.com/sowmyadvn/Java_Revisited/blob/master/src/JavaMemoryManagement/Images/finalKeyWord_right.jpg)
* const correctness isn’t provided by Java

## Points to note:
When string is passed, if original value has to change, assign as String x = x.setToSomething(); If just x.setToSomething() nothing changes

## Escaping references:
![alt text](https://github.com/sowmyadvn/Java_Revisited/blob/master/src/JavaMemoryManagement/Images/escapeRef.jpg)
* If member is an object or collection, improper operations can be performed by someone accidentally.
* Returning pointers to existing objects is called escaping reference

## Solutions:
1. Iterator: 

* Collections.unmodifyableMap is the best approach to avoid escaping reference
* Collections.unmodifyableList 

If we want to return Customer object, then it is better to use interfaces to avoid escaping reference

## Garbage collector:
* Stack’s scope is tight and variables are cleaned from memory as soon as code is done executing enclosed braces 
* Internalized strings: Even if we think two string objects are created when we say String one = “hello” and two = “hello”, new VMs point to same object to save space.
* Calculated strings aren’t automatically added. So, Adding .intern() to end of method call adds strings to pool to reuse.

## Garbage eligibility:
* Automatic in java but different for every language
* Objects not freed lead to memory leaks
![alt text](https://github.com/sowmyadvn/Java_Revisited/blob/master/src/JavaMemoryManagement/Images/GC%20eligibility.jpg)
* Any object which cannot be reached through reference of the stack is eligible for garbage collection (Unreachable collection is garbage)

## Garbage collection:
* gc() method suggests that JVM runs gc process
* There is no guarantee that gc() actually does garbage collection
![alt text](https://github.com/sowmyadvn/Java_Revisited/blob/master/src/JavaMemoryManagement/Images/freemem.jpg)
* When to tell gc to run? To determine which code block is efficient
* -Xmx10m => max heap size, -Xms10m => starting heap size
* Java Visual VM
* Visual GC, MAT (memory analyzer)
* Old (If a reference survives GC 8 or more times)
* Eden (New processes) -> If survives (S0), then if survives all are moved to S1, then again to S0 and so on. S0 and S1 are called survivor spaces

### Java 6:
* PermGen(permanent generation) is never garbage collected (Internalized strings are never gc’ed) and every time a class is created, metadata for class is stored in permgen 
* When permgen is filled, application crashes
* To avoid crashes, increase allocation memory of permgen 
* A new complete set of metadata info is stored as soon as code is changed in server and is redeployed. Old metadata is also retained leading to increase in permgen storage (as no GC) Eventually, PermGen fills and app crashes. So, Better to stop and start Tomcat every time code changes are done

### Java 7 and after:
* Internal strings are removed from permgen
* Internalized strings are GC'ed
Java 8 and after:
* Permgen is removed and instead metaspace is used to store metadata


## Tuning the VM: Arguments
* -Xmx - Maximum heap size. Default: Quarter of memory size
* PermGen size: -XX:MaxPermSize=512m
* -verbose:gc
* 1/3rd of total heap size is young gen. Young gen 1/2 to 1/4 of overall heap size  -Xmn256m(max as well as initial)
* -XX:HeapDumpOnOutOfMemory: create heap dump 

3 types of gc collector:
* Serial collector:Single thread to perform gc work. -XX:+UseSerialGC
* Parallel: multiple threads running and doing GC. For larger data sets, also called throughput collector -XX:UseParallelGC
* Mostly concurrent GC: it’s the closes we can get to real-time GC. No need to pause during sweep phase. Application is however stopped in mark phase. Two types of mostly concurrent GCs => mark sweep collector and G1GC => -XX:+UseMarkSweepCollector and -XX:+UseG1GC
* -XX:+PrintCommandlineFlags to find default GC




