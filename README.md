#Hand-in 4 - Synchronization and Concurrency Control

##Project Overview

###FILLME.TXT

##To-Do

__Here's a list of what still needs to done:__

 * __Write overview:__ Fill out the project overview.
 * __Produce Test Dumps:__ Perform the tests and post the output in files named 'test_dump_X.txt'.

 
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
 * Follow the instructions in the console.

##Test Cases

__Here are some different test cases, and the console input needed, after the initial setup, to try them out:__

1. __Submit, review, reject, resubmit, review, pass and then qualify hand-in:__ In other words, try to go through the whole chain of states in a completely legal and plausible way.
   * {execute, handin-01, execute, review-01, execute, reject-01, execute, handin-01, execute, review-01, execute, approve-01, execute, qualify-for-exam}
2. __Attempt to produce a deadlock:__ By executing a review before the hand-in is executed, and then execute the hand-in. The review execution might then wait for the hand-in execution to complete, which in turn waits for the review execution to complete, because they might be blocking each other's desired resource. This kind of deadlock was demonstrated by Rao. In our implementation, the review should simply be denied, freeing up the resources, and the hand-in can be executed. One can then try again to execute a review, and this time, it should succeed.
   * {execute, review-01, execute, handin-01}
3. __Attempt to execute a review before handing in:__ In our implementation, this action should abort, since it does not make sense. If letting the execution wait for the handin to be executed, get closer to making the deadlock attempted above, possible. Thus, the review should fail, and you should then manually try again at a later time, when the handin is executed.
   * {execute, review-01}
4. __Show all details about handin-01:__ Simply test out the "display" feature.
   * {display, handin-01}
5. __Show all users:__ Test out the "users" feature.
   * {users}
6. __Show all tasks attended by Rao:__ Test out the "tasks" feature.
   * {tasks, rao}
7. __Attempt to corrupt the data or produce some other kind of error...__ 
