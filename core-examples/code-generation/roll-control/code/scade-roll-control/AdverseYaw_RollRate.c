/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "AdverseYaw_RollRate.h"

/** AdverseYaw represents simplified coupling effects between roll and yaw. */
/* RollRate::AdverseYaw */
kcg_real AdverseYaw_RollRate(
  /* RollRate::AdverseYaw::leftAdverseYaw */ kcg_real leftAdverseYaw,
  /* RollRate::AdverseYaw::rightAdverseYaw */ kcg_real rightAdverseYaw)
{
  /* RollRate::AdverseYaw::rollCoupling */ kcg_real rollCoupling;
  
  rollCoupling = (leftAdverseYaw - rightAdverseYaw) * 0.1;
  return rollCoupling;
}

/* $**************** KCG Version 6.4 (build i21) ****************
** AdverseYaw_RollRate.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

