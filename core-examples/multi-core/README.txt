- arinc653.aadl
  * Provide an example to model a system
    with ARINC653 related partitions and there association
    within a multi-core architecture
    
- simple.aadl
  * Simple model to capture a multi-core architecture with
    a simple processor
    
- cache.aadl
  * Include processor cache, its associated bus and
    the underlying accessing core.
  * The numbers about the cache size and latency are
    available on:
       * http://arstechnica.com/gadgets/2002/07/caching/2/
       * http://en.wikipedia.org/wiki/Intel_Core_%28microarchitecture%29

- p4080.aadl
  * Contain several models version of the P4080 processor
  	- Regular model of the processor hardware component
  	- Extended with error description
  * See http://www.freescale.com/webapp/sps/site/prod_summary.jsp?code=P4080

- arinc653-p4080.aadl
  * Example of the use of ARINC653 annex with the P4080 extended
    component modeled in p4080.aadl file.
    
  