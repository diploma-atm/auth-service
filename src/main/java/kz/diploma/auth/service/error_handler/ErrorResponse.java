package kz.diploma.auth.service.error_handler;

import lombok.Builder;

@Builder
public record ErrorResponse(Integer statusCode, String message) {
}
