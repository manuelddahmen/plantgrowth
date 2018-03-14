/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth.graphics.sound.test;

import be.manudahmen.growth.TestCaseExtended;
import be.manudahmen.growth.audio.SoundProductionSystem;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class TestSound extends TestCaseExtended {
    public void testPlaySound() {
        try {
            SoundProductionSystem soundProductionSystem = new SoundProductionSystem(30,
                    getUniqueFilenameForProduction("testResults", "sounds", "wav"));
            for (int tone = 0; tone < 12; tone++) {
                System.out.println("note" + tone);
                soundProductionSystem.playNote(tone, 1000, SoundProductionSystem.Waveform.SIN);
            }
            soundProductionSystem.end();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testPlayOctaves() {
        SoundProductionSystem soundProductionSystem = null;
        try {
            soundProductionSystem = new SoundProductionSystem(30,
                    getUniqueFilenameForProduction("testResults", "sounds", "wav"));
            try {
                for (int tone = 0; tone < 8 * 12; tone += 12) {
                    System.out.println("note" + tone);
                    soundProductionSystem.playNote(tone, 1000, SoundProductionSystem.Waveform.SIN);
                }
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            soundProductionSystem.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testNotationAnglaiseNote() {
        String[] notes = new String[]{"C4", "D4", "E4", "F4", "G4", "A4", "B4"};
        SoundProductionSystem soundProductionSystem = new SoundProductionSystem();
        for (String note : notes) {
            try {
                int tone = soundProductionSystem.equiv(note);
                System.out.println(note + " " + tone);
                soundProductionSystem.playNote(tone, 1000.0f, SoundProductionSystem.Waveform.SIN);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
}
