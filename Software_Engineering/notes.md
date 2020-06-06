# Contents

|Titles|
|-----|
|[Specification](#spec)|

# Software
Software is something that is working, usualy for ‘real humans’ to use to help them do something

# SE process
![SE_process](https://raw.githubusercontent.com/lakerschampions/Learning-Notes/master/images/seprocess.png?token=AJS34WQCZNBFBN2PAPIBLW263OJHY)

## Specification
<span id = "spec"></span>
### Requirements

#### Requirements Engineering
- elicitation and analysis
    - process
        - discovery
        - classification and organization
        - priortization and negotiation
    - initial method
        - stakeholder analysis
        - personas
        - use case diagram
        
- definition
    - user stories
        - concise and clear, little maintenance, create a clear requirements checklists, rank for importance...
        - difficult to use in BIG projects, loose detail and formality, don't describe process or tasks or context
    - user(req) : what a stakeholder needs to be able to do
    - system(spec) : what the software must do to meet the requirement above
    - funtional and non-functional
    
- validation
    - investtigation techniques
        - surveys
            - good for contacting lots of people , bad for actually understanding something in details 
            - most common mistake : sending a badly made questionnaore
            - 2nd common mistake : reinvent the wheel 
            - other common mistakes : 2 parts questions , leading questions , too long.
        -  interviews & focus group
            - allow you the freedom to ask follow up questions
            - common mistakes : start an interview without a plan
            - more people at once , dicuss differences & opposing opinions.
            - possible conflict
        - observations
            - allows you to see things people didn't say
        - advanced-technology tours
        - advances-ethnography
        
    - why we need validation
        - check that you are right
        - avoiding reworking
        - contractually agreeing
            - internal : You present it to your “boss and colleagues”.
                - using a requirements review
                - reviews appear in several stages
                - with your team first
                - Get a manager, the Requirements leader, a developer, a quality manager, and the client manager (if different) together in a room.
                - Two benefits
                    1. The client manager gets a clear picture before taking it to the client.
                    2. If you can explain it to them, without having trouble, then you are ready to take it to the client.
            - external : You present it back to participants/clients/users.
                - This time the people in the room are the key people from both companies
                - By the end of this final validation, you should have ‘the plan’
                
- document
    - Translation from anecdotal user wishes to a formal document.
    - Usually a big set of nested lists, with unique IDs.
    - Diagrams produced go with them (and cross reference those IDs).
    - Lists should be categorised – e.g., importance, risk etc.
    - Usually define the “acceptance testing” at the end of the project.

- models
    - roles
        - derive the requirements for a asystem
        - during the design process to describle the system engineers implementing the system
        - after implementation to document the systems structure and operation
    - context diagrams
        - identify a number of systems you will have to interact with
        - define the boundaries of the system
    - task analysis
        - can put note but can't put "different actors" into it
        - no decision points
    - UML diagrams
        - behavior diagrams
            - use case diagram
            - activity diagram
                - use to elaborate workflows for key activities (especially if they involve decisions)
                - Explains the process, decision points, wait points & parallel work.
                - Usually to define one Use Case in more details.
                - expressions
                    - Rounded rectangles represent actions.
                    - Diamonds represent decisions.
                    - Bars represent the start (split) or end (join) of concurrent activities
                    - The black circle represents the start.
                    - The encircled black circle represents the end.
            - sequence diagram
                - Good for complex sharing of information between people and systems.
                - Could be seen as a series of messages between key components.
        - structure diagrams
            - class diagram
                - Specify the classes in Object Oriented Code.
            - state diagram
        - scenarios
            - Adding Context/Detail to Models/Diagrams.
            - a structured description of process
            - MUST define a setting or context
            - MUST define one or more actors or users
            - MUST define goals or objectives
            - MUST describe a plot , the plot describes how a user, in a context, achieves a goal.

### Specification
#### Types of Specification
- Natural Language Sentence
    - Can be expressive, intuitive and universal.
    - Can also be ambiguous, vague, and interpreted differently.
    - Guidelines
        - Use a standard format: **1 sentence**, linked to **a user requirements**.
        - Distinguish between mandatory (‘shall’) and desirable (‘should’).
        - Emphasis important elements with bold, italic etc.
        - Avoid jargon, unless clearly specified in a key words section.
        - Make sure the specification is measurable in some form

- Structured
    - Go further than natural language specifications, to **tabulate** specifications, or put them in templates.
    - Can be used to specify additional information
        - Associated logic in the function.
        - Inputs and outputs.
        - Conditions.
        - Side effects or relations to other functions
        
- Graphical
    - UML models, diagrams, prototypes.
    - It’s often easier to see a UML sequence diagram.
    - So when you find specifications are complex – visualize them.
    - UML can be used for either.

- Mathematical

#### Qualitues of Good Specification
- Tracebility
    - It’s really important that all specifications can be traced to user requirements.
    - In reports, you should, for every specification, state which user requirement(s) it is supporting.
    - You may also categorise them by importance, difficulty etc.
    
- Testability
    - Verification – did we build it right?
    - To have implemented a single specification, you’ll want to know you achieved what it specified.
    - Can all the things you specify be tested and proved?
    
-  Specification Reviews
    - There is a formal review process you can go through. Several people in a room, reading each specification a loud.
    - Each person takes a Role – to systematically review the specifications:
        - Validity checks (are the areas of functionality identified as necessary).
        - Consistency checks (do specifications conflict with one another).
        - Completeness checks (does it specify a coherent system or only parts of it).
        - Realism checks (can specifications actually be implemented).
        - Verifability checks (can specifications be tested).
    - Are the system specifications: correct, necessary, important?
    
#### Readers of different types of requirements specification
- User requirements
    - **Client managers**
    - System end-users
    - Client engineers
    - **Contractor managers**
    - System architects
- System Specifications 
    - System end-users
    - Client engineers
    - System architects
    - **Software developers**
    
### Prototype
- Specifications are
    - Good for a checklist of things to achieve.
    - Hard to undersand (unless you wrote them) the overall idea.
    - Often full of conflicting specifications.
    - Bad for conveying the overall idea.
- Prototypes are
    - A way of envisioning how all your specifications work together.
    - A way of testing the consistency of your specifications.
    - Easy to show people and talk about.
    
### Low vs High Fidelity
- Low Fidelity
    - E.g., sketches/’Paper’ prototypes.
    - Focused on underlying ideas.
    - Key functionality, content etc.
    - Produced quickly.
    - Thrown away.
    - Generates many possible ideas.
    - Help client acceptance.

- High Fidelity
    - Built in software for automation.
    - Similar style to final product.
    - Accurate detail is important.
    - Finalises chosen ideas.
    - Still thrown away.
    - Used in realistic studies.
    - Helps client acceptance.

### 3 Types of Prototype
- Role of technology.
- Look and Feel.
- Implementation Guide

### Risks of prototyping
1. Investing too much time/energy on high-fidelity prototypes.
2. Adhoc prototyping code is re-used in the real system.
3. Prototying is used instead of, rather than alongside, documentation.
4. Prototypes might be approved by the wrong stakeholders.

### Final Specification Outputs
- Architecture Design
    - Now we are talking about the internal architecture of the objects, classes, use of APIs
- Interface Design
    - Detailed ‘blueprints’ of final user interface, not just low-fidelity design, but:
        - specifics, e.g., form inputs, validation rules
        - interfaces with other services or between components (that might be developed by different teams)
- Database Design (from G51DBI)
    - Developers will presume that they can request from the DB in their code, as specified
    - Other types of database, however, could be specified
- Component Design (from G51PGP)
    - The exact class structure inside each component or indeed the logic captured in haskell-built server side code

##  Development
<img src = "https://raw.githubusercontent.com/lakerschampions/Road-of-NLP/master/Images/%E6%88%AA%E5%B1%8F2020-06-05%2012.03.50.png">

### Git
- Dev Channel
    - Stable versions – currently version 80.0.3987.87.
    - Beta versions – version66.0.3359.33 (Official Build) beta.
    - Dev versions – more often than weekly.
    - Canary builds – are the bleeding edge. Released daily, this build has not been tested or used, it’s released as soon as it’s built.
   
- roles
    - It will keep a history of everything.
    - It’s designed to stop multiple people overwriting change by mistake.
    - It lets you work on copies (branches).

##  Verification

### Low Level Object-Oriented Design

#### How To Conduct Objected-Oriented Design
- Understand and define the context and the external interactions with the system.
- Design the system architecture.
- Identify the principal objects in the system
- Develop design models.
- Specify interfaces.

#### Test Plan
- Development Test Plans
    - lets us prove that a class functions correctly
    - who will do it, with what data, on which platform
- System/Integration Test Plans
    - lets us prove that the software meets the Specs
    - tests that cause one class to use another etc
    - or test that check that components interface correctly
- Acceptance Test Plans
    - shows that the software meets the requirements
    - often done with client - so they ‘accept’ the software
    
- documents
    - Testing Process - description of approach taken
    - Requirements Traceability - links between Reqs and Tests
    - Tested Items - list of things to be tested
    - Testing Schedule - schedule in relation to overall project
    - Test Recording Procedures - how test results will be recorded 
    - Hardware/Software Requirements - for testing machines
    - Constraints - number of people, machines, etc needed
    - System Tests - a list of all the exact test cases that will be tested
- test type
    - Validation Testing : tests that show the software produces the right answer (when you give it all types of correct data)
    - Defect Testing : tests that show the software doesn't break (when you give it all types of incorrect data) 
    
- Good coder not only code fast, but more importantly, make code (5E):
    - Easy to read
    - Easy to understand
    - Easy to use
    - Easy to modify
    - Easy to test
    
#### White Box vs Black Box
- White Box Testing
    - or transparent, or glass, or clear box testing
    - you know how the code is supposed to work
    - your tests test for how it is supposed to work
    - this is for development testing
- Black Box Testing
    - where a tester doesn't know how the code works
        - you typically are running the compiled version
    - they just know: what is supposed to output for an input
    - this is for release testing and user acceptance testing

#### Automated vs Manual Testing
- Automated
    - large amounts of scripted or coded tests
    - may automate large volume data testing
    - to test server loads, up time
    - run as often as the code is compiled / submitted
    - can be built into version control platforms
- Manual
    - higher level, e.g. testing example user interactions
    - usually run at planned times - end of key stages
    - can act as a progress gate-keeping activity
    - usually run on version of code that is ‘ready’ to test
    
### TDD
![TDD]( https://github.com/lakerschampions/Road-of-NLP/blob/master/Images/%E6%88%AA%E5%B1%8F2020-06-05%2013.19.32.png)

#### Advantages
- It integrates aspects of Specification and Coding and Testing
- Makes you think about how code is used, before you build it
- It means you ‘plan’ code before you ‘write’ code
- It means you code to the bigger picture, not the current function
- Also: When you make a change

#### Good Tests
- You should never have to edit a test
- Your test should cover the possibilities with multiple asserts
- Testing correct handling of error means: error message = pass

### Release Testing
- Good strategies:
    - Performance driven
    - Requirement (or High-Level Spec) driven
    - Scenario driven
    
### Acceptance Testing 
- define acceptance criteria
- plan accepgance testing 
- derive acceptance tests
- run acceptance tests
- accept or reject system
