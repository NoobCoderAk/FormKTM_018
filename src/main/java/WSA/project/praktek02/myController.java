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
    @ResponseBody
    public String getData (@RequestParam("nama") String nama,
            @RequestParam("tanggal")
            @DateTimeFormat(pattern="yyyy-MM-dd")Date date,
            @RequestParam("image") MultipartFile image)throws IOException {
        
        SimpleDateFormat newTanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");
        String blob = Base64.encodeBase64String(image.getBytes());
        String tanggalKu = newTanggal.format(date) ;
        nama = textProcess(nama);
        return nama + "<br>"+ "<br>" + "<img src='data:image/*;base64,"+blob+"'/>"+ tanggalKu ;
    }

    private String textProcess(String nama) {
        String result = " ";
        if (nama.equals("Soekarno")){
            result = nama + " Romusha";
        }else if(nama.equals(" Soeharto")){
            result = nama + " Laksanaken";
        }else if(nama.equals("Megawati")){
            result = nama + " Hooh Tenan";
        }else{
            result = nama + " YOo Ndak Tau";
        }
        return result;
    }
}
