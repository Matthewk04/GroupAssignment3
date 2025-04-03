package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Creates staccato events decreases the duration of original tick by 120
 */
public class StaccatoMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(msg, tick);
	}

	/**
	 *Increases note_off by 80 ticks
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(msg, tick - 120);
	}

}
