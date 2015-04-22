#include "gtypes.h"
#include "deployment.h"



roll_control__types__real lval = 0.0;
roll_control__types__real rval = 0.0;

void sensors_simulation 
    (roll_control__types__real* left_adverse_yaw,
    roll_control__types__real* right_adverse_yaw)
{
	lval = 500.0;
	rval = -200.0;

	*left_adverse_yaw = lval;
	*right_adverse_yaw = rval;
}
