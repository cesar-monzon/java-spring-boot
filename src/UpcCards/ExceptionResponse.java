package UpcCards;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import lombok.Data;

@ControllerAdvice
@RestController
public class ExceptionResponse{

    @Data
    private class JsonResponse {
        final String code = "400";
        String message;

        public JsonResponse(String message) {
            this.message = message;
        }
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<JsonResponse> handleBindException(BindException e, BindingResult result) {
        FieldError fields = result.getFieldError();
        String[] firstCode = fields.getCodes()[0].split("\\.");
        String errorMsg = "missing " + firstCode[firstCode.length - 1];
        return new ResponseEntity<JsonResponse>(new JsonResponse(errorMsg), HttpStatus.BAD_REQUEST);
    }
}
