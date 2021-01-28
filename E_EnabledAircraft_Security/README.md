# E-EnabledAircraft Example

## This example is work in progress ##

This is a generic air transport architecture modeled after the systems presented in
[Future E-Enabled Aircraft Communications and Security: The Next 20 Years and Beyond by Krishna Sampigethaya, Radha Poovendran,  Sudhakar Shetty, Terry Davis,  and Chuck Royalty, Proceedings of the IEEE | Vol. 99, No. 11, November 2011, pgs. 2040-2055](https://ieeexplore.ieee.org/document/6018242)

The figure below is taken from that paper.

<img src="./doc/sampigethaya.png" alt="architecture overview" width="700"/>


There is no publicly available documentation for this example beyond this README.

### Organization of the example



### Analyses supported by this model

### Differences from the technical report

### Exploring the Example

Open the AADL_Models folder.
Start exploring the model by looking at *TransportAircraftOperationalSystem_Generic.aadl* in the TransportAircraft folder. Create a structure diagram from *system implementation AirTransportOperationalSystem.multipassenger* and you'll get a diagram similar to this (after appropriate manipulation including hiding some connections.)

<img src="./doc/context_model.png" alt="context model" width="700"/>

The diagram shows the AADL system context model for an air transport aircraft, including external communication access connections with the aircraft, where the system transport_aircraft represents the e-enabled aircraft. All external elements are represented by the operational_environment.

Next open *OperationalEnvironment_pkg.aadl* and create a diagram from *System Impl operationalEnvironment.basicConfiguration* which should (again with some manipulation) look similar to the below.

<img src="./doc/operational_environment.png" alt="operational environment" width="700"/>

The diagram shows the major subsystems of the operational environment including those  corresponding to the off-board systems, the stakeholders, and end users on the ground.

Next open *TransportAircraft_Generic.aadl* and create a diagram from *System Impl transportAircraft.generic* which should (again with some manipulation)look like this.

<img src="./doc/generic_e_enabled.png" alt="Generic E-Enabled Aircraft" width="700"/>

The three principal aircraft domains are shown: *aircraft_control_systems*, *airline_information_system*, and *passenger_info_entertainment_services*. Computing resources are included in the aircraft subsystems. The remaining hardware components and, as appropriate, computing resources of the aircraft are represented by the *airframe* system.

Next open *AircraftControl_pkg.aadl* and create a diagram from *System Impl aircraftControl.basic* showing bus access which should look similar to this:

<img src="./doc/aircraft_control_domain.png" alt="Aircraft Control Domain" width="700"/>

The second copy of the same diagram can be created and manipulated to show communication paths within the aircraft domain:

<img src="./doc/aircraft_control_domain_comm.png" alt="Aircraft Control Domain" width="700"/>




1/21/2021
