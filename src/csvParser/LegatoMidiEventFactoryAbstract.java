/**
 * 
 */
package csvParser;

import javax.sound.midi.*;

/**
 * abstract factory for creating legato events
 * sublcasses impollement the methods to generate midi events
 */
public class LegatoMidiEventFactoryAbstract {
	public MidiEvent createLegatoEvent(int channel, int note, int velocity, long tick) 
            throws InvalidMidiDataException {
		return null;
	}
}
