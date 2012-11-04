#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###Not yet ready!

##Progress

__Here's a list of what still needs to be implemented:__

 * __taskmanager.local:__ A package which could potentially provide different flavors of local TaskManagers, must include at least:
   * __LocalManager:__ A TaskManager which provides asynchronous content management and reads/writes from/to a local .xml-file.
It would probably be a good idea to have an option to limit the amount of parallel threads to some max integer. E.g., if this parameter is set to '1' we end up with an object quite similar to our previous FileManager.
Also, any TaskManager which saves its content to a file, should probably have a separate thread running in the background which saves the current state every [X] seconds.
In contrast, we used to have the FileManager save everytime changes were made. This approach might not work well in an asynchronous environment where several changes can happen "at the same time".
 
 * __taskmanager.remote:__ A package which provides classes for hosting and managing tasks remotely, with at least the following classes:
   * __RemoteManager:__ A proxy for some kind of TaskManager which is stored on a remote resource, which is then accessed through some kind of internet protocol, e.g. UDP.
   * __RemoteManagerHost:__ A host which provides the means of managing some kind of locally contained TaskManager, from a RemoteManager client, through some kind of internet protocol, e.g. UDP.
The RemoteManagerHost must have the capability to act as a host to multiple RemoteManagers running in parallel from different locations. It would probably be a good idea to have an option to restrict how many clients can be serviced concurrently. Thus, if this parameter is set to '1', we end up with a server similar to what we have made before, but if we turn it up, we can serve multiple clients at the same time.
 * __Console:__ Might need to be updated in order to provide a guided setup of the environment, e.g. choosing the protocol through which a RemoteManager should communicate.

__Here's a list of what we have implemented so far:__

 * __TaskManager:__ An interface which describes what features any kind of TaskManager must provide.
 * __serialization:__ A package with the classes needed to serialize/deserialize to/from task-manager-revised.xml.
 * __remote:__ A package with classes which provide an abstraction from the underlying internet protocols used for remote message passing.
 * __ui:__ A package with at least one class providing interaction with the TaskManager though a user interface, e.g. the console.

##Package Overview

__An view over all the packages and the classes in the project:__ 

 * __remote:__ Contains classes for providing abstractions from the actual implentations of different kinds of remote communication. By implementing the three interfaces, e.g. as done in remote.udp, one can then abstract from the network details from there on. One could imagine also making another package, remote.tcp with a TcpTransceiver etc.. Then, one can simply change what transceivers are used, and the underlying protocol will then be changed.
   * __Transmitter, Receiver, Transceiver:__ These are interfaces for remote message (String) passing.
 * __remote.udp__
   * __UdpTransmitter, UdpReceiver, UdpTransceiver:__ Implementations of the above interfaces, providing remote message passing trough UDP.

 * __serialization:__ 
   * __Cal, Users, User, Tasks, Task:__ The Java object representations of the XML tags in task-manager-revised.xml. Used when serializing/deserializing that file to/from XML.
 * __serialization.util__ 
   * __Serializer:__ This class handles the actual serialization of Java objects into a string of XML, and the deserialization of a string of XML into Java objects.

 * __taskmanager:__
   * __TaskManager:__ An interface for all TaskManagers to implement. Declares the public features which any kind of TaskManager must provide.
 * __taskmanager.local__
   * __LocalManager:__ An asynchronous TaskManager which manages its content in the memory, and stores it on a local .xml-file.
 * __taskmanager.remote:__ TaskManagers for which their actual content is stored on a remote location. The protocol used to communicate is specified by providing a Transceiver for that protocol. E.g., to have a RemoteManager which uses the UDP protocol, it should be supplied with a UdpTransceiver.
   * __RemoteManager:__ A TaskManager which manages its contents remotely through some internet protocol, e.g. UDP. 
   * __RemoteManagerHost:__ A host for the RemoteManagers content, which is accessed through some internet protocol, e.g. UDP.

 * __ui:__ Contains one or more classes which provides a way to interact with a TaskManager through a user interface, e.g. the console.
   * __Console:__ A console interface which guides the user through task execution etc.

##Execution

__In order to execute and test this project, you should do the following:__

1. If testing out the NetManager through UDP, you will need to have a NetManagerHost running, which uses the same protocol, e.g. UDP.
2. Run one or more instances of Console.java.
3. Follow the instructions in the console.

##Test Cases

__Here are some different test cases, and the console input needed, after the initial setup, to try them out:__

 * __Submit, review, reject, resubmit, review, pass and then qualify hand-in:__ In other words, try to go through the whole chain of states in a completely legal and plausible way.
   * {execute, handin-01, execute, review-01, execute, reject-01, execute, handin-01, execute, review-01, execute, approve-01, execute, qualify-for-exam}
 * __Attempt to produce a deadlock:__ By executing a review before the hand-in is executed, and then execute the hand-in. The review execution might then wait for the hand-in execution to complete, which in turn waits for the review execution to complete, because they might be blocking each other's desired resource.
   * {execute, review-01, execute, handin-01}
 * __Attempt to execute a review before handing in:__ In our implementation, this action should abort, since it does not make sense. If letting the execution wait for the handin to be executed, get closer to making the deadlock attempted above, possible. Thus, the review should fail, and you should then manually try again at a later time, when the handin is executed.
   * {execute, review-01}
 * __Show all details about handin-01:__ Simply test out the "display" feature.
   * {display, handin-01}
 * __Show all users:__ Test out the "users" feature.
   * {users}
 * __Show all tasks attended by Rao:__ Test out the "tasks" feature.
   * {tasks, rao}

##Example Console Dumps
###Not yet ready!