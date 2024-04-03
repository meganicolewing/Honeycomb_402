package sprint1;

public record ListResponse(String request, boolean successful, String message, Desc[] data) {};
