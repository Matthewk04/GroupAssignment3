/**
 * 
 */
package midiPlayer;

/**
 * Interface for pitch modification strategies.
 */
public interface PitchStrategy {
    int modifyPitch(int note);
}

class HigherPitchStrategy implements PitchStrategy {
    @Override
    public int modifyPitch(int note) {
        return note + 2;
    }
}

class LowerPitchStrategy implements PitchStrategy {
    @Override
    public int modifyPitch(int note) {
        return note - 2;
    }
}
