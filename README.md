#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###Not yet ready!

##Progress

__Here's a list of what still needs to be implemented:__

 * ??? -> __LocalManager:__ 
   * Must contain a Cal.
     * Must be able to fetch that Cal from an XML-file.
   * Must implement all methods defined in TaskManager.
   * Must work in asynchronous manner, allowing multiple method calls to run in parallel.
   * [OPTIONAL] May have a limit on the number of method calls running in parallel, e.g. only 10 threads at once, or maybe only 1 - making it similar to our previous FileMananger.
   * Must have a separate thread running in the background, which saves the Cal to a file every time a certain amount of time has passed.
     * If not, any method performing changes will have to do the saving, which can cause I/O clashes, or cause large queues waiting for accesss to the .xml-file.
 
 * Oliver -> __RemoteManager:__
   * Must contain a Transmitter.
     * Must be able to use this transmitter, when asked to perform an action, by translating the task into a string, and sending it to the host.
     * Should then listen for a reply and return it as a result.
 * Oliver ->__RemoteManagerHost:__ 
   * Must contain a TaskManager.
   * Must contain a Receiver.
     * Must be able to use this receiver to listen for requests.
       * Must be able to translate these requests, forward them to the TaskManager, and send back the result to the source.

 * Oliver -> __ClientConsole:__ 
   * Might need to be updated in order to provide a guided setup of the environment, e.g. choosing the protocol through which a RemoteManager should communicate.
 * [OPTTIONAL] ??? -> __ServerConsole:__ 
   * May make a console interface for setting up the server.
   * Could allow gently shutting down the server, e.g. by telling it to [exit].
 
##Package Overview

__Brief descriptions of all the packages in the project:__ 
 * __remote:__ Contains interfaces for classes which will provide modularity in terms of how objects are sent remotely.
 * __remote.udp:__ Implementations the interfaces in the 'remote' package, providing modules for allowing transmitting/receiving strings through UDP. 

 * __serialization:__ Contains classes which provide Java object representations of the XML tags declared in task-manager-revised.xml.
 * __serialization.util__ Contains a Serializer class, which acts as  utility to serialize java objects from the 'serialization' package into a String of XML, and deserialize a string of XML into such objects.   

 * __taskmanager:__ Contains an interface which describes the public features which a TaskManager must provide.
 * __taskmanager.local__ Contains implementations of the TaskManager interface, which manages their content locally.
 * __taskmanager.remote:__ Contains implementations of the TaskManager interface, which manages their content remotely.

 * __ui:__ Contains classes which provides interaction with a TaskManager through some kind of User Interface, e.g. the console.

##Execution

__In order to execute and test this project, you should do the following:__

 * If testing out a RemoteManager with a certain protocol, e.g. UDP, you will need to have a corresponding RemoteManagerHost running, before proceeding.
 * Run one or more instances of Console.java, on one or multiple machines.
 * Follow the instructions in the console.

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
 * __Attempt to corrupt the data or produce some other kind of error:__ Execute two related tasks at the same time.
   * {execute, handin-01} - executed at the same time by different sources.

##Example Console Dumps
###Not yet ready!