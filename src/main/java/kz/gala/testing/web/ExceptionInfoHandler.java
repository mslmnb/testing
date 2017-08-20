package kz.gala.testing.web;

import kz.gala.testing.util.ValidationUtil;
import kz.gala.testing.util.exception.ApplicationException;
import kz.gala.testing.util.exception.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class ExceptionInfoHandler {
    private final static Logger log = LoggerFactory.getLogger(ExceptionInfoHandler.class);

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<String> applicationError(HttpServletRequest req, ApplicationException appEx) {
        return new ResponseEntity<String>(getMessage(appEx.getMsgCode(), appEx.getArgs()),appEx.getHttpStatus());
    }

    @Autowired
    private MessageSource messageSource;

    private String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
