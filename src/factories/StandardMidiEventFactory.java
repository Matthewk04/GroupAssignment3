package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Creates standard events and with no tick adjustments
 */
public class StandardMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(msg, tick);
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(msg, tick);
	}

}
