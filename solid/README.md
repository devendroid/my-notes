# SOLID Principale

**SOLID** is an acronym (short form) for first five **Object Oriented Design** (OOD) principles by **Robert C Martin**

**S**ingle Responsibility Principale (SRP)  
**O**pen Close Principle (OCP)  
**L**iskov Substitution Principle (LSP)  
**I**nterface Segregation Principle (ISP)  
**D**ependency Inversion Principal (DIP)  

**Single Responsibility Principal**  [Ex1](srp/SingleResponsibilityEx1.java)  
A class should have one and only one reason to change, means every Java class must perform a single functionality.

**Open Close Principle**  [Ex1](ocp/OpenCloseEx1.java)  
Objects or Entities should be open for extension but closed for modification.

**Liskov Substitution Principle**  [Ex1](lsp/LiskovSubstitutionEx1.java)  
Subclass object should be substitute of super class object, means we should able to replace parent class with child class without interrupting the behaviour of the programm.

**Interface Segregation Principle**  [Ex1](isp/InterfaceSegregationEx1.java)  
Larger interface should splits into smaller onse having only relevant methods,
means service provider/interface should not force the client/class to use the services/methods that do not want to use.

**Dependency Inversion Principal**  [Ex1](dip/DependencyInversionEx1.java)  
We must use abstraction (abstract class and interface) instead of concrete class, High-level module should not depends on low-level module but both should depends on abstraction.

# Design Patterns

Design patterns are reusable solutions to the most commonly occurring software problems. They can speed up the development process by providing a proven way of resolving frequent issues.

**1. Creational Design Patterns**
   - Singleton Pattern
   - Factory Pattern
   - Abstract Factory Pattern
   - Builder Pattern
   - Prototype Pattern
   
**2. Structural Design Patterns**
   - Adapter Pattern
   - Composite Pattern
   - Proxy Pattern
   - Flyweight Pattern
   - Facade Pattern
   - Bridge Pattern
   - Decorator Pattern
   
**3. Behavioral Design Patterns**
   - Template Method Pattern
   - Mediator Pattern
   - Chain of Responsibility Pattern
   - Observer Pattern
   - Strategy Pattern
   - Command Pattern
   - State Pattern
   - Visitor Pattern
   - Interpreter Pattern
   - Iterator Pattern
   - Memento Pattern
