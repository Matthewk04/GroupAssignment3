package csvParser;

public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff;

	private int instrument;
	
	/**
	 * @param startEndTick		
	 * @param velocity			velocity of the note
	 * @param note				midi note
	 * @param channel			midi channel
	 * @param instrument		instrument number
	 * @param noteOnOff			
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel  =channel;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	
	public int getStartEndTick() {
		return startEndTick;
	}

	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getNoteOnOff() {
		return noteOnOff;
	}

	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	

}