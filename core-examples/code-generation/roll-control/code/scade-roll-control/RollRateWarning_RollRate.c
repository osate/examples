/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "RollRateWarning_RollRate.h"

/** RollRateWarning computes the left warning and right warning alarms according to the plane roll rate. */
/* RollRate::RollRateWarning */
void RollRateWarning_RollRate(
  /* RollRate::RollRateWarning::rollRate */ kcg_real rollRate,
  /* RollRate::RollRateWarning::leftWarning */ kcg_bool *leftWarning,
  /* RollRate::RollRateWarning::rightWarning */ kcg_bool *rightWarning)
{
  *leftWarning = rollRate < kRollRateWarning_RollRate.left;
  *rightWarning = rollRate > kRollRateWarning_RollRate.right;
}

/* $**************** KCG Version 6.4 (build i21) ****************
** RollRateWarning_RollRate.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

