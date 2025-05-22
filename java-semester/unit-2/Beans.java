// Preparing a Class to be a Java Bean
// To make a class a JavaBean, it should follow these conventions:

// Must be public.

// Must have a public no-argument constructor.

// Properties should be accessed using getter and setter methods.

// Should be serializable (implements java.io.Serializable) if persistence or session tracking is needed.


// JavaBean properties are private fields accessed through getter/setter methods:

// Read-only property: Only getPropertyName()

// Write-only property: Only setPropertyName()

// Read/write property: Both getter and setter exist


// Types of Beans
// In the Java EE context, types of enterprise beans include:

// - Session Beans

// - - Stateful Session Bean

// - - Stateless Session Bean

// - Entity Beans (used before JPA)

// - Message-driven Beans (MDBs)



// import java.io.Serializable;

// stateful 
// Maintains state (data) across multiple method calls and transactions.

// Tied to a specific client.

// @Stateful
// public class Beans implements  Serializable {
//     private String name;
//     private int salary;
//     public Beans (){}

//     public String getName(){
//         return this.name;
//     }
//     public int getSalary(){
//         return this.salary;
//     }

//     public void setEmployee(String name,int salary){
//         this.name=name;
//         this.salary=salary;
//     }
// }


// stateless
// No client-specific state.

// Used for reusable, independent business logic.
// @Stateless
// public class Beans {
//     public int add(int a, int b) {
//         return a + b;
//     }
// }



//  Entity Bean represent persistent data stored in a database. They map to a table in a relational database, and each instance represents a row.


// Data is stored in a database (container-managed or bean-managed persistence)
// Each entity bean has a unique identity (like a primary key)
// Multiple clients can access the same entity bean
// Managed by the container and closely tied to the data in the database
// Use	Customer, Product, Order — anything stored in DB


// @Entity
// public class Product {
//     @Id
//     private int id;
//     private String name;
//     private double price;
// }



// major difference in entity beans and stateful session beans 

// Feature	                    Entity Bean	                          Stateful Session Bean
// Purpose	                    Models persistent data	              Maintains client-specific state
// Persistence	                Yes (Database)	                      No (In-memory during session)
// Client Scope	                Shared across clients	              Dedicated per client
// Lifecycle	                Managed based on DB interaction	      Lives during client session
// Example	                    Order table row	                      Shopping cart session
// Technology Now Preferred	    JPA (Java Persistence API)	          Still used in EJB (if needed)
