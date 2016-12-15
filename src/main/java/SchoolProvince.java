import java.util.Map;

/**
 * Created by Dahang on 2016-12-14.
 */
public class SchoolProvince {

    public String getProvince() {
        return province;
    }

    public Map<String, String> getRankingLink() {
        return rankingLink;
    }

    public SchoolProvince(String province, Map<String, String> rankingLink) {
        this.province = province;
        this.rankingLink = rankingLink;
    }

    private final String province;

    private final Map<String, String > rankingLink;
}
