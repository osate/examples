#include "gtypes.h"
#include "deployment.h"

int nbiter = 0;

void display 
    (roll_control__types__bool left_warning,
    roll_control__types__bool right_warning,
    roll_control__types__real roll_rate)
{
//	myprint_double ("Roll Rate", amyprint_double);

#ifdef OCARINA_RUNTIME_DEOS

	if ( (left_warning == 1) && (right_warning == 1))
	{
		myprint_str_int ("LEFT WARNING ON  | RIGHT WARNING ON ", nbiter);
	}
	if ( (left_warning == 1) && (right_warning == 0))
	{
		myprint_str_int ("LEFT WARNING ON  | RIGHT WARNING OFF ", nbiter);
	}
	if ( (left_warning == 0) && (right_warning == 1))
	{
		myprint_str_int ("LEFT WARNING OFF | RIGHT WARNING ON ", nbiter);
	}
	if ( (left_warning == 0) && (right_warning == 0))
	{
		myprint_str_int ("LEFT WARNING OFF | RIGHT WARNING OFF ", nbiter);
	}
nbiter++;
#endif


//#ifdef OCARINA_RUNTIME_DEOS
//	myprint_int ("Roll Rate", (int)roll_rate);
//#endif

}
