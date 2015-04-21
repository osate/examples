/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */
#ifndef _RollRateWarning_RollRate_H_
#define _RollRateWarning_RollRate_H_

#include "kcg_types.h"

/* =====================  no input structure  ====================== */

/* =====================  no output structure  ====================== */


/** RollRateWarning computes the left warning and right warning alarms according to the plane roll rate. */
/* RollRate::RollRateWarning */
extern void RollRateWarning_RollRate(
  /* RollRate::RollRateWarning::rollRate */ kcg_real rollRate,
  /* RollRate::RollRateWarning::leftWarning */ kcg_bool *leftWarning,
  /* RollRate::RollRateWarning::rightWarning */ kcg_bool *rightWarning);

#endif /* _RollRateWarning_RollRate_H_ */
/* $**************** KCG Version 6.4 (build i21) ****************
** RollRateWarning_RollRate.h
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

