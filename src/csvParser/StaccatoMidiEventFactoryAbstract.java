/**
 * 
 */
package csvParser;

import javax.sound.midi.*;

/**
 * created to make the stacato events where notes are shorter and more detached
 */
public class StaccatoMidiEventFactoryAbstract extends LegatoMidiEventFactoryAbstract {
	 @Override
	    public MidiEvent createLegatoEvent(int channel, int note, int velocity, long tick) 
	            throws InvalidMidiDataException {

	        ShortMessage noteOn = new ShortMessage();
	        noteOn.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);

	        long noteDuration = 100; 
	        
	        ShortMessage noteOff = new ShortMessage();
	        noteOff.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);

	        MidiEvent noteOnEvent = new MidiEvent(noteOn, tick);
	        MidiEvent noteOffEvent = new MidiEvent(noteOff, tick + noteDuration);

	        return noteOnEvent;
	    }
}
