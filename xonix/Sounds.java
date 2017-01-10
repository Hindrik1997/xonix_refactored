package xonix;

public enum Sounds {
    TimeTicketCollision("bleep.wav"),
    MonsterCollision("bleep.wav"),
    AddedScore("bleep.wav"),;

    private final String clip;
    Sounds(String s) {
        clip = s;
    }

    public String getClip() {
        return clip;
    }
}