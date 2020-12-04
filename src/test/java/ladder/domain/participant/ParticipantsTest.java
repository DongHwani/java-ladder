package ladder.domain.participant;

import ladder.exception.InsufficientParticipantsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @ParameterizedTest
    @CsvSource(value = {"user1:user2:user3"}, delimiter = ':')
    public void createInstanceTest(String userName, String userName2, String userName3) {
        //Given & When
        Participants participants = new Participants(Arrays.asList(new Participant(userName),
                                                                   new Participant(userName2),
                                                                   new Participant(userName3)));
        //Then
        assertThat(participants).isNotNull();
    }

    @DisplayName("1명만 사다리 게임에 참가하였을 경우 예외처리 테스트")
    @Test
    public void insufficientParticipatePersons() {
        assertThatThrownBy(() ->
                new Participants(Arrays.asList(new Participant("user")))
        ).isInstanceOf(InsufficientParticipantsCountException.class);
    }
}
