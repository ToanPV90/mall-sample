package com.uuhnaut69.web.endpoint;

import com.uuhnaut69.common.constant.UrlConstants;
import com.uuhnaut69.common.payload.response.GenericResponse;
import com.uuhnaut69.core.payload.request.SignInRequest;
import com.uuhnaut69.core.payload.request.SignUpRequest;
import com.uuhnaut69.core.payload.response.JwtResponse;
import com.uuhnaut69.core.payload.response.MessageResponse;
import com.uuhnaut69.core.service.token.TokenService;
import com.uuhnaut69.security.auth.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author uuhnaut
 * @project mall
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "Authentication", value = "Authentication Endpoint")
@RequestMapping(path = UrlConstants.BASE_VERSION_API + UrlConstants.PUBLIC_URL)
public class AuthController {

    private final AuthService authService;

    private final TokenService tokenService;

    @ApiOperation(value = "SignIn Endpoint")
    @PostMapping(path = UrlConstants.AUTH_URL + "/sign-in")
    public GenericResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        JwtResponse jwtResponse = authService.signIn(signInRequest);
        log.info("Generate token {}", jwtResponse);
        return GenericResponse.builder().data(jwtResponse).build();
    }

    @ApiOperation(value = "SignUp Endpoint")
    @PostMapping(path = UrlConstants.AUTH_URL + "/sign-up")
    public GenericResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) throws Exception {
        log.info("Sign up user with {}", signUpRequest);
        MessageResponse messageResponse = authService.signUp(signUpRequest);
        return GenericResponse.builder().data(messageResponse).build();
    }

    @ApiOperation(value = "Confirmation Endpoint")
    @GetMapping(path = UrlConstants.AUTH_URL + "/confirm")
    public GenericResponse confirmation(@RequestParam(value = "token", defaultValue = "") String token) {
        tokenService.confirmVerifyToken(token);
        log.info("Generate a verify token {}", token);
        return GenericResponse.builder().build();
    }

}