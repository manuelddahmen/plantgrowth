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

package be.manudahmen.growth.audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class SoundProductionSystem {
    private boolean fileOutput;
    private File outWavFile;
    private SourceDataLine sdl;
    private AudioFormat af;
    byte[] buffer;
    AudioInputStream audioInputStream;
    private int buffIdx = 0;

    public SoundProductionSystem(float secondsFile, File outWavFile) {
        this();
        this.outWavFile = outWavFile;
        this.fileOutput = true;
        int channels = 2;
        buffer = new byte[(int) (channels * secondsFile * 44100)];
    }

    public SoundProductionSystem() {
        af = new AudioFormat((float) 44100, 16, 2, true, false);
        try {
            sdl = AudioSystem.getSourceDataLine(af);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            sdl.open();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        sdl.start();

    }

    public void playNote(int tone, float durationMs) throws LineUnavailableException {
        if (sdl != null && sdl.isOpen()) {
            byte[] buf = new byte[4];
            for (int i = 0; i < durationMs * 44100 / 1000.0; i++) {
                double angle = i / (44100.0 / calculateNoteFrequency(tone)) * 2.0 * Math.PI;
                buf[0] = (byte) (Math.sin(angle) * 100);
                short a = (short) (Math.sin(angle) * 32767);  //32767 - max value for sample to take (-32767 to 32767)
                buf[0] = (byte) (a & 0xFF); //write 8bits ________WWWWWWWW out of 16
                buf[1] = (byte) (a >> 8); //write 8bits WWWWWWWW________ out of 16
                buf[2] = (byte) (a & 0xFF); //write 8bits ________WWWWWWWW out of 16
                buf[3] = (byte) (a >> 8); //write 8bits WWWWWWWW________ out of 16
                sdl.write(buf, 0, 4);

            }
            if (fileOutput) {
                buffer[buffIdx++] = buf[0];
                buffer[buffIdx++] = buf[1];
                buffer[buffIdx++] = buf[2];
                buffer[buffIdx++] = buf[3];
            }
            if (buffIdx >= buffer.length) {
                end();
            }
            //sdl.write(buf, 0, 1);

        }

    }

    public float calculateNoteFrequency(float halfTone) {
        return /*A*/ (float) (440 * Math.pow(2, 1 / 12.0 * halfTone));
    }


    public void end() {
        sdl.drain();
        sdl.stop();
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);

        audioInputStream = new AudioInputStream(bais, af, buffer.length);
        try {
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outWavFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            audioInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
