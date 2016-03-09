/* $**************** KCG Version 6.4 (build i21) ****************
** Command: kcg64.exe -config C:/Users/julien/Desktop/roll-control-code/config.txt
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */
#ifndef _KCG_TYPES_H_
#define _KCG_TYPES_H_

#define KCG_MAPW_CPY

#include "./user_macros.h"

#ifndef kcg_int
#define kcg_int kcg_int
typedef int kcg_int;
#endif /* kcg_int */

#ifndef kcg_bool
#define kcg_bool kcg_bool
typedef unsigned char kcg_bool;
#endif /* kcg_bool */

#ifndef kcg_real
#define kcg_real kcg_real
typedef double kcg_real;
#endif /* kcg_real */

#ifndef kcg_char
#define kcg_char kcg_char
typedef char kcg_char;
#endif /* kcg_char */

#ifndef kcg_false
#define kcg_false ((kcg_bool) 0)
#endif /* kcg_false */

#ifndef kcg_true
#define kcg_true ((kcg_bool) 1)
#endif /* kcg_true */

#ifndef kcg_assign
#include "kcg_assign.h"
#endif /* kcg_assign */

#ifndef kcg_assign_struct
#define kcg_assign_struct kcg_assign
#endif /* kcg_assign_struct */

#ifndef kcg_assign_array
#define kcg_assign_array kcg_assign
#endif /* kcg_assign_array */

/* truthtables::TruthTableValues */
typedef enum kcg_tag_TruthTableValues_truthtables {
  T_truthtables,
  F_truthtables,
  X_truthtables
} TruthTableValues_truthtables;
/* RollMode::TRollMode */
typedef enum kcg_tag_TRollMode_RollMode {
  off_RollMode,
  nominal_RollMode,
  failsoft_RollMode
} TRollMode_RollMode;
/* RollMode::RollMode::SMRollMode */
typedef enum kcg_tag_SSM_TR_SMRollMode {
  SSM_TR_no_trans_SMRollMode,
  SSM_TR_Off_1_SMRollMode,
  SSM_TR_On_1_SMRollMode
} SSM_TR_SMRollMode;
/* RollMode::RollMode::SMRollMode */
typedef enum kcg_tag_SSM_ST_SMRollMode {
  SSM_st_Off_SMRollMode,
  SSM_st_On_SMRollMode
} SSM_ST_SMRollMode;
/* RollMode::RollMode::SMRollMode::On::SMOn */
typedef enum kcg_tag_SSM_TR_SMOn_SMRollMode_On {
  SSM_TR_no_trans_SMOn_SMRollMode_On,
  SSM_TR_Nominal_1_SMOn_SMRollMode_On,
  SSM_TR_Failsoft_1_SMOn_SMRollMode_On
} SSM_TR_SMOn_SMRollMode_On;
/* RollMode::RollMode::SMRollMode::On::SMOn */
typedef enum kcg_tag_SSM_ST_SMOn_SMRollMode_On {
  SSM_st_Nominal_SMRollMode_On_SMOn,
  SSM_st_Failsoft_SMRollMode_On_SMOn
} SSM_ST_SMOn_SMRollMode_On;
/* RollRate::TRealLeftRight */
typedef struct kcg_tag_TRealLeftRight_RollRate {
  kcg_real left;
  kcg_real right;
} TRealLeftRight_RollRate;

/* lut::LutIndex */
typedef struct kcg_tag_LutIndex_lut { kcg_int k; kcg_real f; } LutIndex_lut;

#ifndef kcg_copy_LutIndex_lut
#define kcg_copy_LutIndex_lut(kcg_C1, kcg_C2) (kcg_assign_struct((kcg_C1), (kcg_C2), sizeof (LutIndex_lut)))
#endif /* kcg_copy_LutIndex_lut */

#ifndef kcg_copy_TRealLeftRight_RollRate
#define kcg_copy_TRealLeftRight_RollRate(kcg_C1, kcg_C2) (kcg_assign_struct((kcg_C1), (kcg_C2), sizeof (TRealLeftRight_RollRate)))
#endif /* kcg_copy_TRealLeftRight_RollRate */

#ifdef kcg_use_LutIndex_lut
#ifndef kcg_comp_LutIndex_lut
extern kcg_bool kcg_comp_LutIndex_lut(
  LutIndex_lut *kcg_c1,
  LutIndex_lut *kcg_c2);
#endif /* kcg_comp_LutIndex_lut */
#endif /* kcg_use_LutIndex_lut */

#ifdef kcg_use_TRealLeftRight_RollRate
#ifndef kcg_comp_TRealLeftRight_RollRate
extern kcg_bool kcg_comp_TRealLeftRight_RollRate(
  TRealLeftRight_RollRate *kcg_c1,
  TRealLeftRight_RollRate *kcg_c2);
#endif /* kcg_comp_TRealLeftRight_RollRate */
#endif /* kcg_use_TRealLeftRight_RollRate */

#endif /* _KCG_TYPES_H_ */
/* $**************** KCG Version 6.4 (build i21) ****************
** kcg_types.h
** Generation date: 2015-04-21T14:59:40
*************************************************************$ */

