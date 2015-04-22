#include "gtypes.h"
#include "deployment.h"


void display 
    (roll_control__types__bool left_warning,
    roll_control__types__bool right_warning,
    roll_control__types__real roll_rate)
{
//	myprint_double ("Roll Rate", myprint_double);
	if (left_warning == 1)
	{
#ifdef OCARINA_RUNTIME_DEOS
		myprint_str ("LEFT WARNING ON");
#endif
	}
	else
	{
#ifdef OCARINA_RUNTIME_DEOS
		myprint_str ("Left Warning Off");
#endif
	}

	if (right_warning == 1)
	{
#ifdef OCARINA_RUNTIME_DEOS
		myprint_str ("RIGHT WARNING ON");
#endif
	}
	else
	{
#ifdef OCARINA_RUNTIME_DEOS
		myprint_str ("Right Warning Off");
#endif
	}

#ifdef OCARINA_RUNTIME_DEOS
	myprint_int ("Roll Rate", (int)roll_rate);
#endif

}
