package contest;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class contestTest {
    @DisplayName("n대의 자동차가 참여할 수 있다.")
    @Test
    void n_대의_자동차가_참여(){
        //given
        String[] names = {"car1", "car2", "car3"};
        int attempt = 5;
        Contest contest = new Contest(names, attempt);

        //when
        String[] actual = contest.getParticipantsName();

        //then
        assertThat(actual).isEqualTo(names);

    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다.")
    @Test
    void 우승자를_알_수_있다(){
        //given
        String[] names = {"car1", "car2", "car3"};
        int attempt = 5;
        Contest contest = new Contest(names, attempt);

        //when
        contest.startContest();
        String[] actual = contest.getWinners();

        //then
        assertThat(actual).containsAnyOf("car1", "car2", "car3");
    }


    @DisplayName("우승자는 한 명 이상일 수 있다.")
    @Test
    void 중복_우승자가_있을_수_있다(){
        //given
        String[] names = {"car1", "car2", "car3"};
        int attempt = 5;
        Contest contest = new Contest(names, attempt);

        //when
        contest.startContest();
        String[] actual = contest.getWinners();

        //then
        assertThat(actual).hasSizeGreaterThan(0);
    }

}
