#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###Not yet ready!

##Suggestions

__Here's some suggestions on how to proceed.__

###Candidate Classes
 * __public abstract class UdpEntity__ - A super classs for both UdpManagerClient and UdpManagerServer, implementing common UDP functionality.
 * __public class AsyncManager__ - A dedicated asynchronous TaskManager.

###Candidate Methods
 * __UdpEntity__
   * __public void send(String x)__ - sends a string using UDP.
   * __public String receive()__ - receives a string using UDP.

##Package Overview

__An overview off all the packages and the classes inside:__

 * __serialization__
   * __Serializer:__ This class is capable of serializing/deserializing any class in serialization.common.
 * __serialization.common__
   * __Cal, Users, User, Tasks, Task:__ These classes are used to represent XML-data, and can be serialized/deserialized to/from XML.
 * __taskmanager__
   * __TaskManager:__ An interface for all TaskManagers.
   * __FileManager:__ A TaskManager which manages and stores its content on a local XML-file. 
   * __UdpManagerClient:__ A TaskManager which manages its contents remotely through UDP. 
   * __UdpManagerServer:__ A UDP server which provides functionality to multiple UdpManagerClients, through UDP. 
 * __test__
   * __Console:__ A TaskManager tester which, in the console, guides a user through task execution and more.

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