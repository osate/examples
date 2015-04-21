/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "RollRateCalculate_RollRate.h"

/** RollRateCalculate computes the aircraft roll rate due to stick input and adverse yaw effects. */
/* RollRate::RollRateCalculate */
kcg_real RollRateCalculate_RollRate(
  /* RollRate::RollRateCalculate::joystickCmd */ kcg_real joystickCmd,
  /* RollRate::RollRateCalculate::leftAdverseYaw */ kcg_real leftAdverseYaw,
  /* RollRate::RollRateCalculate::rightAdverseYaw */ kcg_real rightAdverseYaw)
{
  /* pwlinear::LimiterSymmetrical::Lower_limit */ kcg_real Lower_limit_1;
  /* pwlinear::LimiterSymmetrical::Upper_limit */ kcg_real Upper_limit_1;
  /* RollRate::RollRateCalculate::_L6 */ kcg_real _L6;
  /* RollRate::RollRateCalculate::rollRate */ kcg_real rollRate;
  
  Upper_limit_1 = /* 1 */ AdverseYaw_RollRate(leftAdverseYaw, rightAdverseYaw);
  _L6 = (joystickCmd - Upper_limit_1) * 0.25;
  Upper_limit_1 = 25.0 + 0.0;
  Lower_limit_1 = 0.0 - 25.0;
  /* 5 */ if (_L6 >= Upper_limit_1) {
    rollRate = Upper_limit_1;
  }
  else /* 8 */ if (_L6 <= Lower_limit_1) {
    rollRate = Lower_limit_1;
  }
  else {
    rollRate = _L6;
  }
  return rollRate;
}

/* $**************** KCG Version 6.4 (build i21) ****************
** RollRateCalculate_RollRate.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

