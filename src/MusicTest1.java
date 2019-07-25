import javax.sound.midi.*;

public class MusicTest1 {
    public void play() {
        try{
        Sequencer player = MidiSystem.getSequencer();
        System.out.println("We have a sequencer");
        player.open();
        Sequence seq = new Sequence(Sequence.PPQ,4);
        Track track = seq.createTrack();

        ShortMessage first = new ShortMessage();
        first.setMessage(192,1,32,0);
        MidiEvent changeInstrument = new MidiEvent(first,1);
        track.add(changeInstrument);
        ShortMessage a = new ShortMessage();
        a.setMessage(144,1,50,105);
        MidiEvent noteOn = new MidiEvent(a,1);
        track.add(noteOn);

        ShortMessage b = new ShortMessage();
        b.setMessage(128,1,50,105);
        MidiEvent noteOff = new MidiEvent(b,16);
        track.add(noteOff);

        player.setSequence(seq);
        player.start();
    } catch(MidiUnavailableException ex){
        System.out.println("We have an exception");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//close play

    public static void main (String[] args){
        MusicTest1 mt = new MusicTest1();
        mt.play();
    } //close main
} // close class
