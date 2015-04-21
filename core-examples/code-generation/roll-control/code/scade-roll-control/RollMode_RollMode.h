/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */
#ifndef _RollMode_RollMode_H_
#define _RollMode_RollMode_H_

#include "kcg_types.h"

/* =====================  no input structure  ====================== */

/* =====================  no output structure  ====================== */

/* ========================  context type  ========================= */
typedef struct {
  /* ---------------------------  outputs  --------------------------- */
  TRollMode_RollMode /* RollMode::RollMode::mode */ mode;
  /* -----------------------  no local probes  ----------------------- */
  /* -------------------- initialization variables  ------------------ */
  kcg_bool init1;
  kcg_bool init;
  /* ----------------------- local memories  ------------------------- */
  SSM_ST_SMOn_SMRollMode_On /* RollMode::RollMode::SMRollMode::On::SMOn */ SMOn_state_nxt_SMRollMode_On;
  SSM_ST_SMRollMode /* RollMode::RollMode::SMRollMode */ SMRollMode_state_nxt;
  /* -------------------- no sub nodes' contexts  -------------------- */
  /* ----------------- no clocks of observable data ------------------ */
} outC_RollMode_RollMode;

/* ===========  node initialization and cycle functions  =========== */
/* RollMode::RollMode */
extern void RollMode_RollMode(
  /* RollMode::RollMode::absRollRate */ kcg_real absRollRate,
  /* RollMode::RollMode::onOffPressed */ kcg_bool onOffPressed,
  outC_RollMode_RollMode *outC);

#ifndef KCG_NO_EXTERN_CALL_TO_RESET
extern void RollMode_reset_RollMode(outC_RollMode_RollMode *outC);
#endif /* KCG_NO_EXTERN_CALL_TO_RESET */

#ifndef KCG_USER_DEFINED_INIT
extern void RollMode_init_RollMode(outC_RollMode_RollMode *outC);
#endif /* KCG_USER_DEFINED_INIT */

#endif /* _RollMode_RollMode_H_ */
/* $**************** KCG Version 6.4 (build i21) ****************
** RollMode_RollMode.h
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

