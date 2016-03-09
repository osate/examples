/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */
#ifndef _RollControl_RollControl_H_
#define _RollControl_RollControl_H_

#include "kcg_types.h"
#include "RollRateCalculate_RollRate.h"
#include "RollRateWarning_RollRate.h"
#include "RollMode_RollMode.h"
#include "RisingEdge_digital.h"

/* ========================  input structure  ====================== */
typedef struct {
  kcg_real /* RollControl::RollControl::joystickCmd */ joystickCmd;
  kcg_real /* RollControl::RollControl::leftAdverseYaw */ leftAdverseYaw;
  kcg_real /* RollControl::RollControl::rightAdverseYaw */ rightAdverseYaw;
  kcg_bool /* RollControl::RollControl::onOffPressed */ onOffPressed;
} inC_RollControl_RollControl;

/* =====================  no output structure  ====================== */

/* ========================  context type  ========================= */
typedef struct {
  /* ---------------------------  outputs  --------------------------- */
  kcg_real /* RollControl::RollControl::rollRate */ rollRate;
  kcg_bool /* RollControl::RollControl::leftWarning */ leftWarning;
  kcg_bool /* RollControl::RollControl::rightWarning */ rightWarning;
  TRollMode_RollMode /* RollControl::RollControl::mode */ mode;
  /* -----------------------  no local probes  ----------------------- */
  /* -----------------  no initialization variables  ----------------- */
  /* -----------------------  no local memory  ----------------------- */
  /* ---------------------  sub nodes' contexts  --------------------- */
  outC_RollMode_RollMode /* 1 */ _1_Context_1;
  outC_RisingEdge_digital /* 1 */ Context_1;
  /* ----------------- no clocks of observable data ------------------ */
} outC_RollControl_RollControl;

/* ===========  node initialization and cycle functions  =========== */
/** "Title_1" {Title = "Title : ROLL RATE CONTROL APPLICATION"} */
/** "Author_1" {Author = "Created by : ESTEREL TECHNOLOGIES"} */
/* RollControl::RollControl */
extern void RollControl_RollControl(
  inC_RollControl_RollControl *inC,
  outC_RollControl_RollControl *outC);

#ifndef KCG_NO_EXTERN_CALL_TO_RESET
extern void RollControl_reset_RollControl(outC_RollControl_RollControl *outC);
#endif /* KCG_NO_EXTERN_CALL_TO_RESET */

#ifndef KCG_USER_DEFINED_INIT
extern void RollControl_init_RollControl(outC_RollControl_RollControl *outC);
#endif /* KCG_USER_DEFINED_INIT */

#endif /* _RollControl_RollControl_H_ */
/* $**************** KCG Version 6.4 (build i21) ****************
** RollControl_RollControl.h
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

