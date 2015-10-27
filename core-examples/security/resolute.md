Resolute Functions
==================

The following paragraphs discusses the security modeling patterns
and the associated rules we use with RESOLUTE. 


Modeling Patterns
-----------------
### Security Level
The security level is associated with the component. When a component
has several security levels, it must be verified (so, it must have
the property is_verified set to true).
A component with several security level is considered as an MLS
component.

An MLS component must specify what security levels it can handle.
An MLS component must specify what security levels are associated
with each port. 


### Isolation Mechanisms
Either functions (functional model) or processes (implementation model)
are associated to a processor or memory.

If several processes are associated with the same processor, they must
be at the same security level.
If the processes are not at the same security level, they must be
in partitions supported by a separation kernel. Partitions are specified
with virtual processor. Virtual processors are associated
with a kernel that supports time and space isolation.


Security Verification Rules with RESOLUTE
-----------------------------------------
### R0: Shared buses through different components
Check components at different security levels sharing a bus. If two
components at different security levels share the same bus, there
is a potential security issue of the component at a low security level
will accesses data at a high security level.

### R1: Functions inter-connected must use similar security levels
Functions that are communicating must handle data at the same security level.
The feature or the component must share the same security levels.

### R2: Processes with different security levels executed on the same processor are bound to separate memories
Two process or abstract AADL components with different
security levels cannot be bound or associated to the same memory.

### R3: Processes having different security levels must be associated with separate partitions
Two process or abstract AADL components having different security
levels cannot be bound to the same processor or partition.
They must be in separate partitions that are executed on a kernel
supporting time and space isolation.

### R4: All threads in a process must have the same security level or the process is verified
All AADL thread components in an AADL process component must have the same
security level.

### R5: An MLS component must specify the security level of the data he is handling on his ports
An MLS component is a component having multiple security levels. For MLS components,
the component must explicitly defined the security levels it handles. Such components
must also define the security level for each feature (what security levels are
associated with each interface/feature).

### R6: Bouncer component.
An MLS component cannot be used as a gateway to downgrade a data from a given
security level to another one unless it has been verified.
