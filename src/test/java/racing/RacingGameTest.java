package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Operator;
import step3.RacingGame;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "200:3", "4:6","4:100"}, delimiter = ':')
    void validCarCntAndTimeTest(int carCnt, int time) {
        assertThat(RacingGame.validCarCnt(carCnt,time)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:1", "200:0", "0:6","4:-100"}, delimiter = ':')
    void invalidCarCntAndTimeTest(int carCnt, int time) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        RacingGame.validCarCnt(carCnt,time));
    }

    @ParameterizedTest
    @CsvSource(value = {"7:100", "1:20", "9:3","10:22"}, delimiter = ':')
    void isRangeInTime(int carCnt, int time) {
        RacingGame racingGame = new RacingGame(carCnt, time);
        racingGame.run();
        assertThat(racingGame.getCarPositions()).doesNotContain(time+1);
    }
}
