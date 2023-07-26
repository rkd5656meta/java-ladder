package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public final List<Player> players;

    public Players(List<Player> players) {
        checkPlayersSize(players);
        this.players = players;
    }

    public Players(String[] players) {
        this(Arrays.stream(players).map(Player::new).collect(Collectors.toList()));
    }

    private void checkPlayersSize(List<Player> players) {
        if (players.size() <= 1) {
            throw new IllegalArgumentException("참여자는 2명 이상으로 설정 하세요");
        }
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public int indexOf(String name) {
        int index = players.indexOf(new Player(name));

        if (index < 0){
            throw new IllegalArgumentException("찾으시는 참여자가 없습니다.");
        }

        return index;
    }

    @Override
    public String toString() {
        return this.players.stream()
                .map(Player::toString)
                .collect(Collectors.joining(""));
    }
}