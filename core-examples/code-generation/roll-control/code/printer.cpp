
#include "deployment.h"

#ifdef OCARINA_RUNTIME_DEOS

#include "subprograms.h"
#include <apex.h>

#include <string.h>
#include <videobuf.h>
#include <deos.h>

VideoStream VideoOutProc(0, 10, 4, 77);  // specify 4 rows of output starting at row 3

extern "C" void myprint_str (const char* s)
{
	VideoOutProc << s << endl;
}

extern "C" void myprint_double (const float d)
{

}

extern "C" void myprint_uchar (const unsigned char uc)
{
	VideoOutProc << uc << endl;
}

//extern "C" void myprint_float (const float f)
//{
//	VideoOutProc << f << endl;
//}

extern "C" void myprint_int (const int i)
{
	VideoOutProc << i << endl;
}

extern "C" void myprint_str_int (const char *s, const int i)
{
	VideoOutProc << s << i << endl;
}

extern "C" void myprint_end (void)
{
	VideoOutProc << endl;
}
#endif
