all: clean generate

generate:
	ocarina -aadlv2 -f -b -r tasksync::pc.singletask -g polyorb_hi_c *.aadl
	ocarina -aadlv2 -f -b -r tasksync::pc.multitasks -g polyorb_hi_c *.aadl

clean:
	rm -rf *~  pc_i  pc_multitasks  pc_singletask 
