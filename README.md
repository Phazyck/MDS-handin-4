#Hand-in 4 - Synchronization and Concurrency Control

##Introduction

__Everything you need to know:__

In this project, we have made some new decisions regarding design, and reused/improved on some old ones.
Remote communication works via communication modules, allowing to quickly change from udp to tcp, if needed.
Classes used for serialization have been updated according to the revised .xml-file. Some now have additional helper method, providing more user-friendly ways of manipulating their internal data.
After some thinking, we have gone back to making a (better) generic Serializer.
Any class taking on the role of a TaskManager, implements that interface.
This allows us to switch out TaskManagers as needed, e.g. changing from a local to a remote TaskManager.
The LocalManager is made safe in a concurrent environment.
Thus, a RemoteManagerHost holding a LocalManager, will spawn new threads for each request, with thread interacting with the LocalManager and sending back a reply when done.
For testing purposes, we have decided to make an interactive client console, instead of our previously hard-coded tests.

To test the applicaton, see the _Execution_ section, and maybe try out some of the cases in the _Test Cases_ section.

There are no refences to other libraries than the standard JDK library.

For each test cases, some text dumps have been organized in the folder named 'test_dumps'.

Enjoy!
 
##Package Overview

__Brief descriptions of all the packages in the project:__ 
 * __concurrent:__ Contains Runnable classes used in different situations involving concurrency.

 * __remote:__ Contains interfaces for classes which will provide modularity in terms of how objects are sent remotely.
 * __remote.udp.string:__ Implementations of the interfaces in the 'remote' package, providing modules for allowing transmitting/receiving strings through UDP. 

 * __serialization:__ Contains classes which provide Java object representations of the XML tags declared in task-manager-revised.xml.
 * __serialization.util__ Contains a Serializer class, which acts as  utility to serialize java objects from the 'serialization' package into a String of XML, and deserialize a string of XML into such objects.   

 * __taskmanager:__ Contains an interface which describes the public features which a TaskManager must provide.
 * __taskmanager.local__ Contains implementations of the TaskManager interface, which manages their content locally.
 * __taskmanager.remote:__ Contains implementations of the TaskManager interface, which manages their content remotely.

 * __ui:__ Contains classes which provides interaction with a TaskManager through some kind of User Interface, e.g. the console.

##Execution

__In order to execute and test this project, you should do the following:__

 * To reset the data, overwrite the 'task-manager-revised.xml' file in 'MDS-handin-4\lib' with the 'task-manager-revised.xml' file in 'MDS-handin-4'.
 * If testing out a RemoteManager with a certain protocol, e.g. UDP, you will need to have a corresponding RemoteManagerHost running, before proceeding.
 * Run one or more instances of Console.java, on one or multiple machines.
 * In the console for each instance, you can choose to test either a local or a remote TaskManager
 * Type either 'local' or 'remote' and hit enter.
 * Follow the instructions in the console.

##Test Cases

__Here are some different test cases, and the console input needed, after the initial setup, to try them out:__

1. __Submit, review, reject, resubmit, review, pass and then qualify hand-in:__ In other words, try to go through the whole chain of states in a completely legal and plausible way.
   * [execute|handin-01|execute|review-01|execute|reject-01|execute|handin-01|execute|review-01|execute|approve-01|execute|qualify-for-exam]
2. __Attempt to produce a deadlock:__ By executing a review before the hand-in is executed, and then execute the hand-in. The review execution might then wait for the hand-in execution to complete, which in turn waits for the review execution to complete, because they might be blocking each other's desired resource. This kind of deadlock was demonstrated by Rao. In our implementation, the review should simply be denied, freeing up the resources, and the hand-in can be executed. One can then try again to execute a review, and this time, it should succeed.
   * [execute|review-01|execute|handin-01]
3. __Attempt to execute a review before handing in:__ In our implementation, this action should abort, since it does not make sense. If letting the execution wait for the handin to be executed, get closer to making the deadlock attempted above, possible. Thus, the review should fail, and you should then manually try again at a later time, when the handin is executed.
   * [execute|review-01]
4. __Show all details about handin-01:__ Simply test out the "display" feature.
   * [display|handin-01]
5. __Show all users:__ Test out the "users" feature.
   * [users]
6. __Show all tasks attended by Rao:__ Test out the "tasks" feature.
   * [tasks|rao]
7. __Attempt to produce faulty output due to concurrency errors:__ Imagine the following scenario: 'handin-01' is executed by student-01. TA-01 then executes 'review-01', followed by 'approve-01'.
Rao then looks at the assignment and spots a fatal flaw, or maybe the students have cheated, thus he will execute 'reject-01'.
Meanwhile, Thomas is about to execute 'qualify-for-exam'. Rao's request reaches the request just before Thomas' request.
One could imagine Rao's request gets halfway through the process, modifying all related tasks, except the response task 'handin-01'.
Meanwhile, the scheduler switches to the thread which handles Thomas' request. First, checks are done on the conditions. If this check is allowed at this point in time, Thomas' request will go through, even though 'reject-01' came first, leaving us with a handin which is both qualified and rejected.
In order to increase this risk of happening, we have introduced a private field "SLEEP" inside the localmanager. Setting the field to an integer, e.g. 10, will make any thread reaching a certain point in the code sleep in 'SLEEP' seconds.
In a previous build, this produced errors. We have now fixed this by placing locks at some appropriate places. To prove this, follow this test case:
     * Change the SLEEP field in LocalManager.java to 10, run the RemoteManagerHost and connect four Console instances to it. Let's call these four consoles student-01, TA-01, Rao and Thomas. student-01 will first enter its command sequence, followed by TA-01. Rao and Thomas will then time their sequences so that each time Rao hits enter, Hilde hits enter a split-second later.
     * student-01 : [execute|handin-01]
     * TA-01: [execute|review-01|execute|approve-01
     * Rao: [execute|reject-01] 
     * Thomas: [execute|qualify-for-exam]
