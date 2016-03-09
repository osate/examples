/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */
#ifndef _RollRateCalculate_RollRate_H_
#define _RollRateCalculate_RollRate_H_

#include "kcg_types.h"
#include "AdverseYaw_RollRate.h"

/* =====================  no input structure  ====================== */

/* =====================  no output structure  ====================== */


/** RollRateCalculate computes the aircraft roll rate due to stick input and adverse yaw effects. */
/* RollRate::RollRateCalculate */
extern kcg_real RollRateCalculate_RollRate(
  /* RollRate::RollRateCalculate::joystickCmd */ kcg_real joystickCmd,
  /* RollRate::RollRateCalculate::leftAdverseYaw */ kcg_real leftAdverseYaw,
  /* RollRate::RollRateCalculate::rightAdverseYaw */ kcg_real rightAdverseYaw);

#endif /* _RollRateCalculate_RollRate_H_ */
/* $**************** KCG Version 6.4 (build i21) ****************
** RollRateCalculate_RollRate.h
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

