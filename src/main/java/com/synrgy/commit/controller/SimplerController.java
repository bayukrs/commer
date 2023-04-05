package com.synrgy.commit.controller;

import com.synrgy.commit.dao.request.ProfileModel;
import com.synrgy.commit.model.SimplerPayment;
import com.synrgy.commit.service.ProfileService;
import com.synrgy.commit.service.SimplerService;
import com.synrgy.commit.util.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/simpler/")
public class SimplerController {
    @Autowired
    Response response;
    @Autowired
    SimplerService simplerService;

    @PostMapping(value = "payment", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<Map> update (SimplerPayment objModel,
                                       Principal principal,
                                       MultipartFile file)  {
        try {
            Map map = simplerService.payment(objModel,principal,file);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Map>(response.ControllerError("Error"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("history")
    public ResponseEntity<Map> history(
            Principal principal
    ){
        Map map = simplerService.history(principal);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping(value = "/image/payment/{image}")
    public @ResponseBody byte[] getImage(@PathVariable("image") String image) throws IOException {
        File file = new File("/payment/" + image);
//        InputStream in = getClass().getResourceAsStream("/payment/"+image);
        InputStream in = new BufferedInputStream(Files.newInputStream(file.toPath()));
        System.out.println("Input : " + in);
        return IOUtils.toByteArray(in);
    }
}
