package br.com.saimon.javatodo.usersConfig.registration.token;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConfirmationToken {
    private Long id;
    private String token;
    private LocalDateTime localDateTime;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    public ConfirmationToken(String token, LocalDateTime localDateTime, LocalDateTime expiredAt, LocalDateTime confirmedAt) {
        this.token = token;
        this.localDateTime = localDateTime;
        this.expiredAt = expiredAt;
        this.confirmedAt = confirmedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConfirmationToken)) return false;
        ConfirmationToken that = (ConfirmationToken) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getToken(), that.getToken()) && Objects.equals(getLocalDateTime(), that.getLocalDateTime()) && Objects.equals(getExpiredAt(), that.getExpiredAt()) && Objects.equals(getConfirmedAt(), that.getConfirmedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getToken(), getLocalDateTime(), getExpiredAt(), getConfirmedAt());
    }
}
