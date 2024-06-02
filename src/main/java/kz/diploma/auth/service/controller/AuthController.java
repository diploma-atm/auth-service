package kz.diploma.auth.service.controller;

import kz.diploma.auth.service.chain.AuthProcessor;
import kz.diploma.auth.service.model.dto.AuthResponseDTO;
import kz.diploma.auth.service.model.dto.UserInfoDTO;
import kz.diploma.auth.service.model.request.AuthRequest;
import kz.diploma.auth.service.model.request.CheckSessionRequest;
import kz.diploma.auth.service.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthProcessor authProcessor;
    private final AuthService authService;

    @PostMapping("/check/session")
    public ResponseEntity<UserInfoDTO> checkSession(@RequestBody CheckSessionRequest req) {
        var userInfoDTO = authService.checkSession(req.token());

        return new ResponseEntity<>(userInfoDTO, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequest authRequest) {
        var processed = authProcessor.execute(authRequest.getPhoneNumber(),
                authRequest.getPassword());

        var headers = new HttpHeaders();
        headers.setAll(processed.getHeaders());

        return ResponseEntity.ok()
                .headers(headers)
                .body(processed.getResponse());
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestBody CheckSessionRequest req) {
        authService.logout(req.token());
    }

}
