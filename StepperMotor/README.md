# Stepper Motor Example

This example shows an analytical architectural-fault-modeling approach can be used to diagnose hard to test and correct time-sensitive design errors in a control system early in the lifecycle leading to reduced rework cost.

A complete description this example is available in the case-study is available in [Improving Quality Using Architecture
Fault Analysis with Confidence
Arguments (CMU/SEI-2015-TR-006)](https://resources.sei.cmu.edu/asset_files/TechnicalReport/2015_005_001_435065.pdf)

This example differs in some details from that shown in the report but covers similar ground.

### Organization of the example

The example is contained in CasePosiitonControl.aadl with supporting error-types in SMErrorTypes.aadl. There are several implementations of the stepper motor within CasePositionControl.aadl, all of which are described a various levels of detail in the referenced report.

* SMS.Original
* SMS.MidFrame
* SMS.buffered
* SMS.Position

### Analyses supported by this model
* EMV
* Latency

### Differences from the technical report

There are many differences between the example and what is shown in the technical report. The meaningful ones are shown below.
* Behavior analysis is not supported in the current version of OSATE
* A figure similar (but not identical) to Figure 8, *SMS in Its Operational Environment* is created from "system implementation SMS_Operational_Environment.original"
* Figure 10, *Details of Logical SM_PCS Architecture* shows the period of the SM_PCS and the health monitor (HM). The current diagramming functionality of OSATE does not support this display. Otherwise diagramming System Impl SMS.Original will produce a similar diagram.
* Figure 13, *Position Control System Behavior Specification* shows the "thread implementation SM_PCS.impl". Within it is an "annex Behavior_Specification" that is commented out in the example file. Apparently the behavior specification annex is purely informative at this point.
* There are many naming differences but the semantics are pretty much the same.

### Conducting analysis

* The fault impact analysis discussed in Figure 25 is created by instantiating system implementation SMS.Original and then selecting Analyses -> Safety -> Analyze Fault Impact. The result is identical.

5/27/2020

