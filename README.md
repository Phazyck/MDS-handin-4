#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###TODO
####Test cases - Describe test cases:
 1. Execute a task.
  * Description...
 2. Try to produce a deadlock.
  * Description...
 3. Test case 3.
 4. etc...

####Candidate classes - Define possibly missing classes:
 1. A super class for both Client and Server, implementing common UDP functionality?
 2. Candidate class 2.
 3. etc...

####Candidate methods - Define interfaces for a class:
 1. Client - void send(String request) - sends a request to the server through UDP.
 2. Server - String receive() - receives and returns a request from the client through UDP.
 3. Class - type method(args) - description.
 4. etc...

####Class requirements - Describe requirements for a class:
 1. Client and Server must communicate using UDP.
 2. Server must allow multiple clients at the same time.
 3. The Tasks must be managed synchronously.
 4. Candidate requirement 4.
 5. etc...

####Delegate Class - Assign class development to team members:
 1. Class 1 => Member 1
 2. Class 2 => Member 2
 3. etc...


##Package Overview

###serialization

__Serializer:__
 This class is capable of serializing/deserializing any class in serialization.common.

###serialization.common

__Cal, Users, User, Tasks, Task:__
 These classes are used to represent XML-data, and can be serialized/deserialized to/from XML.

###udp

__Server:__
 A UDP server which enables multiple clients to execute tasks.

__Client:__
 A UDP client for the Server class.

###taskmanager

__TaskManager:__
 A synchronous TaskManager.

##Execution

In order to execute and test this project, you should do the following:

1. Run a single instance of Server.java.
2. Run one or more instances of Client.java.
3. Follow the instructions in the terminal.

##Example Test Runs
###Not yet ready!