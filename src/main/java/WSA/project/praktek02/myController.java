/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSA.project.praktek02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ABID
 */

@Controller
public class myController {
    @RequestMapping("/home")
    public String getInput(
            @RequestParam(value = "nama") String var_nama,
            @RequestParam(value = "nim") String var_nim,
            @RequestParam(value = "email") String var_email,
            @RequestParam(value = "tanggal") String var_tanggal,
            @RequestParam(value = "prodi") String var_prodi,
            @RequestParam(value = "image") MultipartFile var_image,Model ktm
        )throws IOException{
        byte[] img = var_image.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink = "data:image/*;base64,".concat(base64Image);
        ktm.addAttribute("send_nama", var_nama);
        ktm.addAttribute("send_nim", var_nim);
        ktm.addAttribute("send_email", var_email);
        ktm.addAttribute("send_tanggal", var_tanggal);
        ktm.addAttribute("send_prodi", var_prodi);
        ktm.addAttribute("send_image", imglink);
        return "viewktm";   
    }
}
