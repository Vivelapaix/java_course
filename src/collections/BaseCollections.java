package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseCollections {

    enum MovieJenre {
        COMEDY("Comedy"),
        ACTION("Action"),
        ADVENTURE("Adventure");

        private String name;

        MovieJenre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Film implements Comparable<Film> {
        private String title;
        private String category;
        private long views;
        private long likes;
        private long dislikes;

        public Film(String title, String category, long views, long likes, long dislikes) {
            this.title = title;
            this.category = category;
            this.views = views;
            this.likes = likes;
            this.dislikes = dislikes;
        }

        public String getTitle() {
            return title;
        }

        public String getCategory() {
            return category;
        }

        public long getViews() {
            return views;
        }

        public long getDislikes() {
            return dislikes;
        }

        public long getLikes() {
            return likes;
        }

        @Override
        public int compareTo(Film film) {
            return views > film.views ? -1 : 1;
        }

        @Override
        public String toString() {
            return "Film{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                '}';
        }
    }

    public static List<Film> generateFilmList() {
        return Arrays.asList(
            new Film("One", MovieJenre.COMEDY.getName(), 648279, 54534, 27834),
            new Film("Two", MovieJenre.ADVENTURE.getName(), 546986, 240942, 423871),
            new Film("Spy kids", MovieJenre.ADVENTURE.getName(), 546986, 240942, 8913),
            new Film("American Pie", MovieJenre.COMEDY.getName(), 8564834, 322, 53453),
            new Film("Total recall", MovieJenre.ACTION.getName(), 643834, 3251451, 896534),
            new Film("Rush Hour", MovieJenre.COMEDY.getName(), 7439793, 325345341, 3489)
        );
    }

    public static List<String> getTopNViewsFilmTitles(List<Film> films, int n) {
        return films.stream()
            .filter(x -> x.getCategory().equals(MovieJenre.COMEDY.getName()))
            .sorted()
            .limit(n)
            .map(Film::getTitle)
            .collect(Collectors.toList());
    }

    public static List<String> getDislikedFilmTitlesWithDislikeCount(List<Film> films) {
        return films.stream()
            .filter(x -> x.getCategory().equals(MovieJenre.ADVENTURE.getName()))
            //.sorted((f1, f2) -> f1.getDislikes() > f2.getDislikes() ? 1 : -1)
            //.sorted((f1, f2) -> Long.compare(f1.getDislikes(), f2.getDislikes()))
            .sorted(Comparator.comparingLong(Film::getDislikes))
            .map(x -> String.join(" ", x.getTitle(), String.valueOf(x.getDislikes())))
            .collect(Collectors.toList());
    }

    static class FilmLikesComparator implements Comparator<Film> {
        public int compare(Film a, Film b) {
            // a.getLikes() == b.getLikes() ? 0 : (a.getLikes() > b.getLikes() ? -1 : 1)
            return Long.compare(b.getLikes(), a.getLikes());
        }
    }

    public static Map<String, Long> getLikedFilmTitles(List<Film> films, int n) {
        return films.stream()
            .filter(x -> x.getCategory().equals(MovieJenre.COMEDY.getName()))
            .sorted(new FilmLikesComparator())
            .limit(n)
            .collect(Collectors.toMap(Film::getTitle, Film::getLikes));
    }

    public static void main(String[] args) {
        System.out.println("--- Top 2 Views");
        getTopNViewsFilmTitles(generateFilmList(), 2).forEach(System.out::println);
        System.out.println("--- Dislike Sorted");
        getDislikedFilmTitlesWithDislikeCount(generateFilmList()).forEach(System.out::println);
        System.out.println("--- Top 2 Map by Likes");
        getLikedFilmTitles(generateFilmList(), 2).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
