package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Creates legato events and increases the duration of original tick by 80
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(msg, tick);
	}

	/**
	 *delays note_off by 80 ticks
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(msg, tick + 80);
	}

}
