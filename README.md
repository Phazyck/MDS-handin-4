#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###TODO
####Test cases - Describe test cases:
 1. Submit, fail, resubmit and pass a hand-in.
   1. Execute "handin-01".
   2. Execute "review-01".
   3. Execute "reject-01".
   4. Execute "handin-01".
   5. Execute "review-01".
   6. Execute "approve-01".
   7. Execute "qualify-for-exam".
 2. Try to produce a deadlock.
   1. I dunno...
 3. Execute a review before handing in.
   1. Execute "review-01".

####Candidate classes - Define possibly missing classes:
 1. An abstract super class, UdpEntity, for both UdpManagerClient and UdpManagerServer, implementing common UDP functionality?
 2. A class AsyncManager, that manages tasks asynchronously.

####Candidate methods - Define interfaces for a class:
 1. UdpEntity - void send(String request) - sends a request to the server through UDP.
 2. UdPEntity - String receive() - receives and returns a request from the client through UDP.

####Class requirements - Describe requirements for a class:
 1. UdpManagerClient and UdpManagerServer must communicate using UDP.
 2. UdpManagerServer must be able to handle requests from multiple UdpManagerClients.
 3. The Tasks must be managed synchronously.

####Delegate Class - Assign class development to team members:
 1. Console => Oliver


##Package Overview

###serialization

__Serializer:__
 This class is capable of serializing/deserializing any class in serialization.common.

###serialization.common

__Cal, Users, User, Tasks, Task:__
 These classes are used to represent XML-data, and can be serialized/deserialized to/from XML.


###taskmanager

__TaskManager:__
 An interface for all TaskManagers.

__FileManager:__
 A TaskManager which manages and stores its content on a local XML-file.

__UdpManagerClient:__
 A TaskManager which manages its contents remotely through UDP.

__UdpManagerServer:__
 A UDP server which provides functionality to multiple UdpManagerClients, through UDP.

###test

__Console:__
  A TaskManager tester which, in the console, guides a user through task execution and more.

##Execution

In order to execute and test this project, you should do the following:

1. If testing out UdpClient, run a single instance of UdpServer.java.
2. Run one or more instances of Console.java.
3. Follow the instructions in the console.

##Example Test Runs
###Not yet ready!