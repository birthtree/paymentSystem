package ru.akkuzin.paymentService.model.dto.enums;

import lombok.Getter;


@Getter
public enum CommandResultStatus {
    SUCCESS,
    FAILED;
    public static CommandResultStatus fromString(String string) {
        for (CommandResultStatus commandResultStatus : CommandResultStatus.values()) {
            if (commandResultStatus.name().equalsIgnoreCase(string)) {
                return commandResultStatus;
            }
        }
        throw new IllegalArgumentException("Unknown commandResultStatus: " + string);
    }
}
