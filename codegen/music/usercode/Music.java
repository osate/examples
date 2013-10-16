package usercode;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.media.sound.MixerSourceLine;
import com.sun.media.sound.SoftMixingDataLine;

public class Music {
	
	public static AudioInputStream firstTrackStream;
	public static AudioInputStream secondTrackStream;

	private static boolean firstTrackInitialized = false;
	private static boolean secondTrackInitialized = false;
	private static boolean playerInitialized = false;
	public final static int BUFFER_SIZE = 64*1024;
	private static byte[] firstTrackBuffer;
	private static byte[] secondTrackBuffer;
	private static byte[] playerBuffer = new byte[BUFFER_SIZE];

	public static String SOUND_FILE = "drum.wav";
	public static SourceDataLine soundLine;
	
	public static void SendFirstTrack(SampleChunk track) 
	{
		if (! firstTrackInitialized)
		{
			AudioFormat audioFormat;
			try {
				audioFormat = AudioSystem.getAudioFileFormat(new File( SOUND_FILE )).getFormat();

	            DataLine.Info info=new DataLine.Info(TargetDataLine.class,audioFormat);
	            firstTrackStream = AudioSystem.getAudioInputStream(new File (SOUND_FILE));
	            firstTrackBuffer = new byte[BUFFER_SIZE];
	            firstTrackInitialized = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try {
			firstTrackStream.read(firstTrackBuffer,0,BUFFER_SIZE);
			track.setBuffer(firstTrackBuffer);
			track.setValid(true);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void SendSecondTrack(SampleChunk track) 
	{
		if (! secondTrackInitialized)
		{
			AudioFormat audioFormat;
			try {
				audioFormat = AudioSystem.getAudioFileFormat(new File( SOUND_FILE )).getFormat();

	            DataLine.Info info=new DataLine.Info(TargetDataLine.class,audioFormat);
	           secondTrackStream = AudioSystem.getAudioInputStream(new File (SOUND_FILE));
	           secondTrackBuffer = new byte[BUFFER_SIZE];
	            secondTrackInitialized = true;

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		try {
			secondTrackStream.read(secondTrackBuffer,0,BUFFER_SIZE);
			track.setBuffer(secondTrackBuffer);
			track.setValid(true);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		
	}
	
	public static void Play(SampleChunk track1, SampleChunk track2) 
	{
		if (! playerInitialized)
		{
			AudioFormat audioFormat;
			
			try {
				audioFormat = AudioSystem.getAudioFileFormat(new File( SOUND_FILE )).getFormat();
		        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		        soundLine = (SourceDataLine) AudioSystem.getLine(info);
		        soundLine.open(audioFormat);
		        soundLine.start();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
	        soundLine.write(track1.getBuffer(), 0, BUFFER_SIZE);
	        soundLine.drain();
	       // soundLine.drain();
//	        soundLine.write(track2.getBuffer(), 0, BUFFER_SIZE);
//	        soundLine.drain();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
