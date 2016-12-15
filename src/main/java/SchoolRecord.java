/**
 * Created by Dahang on 2016-12-14.
 */
public class SchoolRecord {

    private final String rank;

    private final String rankIn5;

    private final String name;

    private final String city;

    private final String rating;

    private final String ratingIn5;

    private final String url;

    public SchoolRecord(String rank, String rankIn5, String name, String city, String rating, String ratingIn5, String url) {
        this.rank = rank;
        this.rankIn5 = rankIn5;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.ratingIn5 = ratingIn5;
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public String getRankIn5() {
        return rankIn5;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getRating() {
        return rating;
    }

    public String getRatingIn5() {
        return ratingIn5;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolRecord)) return false;

        SchoolRecord that = (SchoolRecord) o;

        if (getRank() != null ? !getRank().equals(that.getRank()) : that.getRank() != null) return false;
        if (getRankIn5() != null ? !getRankIn5().equals(that.getRankIn5()) : that.getRankIn5() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getRating() != null ? !getRating().equals(that.getRating()) : that.getRating() != null) return false;
        if (getRatingIn5() != null ? !getRatingIn5().equals(that.getRatingIn5()) : that.getRatingIn5() != null)
            return false;
        return getUrl() != null ? getUrl().equals(that.getUrl()) : that.getUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getRank() != null ? getRank().hashCode() : 0;
        result = 31 * result + (getRankIn5() != null ? getRankIn5().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getRatingIn5() != null ? getRatingIn5().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SchoolRecord{" +
                "rank='" + rank + '\'' +
                ", rankIn5='" + rankIn5 + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating='" + rating + '\'' +
                ", ratingIn5='" + ratingIn5 + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
