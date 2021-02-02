package net.airgame.fabric.fix.spectator.manager;

public class SpectatorManager {
    private static int spectatorTargetID;

    public static int getSpectatorTargetID() {
        return spectatorTargetID;
    }

    public static void setSpectatorTargetID(int spectatorTargetID) {
        SpectatorManager.spectatorTargetID = spectatorTargetID;
    }
}
