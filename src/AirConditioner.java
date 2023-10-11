public class AirConditioner {
    // Class Constants
    private static final int MIN_TEMPERATURE = 20;
    private static final int MAX_TEMPERATURE = 30;
    private static final int MIN_FAN_SPEED = 0;
    private static final int MAX_FAN_SPEED = 2;

    // Attributes
    private boolean airOn;
    private boolean fanOn;
    private int targetTemperature;
    private int fanSpeed;

    public AirConditioner(int targetTemperature, int fanSpeed) {
        this.airOn = false;
        this.fanOn = false;
        this.targetTemperature = Math.min(MAX_TEMPERATURE, Math.max(MIN_TEMPERATURE, targetTemperature));
        this.fanSpeed = Math.min(MAX_FAN_SPEED, Math.max(MIN_FAN_SPEED, fanSpeed));
    }

    public boolean isAirOn() {
        return airOn;
    }

    public int getTargetTemperature() {
        return targetTemperature;
    }

    public void turnAirOnOff() {
        this.airOn = !this.airOn;
        this.fanOn = this.airOn;
    }

    public void increaseTemperature() {
        this.targetTemperature = Math.min(this.targetTemperature + 1, MAX_TEMPERATURE);
    }

    public void decreaseTemperature() {
        this.targetTemperature = Math.max(this.targetTemperature - 1, MIN_TEMPERATURE);
    }

    public void changeFanSpeed() {
        this.fanSpeed = this.fanSpeed + 1;
        if (this.fanSpeed > MAX_FAN_SPEED) this.fanSpeed = MIN_FAN_SPEED;
    }

    @Override
    public String toString() {
        if(airOn) {
            return "Air Conditioner {Status: on, Temp: " + targetTemperature + "°C, Fan: " + getFanSpeedString() + "}";
        } else {
            return "Air Conditioner {Status: off}";
        }
    }

    private String getFanSpeedString() {
        return switch (fanSpeed) {
            case 0 -> "low";
            case 1 -> "medium";
            default -> "high";
        };
    }
}
