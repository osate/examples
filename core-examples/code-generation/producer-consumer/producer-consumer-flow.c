#include <stdio.h>
#include <time.h>
#include <po_hi_time.h>

int produce_data = 0;

void user_produceflow_spg (int* data)
{
#if defined (POSIX)
   struct timespec mytime;
   clock_gettime (CLOCK_REALTIME, &mytime);
   *data = produce_data;
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

void user_consumeflow_spg (int data)
{
#if defined (POSIX)
   struct timespec mytime;
   clock_gettime (CLOCK_REALTIME, &mytime);
   printf( "At time %3lu:%3lu, consume : %d\n", mytime.tv_sec % 3600 , mytime.tv_nsec/1000000,data);
#else
   printf ("Consume %d\n", data);
#endif

}

