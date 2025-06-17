## Dart

**Dart** is an **open-source**, **general-purpose**, **object-oriented** programming language with C-style syntax developed by **Google** in 2011\.

### Dart Execution model
When you start a Flutter/Dart application, a new Thread process is created and launched.
So, when this thread is created, Dart automatically:-  
1\. Initialises 2 Queues, naming "**MicroTask**" and "**Event**" FIFO queues.  
2\. Executes the **main()** method and, once this code execution is completed  
3\. Launches the **Event Loop**.

![][image1]

**Event Loop**  
During the whole life of the thread, a single internal and invisible process called the "Event Loop", will drive the way your code will be executed and in which sequence order, depending on the content of both MicroTask and Event Queues.
````dart
void eventLoop() {  
     while(microTaskQueue.isNotEmpty) {  
         fetchFirstMicroTaskFromQueue();   
         executeThisMicroTask();  
         return;      
     }  
       
     if(eventQueue.isNotEmpty) {  
         fetchFirstEventFromQueue();  
         executeThisEventRelatedCode();  
     }  
}
````

**MicroTask Queue**  
The MicroTask Queue is used for very short internal actions that need to be run asynchronously, right after something else completes and before giving the hand back to the Event Queue.  
As we can see the MicroTask Queue has precedence over the Event Queue.

**Event Queue**  
The Event Queue is used to reference operations that result from external events such as I/O, gesture, drawing, timers, streams, futures.  
As soon as there is no longer any micro task to run, the Event Loop considers the first item in the Event Queue and will execute it.

### What is a pub tool?
Pub is the package manager for the Dart programming language, containing reusable libraries & packages for Dart programs.  
Some basics command:  
**pub get**  //to get dependencies  
**pub upgrade**  //to upgrade dependencies  
**pub publish**  //to make your library available for others.

### Language Basics

**Variables**
```dart
Ex:- var name = 'Deven';
String name = 'Deven'; 
String? Name; // Null Safe   
```
**Late variable**
If you're sure that a variable is set before it's used, but Dart disagrees, you can fix the error by marking the variable as late:
```dart
late String description;
```

**Lazy variable**
When you mark a variable as late but initialize it at its declaration, then the initializer runs the first time the variable is used.  In the following example, if the temperature variable is never used, then the expensive `readThermometer()` function is never called:
```dart
late String temperature = readThermometer(); // Lazily initialized.
```

**Final & Const variable**
If you never intend to change a variable, use final or const, either instead of var or in addition to a type. A final variable can be set only once; a const variable is a compile-time constant. (Const variables are implicitly final.)
```dart
final name = 'Bob'; // Without a type annotation  
final String nickname = 'Bobby';  
const name = 'Bob'; // Without a type annotation  
const String nickname = 'Bobby';
```

**Difference b/w Object, dynamic and var**  
In Dart, Object, dynamic, and var are used for variable declarations but differ in how types are handled:

***Object***:   The base class for all types in Dart. Variables declared as Objects can hold any type of value, but you need to explicitly cast them when accessing methods or properties specific to that type. ex-
```dart
Object obj = “Hello”;     
(obj as String).length;
```

***Dynamic***:  Allows any type, similar to Object, but without the need for casting. The type is determined at run time. ex-
```dart
dynamic obj = “Hello”;  
obj.length;
```

***Var***:  No need for explicit casting. The type is determined at compile time.ex-
```dart
var obj = “Hello”;  
obj.length;
```

**Access Modifiers**  
In Dart privacy is at library level rather than Class level,
***Private***: We can make private using underscore prefix (\_)  eg- `String _name = “deven”;`
***Public***: By default everything in dart is public
***Protected***: Not supported in dart

### Collection literals
Dart has built-in support for lists, maps, and sets. You can create them using literals:

**List**  
A list is an ordered collection of data that is stored and referenced as a single entity. Each element in the list is accessed by its index,
```dart
final aListOfStrings = ['one', 'two', 'three'];  
final aListOfInts = <int>[ ]; // Dynamic list  
final aListOfInts = List.filled(3 , 0); // List with Fixed length of 3 
```
**Set**  
A set is a collection of unique items. Unlike lists, sets are particularly unique data structures that ensure duplicate values do not exist in the collection.
```dart
final aSetOfStrings = {'one', 'two', 'three'};  
final aSetOfInts = <int>{};
```
**Map**  
A map is a dynamic, generic collection of items stored as a key-value pair. The keys are unique entities that serve to reference and retrieve their respective values.
```dart
final aMapOfStringsToInts = {  'one': 1, 'two': 2, 'three': 3};  
final aMapOfIntToDouble = <int, double>{};

// Iterating a map:
for(String k in map.keys) {  
       print(map[k]);  
}
```
**Stack**  
A stack is an abstract collection that stores data in an ordered sequence. There is only one point of entry and exit in a stack, It use LIFO method to insert and remove the data, using push and pop functions.  
Dart uses an external package to implement the stack data structure.
```dart
Stack dynamicStack = Stack();  
Stack<int> intStack = Stack();
```
### Extension
Extension methods add functionality to existing class without extending them.
```dart
extension NumberParsing on String {
   int parseInt() {
     return int.parse(this);
   }
   // ···
 }
 print('42'.parseInt()); // Use an extension method.
```


