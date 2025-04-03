package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class StaccatoMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		// TODO Auto-generated method stub
		return null;
	}

}
