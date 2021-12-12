package io.achyutha.achyutha.registration.tocken;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTockenService {
    private final ConfirmationTockenRepository confirmationTockenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTockenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTockenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTockenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
