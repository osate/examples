/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

#include "kcg_types.h"

#ifdef kcg_use_LutIndex_lut
kcg_bool kcg_comp_LutIndex_lut(LutIndex_lut *kcg_c1, LutIndex_lut *kcg_c2)
{
  kcg_bool kcg_equ;
  
  kcg_equ = kcg_true;
  kcg_equ = kcg_equ & (kcg_c1->f == kcg_c2->f);
  kcg_equ = kcg_equ & (kcg_c1->k == kcg_c2->k);
  return kcg_equ;
}
#endif /* kcg_use_LutIndex_lut */

#ifdef kcg_use_TRealLeftRight_RollRate
kcg_bool kcg_comp_TRealLeftRight_RollRate(
  TRealLeftRight_RollRate *kcg_c1,
  TRealLeftRight_RollRate *kcg_c2)
{
  kcg_bool kcg_equ;
  
  kcg_equ = kcg_true;
  kcg_equ = kcg_equ & (kcg_c1->right == kcg_c2->right);
  kcg_equ = kcg_equ & (kcg_c1->left == kcg_c2->left);
  return kcg_equ;
}
#endif /* kcg_use_TRealLeftRight_RollRate */

/* $**************** KCG Version 6.4 (build i21) ****************
** kcg_types.c
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

