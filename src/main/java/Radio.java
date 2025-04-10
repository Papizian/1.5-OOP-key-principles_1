public class Radio {
    private int currentStation;
    private int currentVolume;
    private static final int maxstation = 9;
    private static final int minstation = 0;
    private static final int maxvolume = 10;
    private static final int minvolume = 0;

    public void setCurrentStation(int station) {
        if (station >= minstation && station <= maxstation) {
            currentStation = station;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void nextStation() {
        if (currentStation == maxstation) {
            currentStation = minstation;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == minstation) {
            currentStation = maxstation;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxvolume ) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minvolume ) {
            currentVolume--;
        }
    }
}