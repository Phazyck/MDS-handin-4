##OBS: Major updates to the project have yet to be committed. I committed them locally on my desktop and then went out of town. It'll be up on Sunday. -Oliver

#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###Not yet ready!

##Progress

__Here's a list of what still needs to be implemented:__

 * __taskmanager.local:__ A package which provides different flavors of local TaskManagers, including at least the following:
   * __LocalManager:__ A TaskManager which provides asynchronous content management and reads/writes from/to a local .xml-file.
   * _NOTE1:_ It would probably be a good idea to have an option to limit the amount of running threads to some integer. E.g., if this parameter is '1' we end up with an object quite similar to our previous FileManager.
   * _NOTE2:_ Any TaskManager which saves its content to a file, should probably have a thread running which saves the state every [X] seconds.
Before, we used to have the FileManager save everytime changes where made. This approach might not work well in an asynchronous environment where several changes can happen "at the same time".
 
 * __taskmanager.remote:__ A package which provides classes for hosting and managing tasks remotely, with at least the following classes:
   * __RemoteManager:__ A TaskManager which provides remote access to some kind of Task Manager, e.g. an AsyncManager, through some kind of internet protocol, e.g. UDP.
   * __RemoteManagerHost:__ A class holding some kind of TaskManager, e.g. AsyncManager, which allows one or more NetManagers to manage it remotely through some kind of internet protocol, e.g. UDP.
 * __Console:_ Might need to be updated in order to provide a guided setup of the environment, e.g. choosing the protocol through which a RemoteManager should communicate.

__Here's a list of what we have implemented so far:__

 * __TaskManager:__ An interface which describes what features any kind of TaskManager must provide.
 * _serialization:_ A package with the classes needed to serialize/deSerialize to/from task-manager-revised.xml.
 * _remote:_ A package with classes which provide an abstraction from the underlying internet protocols used for remote message passing.
 * _ui:_ A package with at least one class providing interaction with the TaskManager though a user interface, e.g. the console.

##Package Overview

__An overview off all the packages and the classes inside:__ 

 * __remote__
   * __Transmitter, Receiver, Transceiver:__ These are interfaces for remote message (String) passing.
 * __remote.udp__
   * __UdpTransmitter, UdpReceiver, UdpTransceiver:__ Implementations of the above interfaces, providing remote message passing trough UDP.

 * __serialization__
   * __Cal, Users, User, Tasks, Task:__ These classes are used to represent XML-data, and can be serialized/deserialized to/from XML.
 * __serialization.util__
   * __Serializer:__ This class is capable of serializing/deserializing any class in the serialization package.

 * __taskmanager__
   * __TaskManager:__ An interface for all TaskManagers.
 * __taskmanager.local__
   * __FileManager:__ A TaskManager which manages and stores its content on a local XML-file. 
   * __AsyncManager:__ A TaskManger which provides asynchronous content management.
 * __taskmanager.remote__ 
   * __RemoteManager:__ A TaskManager which manages its contents remotely through some internet protocol, e.g. UDP. 
   * __RemoteManagerHost:__ A host for the NetManagers content, which is accessed through some internet protocol, e.g. UDP.

 * __ui__
   * __Console:__ A console interface which guides the user through task execution etc.

##Execution

__In order to execute and test this project, you should do the following:__

1. If testing out the NetManager through UDP, you will need to have a NetManagerHost running, which uses the same protocol, e.g. UDP.
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