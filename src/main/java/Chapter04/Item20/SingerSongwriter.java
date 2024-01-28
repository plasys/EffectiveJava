package Chapter04.Item20;

import java.applet.AudioClip;

interface Singer {}
interface Songwriter {}
public interface SingerSongwriter extends Singer, Songwriter {
    AudioClip strum();
    void actSensitive();
}
