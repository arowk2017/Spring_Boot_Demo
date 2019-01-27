package com.codecliquesoftware.demo4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
class Demo4Controller {
    
    Error error = new Error();
    Success success = new Success();
    
    
    @Autowired 
    private UserRepository userRepository;
    
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value="/apply", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    Object apply(@Valid @RequestBody ApplyForm apply, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();

            ObjectNode jsonObject = objectMapper.createObjectNode();

            for (FieldError e : errors){
                jsonObject.put(e.getField(), e.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject);
        
        }
        else
        {
            System.out.println(apply.toString());
            User n = new User();
		n.setName(apply.getName());
		n.setEmail(apply.getEmail());
                n.setPhone(apply.getPhone());
		n.setCity(apply.getCity());
                n.setState(apply.getState());
		
		
                try {
                    userRepository.save(n);
                } catch (DataAccessException dae) {
                    System.err.println(dae);
                }
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

}