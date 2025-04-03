/*
 * csvParser - MIDI Instrument Strategy Pattern
 * 
 * This package defines a strategy pattern for selecting different MIDI instruments.
 * Each strategy assigns a specific instrument to a MIDI track.
 * 
 */

package midiPlayer;

import javax.sound.midi.*;

/**
 * Interface for defining instrument selection strategies.
 * Implementing classes should specify a method to assign an instrument to a given track and channel.
 */
interface InstrumentStrategy {
    /**
     * Applies an instrument change to the given MIDI track.
     * 
     * @param track   The MIDI track to modify.
     * @param channel The MIDI channel to assign the instrument to.
     * 
     * MIDI instrument 0 (Acoustic Grand Piano)
     * MIDI instrument 33 (Electric Bass Guitar)
     * MIDI instrument 56 (Trumpet)
     */
    void applyInstrument(Track track, int channel);
}

class ElectricBassGuitarStrategy implements InstrumentStrategy {
    @Override
    public void applyInstrument(Track track, int channel) {
        InstrumentUtil.changeInstrument(track, channel, 33); 
    }
}

class TrumpetStrategy implements InstrumentStrategy {
    @Override
    public void applyInstrument(Track track, int channel) {
        InstrumentUtil.changeInstrument(track, channel, 56); 
    }
}

class AcousticGrandPianoStrategy implements InstrumentStrategy {
    @Override
    public void applyInstrument(Track track, int channel) {
        InstrumentUtil.changeInstrument(track, channel, 0); 
    }
}

/**
 * used for handling MIDI instrument changes.
 */
class InstrumentUtil {
    /**
     * Changes the instrument for the specified track and channel.
     * 
     * @param track       what MIDI track to modify.
     * @param channel     what MIDI channel to assign the instrument to.
     * @param instrument  what MIDI program number representing the instrument.
     */
    public static void changeInstrument(Track track, int channel, int instrument) {
        try {
            ShortMessage programChange = new ShortMessage();
            programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
            track.add(new MidiEvent(programChange, 0));
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