### Callable objects
To allow an instance of your Dart class to be called like a function, implement the **call()** method.(Its similar to invoke operator in kotlin)
```dart
class WannabeFunction {  
  String call(String a, String b, String c) => '$a $b $c!';  
}
var wf = WannabeFunction();  
var out = wf('Hi', 'there,', 'gang');
```
## Mixins

Mixins are a way of reusing code in multiple class hierarchies. The following is a mixin declaration
```dart
mixin Piloted {  
  int astronauts = 1;  
  void describeCrew() {  
    print('Number of astronauts: $astronauts');  
  }  
}  
// To add a mixin's capabilities to a class, just extend the class with the mixin.  
class PilotedCraft extends Spacecraft with Piloted {  
// PilotedCraft now has the astronauts field as well as the describeCrew() method.
 ···  
}
```


### Cascades operator
To perform a sequence of operations on the same object, use cascades **(..)** We've all seen an expression like this:  
Using cascades, you can chain together operations that would otherwise require separate statements. For example, consider the following code, which uses the conditional member access operator (?.) to read properties of button if it isn't null:
```dart
var button = querySelector('#confirm');  
button?.text = 'Confirm';  
button?.classes.add('important');  
button?.onClick.listen((e) => window.alert('Confirmed!'));  
button?.scrollIntoView();
```

To instead use cascades, you can start with the *null-shorting* cascade (?..), which guarantees that none of the cascade operations are attempted on a null object. Using cascades shortens the code and makes the button variable unnecessary:
```dart
querySelector('\#confirm')  
?..text \= 'Confirm'  
..classes.add('important')  
..onClick.listen((e) \=\> window.alert('Confirmed\!'))  
..scrollIntoView();
```
### Spread operator
In Dart, Spread Operator **(…)** and Null-aware Spread Operator **(…?)** are used for inserting multiple elements in a collection like Lists, Maps, etc.
```dart
// Syntax:-    …<Data_structure>  or  …?<Data_structure>  
// initialise a List l1  
  List? list1 = ["Spread", "Operator"];  
      
// initialize another List l2 using l1  
List? list2 = ["Wow",...list1, "is", "amazing"];

// o/p:-  [Wow, Spread, Operator, is, amazing]
```
### Types of parameter in method/function

**Optional Positional Parameter**
Positional parameters are the kind you're likely familiar with:
```dart
int sumUp(int a, int b, int c) {  
    return a + b + c;  
}  
int total = sumUp(1, 2, 3);
// With Dart, you can make these positional parameters optional by wrapping them in brackets:

int sumUpToFive(int a, [int? b, int? c, int? d, int? e]) { }  
OR  
int sumUpToFive(int a, [int b = 2, int c = 3, int d = 4, int e = 5]) { }  
sumUpToFive(1, 2); // call like
```
**Named Parameters**
Using a curly brace syntax at the end of the parameter list, you can define parameters that have names. Named parameters are optional unless they're explicitly marked as required.
```dart
void printName(String firstName, String lastName, {String? middleName}) {}

printName('Dash', 'Dartisan');  
printName('John', 'Smith', middleName: 'Who');  
// Named arguments can be placed anywhere in the argument list  
printName('John', middleName: 'Who', 'Smith');
```
### Constructors
**Named Parameters Using “this” in a constructor**
Dart provides a handy shortcut for assigning values to properties in a constructor: use this.propertyName when declaring the constructor
```dart
class MyColor {  
    int red;  
    int green;  
    int blue;
    MyColor(this.red, this.green, this.blue);  
}  
final color = MyColor(80, 80, 128);

// This technique works for named parameters, too. Property names become the names of the parameters:  
class MyColor {  
  . . . . .  
  MyColor({required this.red, required this.green, required this.blue});  
}  
final color = MyColor(red: 80, green: 80, blue: 80);
```
**Named constructor**
To allow classes to have multiple constructors, Dart supports named constructors:
```dart
class Point {  
	double x, y;	  
	Point(this.x, this.y);
Point.origin()  
	 : x = 0,  
	   y = 0;  
}
// Then use like,  
final myPoint = Point.origin();
```
**Factory constructor**  
Dart supports factory constructors, which can return its instance or instance of subtypes or even null. To create a factory constructor, use the `factory` keyword:

