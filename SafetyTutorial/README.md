Documentation for the Safety Tutorial Example is in the OSATE Help system. To access it go to Help->Help Contents->Error Model Annex Documentation. The two documents "Safety Analysis with Error Model V2" and "Safety Analysis of a GPS System" use the Safety Tutorial as the example. The first document explains support for FHA, Fault Impact, and Fault Tree analysis, the second is a walk through the GPS receiver example. It is worthwhile consulting both documents when looking at this example.

There are minor differences between what is currently generated with OSATE and what is shown in the documents. Most of them are not worth calling out (just wording changes, formatting, etc.) There are a few substantive differences highlighted here.

In the section on *Flow-Based Fault Trees Generated from Backward Trace of Error Propagations* "GPS.basic incoming satellite signal" appears in the generated version but not in the document when running the FTA with "outgoing propagation" and "Fault Contributor Trace".

In the section on *The GPS System and its External Interface* the probabilities assigned to various events in the definition of system FlightSystem differs between the document and the example. In the below, the first value is that shown in the document. The second is the value for example.

- ServiceOmisson: 2.5e-9 , 8.0e-7
- ErraticBehaivor: 2.0e-4 , 2.0e-7
- NoPilotInput: 2.0e-6 , 2.0e-7
- ErraticPilotInput: 7.0e-6 , 7.0e-7
- NoSignal: 2.0e-6 , 2.0e-7

These differences do not appear to affect the other parts of the Safety Tutorial.

In *Initial Physical System Design* (within *Early Physical System Analysis*)
The definition of implementation GPS.parts_SingleSensor includes a "component error behavior" with propagations in the example but not in the document.

In *Transient and Persistent Faults in the Sensor*, it is not clear from the documentation but the transitions shown in the component error behavior actually appear in the Device sensor_transient in the GPSParts.aadl file. There are only two differences between implementation GPSSystem.parts_SingleSensor and GPSSystem.parts_SingleSensorTransient. The first is that the definition of SatelliteSignalReceiver1 refers to device GPSParts::sensor in the former and to GPSParts::sensor_transient in the latter. The second is that the former includes a component error behavior section, while the latter does not.

*DOING A FTA WITH FAILSTOP for implementation GPS.parts_SingleSensorTransient causes a java.lang.StackOverflowError.*

In *Initial GPS System Architecture* (under *GPS Functional Architecture and Physical System Binding*) there is an error in the documentation. The two diagrams that start this section are identical. There are syntax differences in the models. The Fault Impact on GPS.basic does not match. There are additional rows of the form "SatelliteSignalReceiver1 error event failure" that are in the documentation but that are not generated.

The FTA results in a similar tree and all of the probabilities match EXCEPT that the Spec is shown as 8.0e-08 in the example and 1.7e-07 in the help file.

Doing a FTA on GPS.BasicRedundancy produces a tree with an extra leaf "'processing' incoming 'processor' {ServiceOmisson} from undeveloped 2.8e-05" and the rolled up probability is 5.4e-05 rather than the documents 2.6e-05.

In *Functional Architecture Bound to Physical Architecture* a FTA from GPS.BasicBound yields a tree with two additional nodes (over what is shown in the documentation), namely "'network' source 'network_binding_es'", and "'network' source 'network_access_es'".

In *Redundant Processors within GPS System Architecture* the example does not "absorb" one of the processors. The FTA is different but the overall results are the same.

08/21/2020
