import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldCreateDefaultRadio() {
        Radio radio = new Radio();
        assertEquals(9, radio.getMaxStation());
    }

    @Test
    void shouldCreateCustomRadio() {
        Radio radio = new Radio(15);
        assertEquals(14, radio.getMaxStation());
    }

    @Test
    void shouldThrowExceptionForInvalidStationCount() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetInvalidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(555);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.nextStation();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToZeroAfterMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToMaxAfterZeroStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldWorkWithCustomStations() {
        Radio radio = new Radio(30);
        assertEquals(29, radio.getMaxStation());

        radio.setCurrentStation(29);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseMinVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldKeepCurrentStationWhenSettingInvalid() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(999);
        assertEquals(5, radio.getCurrentStation());
    }
}