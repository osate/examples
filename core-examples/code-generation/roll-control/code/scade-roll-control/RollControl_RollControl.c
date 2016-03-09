/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "RollControl_RollControl.h"

#ifndef KCG_USER_DEFINED_INIT
void RollControl_init_RollControl(outC_RollControl_RollControl *outC)
{
  outC->mode = off_RollMode;
  outC->rightWarning = kcg_true;
  outC->leftWarning = kcg_true;
  outC->rollRate = 0.0;
  /* 1 */ RollMode_init_RollMode(&outC->_1_Context_1);
  /* 1 */ RisingEdge_init_digital(&outC->Context_1);
}
#endif /* KCG_USER_DEFINED_INIT */


#ifndef KCG_NO_EXTERN_CALL_TO_RESET
void RollControl_reset_RollControl(outC_RollControl_RollControl *outC)
{
  /* 1 */ RollMode_reset_RollMode(&outC->_1_Context_1);
  /* 1 */ RisingEdge_reset_digital(&outC->Context_1);
}
#endif /* KCG_NO_EXTERN_CALL_TO_RESET */

/** "Title_1" {Title = "Title : ROLL RATE CONTROL APPLICATION"} */
/** "Author_1" {Author = "Created by : ESTEREL TECHNOLOGIES"} */
/* RollControl::RollControl */
void RollControl_RollControl(
  inC_RollControl_RollControl *inC,
  outC_RollControl_RollControl *outC)
{
  /* RollControl::RollControl */ kcg_real tmp;
  
  outC->rollRate = /* 1 */
    RollRateCalculate_RollRate(
      inC->joystickCmd,
      inC->leftAdverseYaw,
      inC->rightAdverseYaw);
  /* 1 */
  RollRateWarning_RollRate(
    outC->rollRate,
    &outC->leftWarning,
    &outC->rightWarning);
  /* 2 */ if (0. <= outC->rollRate) {
    tmp = outC->rollRate;
  }
  else {
    tmp = - outC->rollRate;
  }
  /* 1 */ RisingEdge_digital(inC->onOffPressed, &outC->Context_1);
  /* 1 */
  RollMode_RollMode(tmp, outC->Context_1.RE_Output, &outC->_1_Context_1);
  outC->mode = outC->_1_Context_1.mode;
}

/* $**************** KCG Version 6.4 (build i21) ****************
** RollControl_RollControl.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

