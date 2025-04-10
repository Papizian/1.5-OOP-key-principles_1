public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int maxStation;
    private static final int minStation = 0;
    private static final int maxVolume = 100;
    private static final int minVolume = 0;
    private static final int defaultStationCount = 10;

    public Radio() {
        this.maxStation = defaultStationCount - 1;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxStation = stationCount - 1;
    }

    public void setCurrentStation(int station) {
        if (station >= minStation && station <= maxStation) {
            currentStation = station;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }
}