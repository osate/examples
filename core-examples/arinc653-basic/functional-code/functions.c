/*
 *                               POK header
 * 
 * The following file is a part of the POK project. Any modification should
 * made according to the POK licence. You CANNOT use this file or a part of
 * this file is this part of a file for your own project
 *
 * For more information on the POK licence, please see our LICENCE FILE
 *
 * Please follow the coding guidelines described in doc/CODING_GUIDELINES
 *
 *                                      Copyright (c) 2007-2009 POK team 
 *
 * Created by julien on Thu Jan 15 23:34:13 2009 
 */
#include "gtypes.h"

void myprint (const char*);
twoparts_sampling__character* counter = 0;
void user_producer
    (twoparts_sampling__character* dataout)
{
	myprint_str_int ("I send ", counter++);
	*dataout = counter;
}


void user_consumer
    (twoparts_sampling__character datain)
{
	myprint_str_int ("I receive ", datain);
}


