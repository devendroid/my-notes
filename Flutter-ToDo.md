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




## Flutter

**Flutter** is an **open-source**, **cross-platform** software development tool kit created by **Google.**

We all know that Flutter is a cross-platform framework that allows developers to build apps from the same codebase to various platforms. But this fact alone doesn’t tell us anything about **HOW this framework actually turns the code we’ve written into native applications?** There are several approaches, such as:    

-- **Showing everything inside a WebView**   
-- **Translating framework-specific code into native code and using native components**   
-- **Rendering custom components**   

  There are pros and cons to all of these approaches, but let’s look at the one Flutter uses.

For the sake of understanding today’s topic, let’s omit the details of how Flutter compiles your code for native platforms and so on. We’ll only focus on one thing: what we see on the screen and how we create it.

One thing you need to know is that Flutter doesn’t “translate” the UI to native components. So, your Flutter Button won’t be translated into an Android Button or iOS Button. Flutter *draws* straight on the canvas using the **Skia 2D Graphics Engine** (although soon it will be the  **Impeller Graphics Engine**), bypassing native components. This allows Flutter widgets to remain independent of the platform and its UI APIs.

### Flutter App Architecture: [\#1](https://docs.flutter.dev/resources/architectural-overview)

**![][image2]**

**Key points to consider about architecture:**

1. **Flutter Framework:** Written in Dart, this layer provides a comprehensive set of libraries and widgets, including Material Design and Cupertino (iOS-style) widgets, enabling developers to craft highly customizable user interfaces.

2. **Flutter Engine:** Primarily written in C++, the engine is responsible for rendering and core functionalities. Initially, Flutter utilized the Skia graphics library for rendering. However, with the release of Flutter 3.27, the Impeller rendering engine has become the default on both iOS and Android platforms. Impeller aims to deliver more predictable performance by precompiling shaders and leveraging modern graphics APIs like Metal.

3. **Embedder:** This component allows Flutter applications to run on various platforms by providing an entry point and access to native APIs. It's platform-specific and integrates the Flutter engine into the target operating system.

