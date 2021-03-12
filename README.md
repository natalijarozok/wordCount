
**1. How often do you commit / push (more often is better) => Why is this is good? Trade-offs?**

Often commits are better in development process because 
- commits are small and have only related changes
- it is easier for other team members to understand the intention of commit and probably roll it back
- smaller commits make code integration easier (help avoid merge conflicts).

Often commits can lead to commiting of unfinished or untested work. Possible trade-off is to split the feature or bug fixing into small logical chunks.

**2. Are there automated unit- and integration-tests ( for this small hiring example w expect 100% test coverage) => Why is this is good? Trade-offs?**

Yes. There are automated unit and integration tests in place.  
It is very important to have automated unit- and integration-tests.    
Goog unit and integration tests help to reduce the number of bugs in a system, ensure sustainable system growth in time.  
The number of integration tests should be smaller than the number of unit tests.   
Integration tests take longer to execute because they work with out-of-process (external) dependencies.  


**3. Check for separate by concerns => What does it mean? Why is this is good? Trade-offs?**

Separation by concerns is one of the principles in software development.   
It means a split of the system into parts such that each part addresses a separate concern.   
It helps to well-organize the system, makes code clean.  


**4. Decouple all I/O from Domain => What does it mean? Why is this good? Trade-offs? (Clean Architecture, Hexagonal Architecture, Onion Architecture)**

Decoupling all I/O from Domain means extraction of I/O operations from domain logic or substituting the concrete I/O class with interface and making that class to implement interface.   
Decoupling helps to make the system scalable. Each component of the system can act independently. A change in independent components does not require change in other components.  


**5. Is the UI decoupled from Domain => Why is this important? Trade-offs?**

UI is decoupled from domain.  

**6. Expect you to improve your design over time by Refactoring. => Why is this important? Trade-offs? What code-smells do know?**

Refactoring of code should be done on a permanent basis because it helps to keep the code, thus makes the system sustainable.
Among code smells are:
- duplicate code
- unmeaningful names of classes and class members
- large functions
- high coupling and low cohesion in classes
- classes that reveal their logic.


**7. Are the SOLID principles applied?**

SOLID principles are applied in the code.  
**S** - single responsibility (there is only 1 reason to change (1 job) for a class  or function: for example mixing calculation and formatting in one class).  
**O** - open for extension, closed for modification (O principle says that class should not be modifiable. If we want to make a modification to  class A we should extend it with class B that will contain modification.).   
**L** - Liskov principle - subclass can substitute parent class without braking code:  
L is just an extension of O principle.  
L principle goes further and declares that if we have class A and class B extends class A, then substitution of base class A by class B can be done without breaking code. This means that derived class B must not change behaviour of base class A(functionality is not changed). This can be achieved when. 
  - class B method signature must match signature of base class A  
  - class B method return type must match to a base class A  
  - class B method exception type must match to a base class A.  

**I** - interface segregation (don’t create large interfaces that force implementing classes to   implement unnecessary methods).   
**D** - dependency inversion (high-level classes should not depend on concrete implementations of  low-level classes; low-level classes should be hidden behind their abstractions).  


**8. Can you find the requirements in the code?**

Requirements can be found in unit and integration tests.

**9. Is the code intention revealing?**

The code is intention revealing. Meaningful names of classes and class members were used.

**10. What does Clean Code mean to you?**

Clean code is the code that is easy to understand and easy to change.




