#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###Not yet ready!

##Suggestions

__Here's some suggestions on how to proceed.__

###Candidate Classes
 * An abstract super class, UdpEntity, for both UdpManagerClient and UdpManagerServer, implementing common UDP functionality?
 * A class AsyncManager, that manages tasks asynchronously.

###Candidate Methods
 * UdpEntity - void send(String request) - sends a request to the server through UDP.
 * UdPEntity - String receive() - receives and returns a request from the client through UDP.

##Package Overview

__An overview off all the packages and the classes inside:__

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

__In order to execute and test this project, you should do the following:__

1. If testing out UdpClient, run a single instance of UdpServer.java.
2. Run one or more instances of Console.java.
3. Follow the instructions in the console.

##Test Cases

__Here are some different test cases, and the console input needed to try them out:__

 * Submit, review, reject, resubmit, review, pass and then qualify hand-in.
   * {execute, handin-01, execute, review-01, execute, reject-01, execute, handin-01, execute, review-01, execute, approve-01, execute, qualify-for-exam}
 * Attempt to produce a deadlock.
   * I dunno...
 * Attempt to execute a review before handing in.
   * {execute, review-01}
 * Show all details about handin-01
   * {display, handin-01}
 * Show all users
   * {users}
 * Show all tasks attended by Rao.
   * {tasks, rao}

##Example Console Dumps
###Not yet ready!