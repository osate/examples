#include <stdio.h>
#include <time.h>
#include <types.h>
#include <po_hi_time.h>

int produce_data = 0;

extern software__alpha_type shareddata;

void user_producevar_spg ()
{
#if defined (POSIX)
   struct timespec mytime;
   clock_gettime (CLOCK_REALTIME, &mytime);
   shareddata = produce_data;
   printf ("At time %3lu:%3lu, produce : %d\n", mytime.tv_sec % 3600, mytime.tv_nsec/1000000,produce_data);
#else
   printf ("Produce %d\n", data);
#endif
   produce_data++;

   if (produce_data == 10)
   {
      exit (0);
   }

}

void user_consumevar_spg ()
{
#if defined (POSIX)
   struct timespec mytime;
   clock_gettime (CLOCK_REALTIME, &mytime);
   printf( "At time %3lu:%3lu, consume : %d\n", mytime.tv_sec % 3600 , mytime.tv_nsec/1000000,shareddata);
#else
   printf ("Consume %d\n", data);
#endif

}
