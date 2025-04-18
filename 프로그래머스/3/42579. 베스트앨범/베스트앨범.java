import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                    .add(new Song(i, plays[i]));
        }

        List<String> genreOrder = new ArrayList<>(genrePlayMap.keySet());
        genreOrder.sort((a, b) -> genrePlayMap.get(b) - genrePlayMap.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Song> songs = songMap.get(genre);
            songs.sort((a, b) -> b.play == a.play ? a.index - b.index : b.play - a.play);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}