package xyz.n7mn.nico_proxy.data;

public class ResultData {

    private String VideoURL = null;
    private String AudioURL = null;
    private boolean isHLS = false;
    private boolean isStream = false;
    private String DataText = null;

    public ResultData(){

    }

    public ResultData(String videoURL, String audioURL, boolean isHLS, boolean isStream, String dataText) {
        VideoURL = videoURL;
        AudioURL = audioURL;
        this.isHLS = isHLS;
        this.isStream = isStream;
        DataText = dataText;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    public String getAudioURL() {
        return AudioURL;
    }

    public void setAudioURL(String audioURL) {
        AudioURL = audioURL;
    }

    public boolean isHLS() {
        return isHLS;
    }

    public void setHLS(boolean HLS) {
        isHLS = HLS;
    }

    public boolean isStream() {
        return isStream;
    }

    public void setStream(boolean stream) {
        isStream = stream;
    }

    public String getDataText() {
        return DataText;
    }

    public void setDataText(String dataText) {
        DataText = dataText;
    }
}
