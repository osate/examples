The following example comes from the STAP primer report
from Nancy Leveson. See: http://sunnyday.mit.edu/STPA-Primer-v0.pdf

See chapter 3 of the report for a full description of this system.

The example is a door controller and explain when this is safe
or unsafe to open or close the door. In particular, we see the
following components:
 - door_controller  : indicate if the door can be opened or not
 - train_controller : contains a speed sensor as 
 - door_sensor      : indicate if somebody is standing between
                      the doors and that avoid them to be closed.
 - alarm            : report an emergency condition

To describe the system behavior, we make use of the AADL behavior
annex. The behavior specification is added to the door_controller
to specify the condition for opening a door (when this is safe
or not). In addition, behavior specifications have been
added to other components (such as the alarm).

We also make use of the Error-Model Annex to order to show
the error occurrence and propagation among the architecture.
We also connect the behavior and error-annex as well using
the components internal events.
