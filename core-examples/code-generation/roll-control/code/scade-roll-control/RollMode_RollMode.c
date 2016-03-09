/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "RollMode_RollMode.h"

#ifndef KCG_USER_DEFINED_INIT
void RollMode_init_RollMode(outC_RollMode_RollMode *outC)
{
  outC->init = kcg_true;
  outC->init1 = kcg_true;
  outC->SMRollMode_state_nxt = SSM_st_Off_SMRollMode;
  outC->SMOn_state_nxt_SMRollMode_On = SSM_st_Nominal_SMRollMode_On_SMOn;
  outC->mode = off_RollMode;
}
#endif /* KCG_USER_DEFINED_INIT */


#ifndef KCG_NO_EXTERN_CALL_TO_RESET
void RollMode_reset_RollMode(outC_RollMode_RollMode *outC)
{
  outC->init = kcg_true;
  outC->init1 = kcg_true;
}
#endif /* KCG_NO_EXTERN_CALL_TO_RESET */

/* RollMode::RollMode */
void RollMode_RollMode(
  /* RollMode::RollMode::absRollRate */ kcg_real absRollRate,
  /* RollMode::RollMode::onOffPressed */ kcg_bool onOffPressed,
  outC_RollMode_RollMode *outC)
{
  /* RollMode::RollMode::SMRollMode::On::SMOn */ SSM_ST_SMOn_SMRollMode_On SMOn_state_act_SMRollMode_On;
  /* RollMode::RollMode::SMRollMode::On::SMOn */ SSM_ST_SMOn_SMRollMode_On SMOn_state_sel_SMRollMode_On;
  /* RollMode::RollMode::SMRollMode */ SSM_ST_SMRollMode SMRollMode_state_sel;
  /* RollMode::RollMode::SMRollMode */ SSM_ST_SMRollMode SMRollMode_state_act;
  /* RollMode::RollMode::SMRollMode */ kcg_bool SMRollMode_reset_act;
  
  /* init_SMRollMode */ if (outC->init1) {
    SMRollMode_state_sel = SSM_st_Off_SMRollMode;
  }
  else {
    SMRollMode_state_sel = outC->SMRollMode_state_nxt;
  }
  /* sel_SMRollMode */ switch (SMRollMode_state_sel) {
    case SSM_st_Off_SMRollMode :
      if (onOffPressed) {
        SMRollMode_state_act = SSM_st_On_SMRollMode;
      }
      else {
        SMRollMode_state_act = SSM_st_Off_SMRollMode;
      }
      SMRollMode_reset_act = onOffPressed;
      break;
    case SSM_st_On_SMRollMode :
      if (onOffPressed) {
        SMRollMode_state_act = SSM_st_Off_SMRollMode;
      }
      else {
        SMRollMode_state_act = SSM_st_On_SMRollMode;
      }
      SMRollMode_reset_act = onOffPressed;
      break;
    
  }
  /* act_SMRollMode */ switch (SMRollMode_state_act) {
    case SSM_st_Off_SMRollMode :
      outC->mode = off_RollMode;
      outC->SMRollMode_state_nxt = SSM_st_Off_SMRollMode;
      break;
    case SSM_st_On_SMRollMode :
      if (SMRollMode_reset_act) {
        outC->init = kcg_true;
      }
      /* init_SMOn */ if (outC->init) {
        SMOn_state_sel_SMRollMode_On = SSM_st_Nominal_SMRollMode_On_SMOn;
      }
      else {
        SMOn_state_sel_SMRollMode_On = outC->SMOn_state_nxt_SMRollMode_On;
      }
      /* sel_SMOn */ switch (SMOn_state_sel_SMRollMode_On) {
        case SSM_st_Nominal_SMRollMode_On_SMOn :
          if (absRollRate > kFailSoftRoll_RollMode) {
            SMOn_state_act_SMRollMode_On = SSM_st_Failsoft_SMRollMode_On_SMOn;
          }
          else {
            SMOn_state_act_SMRollMode_On = SSM_st_Nominal_SMRollMode_On_SMOn;
          }
          break;
        case SSM_st_Failsoft_SMRollMode_On_SMOn :
          if (absRollRate <= kFailSoftRoll_RollMode) {
            SMOn_state_act_SMRollMode_On = SSM_st_Nominal_SMRollMode_On_SMOn;
          }
          else {
            SMOn_state_act_SMRollMode_On = SSM_st_Failsoft_SMRollMode_On_SMOn;
          }
          break;
        
      }
      /* act_SMOn */ switch (SMOn_state_act_SMRollMode_On) {
        case SSM_st_Nominal_SMRollMode_On_SMOn :
          outC->mode = nominal_RollMode;
          break;
        case SSM_st_Failsoft_SMRollMode_On_SMOn :
          outC->mode = failsoft_RollMode;
          break;
        
      }
      outC->SMRollMode_state_nxt = SSM_st_On_SMRollMode;
      /* act_SMOn */ switch (SMOn_state_act_SMRollMode_On) {
        case SSM_st_Nominal_SMRollMode_On_SMOn :
          outC->SMOn_state_nxt_SMRollMode_On =
            SSM_st_Nominal_SMRollMode_On_SMOn;
          break;
        case SSM_st_Failsoft_SMRollMode_On_SMOn :
          outC->SMOn_state_nxt_SMRollMode_On =
            SSM_st_Failsoft_SMRollMode_On_SMOn;
          break;
        
      }
      outC->init = kcg_false;
      break;
    
  }
  outC->init1 = kcg_false;
}

/* $**************** KCG Version 6.4 (build i21) ****************
** RollMode_RollMode.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

