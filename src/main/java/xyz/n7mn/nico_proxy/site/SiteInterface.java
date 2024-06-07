package xyz.n7mn.nico_proxy.site;

import xyz.n7mn.nico_proxy.data.ResultData;

import java.util.List;
import java.util.regex.Pattern;

public interface SiteInterface {
    ResultData get() throws Exception;
    ResultData getVideo() throws Exception;
    ResultData getLive() throws Exception;
    String getTitle() throws Exception;

    List<Pattern> getSupportURL();

}
