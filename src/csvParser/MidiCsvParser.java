package csvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.ShortMessage;

public class MidiCsvParser {
	public static List<MidiEventData> parseCsv(String file) throws IOException {
		List<MidiEventData> events = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				if(columns.length != 6) continue;
				
				int startEndTick = Integer.parseInt(columns[0].trim());
				String noteOnOffStr = columns[1].trim();
				int channel = Integer.parseInt(columns[2].trim());
				int note = Integer.parseInt(columns[3].trim());
				int velocity = Integer.parseInt(columns[4].trim());
				int instrument = Integer.parseInt(columns[5].trim());
				
				int command = 0;
				if (noteOnOffStr.equals("Note_on_c")) {
	                   command = ShortMessage.NOTE_ON;
	               } else if (noteOnOffStr.equals("Note_off_c")) {
	                   command = ShortMessage.NOTE_OFF;
	               }
				int noteOnOff = command + channel;
				
				events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
				
			}
		}
		return events;
	}
}