###*What technology is Flutter built with?**  
Flutter is built with C, C++, Dart, Skia (a 2D rendering engine), and [Impeller](https://docs.flutter.dev/perf/impeller) (the default rendering engine on iOS). See this [architecture diagram](https://docs.google.com/presentation/d/1cw7A4HbvM_Abv320rVgPVGiUP2msVs7tfGbkgdrTy0I/edit#slide=id.gbb3c3233b_0_162) for a better picture of the main components. For a more detailed description of the layered architecture of Flutter, read the [architectural overview](https://docs.flutter.dev/resources/architectural-overview).

**How are Flutter Apps Compiled?**   
The Dart code in Flutter applications is directly compiled into the native code for both iOS and Android. The Dart compiler supports two modes of compilation –   
Just-In-Time (JIT) : During development to support hot reload.   
Ahead-Of-Time (AOT) : When we run in release mode.

### Hot Reload vs Hot Restart  
**Hot reload** works by injecting updated source code files into the running Dart VM (Virtual Machine). This doesn't only add new classes, but also adds methods and fields to existing classes, and changes existing functions. 
**Hot restart** resets the state to the app's initial state.

### Widget Lifecycle [\#1](https://medium.com/@iniwillie10/mastering-the-different-types-of-state-dependence-functions-in-flutter-31f913e94cee)

**createState()** : creates the state object for the widget.
**initState()** : called after the state object is created. It is used to initialise the state of the widget
**didChangeDependencies()** : This method is called immediately after *initState* and called whenever a widget’s dependencies change. A widget’s dependencies are other objects on which the widget relies, such as inherited widgets or other stateful widgets.
**build()** : It is used to build the widget tree. This gets called each time the widget is rebuilt, and it happens:  
\- after initState,   
\- didChangeDependencies,   
\- didUpdateWidget,   
\- or when the state is changed via a call to setState
**didUpdateWidget()** : This method is called when the widget is updated with new properties. A typical case is when a parent passes some variable to the children() widget via the constructor.
**setState()**  
**deactivate()** : This method is invoked when State is removed from subtree A and reinserted to subtree B with the use of a GlobalKey.
**dispose()** : This method is called when the widget is about to be destroyed permanently. It is used to release any resources used by the widget like closing network connections or stopping animations.

### App Lifecycle States (WidgetsBindingObserver)

1. **resumed**: The app has returned to the foreground and is ready to interact with the user. It transitions from the paused or inactive state.

2. **inactive**: The app is in an inactive state, typically transitioning between foreground and background. User interactions are not processed during this state.

3. **hidden**: The app is in a hidden state, indicating that it is not visible to the user. This state often occurs when the app is minimized or covered by another application.

4. **paused**: The app is paused and not executing code. This state occurs when the app is in the background and not visible to the user.

5. **detached**: The app is completely detached from the framework, indicating that it is about to be terminated.

### Flutter Render Pipeline [\#1](https://www.youtube.com/watch?v=3k70-1T_LPM), [\#2](https://medium.com/flutter-community/flutter-what-are-widgets-renderobjects-and-elements-630a57d05208)

The **Flutter Render Pipeline** is the process through which Flutter transforms a UI description (provided as Widgets) into pixels on the screen. It involves several key stages, each responsible for a specific part of the rendering process.

In Flutter, everything is a Widget. When we create a UI using Widgets, it known as the Widget tree. However, behind the scenes, Flutter also constructs an Element tree and a Render Object tree. These three trees are almost identical but serve different purposes.

**1\.** **Widget tree**  
Widgets describe the configuration of the app’s UI. When the UI is built, Flutter constructs a Widget tree, which is immutable and short-lived. Widgets describe how the interface should look but don’t hold the actual UI state.

**2\.** **Element tree**  
The Element tree represents a bridge between the Widget tree and the rendering system. Each Element is created from a corresponding Widget and is responsible for:
* Holding the state (for StatefulWidgets).
* Managing the Widget lifecycle (build, update, etc.).
* Acting as a container for RenderObjects.

**3\. Render object tree**  
The Render Object tree is responsible for:
* Layout: Measuring and positioning widgets.
* Painting: Converting layout data into visual elements drawn on the screen.

This tree is mutable, meaning it updates efficiently when changes occur (like resizing or repositioning).

**4\. Layers tree**  
Flutter uses a Layer tree to optimize rendering. Layers reduce unnecessary redrawing by compositing only the parts of the screen that have changed.

**5\. Rastering by GPU**  
Finally, the composited layers are handed off to the GPU, which rasterizes them (turns vector instructions into pixels) and displays them on the screen.

![][image3]

[Image Source](https://geekyants.com/_next/image?url=https%3A%2F%2Fstatic-cdn.geekyants.com%2Farticleblogcomponent%2F13127%2F2022-10-19%2F162281925-1666165877.jpg&w=1920&q=75)

**ComponentElement**: An Element that composes other Elements.  
**RenderObjectElement:** An Element that uses RenderObjectWidget as its configuration.  
**RenderObject**: An object in the Render tree.

### Build Context [\#1](https://www.educative.io/answers/what-is-buildcontext-in-flutter)

\- BuildContext is an object that Flutter uses to provide information about the location of a widget in the widget tree. It represents the current build context in which a widget is being built or updated.
\- BuildContext is a part of the Flutter framework, and it's created automatically when a widget is inserted into the widget tree. Each widget's build method receives its associated BuildContext as an argument.
\- Each BuildContext is unique to a widget. This means that the BuildContext of a widget is not the same as the BuildContext of the widgets returned by the widget.
\- It's used for configuring widgets, accessing localization and theme data, and performing navigation.  

**Useful methods in BuildContext:-**

***findAncestorWidgetOfExactType***  
This method is used to locate or find a widget of a particular type in the widget tree. This method will go up the widget tree from the widget it was called from, and try to locate the first widget in the tree whose type is the same one passed to the method.

***findAncestorStateOfType***  
This method is just like the findAncestorWidgetOfExactType method, b. Still, this returns the State object of a StatefulWidget widget whose instance is the same as the instance passed to the method.

**Go bit more Deeper:**  [\#1](https://blog.codemagic.io/a-pragmatic-guide-to-buildcontext-in-flutter/)
Take a look of this simple example,
```dart
class MyStaticPage extends StatelessWidget {  
  @override  
  Widget build(BuildContext context) {  
    return Container();  
  }  
}
```
What will happen when the above code will run? From where actually this BuildContext will come?  
When we run this code behind the scene what will do the Flutter Framework:
1. Flutter Framework will call the `createElement()` method of `StatelessWidget` that will return a instance of StatelessElement
2. Now Flutter Framework will call the `mount()` method of `StatelessElement` inside that some configuration will be done.

3. And after that Flutter Framework will call the `build()` method of `StatelessElement` where inside the build() method called `build(this)` and pass the “this” context that is actually referred as BuildContext because `StatelessElement extends Element` class and `Element class implements BuildContext` class.

4. Finally Flutter Framework receives the created widget as return by `build()` method and process further to display it on screen.

### Routing [\#1](https://www.youtube.com/watch?v=laqnY0NjU3M)

In flutter there three option are available for Routing:  
![][image4]

**1\. Anonymous Routing:** Routing without route name

![][image5]

**2\. Named Routing**  
**![][image6]**

**3\. Generated Routing**  
![][image7]

### **What is Key?**

![][keys_image]

- **Key\*** is an abstract class but can be instantiated because it has a factory constructor.
- **LocalKey** is abstract class cant be instantiated.
- ValueKey, ObjectKey, and UniqueKey are concrete classes.
- **GlobaKey\*** is an abstract class but can be instantiated because it has a factory constructor.
- LabeledGlobalKey is concrete classes

**Key**   
In Flutter, keys are unique identifiers that are attached to widgets. They help Flutter distinguish between different widgets and track changes efficiently when the UI rebuilds. Think of them as fingerprints for widgets — they ensure each widget is recognized and considered as an individual.
**LocalKey**  
It’s used to identify widgets within the same parent widget. Local keys cannot be used to identify widgets outside of their parent.
**ValueKey**  
The ValueKey is a straightforward key type that stores a simple alphanumeric value. It’s handy when you need to identify a widget based on a specific value. For example, you can use a ValueKey to differentiate between items in a list.
**ObjectKey**  
When you want to identify a widget based on an object, the ObjectKey comes to the rescue. It stores an object and uses it as a unique identifier. This is useful when you’re dealing with complex data structures.
**UniqueKey**  
As the name suggests, the UniqueKey generates a unique identifier for each widget. This key type ensures that no two widgets share the same key, making it ideal for scenarios where absolute uniqueness is required.
**GlobalKey**  
It can identify widgets from anywhere in the widget tree.

### State Managements [\#1](https://medium.com/@enitinmehra/state-management-in-flutter-a-comprehensive-guide-7212772f026d)

- Stateful Widget (by flutter)
- ValueNotifier-ValueListenableBuilder (by flutter)
- ChangeNotifier-ListenableBuilder (by flutter)
- Providers (third party)
- Flutter BLoC: (third party) The best practice is to put the BlocProvider as low as it can go
- Riverpod (third party, Build top of Provider) [\#1](https://www.dhiwise.com/post/flutter-insights-navigating-the-riverpod-vs-bloc-puzzle)
- GetX (third party)

### BLoC [\#1](https://dev.to/princetomarappdev/clean-code-architecture-and-bloc-in-flutter-a-comprehensive-guide-for-beginners-and-experts-33k8) [\#2](https://github.com/TheWCKD/blocFromZeroToHero) [\#3](https://medium.com/flutter-community/flutter-bloc-for-beginners-839e22adb9f5)

BLoC stands for **Business Logic Component**, a pattern used in Flutter to manage the app's state. It's designed to separate the app's business logic from its user interface (UI).

***Key features:-***
**Separation of Concerns**: BLoC keeps your business logic separate from your UI code, making your app easier to understand and maintain.
**Testability**: Since the business logic is separate, it's easier to test.
**Reusability**: You can use the same business logic in different app parts without changing the UI.

***Some challenges:-***

**Learning Curve**: Understanding how to use streams and sinks can take time, especially for beginners.
**Boilerplate**: BLoC can require a lot of extra code, which might be overwhelming for simple apps.

***Cubit vs Bloc:-***
- Cubit is a minimum version of Bloc
- Bloc extens Cubit
- Cubit uses function to listen user actions while Bloc uses event
- Cubit functions are not a stream, while Bloc events are stream

![][image8]

***Use of Equability Class:-***

**PROBLEM**: Two instances of the same class are not equal even having the same value, because both are stored in different memory locations.  
![][image9]

**SOLUTION:-** But we can override this behaviour easily by very popular library Equatable developed by flutter dev community.

**USE:-** When we write test cases for Bloc or whenever we are required to check if the state is the same or not.

***Best Practice about to instantiate a Cubit/Bloc:***   
![][image10]

***Cubit/Bloc Problem discussions:*** [\#1](https://github.com/felangel/bloc/issues/1819)  [\#2](https://github.com/felangel/bloc/pull/2859#issuecomment-1004018783)

### Using Serialization/Deserialization

- **Object to Json  (Serialisation)**  
  1\. Object \-\> Map  (Using manual)  
  2\. Map \-\> Json String  (Using json.encode(-))

- **Json to Object  (Deserialisation)**  
  1\. Json \-\> Map (Using json.decode(-))  
  2\. Map \-\> Object (Using manual)

![][image11]

### Future, async & await

Future is a result of an asynchronous function.

**Stream and its type**  [\#1](https://dev.to/vishnucprasad/mastering-flutter-streams-exploring-single-and-broadcast-streams-d3e)  
A stream is a sequence of asynchronous events, and it allows the components of your application to communicate without blocking the execution.  
In Dart, there are two types of streams:
1. **Single Subscription Streams**  
   Single Subscription Streams allow only one listener to listen to the stream. Once a listener is subscribed, no other listeners can subscribe to the same stream.
2. **Broadcast Streams**  
   Broadcast Streams allow multiple listeners to subscribe to the same stream. This is useful when you want to broadcast events to multiple parts of your application simultaneously.

### Isolate [\#1](https://blog.codemagic.io/understanding-flutter-isolates/)

Isolates are a Dart concurrency model that allows for running code in parallel. They are independent of each other and communicate through message passing. Isolates are useful for performing expensive computations, I/O-bound tasks, and background processing.

**Limitation:**  
\- Isolates in Flutter do not share memory. Communication between them is organized by passing messages. This leads to the following issue: limit on the size of transmitted data. It is costly and in some cases impossible to send large amount of data from the isolate to the main thread.  
Thus, it is best to use isolates for resource-intensive operations that return small amount of data.

### MultiTheme Setup

1.Create ThemeData object for light and dark if require any custom color key then make an extension for ThemeData. like:
```dart
light  = ThemeData(primarySwatch: Color.green, … );  
dark  = ThemeData(primarySwatch: Color.green, … );
```
2.MaterialApp widget have three properties like
```dart
  MaterialApp(  
    theme: light,  
    darkTheme: dark,  
    themMode: Provider.of<ThemeNotifier>(context).getThemeMode()            
  );
// Note:- ThemeMode a predefined flutter enum that has three values light, dark, system.
```

3.Setup a ChangeNotifier to change and notify the theme for MaterialApp, like  
 ```dart  
   class ThemeNotifier with ChangeNotifier {  
      ThemeMode _themeMode;
      ThemeNotifier(this._themeMode);
      getThemeMode() => _themeMode;
      setThemeMode(ThemeMode themeMode) async {  
         _themeMode = themeMode;  
         notifyListeners();  
      }  
   }
```
4.Use the color in app from Theme like:  
   `Theme.of(context).primarySwatch;`
   
### Multilingual (Localization) Setup

1.Create json files to define key values as per language like en.json, hi.json
2.Create our custom ApplicationLocalizationDelegation by extends the LocalizationDelegation.
3.MaterialApp have three properties for this:
```dart
MaterialApp(   
    supportedLocales: const [  
        Locale('en', 'US'),  
        Locale('es', 'ES'),  
        Locale('fr', 'Fr') ],

    localizationsDelegates: const [  
       ApplicationLocalizations.*delegate*,  
       GlobalMaterialLocalizations.*delegate*,  
       GlobalWidgetsLocalizations.*delegate* ],

    localeResolutionCallback: (locale, supportedLocales) {  
         for (var supportedLocaleLanguage in supportedLocales) {  
           if (supportedLocaleLanguage.languageCode == locale?.languageCode ) {  
              return supportedLocaleLanguage;  
            }  
         }  
      return supportedLocales.first;  
    }  
)
```
4.Write a ChangeNotifier to update the current app language by setting current Local.

5.Use below code
```dart
class LocalizationNotifier extends ChangeNotifier {
    LocalizationNotifier(this._appLocale);
    Locale _appLocale = const Locale('it');
    Locale get appLocal => _appLocale;
    setAppLocal(Locale language) async {
      _appLocale = language;
      notifyListeners();
   }
}
```



### Offline first Architectures [\#1](https://docs.flutter.dev/app-architecture/design-patterns/offline-first)

**Reading Data:** There can be three different approaches, all is depends on frequency of data updates on server,  
1\. Using local data as fallback  
2\. Using Stream (Use generator function with emit two values)  
3\. Using local data only

**Writing Data:** There can be two approaches based on the priority of user inputs available on server, some app require to immediate or some are flexible to send user data on server,  
1\. Online only writing  
2\. Offline first writing

### IntrinsicHeight & IntrinsicWidth [\#1](https://www.youtube.com/watch?v=ce07f8ClcMQ)

### CI/CD \- CodeMagic [#1](https://blog.codemagic.io/getting-started-with-codemagic)

### DeepLink:  [\#1](https://medium.com/codeinflutter/flutter-deep-link-app-link-implementation-a-comprehensive-guide-for-2024-fb1418d998d1)

**DeepLink-**  Deep links are links that not only open an app, but also take the user to a specific location "deep" inside the app.
**AppLink-** An *app link* is a type of deep link that uses `http` or `https` and is exclusive to Android devices. To set up app links, you need to own a web domain.
**UniversalLink-** A *universal link*, a type of deep link exclusive to iOS devices, uses only the `http` or `https` protocols. To set up universal links, you need to own a web domain.

### Dependency Injection  [\#1](https://www.youtube.com/watch?v=izPV3C0hdoI)  
There can be following ways to create a provides the instance among the widgets:

1. Create the instance of any class by self
2. Using ServiceLocator pattern (by get\_it package)
3. Using **Dependency Injection** pattern (by injectable package)
4. Using InheritedWidget

### Inherited widgets [\#1](https://medium.com/@yurinovicow/flutter-i-finally-understood-inheritedwidget-f9e3c98c4596)

The inherited widget provides us with a convenient way to pass data between widgets. While developing an app you will need some data from your parent’s widgets or grant parent widgets or maybe beyond that. So if your app is small you can pass your data using the constructor of the widget class, but for a larger app, this is not an easy task. Unknowingly we have used inherited widgets in many places while developing the flutter app.**Theme**.of(context), **MediQuery**.of(context), and **Navigator**.of(context).

### Packages and Plugins:-
**Package:-**
- Packages in Flutter typically refer to reusable libraries of Dart code that can be added to your project to provide specific functionality.
- These packages are hosted on the [pub.dev](https://pub.dev/) website, which is the official package repository for Flutter.
- Developers can easily search for, find, and include packages in their Flutter projects by specifying them in the pubspec.yaml file, which is the project's configuration file.
- Examples of packages include packages for handling HTTP requests, state management (e.g., http, provider).

**Plugin:-**
- Plugins are a subset of packages that are specifically designed for interfacing with platform-specific, native code or services.
- They allow Flutter apps to communicate with device features or native functionality, like accessing the camera, GPS, sensors, or other device-specific capabilities.
- Plugins typically consist of Dart code (for the Flutter side) and native code (for iOS and Android) that work together to provide a unified Flutter API for accessing platform-specific features.
- Ex- camera, video\_payer etc.

We can access the native (android/ios) features in flutter using Method Channel and Event Channel.

***Method Channel:-***  
Allows sending messages from Dart to native code and receiving responses. Used for invoking methods.  
static const platform \= MethodChannel('com.example/mychannel');

***Event Channel:-***  
Used for streaming data from native code to Dart. Ideal for continuous data updates.  
static const eventChannel \= EventChannel('com.example/myeventchannel');

### Flutter Testing [\#1](https://docs.flutter.dev/testing/overview) [\#2](https://www.youtube.com/watch?v=cVru6Gy4duQ) 
Automated testing falls into a few categories:

-- A **unit test** tests a single function, method, or class. **\[flutter\_test, mockito\]**    These packages provides following functionalities:   test(), group(), expect(),  `@GenerateMocks([http.Client])` above the main function etc.

-- A **widget test** tests a single widget **\[flutter\_test\]**

- The WidgetTester allows building and interacting with widgets in a test environment.
- The testWidgets() function automatically creates a new WidgetTester for each test case, and is used in place of the normal test() function.
- The Finder classes allow searching for widgets in the test environment.
- Widget-specific Matcher constants help verify whether a Finder locates a widget or multiple widgets in the test environment.

- An **integration test** tests a complete app or a large part of an app.  **\[integration\_test\]**

**Unit tests** and **widget tests** validate individual classes, functions, or widgets. They don't validate how individual pieces work together in whole or capture the performance of an app running on a real device. To perform these tasks, use **integration tests**. Integration tests verify the behaviour of the complete app. This test can also be called **end-to-end testing or GUI testing**.  **host machine:** The system on which you develop your app, like a desktop computer.

***target device:*** The mobile device, browser, or desktop application that runs your Flutter app.
If you run your app in a web browser or as a desktop application, the host machine and the target device are the same.

### Responsive UI  [\#1](https://medium.com/@kamrani062/responsiveness-in-flutter-ui-crafting-screens-for-all-devices-a264c3f435ec)
The key components that help to create responsive UI:
**1\) Use Layout Widgets:**   
Flutter provides layout widgets like Row, Column, and Container that can automatically adapt to screen sizes.
**2\) MediaQuery:**  
Flutter’s MediaQuery class allows you to retrieve information about the screen, such as dimensions and orientation. You can use this information to make decisions about how your UI should adapt.
```dart
final double screenHeight = MediaQuery.of(context).size.height;  
final double screenWidth = MediaQuery.of(context).size.width;  
final Orientation orientation = MediaQuery.of(context).orientation;
```
**3\) Flexible, Expanded & Wrap Widgets:**  
Widgets like Flexible and Expanded allow children widgets to grow and shrink based on available space.
**4\) Orientation Detection:**  
Use the OrientationBuilder widget to detect changes in screen orientation and adjust your UI accordingly. You can adapt your UI based on screen orientation.
```dart
OrientationBuilder(  
builder: (context, orientation) {  
return orientation \== Orientation.portrait  
? Text('Portrait Mode')  
: Text('Landscape Mode');  
}, )
```
**5\) Use Aspect Ratios:**  
The AspectRatio widget helps maintain the aspect ratio of a widget, ensuring that images or videos don't stretch or distort on different screens.  
The AspectRatio widget maintains the aspect ratio of its child.

### Optimization Tips [\#1](https://www.youtube.com/watch?v=8oIsZEhnqtA)

**1\. Use const constructor:** It tells Flutter Framework the Widget and its childrens are immutable, that prevent unnecessary rebuilding and improve performance.
**2\. Prevent Rebuilding of widgets:** Use final to create a widget instance, it ensures the widget instance will create once and then reuse for every build.
**3\. SizedBox than Container:** Use SizedBox than Container if you need only sizing to your widget; it's lightweight and less overhead.
**4\. Minimize Widget tree depth:** Don't write a long widget tree to create ui, instead create multiple small widgets and then compose them.
**5\. StatelessWidget widget instead of function:** Use StatelessWidget to create custom widgets instead of returned by a function;
**6\. ListView:** Use ListView.builder than ListView if you have elements thats require a scroll.
**7**\. Minimize import, don't import the whole library, import only the required classes.
**8**\. **Network Optimization**
- RESTful APIs: Use paginated API responses to fetch small chunks of data.
- GraphQL: Fetch only the required fields instead of the entire dataset.
- Compression: Enable Gzip compression on the server to reduce data size.
- Caching: Implement caching to minimize repeated network calls.

**9**\. Use widget lifecycle method for efficient resource management and prevent memory leaks.
**10**\. Widget tree shacking [\#1](https://medium.com/@samra.sajjad0001/flutter-tree-shaking-optimizing-your-app-for-performance-9a2d82b43eb1)
**11**\. Web App Optimize  [\#1](https://medium.com/flutter/best-practices-for-optimizing-flutter-web-loading-speed-7cc0df14ce5c)
**12\. Tree Shaking:-**  Tree shaking is an optimization technique in Flutter that removes unused code from an app's bundle to make it smaller and more efficient. This improves the app's performance and load times.
Here's how tree shaking works in Flutter:
* **Analysis**: The Flutter tool analyzes the app's codebase, including all the Dart files, libraries, and dependencies.
* **Identification**: The tree shaking mechanism uses static analysis to identify parts of the code that are never used.
* **Removal**: The unused code is removed from the final compiled app.
* **Optimization**: Tree shaking can also lead to other optimizations.

**Note:** Tree shaking is active by default in release builds, but it can't be applied in debug mode.

### Flutter App Security

1.**SSL Pinning:   [\#1](https://medium.com/@MarvelApps_/ssl-pinning-with-flutter-e0aa8f3eeaf7)**

### FlutterDevTool  [\#1](https://www.youtube.com/watch?v=dTNMxeIfS-o)

**Flutter Inspector:**  
**Performance:**
\- For 60FPS it required to each frame should take 16ms to render if it takes longer than this then OS starts skip those frame- For 60FPS it required to each frame should take 16ms to render if it takes longer than this then OS starts skip those frames, thats know as Jank (Slow Frame)s.
**CPU Profiler:**  
**Memory:**  
**Debugger:**  
**Network:**  
**Logging:**  
**Provider:**  
**App Size:**

### Build Flavors in Flutter [#1](https://medium.com/@matt.goodson.business/separating-build-environment-configurations-in-flutter-with-firebase-doing-it-the-right-way-c72c3ad3621f) [#2](https://docs.flutter.dev/deployment/flavors) [#3](https://medium.com/@animeshjain/build-flavors-in-flutter-android-and-ios-with-different-firebase-projects-per-flavor-27c5c5dac10b)

### State Restoration in flutter

[https://docs.flutter.dev/platform-integration/android/restore-state-android](https://docs.flutter.dev/platform-integration/android/restore-state-android)  
[https://github.com/flutter/flutter/issues/84193](https://github.com/flutter/flutter/issues/84193)  
[https://github.com/flutter/flutter/issues/6827](https://github.com/flutter/flutter/issues/6827)  
[https://mobikul.com/state-restoration-flutter/](https://mobikul.com/state-restoration-flutter/)  
[https://scal.io/work/flutter-navigation-saver](https://scal.io/work/flutter-navigation-saver)

### Vulnerability & Sonarqube [\#1](https://medium.com/@meaghosh/static-code-analysis-with-sonarqube-with-flutter-11a74beb9950)  [\#2](https://medium.com/@rohitsuhag7/setup-sonarqube-locally-for-flutter-on-mac-2db922f1f9d3)  [\#3](https://www.youtube.com/watch?v=QD5J8YvQPPM)  [\#4](https://www.youtube.com/watch?v=6vdRvz_LnbQ)

SonarQube is an open-source, self-managed, automatic code review tool that helps developers ensure high code quality and security. It analyzes source code based on defined rules to detect coding issues, such as bugs and code smells, in over 30 programming languages, frameworks, and IaC platforms. SonarQube then provides reports on issues like duplicated code, coding standards, unit tests, code coverage, and security.

Steps to setup on machine:

      1\.   Install java  
      2\.   Installation of SonarQube/Sonar-Scanner

3. Install Docker
4. Start SonarQube
5. Log in to SonarQube Dashboard
6. Create a new project in SonarQube Dashboard
7. Download sonar-flutter-plugin and add plugin to SonarQube
8. Add sonar-project.properties
9. Run Analysis
10. View SonarQube scan results

### Important Topics/Concepts
[**Flutter Release Notes**](https://docs.flutter.dev/release/release-notes)
[**Write your service locator**](https://medium.com/@yurinovicow/flutter-write-service-locator-in-15-lines-of-code-9b7bc5b8ae5c)
[**CleanArc \+ BLoC \+ DI**](https://blog.stackademic.com/flutter-clean-architecture-with-bloc-and-dependency-injection-in-detail-9424c9b3fa8b)
[**Flutter Design Paterns**](https://flutterdesignpatterns.com)
[**Flutter + BLoc**](https://github.com/felangel/bloc/tree/master/examples/flutter_todos)
[**Communication bw Flutter & Wevview**](https://www.freecodecamp.org/news/how-to-build-a-native-communication-bridge-in-flutter-with-webview-and-javascript)
[**Dart/Flutter Tricks**](https://github.com/vandadnp/flutter-tips-and-tricks)

### Interview QA
[https://docs.flutter.dev/resources/faq](https://docs.flutter.dev/resources/faq)
[https://medium.com/@ahsan-001/flutter-advanced-interview-questions-a-detailed-guide-with-coding-examples-f78900977c09](https://medium.com/@ahsan-001/flutter-advanced-interview-questions-a-detailed-guide-with-coding-examples-f78900977c09)
[https://medium.com/@artur.fijal.koalasoft/real-flutter-interview-questions-d522f77cbd87](https://medium.com/@artur.fijal.koalasoft/real-flutter-interview-questions-d522f77cbd87)
[https://medium.com/whitecodel/flutter-interview-questions-2024-part-4-c6d9123b5edc](https://medium.com/whitecodel/flutter-interview-questions-2024-part-4-c6d9123b5edc)
[https://medium.com/@arunb9525/advanced-flutter-interview-questions-798dae5013fc](https://medium.com/@arunb9525/advanced-flutter-interview-questions-798dae5013fc)
[https://github.com/debasmitasarkar/flutter_interview_topics](https://github.com/debasmitasarkar/flutter_interview_topics)

Thanks :)
