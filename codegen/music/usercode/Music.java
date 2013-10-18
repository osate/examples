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

	public static String SOUND_FILE1 = "drum.wav";
	public static String SOUND_FILE2 = "drum.wav";
	public static SourceDataLine firstSoundLine;
	public static SourceDataLine secondSoundLine;

	
	public static void SendFirstTrack(SampleChunk track, LatencyValue lat) 
	{
		if (! firstTrackInitialized)
		{
			AudioFormat audioFormat;
			try {
				audioFormat = AudioSystem.getAudioFileFormat(new File( SOUND_FILE1 )).getFormat();

	            DataLine.Info info=new DataLine.Info(TargetDataLine.class,audioFormat);
	            firstTrackStream = AudioSystem.getAudioInputStream(new File (SOUND_FILE1));
	            firstTrackBuffer = new byte[BUFFER_SIZE];
	            firstTrackInitialized = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if (lat.isEnabled())
		{
			try {
				firstTrackStream.read(firstTrackBuffer,0,BUFFER_SIZE);
				track.setBuffer(firstTrackBuffer);
				track.setValid(true);
				track.setContainData(true);
	
				Thread.sleep(lat.getValue());
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			track.setContainData(false);
			track.setValid(true);
		}
		
	}
	
	public static void SendSecondTrack(SampleChunk track, LatencyValue lat) 
	{
		if (! secondTrackInitialized)
		{
			AudioFormat audioFormat;
			try {
				audioFormat = AudioSystem.getAudioFileFormat(new File( SOUND_FILE2 )).getFormat();

	            DataLine.Info info=new DataLine.Info(TargetDataLine.class,audioFormat);
	           secondTrackStream = AudioSystem.getAudioInputStream(new File (SOUND_FILE2));
	           secondTrackBuffer = new byte[BUFFER_SIZE];
	            secondTrackInitialized = true;

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		if (lat.isEnabled())
		{
			try {
				secondTrackStream.read(secondTrackBuffer,0,BUFFER_SIZE);
				track.setBuffer(secondTrackBuffer);
				track.setValid(true);
				track.setContainData(true);
				Thread.sleep(lat.getValue());
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			track.setContainData(false);
			track.setValid(true);
		}

		
	}
	
	public static void Play(SampleChunk track1, SampleChunk track2) 
	{
		if (! playerInitialized)
		{
			AudioFormat audioFormat1;
			AudioFormat audioFormat2;
			try {
				audioFormat1 = AudioSystem.getAudioFileFormat(new File( SOUND_FILE1 )).getFormat();
		        DataLine.Info info1 = new DataLine.Info(SourceDataLine.class, audioFormat1);
		        firstSoundLine = (SourceDataLine) AudioSystem.getLine(info1);
		        firstSoundLine.open(audioFormat1);
		        firstSoundLine.start();
		        
				audioFormat2 = AudioSystem.getAudioFileFormat(new File( SOUND_FILE2 )).getFormat();
		        DataLine.Info info2 = new DataLine.Info(SourceDataLine.class, audioFormat2);
		        secondSoundLine = (SourceDataLine) AudioSystem.getLine(info2);
		        secondSoundLine.open(audioFormat2);
		        secondSoundLine.start();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if (track1.getContainData())
			{
				firstSoundLine.write(track1.getBuffer(), 0, BUFFER_SIZE);
				firstSoundLine.drain();
			}

			
			if (track2.getContainData())
			{
				secondSoundLine.write(track2.getBuffer(), 0, BUFFER_SIZE);
				secondSoundLine.drain();	

			}
//			secondSoundLine.write(track2.getBuffer(), 0, BUFFER_SIZE);
//			secondSoundLine.drain();		
	       // soundLine.drain();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
