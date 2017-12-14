## SOLID:
  * What are SOLID Prinicples
  * Explain Open Closed principle with an example from ur project/past experience

## Testing:
  * What's the difference between Unit testing & Integration testing?
  * How do we write unit tests of a component when the dependent components are not developed(assume their interfaces are available)?
  
## REST:
  * What are REST principles?
  * Do you know the RichardsonMaturity model
  * Do you know the resource naming conventions to follow in REST
  
## Spring:
  * What is dependency injection. How it benefits the developer?
  * Spring MVC: What's the difference between a servlet filter and spring interceptor?
  * Spring bean lifecycle
  
## Hibernate:
  * How do you map one-to many relationship with JPA/Hibernate
  * How a composite primary key is defined in Hibernate
  * Do you know hibernate inheritance strategies
  * Why and how do we use cacheing in hibernate
  
## Java:
 * Exception heirachy
 * When do we need to use Runtime Exceptions
 * Purpose of equlas and hashcode
 
## Java8:
 * How Java8 functional programming is different from its earlier versions
 * What stream api functions that you know. 
	- Problem: In a collection of persons, how do you find first 3 names of female persons whose weight is under 50kg using stream api. Solve this in java7 and java8.
 * What are Default methods
 * What is the difference between interface and abstract class (now both have method implementations)?
  
  
## Javascript/JQuery
  * OOJS features
  
## AngularJS
   * Difference between Jquey and Angular
   * What's the difference between a controller and a service
   * How do we pass data from one controller to other

## Non Functional Requirements
  * What is scalability. types? How to improve?
  
## Code review
  * What do you check when you do code review
  * What does 'clean code' mean to you
  
## Problem:

* In an Issue Tracker app (like JIRA) write a service layer component to update an issue. Complete the below code
```
@Service
public class IssueService {


   @Autowired
   private IssueRepository issueRepository;
   
   public Issue update(Issue issue) {
		
		// TODO: Validate the issue.status first; 
		// Status can be updated from CREATED to IN_PROGRESS to COMPLETED. 
		
		// TODO: Save the issue using issueRepository
   }
}
```

Notes: Handle exceptions appropriately, Write clean code; Write Unit tests