**Redirecting constructor**  
Sometimes a constructor's only purpose is to redirect to another constructor in the same class. A redirecting constructor's body is empty, with the constructor call appearing after a colon (:).
```dart
// Delegates to the main constructor.  
Automobile.hybrid(String make, String model) : this(make, model, 60);
```
**Const constructor**  
If your class produces objects that never change, you can make these objects compile-time constants. To do this, define a const constructor and make sure that all instance variables are final.
```dart
class ImmutablePoint {  
	static const ImmutablePoint origin \= ImmutablePoint(0, 0);  
	final int x;  
	final int y;  
	const ImmutablePoint(this.x, this.y);  
}
```
### Generator function [#1](https://dart.dev/language/functions#generators)

To produce sequential values Dart provide generator function, There two types:  
1\. **Synchronous** generator: Returns an **Iterable** object.
```dart
Iterable<int> naturalsTo(int n) sync* { 
   int k = 0;  
   while (k < n) yield k++; 
}
```
2\. **Asynchronous** generator: Returns a **Stream** object.
```dart
Stream<int> asynchronousNaturalsTo(int n) async* {  
   int k = 0;  
   while (k < n) yield k++;  
}
```
***What is yield?**   
It's like a return, but doesn't terminate the function.

### Common Design Patterns in Dart [\#1](https://techdynasty.medium.com/design-patterns-in-flutter-25191278149c)

**Singleton**
```dart
class AppSession {  
      static AppSession? _instance;
      AppSession._() {  
          _instance = this;  
      }
      factory AppSession() => _instance ?? AppSession._();   // AppSession()  
      // OR  
      factory AppSession.get() => _instance ?? AppSession._();   // AppSession.get()  
}
```

**Builder Pattern** [#1](https://ildysilva.medium.com/the-builder-pattern-in-dart-simplifying-the-creation-of-complex-objects-78f96ebe1eb3)  
The Builder Pattern is a creational design pattern used to build complex objects step by step. It allows for the creation of objects with different configurations, hiding the details of their construction.
  ```dart
  class Card {  
    final int id;  
    final String title;  
    final String desc;  
    Card(this.id, this.title, this.desc);  
  }  
    
  class CardBuilder {  
    // Mandatory  
    final int id;  
    //Optional  
    String title = "";  
    String desc = "";  
      
    CardBuilder(this.id);  
    CardBuilder withTitle(String t) {  
      title = t;  
        return this;  
    }  
      
    CardBuilder withDesc(String d) {  
      desc = d;  
        return this;  
    }  
      
    Card build() {  
      return Card(id, title, desc);  
    }  
  }  
   Card c = CardBuilder(3)  
      .withTitle("dfsf")  
      .build();
```
**Factory Pattern** [#1](https://medium.com/flutterdude/mastering-the-factory-pattern-in-flutter-a-practical-guide-a765f4a3f43)

**Repository Pattern**  
This pattern provides a centralized data access layer that abstracts the underlying data sources, such as databases, APIs, or caches.


### FFI [#1](https://medium.com/@chetan.akarte/what-is-ffi-in-dart-c2f4fab4c619)

FFI stands for **Foreign Function Interface** In Dart, FFI is a mechanism that allows Dart code to call C and C++ functions in a shared library. This capability is particularly useful for performing tasks that require direct access to platform APIs, integrating with existing C/C++ codebases, or for computationally intensive tasks where leveraging native code can offer significant performance benefits.  
The Dart FFI library (**dart:ffi**) provides the tools necessary to interface with native code. Here’s a broad overview of how FFI works in Dart:  
**Native Libraries** **or Shared libraries** (.so files on Linux and Android, .dylib files on macOS and iOS, .dll files on Windows) contain the C/C++ code that you want to call from Dart. These libraries are loaded into the Dart VM.



# Flutter To Do

- Flutter Design Paterns [#1](https://flutterdesignpatterns.com)
- Flutter + BLoc [#1](https://github.com/felangel/bloc/tree/master/examples/flutter_todos)
- Communication bw Flutter & Wevview [#1](https://www.freecodecamp.org/news/how-to-build-a-native-communication-bridge-in-flutter-with-webview-and-javascript)
- Dart/Flutter Tricks [#1](https://github.com/vandadnp/flutter-tips-and-tricks)
- Interview QA [#1](https://github.com/debasmitasarkar/flutter_interview_topics)
