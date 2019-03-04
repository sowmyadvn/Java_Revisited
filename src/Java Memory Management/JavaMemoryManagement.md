Generally java variables and data structures are either stored in stack or heap.

##Memory rules:    
* Local variables are stored in stack
* Objects are stored in heap
* References to objects are stored in stack

##Pass by value:
* When passed by value, local Variable value isn’t obviously changed. The reason is that when passed by value, copy of local variable is created and updated but not the original value.
* Pass by reference isn’t possible in Java
* For objects, reference to objects is passed by value. So, when an object is passed and its member is changed, automatically it is reflected in the actual object value

##final keyword:
* A variable can only be assigned (similar to constant)
* Can be assigned only once => we cannot change which object in the heap the variable points to
* The one below is absolutely fine
* const correctness isn’t provided by Java

##Points to note:
When string is passed, if original value has to change, assign as String x = x.setToSomething(); If just x.setToSomething() nothing changes





