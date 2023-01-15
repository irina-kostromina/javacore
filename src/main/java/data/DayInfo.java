package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayInfo {

    @JsonProperty(value = "LongPhrase")
    private String mPhrase;

    public String getmPhrase() {
        return mPhrase;
    }

    public void setmPhrase(String mPhrase) {
        this.mPhrase = mPhrase;
    }
}
