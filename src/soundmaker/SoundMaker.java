package soundmaker;

import javafx.scene.media.AudioClip;

import java.io.File;

public class SoundMaker {
    static private final String PATH = "resource\\sound";
    static private File dir = new File(PATH);
    static private File[] files = dir.listFiles();

    static private AudioClip applauseSound = new AudioClip(files[0].toURI().toString());
    static private AudioClip clickSound = new AudioClip(files[1].toURI().toString());
    static private AudioClip clickOffSound = new AudioClip(files[2].toURI().toString());
    static private AudioClip correctSound = new AudioClip(files[3].toURI().toString());
    static private AudioClip dingDingSound = new AudioClip(files[4].toURI().toString());
    static private AudioClip wrongSound = new AudioClip(files[5].toURI().toString());

    private static double volume = 1.0;
    private static boolean muted = false;

    public static void applause() {
        applauseSound.play();
    }

    public static void click() { clickSound.play(); }

    public static void clickOff() {
        clickOffSound.play();
    }

    public static void correct() {
        correctSound.play();
    }

    public static void dingDing() {
        dingDingSound.play();
    }

    public static void wrong() {
        wrongSound.play();
    }

    public static void setMute(boolean mute) {
        muted = mute;
        updateVolume();
    }

    private static void updateVolume() {
        double targetVolume = muted ? 0.0 : volume;

        applauseSound.setVolume(targetVolume);
        clickSound.setVolume(targetVolume);
        clickOffSound.setVolume(targetVolume);
        correctSound.setVolume(targetVolume);
        dingDingSound.setVolume(targetVolume);
        wrongSound.setVolume(targetVolume);
    }

}