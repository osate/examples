Internet of Things example
==========================

# Objectives
This is an example of a home automation system. The home
contains a router, a server and a arduino connected
together. The router is then connected to the internet.

The arduino controls a door sensor, a door actuator (open or
close the door), a proximity sensor, a temperature sensor, etc.
The server logs data and receives commands from the outside.
It forwards then user requests to the arduino and arduino
replies to the clients.

Using the AADL model, we would like to perform
performance (latency) and safety analysis.

# Analysis Tools Support
This example highlights the user of the following
analysis capabilities in OSATE:
* Performance with latency analysis
* Safety with Fault Impact and Functional Hazard Analysis

# Contact
This model has been designed by Julien Delange <jdelange@sei.cmu.edu>