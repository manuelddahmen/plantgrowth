package be.manudahmen.growth.audio;

public class Note {
    private int tone;
    private SoundProductionSystem.Waveform waveform;
    private Enveloppe enveloppe;
    private Timer timer;
    private double minDurationMs;
    private boolean finish;
    private long positionNIncr;

    public Note(double minDurationMs, int tone, SoundProductionSystem.Waveform waveform, Enveloppe enveloppe) {
        this.minDurationMs = minDurationMs;
        this.tone = tone;
        this.waveform = waveform;
        this.enveloppe = enveloppe;
        positionNIncr = 0;
        this.timer = new Timer();
        timer.init();
    }

    public double getMinDurationMs() {
        return minDurationMs;
    }

    public void setMinDurationMs(double minDurationMs) {
        this.minDurationMs = minDurationMs;
    }

    public int getTone() {
        return tone;
    }

    public void setTone(int tone) {
        this.tone = tone;
    }

    public SoundProductionSystem.Waveform getWaveform() {
        return waveform;
    }

    public void setWaveform(SoundProductionSystem.Waveform waveform) {
        this.waveform = waveform;
    }

    public Enveloppe getEnveloppe() {
        return enveloppe;
    }

    public void setEnveloppe(Enveloppe enveloppe) {
        this.enveloppe = enveloppe;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
        timer.init();
    }

    public Timer getTimer() {
        return timer;
    }

    public boolean isFinish() {
        return getTimer().getTimeElapsedMS() >= this.getMinDurationMs();
    }

    public long getPositionNIncr() {
        return positionNIncr++;
    }
}
