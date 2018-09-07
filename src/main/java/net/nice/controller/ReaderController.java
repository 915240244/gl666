package net.nice.controller;


import net.nice.bean.Reader;
import net.nice.service.ReaderService;
import net.nice.utils.MD5;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @SuppressWarnings("deprecation")
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("reader_ID") String reader_ID,
                            @RequestParam("reader_Email") String reader_Email,
                            @RequestParam("reader_Password") String reader_Password,
                           HttpSession session){
        System.out.println(reader_Email+"-----------------------");
        if (this.readerService.checkExist(reader_ID)){
            /*返回出账号已存在*/
            return "emailExist";
        }
        else {
            String rpassword= MD5.generateCode(reader_Password);
            Reader reader=new Reader(reader_ID,rpassword,reader_Email);
            final boolean rs = this.readerService.createReader(reader);
            if (rs){
                System.out.println("rs = 登录成功啦 " + rs);
                return "success";
            }

            /*返回注册失败*/
            return "fail";
        }
    }

    /*登录*/
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("reader_ID") String reader_ID,
                        @RequestParam("password") String reader_Password,
                        HttpSession session){
        String rpassword= MD5.generateCode(reader_Password);
        Reader reader=new Reader(reader_ID,rpassword);
        Reader login = this.readerService.login(reader);
        System.out.println(rpassword+"---------------------------");
        if (login==null){
            //登录失败
            System.out.println("rs = 登录成功啦 ");
            return "no";
        }else {
            session.setAttribute("reader",login);
            session.setAttribute("Id",login.getReader_ID());
            //登录成功
            System.out.println("rs = 登录成功啦-------------- ");
            return "yes";
        }
    }


    /*修改个人信息
    *姓名
    *联系方式
    *地址
    *性别
    * */
    @RequestMapping("/updatereaderInfo")
    @ResponseBody
    public String updateReaderInfo(@RequestParam("reader_ID") String reader_ID,
                                   @RequestParam("reader_Name") String reader_Name,
                                   @RequestParam("reader_Phone") String reader_Phone,
                                   @RequestParam("reader_Address") String reader_Address,
                                   @RequestParam("reader_Gender") String reader_Gender,
                                   HttpSession session){
        Reader reader= (Reader) session.getAttribute("reader");

        if (reader==null){
            return "failaaa";
        }else {
            reader.setReader_ID(reader_ID);
            reader.setReader_Name(reader_Name);
            reader.setReader_Phone(reader_Phone);
            reader.setReader_Address(reader_Address);
            reader.setReader_Gender(reader_Gender);

            boolean b = this.readerService.updateReaderInfo(reader);
            if (b){
                /*session.removeAttribute("reader");*/
                session.setAttribute("user",reader);
                return "success";
            }else return "fail";
        }
    }


    /*修改头像*/
    @RequestMapping("/uploadLogo")
    @ResponseBody
    public String uploadLogo(@RequestParam(value = "picFile",required = false) MultipartFile multipartFile,
                             HttpServletRequest request, HttpSession session,Model model){
        String realPath = request.getSession().getServletContext().getRealPath("");
        String path="";
        if (!multipartFile.isEmpty()){
            //随机生成uuid作为图片的名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //随机生成uuid作为图片的名称
            String contentType = multipartFile.getContentType();
            //获取图片的后缀名
            String substring = contentType.substring(contentType.indexOf("/")+1);
            //获取图片路径
            path="/images/logo/"+uuid+"."+substring;
            try {
                multipartFile.transferTo(new File(realPath+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String readerLogo="images/logo/"+uuid+"."+substring;

            Reader reader= (Reader) session.getAttribute("reader");
            if (reader==null){
                return null;
            }else {
                reader.setReader_Photo(readerLogo);
            }
            int c=this.readerService.uploadLogo(reader);
            if (c==1){
                session.setAttribute("user",reader);
            }




            System.out.println("头像上传成功+++++++++++++++++++++++++++++");
        }
        return null;
    }

    /*查询借阅记录*/
    public String querylog(){

        return null;
    }


    @RequestMapping("/geren")
    public String geren(){
        return "geren.jsp";
    }

    @RequestMapping("/asd.do")
    public String huo(Model model,HttpSession session){

        Reader reader= readerService.ShowUser((String) session.getAttribute("Id"));
        model.addAttribute("user",reader);
        return "/geren.jsp";
    }









    /*后台管理员部分*/

    //显示全部读者数据-book_zt.jsp
    @RequestMapping(value = "reader.do" )
    @ResponseBody
    public Object Readerlike(){
        List<Reader> readerlist = readerService.getAllReader();
        JSONArray jsonArray = JSONArray.fromObject(readerlist);
        return jsonArray.toString();
    }

    //读者姓名查询
    @RequestMapping("readername.do")
    @ResponseBody
    public  String  readerName(@RequestParam("name")String  name){

        List<Reader> readerList = readerService.readerList(name);
        if (readerList==null) return "";

        JSONArray jsonArray = JSONArray.fromObject(readerList);
        System.out.println("jsonArray = " + jsonArray);
        return jsonArray.toString();
    }
    //读者身份证查询
    @RequestMapping("readerID.do")
    @ResponseBody
    public  String  readerId(@RequestParam("reader") String readerID ){

        Reader readerId = readerService.readerId(readerID);
        if (readerId==null) return "";
        JSONArray jsonArray = JSONArray.fromObject(readerId);
        return jsonArray.toString();
    }
}
