package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty(value = "Minimum")
    private TemperatureValue minimum;
    @JsonProperty(value = "Maximum")
    private TemperatureValue maximum;

    public TemperatureValue getMinimum() {
        return minimum;
    }

    public void setMinimum(TemperatureValue minimum) {
        this.minimum = minimum;
    }

    public TemperatureValue getMaximum() {
        return maximum;
    }

    public void setMaximum(TemperatureValue maximum) {
        this.maximum = maximum;
    }
}
