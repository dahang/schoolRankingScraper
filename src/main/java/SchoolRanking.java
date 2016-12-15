import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class SchoolRanking {

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    private static final String RANKING_URL = "http://compareschoolrankings.org/";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static void scraperSchoolRanking(String URI, String fileName) throws Exception {

        final Document page = Jsoup.connect(URI).userAgent(USER_AGENT).get();

        final List<SchoolRecord> resultList = new ArrayList<SchoolRecord>();

        Element schoolTable = page.select("table.rating").first();

        Elements schoolList = schoolTable.select("tr");

        for (int i = 2; i < schoolList.size(); i++) {
            Element table = schoolList.get(i);
            Elements schoolInfo = table.select("td.tdcell");

            final String rank = schoolInfo.get(0).text();
            final String rankIn5 = schoolInfo.get(1).text();
            final String name = schoolInfo.get(3).text();
            final String url = schoolInfo.get(3).select("a").attr("href");
            final String city = schoolInfo.get(4).text();
            final String rating = schoolInfo.get(5).text();
            final String ratingIn5 = schoolInfo.get(6).text();

            resultList.add(new SchoolRecord(rank, rankIn5, name, city, rating, ratingIn5, url));
        }

        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(fileName + ".json"), resultList);
    }

    private static List<SchoolProvince> scraperSchoolrankings(String URI, String fileName) throws Exception {

        final Document page = Jsoup.connect(URI).userAgent(USER_AGENT).get();

        final List<SchoolProvince> resultList = new ArrayList<SchoolProvince>();

//        System.out.println(page.outerHtml());

        Element schoolTable = page.select("table").first();

        Elements schoolList = schoolTable.select("tr");

        for (int i = 2; i < schoolList.size() - 1; i++) {
            Element table = schoolList.get(i);
            Elements rankingInfo = table.select("td");

            final String province = rankingInfo.get(1).text();
            Map rankingLink = new HashMap();
            rankingLink.put(rankingInfo.get(2).text(), rankingInfo.get(2).select("a").attr("href"));

            if (rankingInfo.size() > 3) {
                rankingLink.put(rankingInfo.get(3).text(), rankingInfo.get(3).select("a").attr("href"));
            }

            resultList.add(new SchoolProvince(province, rankingLink));
        }

        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(fileName + ".json"), resultList);

        return resultList;

    }

    public static void main(String[] args) throws Exception {

        final List<SchoolProvince> rankingList = scraperSchoolrankings(RANKING_URL, "schoolRanking");

        for (SchoolProvince ranking : rankingList) {
            final String proive = ranking.getProvince();

            for (String key : ranking.getRankingLink().keySet())
                scraperSchoolRanking(ranking.getRankingLink().get(key), proive + key);
        }

    }
}