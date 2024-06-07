package xyz.n7mn.nico_proxy.site;

import xyz.n7mn.nico_proxy.data.ResultData;
import xyz.n7mn.nico_proxy.exception.NotSupportURL;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NicoVideo implements SiteInterface {

    private final String RequestURL;
    private final String ProxyIP;
    private final int ProxyPort;

    private final Pattern SupportURL1 = Pattern.compile("https://(www|live|cas)\\.nicovideo\\.jp/(watch|user)/(.+)");
    private final Pattern SupportURL2 = Pattern.compile("https://nico\\.ms/(.+)");

    private final List<Pattern> SupportURL = new ArrayList<>();

    public NicoVideo(){
        RequestURL = null;
        ProxyIP = null;
        ProxyPort = 3128;
        setSupportURL();
    }

    public NicoVideo(String RequestURL){
        this.RequestURL = RequestURL;
        this.ProxyIP = null;
        this.ProxyPort = 3128;
        setSupportURL();
    }

    public NicoVideo(String RequestURL, String ProxyIP, int ProxyPort){
        this.RequestURL = RequestURL;
        this.ProxyIP = ProxyIP;
        this.ProxyPort = ProxyPort;
        setSupportURL();
    }

    @Override
    public ResultData get() throws Exception {
        Matcher matcher1 = SupportURL1.matcher(RequestURL);
        Matcher matcher2 = SupportURL2.matcher(RequestURL);

        if (matcher1.find()){
            if (matcher1.group(1).equals("live") || matcher1.group(1).equals("cas")){
                return getLive();
            } else {
                return getVideo();
            }
        }

        if (matcher2.find()){
            if (matcher2.group(1).startsWith("lv|ch")){
                return getLive();
            } else {
                return getVideo();
            }
        }

        throw new NotSupportURL();
    }

    @Override
    public ResultData getVideo() throws Exception {



        return null;
    }

    @Override
    public ResultData getLive() throws Exception {
        return null;
    }

    @Override
    public String getTitle() throws Exception {
        return "";
    }

    @Override
    public List<Pattern> getSupportURL() {
        return SupportURL;
    }

    private void setSupportURL(){
        this.SupportURL.add(SupportURL1);
        this.SupportURL.add(SupportURL2);
    }
}
