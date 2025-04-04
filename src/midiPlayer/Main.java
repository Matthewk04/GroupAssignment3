/*
 *  THE SONG IS BAD GUY BY Billie Eilish
 */


package midiPlayer;

import java.util.List;
import javax.sound.midi.*;

import csvParser.MidiCsvParser;
import csvParser.MidiEventData;
import factories.*;

public class Main {
	public static void main ( String [ ] args ) {
		try {
			List <MidiEventData> events = MidiCsvParser.parseCsv ("src/files/mysterysong.csv") ;
			
			
			Sequence sequence = new Sequence ( Sequence.PPQ, 384 ) ;
			Track track = sequence.createTrack ( ) ;

			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract ( ) ;
			//MidiEventFactoryAbstract factoryAbstract  = new LegatoMidiEventFactoryAbstract ( ) ;
			//MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract ( ) ;

			MidiEventFactory factory = factoryAbstract.createFactory ( ) ;

			// Choose an instrument strategy ( e . g . , Trumpet , Bass Guitar , Piano )
			InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy ( ) ;
			instrumentStrategy.applyInstrument ( track , 0 ) ;
			instrumentStrategy = new TrumpetStrategy ( ) ;
			instrumentStrategy.applyInstrument (track , 1 ) ;

			// Choose a pitch strategy ( e.g. , HigherPitch ,LowerPitch )
			PitchStrategy pitchStrategy = new HigherPitchStrategy ( );
			for (MidiEventData event:events ) {
				int modifiedNote = pitchStrategy.modifyPitch ( event.getNote ( ) ) ;

				// call this as much as you want if you want to get a higher pitch
				modifiedNote = pitchStrategy.modifyPitch (modifiedNote ) ;
				if (event.getNoteOnOff( ) == ShortMessage.NOTE_ON) {
					track.add (factory.createNoteOn(event.getStartEndTick ( ) ,
							modifiedNote ,
							event.getVelocity() ,
							event.getChannel())) ;
				}
				else {
					track.add ( factory.createNoteOff ( event.getStartEndTick ( ) , modifiedNote , event.getChannel ( ) ) ) ;
				}
			}

			// Playing the sequence
			Sequencer sequencer = MidiSystem.getSequencer ( ) ;
			sequencer.open ( );
			sequencer.setSequence(sequence) ;
			sequencer.start ( ) ;
			while (sequencer.isRunning ( ) | sequencer.isOpen ( ) ) {
				Thread.sleep (100) ;
			}
			Thread.sleep(500) ;
			sequencer.close() ;
		} catch (Exception e) {
			e.printStackTrace( );
		}
	}
}